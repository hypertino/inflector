package com.hypertino.inflector.naming

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TestCamelCaseBuilder extends AnyFlatSpec with Matchers {
  "CamelCaseBuilder " should " build stringLikeThis" in {

    val parser = SnakeCaseParser
    val builder = new CamelCaseBuilder()

    parser.parse("string_like_this", builder)
    builder.toString() shouldBe "stringLikeThis"
  }
}
