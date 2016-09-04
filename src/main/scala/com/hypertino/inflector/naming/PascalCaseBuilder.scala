package com.hypertino.inflector.naming

class PascalCaseBuilder(possibleLength: Option[Int] = None) extends CamelCaseBuilder(possibleLength) {
  nextIsUpperCase = true
}
