package com.hypertino.inflector.naming

class LowercaseConverter extends Converter {
  def convert(identifier: String): String = identifier.toLowerCase
}
