package com.free.bean

import java.io.Serializable

import org.json.JSONObject
import com.free.interpreter.Interpreter

/**
  * Created by Administrator on 2020/3/14 0014.
  */
class MatchScene(val scene_name:String,
                 val scene_type: String,
                 val filter_expression: Interpreter,
                 val execute_expression: Interpreter,
                 val update_rules: List[ColumnPriority]) extends Serializable

object MatchScene{
  def apply(json:JSONObject, default_priority: Int): MatchScene = {
    val scene_name=json.optString("scene_name")
    val scene_type=json.optString("scene_type")
    val filter_expression=Interpreter.parseRuleExpression(json.optString("filter_expression"))
    val execute_expression=Interpreter.parseRuleExpression(json.optString("execute_expression"))
    val ruleArray = json.optJSONArray("update_rules")
    val update_rules = (for(i<-0 until ruleArray.length()) yield ColumnPriority(ruleArray.getJSONObject(i),default_priority)).toList
    new MatchScene(scene_name,scene_type,filter_expression,execute_expression,update_rules)
  }
}
