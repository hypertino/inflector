package com.hypertino.inflector.naming

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


class TestConverters extends AnyFlatSpec with Matchers {
  "SnakeCaseToCamelCaseConverter " should " convert string_like_this " in {
    SnakeCaseToCamelCaseConverter.convert("string_like_this") shouldBe "stringLikeThis"
  }
  "CamelCaseToDashCaseConverter " should " convert string_like_this " in {
    CamelCaseToDashCaseConverter.convert("stringLikeThis") shouldBe "string-like-this"
  }
  "CamelCaseToHyphenCaseConverter " should " convert string_like_this " in {
    CamelCaseToHyphenCaseConverter.convert("stringLikeThis") shouldBe "String-Like-This"
  }
}
