package com.hypertino.inflector.naming

import org.scalatest.{FlatSpec, Matchers}

class TestCamelCaseParser extends FlatSpec with Matchers {
  "CamelCaseParser " should " parse stringLikeThis " in {
    val parser = CamelCaseParser
    val builder = new SnakeCaseBuilder()

    parser.parse("stringLikeThis", builder)
    builder.toString() shouldBe "string_like_this"
  }

  "CamelCaseParser " should " parse string1Like2This3 " in {
    val parser = CamelCaseParser
    val builder = new SnakeCaseBuilder()

    parser.parse("string1Like2This3", builder)
    val result = builder.toString()

    assert(result == "string1_like2_this3")
  }
}
