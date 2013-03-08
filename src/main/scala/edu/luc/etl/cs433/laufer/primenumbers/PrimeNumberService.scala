package edu.luc.etl.cs433.laufer.primenumbers

import akka.actor.Actor
import spray.http.MediaTypes.`text/html`
import spray.http.StatusCodes.NotFound
import spray.routing.Directive.pimpApply
import spray.routing.HttpService
import spray.routing.directives.CompletionMagnet.{fromObject, fromStatusObject}

// we don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
class PrimeNumberServiceActor extends Actor
  with PredicateCheckerService with PrimeNumberChecker {

  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  def actorRefFactory = context

  // this actor only runs our route, but you could add
  // other things here, like request stream processing
  // or timeout handling
  def receive = runRoute(demoRoute)
}


// this trait defines our service behavior independently from the service actor
trait PredicateCheckerService extends HttpService with PredicateOnBigInt {

  val demoRoute = {
    get {
      path("\\d+".r) { s =>
        if (predicate(BigInt(s)))
          respondWithMediaType(`text/html`) { // XML is marshalled to `text/xml` by default, so we simply override here
            complete(s)
          }
        else
          complete(NotFound, NotFound.defaultMessage)
      }
    }
  }
}