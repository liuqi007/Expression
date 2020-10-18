package com.free.interpreter.function.logical

import com.free.interpreter.Interpreter
import com.free.interpreter.strategy.LogicalStrategy
import org.json.JSONObject

/**
  * Created by Administrator on 2020/3/14 0014.
  */
class EqualsLogical(params: Array[Interpreter]) extends LogicalStrategy{
  override def exec(input:JSONObject):Boolean={
    val r1 = params(0).exec(input)
    val r2 = params(1).exec(input)
    r1.equals(r2)
  }
}
object EqualsLogical{
  def apply(params: Array[Interpreter]): EqualsLogical = new EqualsLogical(params)
}