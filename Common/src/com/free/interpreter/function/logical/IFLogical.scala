package com.free.interpreter.function.logical

import com.free.interpreter.Interpreter
import com.free.interpreter.strategy.LogicalStrategy
import org.json.JSONObject

/**
  * Created by Administrator on 2020/3/14 0014.
  */
class IFLogical(params: Array[Interpreter]) extends  LogicalStrategy{
  override def exec(input:JSONObject):Boolean={
    params(0).exec(input).toString.toBoolean
  }
}
object IFLogical{
  def apply(params: Array[Interpreter]): IFLogical = new IFLogical(params)
}
