package com.free.interpreter.function.types

import com.free.interpreter.strategy.TypeStrategy
import org.json.JSONObject

/**
  * Created by Administrator on 2020/3/14 0014.
  */
class ColumnType(val columnName: String) extends  TypeStrategy{
  override def exec(input:JSONObject):String = {
      var value = ""
    if(input.has(columnName)){
      value = input.optString(columnName)
    }
    value.trim
  }
}

object ColumnType{
  def apply(param:String): ColumnType = new ColumnType(param)
}
