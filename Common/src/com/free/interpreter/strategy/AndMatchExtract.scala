package com.free.interpreter.strategy

import org.json.JSONObject
import com.free.interpreter.Interpreter

/**
  * Created by Administrator on 2020/3/14 0014.
  */
class AndMatchExtract(val params: Array[Interpreter]) extends ExtractStrategy {
  override def exec(input: JSONObject): Map[String, String] = {
    val r0 = params(0).asInstanceOf[ExtractStrategy].exec(input)
    val r1 = params(1).asInstanceOf[ExtractStrategy].exec(input)
    (r0.keySet & r1.keySet).map(x=>((x,x))).toMap
  }
}
object AndMatchExtract{
  def apply(expression: Array[Interpreter]): AndMatchExtract = new AndMatchExtract(expression)
}
