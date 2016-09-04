package com.hypertino.inflector.naming

import org.scalatest.{FlatSpec, Matchers}

class TestSnakeCaseBuilder extends FlatSpec with Matchers {
  "SnakeCaseBuilder " should " build string_like_this" in {

    val parser = new PascalCaseParser()
    val builder = new SnakeCaseBuilder()

    parser.parse("StringLikeThis", builder)
    val result = builder.toString()

    assert(result == "string_like_this")
  }
}
