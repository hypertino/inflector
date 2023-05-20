package com.hypertino.inflector.naming

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


class TestPascalCaseBuilder extends AnyFlatSpec with Matchers {
  "PascalCaseBuilder " should " build stringLikeThis" in {

    val parser = SnakeCaseParser
    val builder = new PascalCaseBuilder()

    parser.parse("string_like_this", builder)
    val result = builder.toString()

    assert(result == "StringLikeThis")
  }
}
