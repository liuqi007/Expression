package com.free.interpreter


import com.free.exception.MatchCaseNotFoundException
import com.free.interpreter.function.logical.{EqualsLogical, IFLogical, OrLogical, TrueLogical}
import com.free.interpreter.function.types.{ArrayType, ColumnType, ConstantType, IFElseFunction}
import com.free.util.ExpressionParseUtils
import org.apache.commons.lang3.StringUtils
import org.json.JSONObject

/**
 * 表达式解释器
 */
trait Interpreter extends Serializable{
  def exec(input: JSONObject):Any
}
object Interpreter{
  def parseRuleExpression(expression:String):Interpreter={
    var rule:Interpreter = null
    if(StringUtils.isNotEmpty(expression)){

      var indexBegin = expression.indexOf("(")
      val indexEnd = expression.lastIndexOf(")")

      if(indexBegin != -1 && indexEnd != -1){
        val expressionName = expression.substring(0,indexBegin)

        indexBegin +=1

        rule = createInstance(expressionName, parseRuleParams(expression.substring(indexBegin,indexEnd)))
      }
      //常量
      else if(expression.contains("'")){
        rule = ConstantType(expression)
      }
      //shuzu
      else if(expression.contains("\"") && expression.contains(",")){
        rule = ArrayType(expression)
      }else{
        rule = ColumnType(expression)
      }
    }
    rule
  }

  def parseRuleParams(expression:String):Array[Interpreter]={
    var rules: Array[Interpreter] = null

    if(StringUtils.isNotEmpty(expression)){
      val expressions = ExpressionParseUtils.splitKey(expression)
      rules = for(
        exp<-expressions;
        rule = parseRuleExpression(exp)
        if rule != null
      ) yield rule
    }
    rules
  }
  def createInstance(name:String, params:Array[Interpreter]):Interpreter= name match{
    case "if" => IFLogical(params)
//    case "and" => AndLogical(params)
    case "or" => OrLogical(params)
//    case "like" => LikeLogical(params)
    case "true" => TrueLogical(params)
    case "eq" => EqualsLogical(params)
//    case "split" => SplitLogical(params)
    case "ifelse" => IFElseFunction(params)
//    case "not_empty" => IFLogical(params)
//    case "get_hbase" => IFLogical(params)
    case _=>
      println("===expression name:"+name)
      throw new MatchCaseNotFoundException("500")
  }
}
