package com.hypertino.inflector.naming

trait IdentifierParser {
  def parse(identifier: String, builder: IdentifierBuilder)
}
