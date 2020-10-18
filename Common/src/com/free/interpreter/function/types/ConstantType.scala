package com.free.interpreter.function.types

import com.free.interpreter.strategy.TypeStrategy
import org.json.JSONObject

/**
  * Created by Administrator on 2020/3/14 0014.
  */
class ConstantType(val expression: String) extends  TypeStrategy{
  override def exec(input:JSONObject):String = expression.replaceAll("'","")
}

object ConstantType{
  def apply(expression: String): ConstantType = new ConstantType(expression)
}
