package com.hypertino.inflector.naming

object LowercaseConverter extends Converter {
  def convert(identifier: String): String = identifier.toLowerCase
  override val backwardConverter: Option[Converter] = Some(UppercaseConverter)
}
