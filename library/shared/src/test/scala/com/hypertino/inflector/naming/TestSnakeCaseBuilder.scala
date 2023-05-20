package com.hypertino.inflector.naming

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TestSnakeCaseBuilder extends AnyFlatSpec with Matchers {
  "SnakeCaseBuilder " should " build string_like_this" in {

    val parser = CamelCaseParser
    val builder = new SnakeCaseBuilder()

    parser.parse("StringLikeThis", builder)
    val result = builder.toString()

    assert(result == "string_like_this")
  }
}
