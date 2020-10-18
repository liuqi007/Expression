package com.free.interpreter.strategy

import org.json.JSONObject
import com.free.interpreter.Interpreter

/**
  * Created by Administrator on 2020/3/14 0014.
  */
abstract class EqualsMatchStrategy extends Interpreter {
  override def exec(input:JSONObject):Boolean
}
