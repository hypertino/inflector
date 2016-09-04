package com.hypertino.inflector.naming

import org.scalatest.{FlatSpec, Matchers}

class TestSnakeUpperCaseBuilder extends FlatSpec with Matchers {
  "SnakeCaseBuilder " should " build STRING_LIKE_THIS" in {

    val parser = new PascalCaseParser()
    val builder = new SnakeUpperCaseBuilder()

    parser.parse("StringLikeThis", builder)
    builder.toString() shouldBe "STRING_LIKE_THIS"
  }
}
