package com.free.interpreter.function.types

import com.free.interpreter.strategy.TypeStrategy
import org.json.JSONObject

/**
  * Created by Administrator on 2020/3/14 0014.
  */
class ArrayType(val expression: String) extends  TypeStrategy{
  override def exec(input:JSONObject): Array[String] = expression.replaceAll("\"","").split(",")
}

object ArrayType{
  def apply(expression: String): ArrayType = new ArrayType(expression)
}
