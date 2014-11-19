[![Build Status](https://travis-ci.org/lucoodevcourse/primenumbers-spray-scala.svg?branch=master)](https://travis-ci.org/lucoodevcourse/primenumbers-spray-scala) 
[![Coverage Status](https://coveralls.io/repos/lucoodevcourse/primenumbers-spray-scala/badge.png)](https://coveralls.io/r/lucoodevcourse/primenumbers-spray-scala)

# Learning Objectives

- Show how CPU-intensive computation can be off-loaded from a mobile app to
  the cloud, by comparison to a mobile device, an unlimited resource for
  computation and storage.

See also the
[corresponding mobile app](https://github.com/lucoodevcourse/primenumbers-android-scala).

# How to use

Test with

    $ sbt test

Run with 

    $ sbt run
	
or

    $ sbt stage
	$ foreman start

or deploy to a foreman-compatible APaaS provider, such as Heroku.

Then, http://host/n returns

- 200 OK if n is prime
- 404 Not Found otherwise

# Sample prime numbers to try

- [1013](http://laufer-primechecker.herokuapp.com/1013)
- [10007](http://laufer-primechecker.herokuapp.com/10007)
- [100003](http://laufer-primechecker.herokuapp.com/100003)
- [1000003](http://laufer-primechecker.herokuapp.com/1000003)
- [10000169](http://laufer-primechecker.herokuapp.com/10000169)
- [100000007](http://laufer-primechecker.herokuapp.com/100000007)

# Sample non-prime numbers to try

- [999989](http://laufer-primechecker.herokuapp.com/999989)

# References

- [Jason Christensen's OOPSLA 2009 presentation](http://www.slideshare.net/jasonc411/oopsla-2009-combining-rest-and-cloud-a-practitioners-report)
