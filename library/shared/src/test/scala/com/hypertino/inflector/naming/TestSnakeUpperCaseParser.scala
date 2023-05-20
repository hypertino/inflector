package com.hypertino.inflector.naming

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TestSnakeUpperCaseParser extends AnyFlatSpec with Matchers {
  "SnakeUpperCaseParser " should " parse STRING_LIKE_THIS " in {

    val parser = SnakeCaseParser
    val builder = new CamelCaseBuilder()

    parser.parse("STRING_LIKE_THIS", builder)
    builder.toString() shouldBe "stringLikeThis"
  }
}
