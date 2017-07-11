package com.hypertino.inflector.naming

import org.scalatest.{FlatSpec, Matchers}

class TestPascalCaseBuilder extends FlatSpec with Matchers {
  "PascalCaseBuilder " should " build stringLikeThis" in {

    val parser = SnakeCaseParser
    val builder = new PascalCaseBuilder()

    parser.parse("string_like_this", builder)
    val result = builder.toString()

    assert(result == "StringLikeThis")
  }
}
