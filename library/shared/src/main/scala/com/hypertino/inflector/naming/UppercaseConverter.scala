package com.hypertino.inflector.naming

object UppercaseConverter extends Converter {
  def convert(identifier: String): String = identifier.toUpperCase
}
