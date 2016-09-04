package com.hypertino.inflector.naming

import org.scalatest.{FlatSpec, Matchers}

class TestSnakeUpperCaseParser extends FlatSpec with Matchers {
  "SnakeUpperCaseParser " should " parse STRING_LIKE_THIS " in {

    val parser = new SnakeUpperCaseParser()
    val builder = new CamelCaseBuilder()

    parser.parse("STRING_LIKE_THIS", builder)
    builder.toString() shouldBe "stringLikeThis"
  }
}
