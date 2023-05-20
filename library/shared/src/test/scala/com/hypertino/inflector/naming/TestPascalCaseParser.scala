package com.hypertino.inflector.naming

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TestPascalCaseParser extends AnyFlatSpec with Matchers {
  "PascalCaseParser " should " parse StringLikeThis " in {

    val parser = CamelCaseParser
    val builder = new SnakeCaseBuilder()

    parser.parse("StringLikeThis", builder)
    val result = builder.toString()

    assert(result == "string_like_this")
  }
}
