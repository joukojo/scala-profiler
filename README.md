# scala-profiler
library for profiling code

## Compilation 

    sbt package publishLocal

## Basic usage
  
	  Profiler.profile {
	  	println("hello")
	  	Thread.sleep(500L )
	  }                    

## With identification 

    Profiler.profileWithIdentifier("hello", {
  	  println("hello")
  	  Thread.sleep(500L)
    })  


