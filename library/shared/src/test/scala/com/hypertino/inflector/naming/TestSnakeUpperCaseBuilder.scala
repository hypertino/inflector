package com.hypertino.inflector.naming

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TestSnakeUpperCaseBuilder extends AnyFlatSpec with Matchers {
  "SnakeCaseBuilder " should " build STRING_LIKE_THIS" in {

    val parser = CamelCaseParser
    val builder = new SnakeUpperCaseBuilder()

    parser.parse("StringLikeThis", builder)
    builder.toString() shouldBe "STRING_LIKE_THIS"
  }
}
