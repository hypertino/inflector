package com.hypertino.inflector.naming

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


class TestDashCaseParser extends AnyFlatSpec with Matchers {
  "SnakeCaseParser " should " parse string-like-this " in {

    val parser = DashCaseParser
    val builder = new CamelCaseBuilder()

    parser.parse("string-like-this", builder)
    val result = builder.toString()

    assert(result == "stringLikeThis")
  }
}
