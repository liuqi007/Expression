package com.free.interpreter.function.logical

import com.free.interpreter.Interpreter
import com.free.interpreter.strategy.LogicalStrategy
import org.json.JSONObject

/**
  * Created by Administrator on 2020/3/14 0014.
  */
class TrueLogical(params: Array[Interpreter]) extends  LogicalStrategy{
  override def exec(input:JSONObject):Boolean= true
}
object TrueLogical{
  def apply(params: Array[Interpreter]): TrueLogical = new TrueLogical(params)
}
