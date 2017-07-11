package com.hypertino.inflector.naming

import org.scalatest.{FlatSpec, Matchers}

class TestDashCaseParser extends FlatSpec with Matchers {
  "SnakeCaseParser " should " parse string-like-this " in {

    val parser = DashCaseParser
    val builder = new CamelCaseBuilder()

    parser.parse("string-like-this", builder)
    val result = builder.toString()

    assert(result == "stringLikeThis")
  }
}
