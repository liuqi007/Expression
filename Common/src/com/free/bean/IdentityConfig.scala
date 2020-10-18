package com.free.bean

import java.io.Serializable
import org.json.JSONObject
import org.json.JSONArray

/**
 * Created by Administrator on 2020/3/14 0014.
 */
class IdentityConfig(val name: String, val source: String, val default_priority: Int, val match_scenes: List[MatchScene]) extends Serializable

object IdentityConfig {
  def buildConfigs(configStr: String): Map[String, IdentityConfig] = {
    val configArray = new JSONArray(configStr)
    (for (i <- 0 until configArray.length()) yield IdentityConfig(configArray.getJSONObject(i))).map(reformat).toMap
  }

  def apply(json: JSONObject): IdentityConfig = {
    val name = json.optString("name")

    val source = json.optString("source")
    val default_priority = json.optInt("default_priority")
    val matchArray = json.optJSONArray("match_scenes")
    val match_scenes = (for (i <- 0 until matchArray.length()) yield MatchScene(matchArray.getJSONObject(i), default_priority)).toList
    new IdentityConfig(name,source,default_priority, match_scenes)
  }

  def reformat(identityConfig: IdentityConfig): (String, IdentityConfig) = (identityConfig.source, identityConfig)
}
