package com.hypertino.inflector.naming

import org.scalatest.{FlatSpec, Matchers}

class TestCamelCaseBuilder extends FlatSpec with Matchers {
  "CamelCaseBuilder " should " build stringLikeThis" in {

    val parser = SnakeCaseParser
    val builder = new CamelCaseBuilder()

    parser.parse("string_like_this", builder)
    builder.toString() shouldBe "stringLikeThis"
  }
}
