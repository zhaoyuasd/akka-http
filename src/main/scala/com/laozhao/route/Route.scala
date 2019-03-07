package com.laozhao.route

import akka.http.scaladsl.marshalling.ToResponseMarshallable
import akka.http.scaladsl.model.{HttpRequest, StatusCode, StatusCodes}
import akka.http.scaladsl.server.StandardRoute

object Route {
  def badRequest(request:HttpRequest):StandardRoute={
    val method=request.method.value.toLowerCase
    val path=request.getUri().path()
    val queryString=request.getUri().rawQueryString().orElse("")

    method match {
      case _ =>
         complete((StatusCodes.NotFound,"404 error,resource not found"))
    }

  }

  def complete(m: =>ToResponseMarshallable):StandardRoute=StandardRoute(_.complete(m))
}
