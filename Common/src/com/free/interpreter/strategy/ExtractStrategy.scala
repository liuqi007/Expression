package com.free.interpreter.strategy

import com.free.interpreter.Interpreter
import org.json.JSONObject


/**
  * Created by Administrator on 2020/3/14 0014.
  */
abstract class ExtractStrategy extends Interpreter {
  override def exec(input:JSONObject):Map[String,String]
}
