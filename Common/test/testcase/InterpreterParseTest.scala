package com.free.testcase

import com.free.interpreter.Interpreter
import org.json.JSONObject
import org.junit.{Before, Test}

class InterpreterParseTest {
  @Test
  def testInterpreter(): Unit = {
    val input = new JSONObject
    input.put("name", "liyang")
    input.put("dept", "hr")
//    val expressionString = "or(eq(name,'liyang'),eq(dept,'hr'))"\
    val expressionString = "eq(name,'liyang')"
    val e = Interpreter.parseRuleExpression(expressionString);
    val b = e.exec(input).toString.toBoolean
    println(b)
  }
}
