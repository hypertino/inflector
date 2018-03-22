package com.hypertino.inflector.naming

object UppercaseConverter extends Converter {
  def convert(identifier: String): String = identifier.toUpperCase
  override val backwardConverter: Option[Converter] = Some(LowercaseConverter)
}
