package edu.luc.etl.cs433.laufer.primenumbers

object Main extends App {
  println(PrimeNumberChecker.isPrime(6033))
  println(PrimeNumberChecker.isPrime(BigInt("99999989")))
//  println(PrimeNumberChecker.isPrime(BigInt("32416187563")))
}