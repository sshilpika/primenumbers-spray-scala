package edu.luc.etl.cs433.laufer.primenumbers

import org.specs2.mutable.Specification
import spray.testkit.Specs2RouteTest
import spray.http._
import StatusCodes._

class PrimeNumberServiceSpec extends Specification with Specs2RouteTest
  with PredicateCheckerService with PrimeNumberChecker {

  def actorRefFactory = system

  "The PrimeNumberService" should {

    "identify 6007 as a prime" in {
      Get("/6007") ~> demoRoute ~> check { responseAs[String] must contain("6007") }
    }

    "identify 6008 as a non-prime" in {
      Get("/6008") ~> demoRoute ~> check { status === NotFound }
    }

    "leave GET requests to other paths unhandled" in {
      Get("/kermit") ~> demoRoute ~> check { handled must beFalse }
    }

    "return a MethodNotAllowed error for PUT requests to the root path" in {
      Put() ~> sealRoute(demoRoute) ~> check { status === MethodNotAllowed }
    }
  }
}