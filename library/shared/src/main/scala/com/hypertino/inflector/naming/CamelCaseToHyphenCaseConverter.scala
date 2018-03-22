package com.hypertino.inflector.naming

object CamelCaseToHyphenCaseConverter extends BaseConverter {
  protected val parser = CamelCaseParser
  protected def createBuilder(): IdentifierBuilder = new HyphenCaseBuilder()
  override val backwardConverter: Option[Converter] = Some(HyphenCaseToCamelCaseConverter)
}
