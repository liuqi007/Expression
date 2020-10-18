
package com.free.interpreter.function.logical

import com.free.interpreter.Interpreter
import com.free.interpreter.strategy.LogicalStrategy
import org.json.JSONObject

/**
  * Created by Administrator on 2020/3/14 0014.
  */
class OrLogical(params: Array[Interpreter]) extends  LogicalStrategy{
  override def exec(input:JSONObject):Boolean={
    var validator = false
    var i=0
    while(i<params.length && !validator){
      validator = params(i).exec(input).toString.toBoolean
      i = i +1
    }
    validator
  }
}
object OrLogical{
  def apply(params: Array[Interpreter]): OrLogical = new OrLogical(params)
}

