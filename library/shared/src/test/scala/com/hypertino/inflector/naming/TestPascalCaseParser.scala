package com.hypertino.inflector.naming

import org.scalatest.{FlatSpec, Matchers}

class TestPascalCaseParser extends FlatSpec with Matchers {
  "PascalCaseParser " should " parse StringLikeThis " in {

    val parser = CamelCaseParser
    val builder = new SnakeCaseBuilder()

    parser.parse("StringLikeThis", builder)
    val result = builder.toString()

    assert(result == "string_like_this")
  }
}
