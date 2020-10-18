package com.free.exception

class MatchCaseNotFoundException(code: String, message: String) extends RuntimeException(message) {
  def this(code: String) {
    this(code, "Not Found match option")
    println("com.xxx.MatchCaseNotFoundException:{code:" + code + ",message:" + message + "}")
  }
}
