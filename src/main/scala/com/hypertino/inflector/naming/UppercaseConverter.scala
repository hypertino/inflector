package com.hypertino.inflector.naming

class UppercaseConverter extends Converter {
  def convert(identifier: String): String = identifier.toUpperCase
}
