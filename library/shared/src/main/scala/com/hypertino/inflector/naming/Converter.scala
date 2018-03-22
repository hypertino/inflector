package com.hypertino.inflector.naming

trait Converter {
  def convert(identifier: String): String
  def backwardConverter: Option[Converter]
}
