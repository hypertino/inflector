package com.hypertino.inflector.naming

object PlainConverter extends Converter {
  def convert(identifier: String): String = identifier
}
