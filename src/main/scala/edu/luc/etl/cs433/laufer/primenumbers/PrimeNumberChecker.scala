package edu.luc.etl.cs433.laufer.primenumbers

trait PrimeNumberChecker extends PredicateOnBigInt {

  override def predicate(i: BigInt): Boolean =
    if (i < 2)
      false
    else {
      val half = i / 2
      var k = BigInt(2)
      while (k <= half) {
    	if (i % k == 0) return false
        k += 1
      }
      true
    }
}
