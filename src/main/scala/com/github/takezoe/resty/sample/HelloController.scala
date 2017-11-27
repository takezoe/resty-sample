package com.github.takezoe.resty.sample

import com.github.takezoe.resty._
import org.slf4j.LoggerFactory

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class HelloController extends HttpClientSupport {

  private val logger = LoggerFactory.getLogger(classOf[HelloController])

  @Action(method = "GET", path = "/hello/{name}")
  def hello(name: String): Message = {
    logger.debug(name)
    Message(name)
  }

  @Action(method = "GET", path = "/async/{name}")
  def async(name: String): Future[Message] = {
    httpGetAsync[Message](s"http://localhost:8080/hello/${name}").map {
      case Right(message) => message
      case Left(error) => throw new ActionResultException(InternalServerError(error))
    }
  }


}

case class Message(message: String)
