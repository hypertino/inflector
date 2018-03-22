package com.hypertino.inflector.naming

object CamelCaseToSnakeCaseConverter extends BaseConverter {
  protected val parser = CamelCaseParser
  protected def createBuilder(): IdentifierBuilder = new SnakeCaseBuilder()
  override val backwardConverter: Option[Converter] = Some(SnakeCaseToCamelCaseConverter)
}
