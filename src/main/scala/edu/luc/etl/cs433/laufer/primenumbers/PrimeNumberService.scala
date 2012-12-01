package edu.luc.etl.cs433.laufer.primenumbers

import java.io.File
import org.parboiled.common.FileUtils
import akka.util.Duration
import akka.util.duration._
import akka.actor.{ActorLogging, Props, Actor}
import akka.pattern.ask
import spray.routing.{HttpService, RequestContext}
import spray.can.server.HttpServer
import spray.httpx.encoding.Gzip
import spray.http._
import MediaTypes._
import StatusCodes._


// we don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
class PrimeNumberServiceActor extends Actor with PrimeNumberService {

  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  def actorRefFactory = context

  // this actor only runs our route, but you could add
  // other things here, like request stream processing
  // or timeout handling
  def receive = runRoute(demoRoute)
}


// this trait defines our service behavior independently from the service actor
trait PrimeNumberService extends HttpService {

  val demoRoute = {
    get {
      path("\\d+".r) { s =>
        if (PrimeNumberChecker.isPrime(BigInt(s)))
          respondWithMediaType(`text/html`) { // XML is marshalled to `text/xml` by default, so we simply override here
            complete(s)
          }
        else
          complete(NotFound, NotFound.defaultMessage)
      }
    }
  }
}