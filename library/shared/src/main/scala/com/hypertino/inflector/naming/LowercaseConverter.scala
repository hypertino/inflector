package com.hypertino.inflector.naming

object LowercaseConverter extends Converter {
  def convert(identifier: String): String = identifier.toLowerCase
}
