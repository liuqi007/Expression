package com.free.bean

import com.free.interpreter.Interpreter
import org.json.JSONObject


/**
  * Created by Administrator on 2020/3/14 0014.
  */
class ColumnPriority (val column:String, val columnType:String, val priority: Int, val value: Interpreter) extends Serializable
object ColumnPriority{
  def apply(json: JSONObject, defaultPrority: Int): ColumnPriority = {
    val column = json.optString("column")
    val columnType= json.optString("column_type")
    val priority= json.optInt("priority")
    val value= Interpreter.parseRuleExpression(json.optString("value"))
    new ColumnPriority(column,columnType,priority,value)
  }
}