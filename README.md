[![Build Status](https://travis-ci.org/hypertino/inflector.svg)](https://travis-ci.org/hypertino/inflector)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.hypertino/inflector_2.12/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.hypertino/inflector_2.12)

# About

_Inflector_ is a Scala/Scala.js library which implements English pluralization and singularization along
with popular identifier's naming convention transformation.

Pluralization is based on based on Damian Conway's paper
["An Algorithmic Approach to English Pluralization"](http://www.csse.monash.edu.au/~damian/papers/HTML/Plurals.html)
and borrows some code from it's [java implementation by Atteo](https://github.com/atteo/evo-inflector)

I've additionally implemented English singularization, it works for me, however didn't checked it very intensively.

# Usage

## Installation

The artifacts for _Inflector_ live on Maven Central and can be tied into your SBT-based Scala project like this:

```sbt
libraryDependencies += "com.hypertino" %% "inflector" % "1.0.1"
```
It is available for Scala 2.11, Scala 2.12, Scala.js 0.6

## Pluralization

```scala
import com.hypertino.inflector.English

println(English.plural("cat")) // -> cats
println(English.plural("cat", 1)) // -> cat
println(English.plural("cat", 2)) // -> cats
println(English.singular("cats")) // -> cat
```

## Identifier conventions


```scala
import com.hypertino.inflector.naming._

println(SnakeCaseToCamelCaseConverter.convert("string_like_this")) // -> stringLikeThis
println(CamelCaseToDashCaseConverter.convert("stringLikeThis")) // -> string-like-this
println(CamelCaseToHyphenCaseConverter.convert("stringLikeThis")) // -> String-Like-This
```
You may also convert back to camel-case and construct other converters.

# License

_Inflector_ library is available under the BSD 3-Clause License

