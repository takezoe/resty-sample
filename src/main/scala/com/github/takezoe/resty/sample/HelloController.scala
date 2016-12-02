package com.github.takezoe.resty.sample

import com.github.takezoe.resty.Action

class HelloController {

  @Action(method = "GET", path = "/hello/{name}")
  def hello(name: String): Message = {
    Message(name)
  }

}

case class Message(message: String)
