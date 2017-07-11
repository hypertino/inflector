package com.hypertino.inflector.naming

import org.scalatest.{FlatSpec, Matchers}

class TestSnakeCaseParser extends FlatSpec with Matchers {
  "SnakeCaseParser " should " parse string_like_this " in {

    val parser = SnakeCaseParser
    val builder = new CamelCaseBuilder()

    parser.parse("string_like_this", builder)
    val result = builder.toString()

    assert(result == "stringLikeThis")
  }
}
