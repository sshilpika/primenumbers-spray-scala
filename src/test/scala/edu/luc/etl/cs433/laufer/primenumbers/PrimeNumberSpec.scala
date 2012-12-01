package edu.luc.etl.cs433.laufer.primenumbers

import org.specs2.mutable.Specification


class PrimeNumberSpec extends Specification with PrimeNumberChecker {

  "The PrimeNumberChecker" should {

    "identify 1 as a non-prime" in { predicate(1) must beFalse }
    "identify 2 as a prime" in { predicate(2) must beTrue }
    "identify 4 as a non-prime" in { predicate(4) must beFalse }
    "identify 6007 as a prime" in { predicate(6007) must beTrue }
    "identify 6033 as a non-prime" in { predicate(6033) must beFalse }
  }
}