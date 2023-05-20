package com.hypertino.inflector.naming

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TestDashCaseBuilder extends AnyFlatSpec with Matchers {
  "DashCaseBuilder " should " build string-like-this" in {

    val parser = CamelCaseParser
    val builder = new DashCaseBuilder()

    parser.parse("StringLikeThis", builder)
    val result = builder.toString()

    assert(result == "string-like-this")
  }
}
