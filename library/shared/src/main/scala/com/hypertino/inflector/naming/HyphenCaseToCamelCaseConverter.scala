package com.hypertino.inflector.naming

object HyphenCaseToCamelCaseConverter extends BaseConverter {
  protected val parser = DashCaseParser
  protected def createBuilder(): IdentifierBuilder = new CamelCaseBuilder()
  override val backwardConverter: Option[Converter] = Some(CamelCaseToHyphenCaseConverter)
}
