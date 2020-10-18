package com.free.interpreter.function.types

import com.free.interpreter.Interpreter
import com.free.interpreter.strategy.TypeStrategy
import org.json.JSONObject

/**
  * Created by Administrator on 2020/3/14 0014.
  */
class IFElseFunction(params: Array[Interpreter]) extends  TypeStrategy{
    override def exec(input:JSONObject):String={
      val validate = params(0).exec(input).toString.toBoolean
      val r1 = params(1).exec(input).toString
      val r2 = params(2).exec(input).toString
      if( validate) r1 else r2
    }
  }
  object IFElseFunction{
    def apply(params: Array[Interpreter]): IFElseFunction = new IFElseFunction(params)
  }
