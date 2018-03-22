package com.hypertino.inflector.naming

object SnakeCaseToPascalCaseConverter extends BaseConverter {
  protected val parser = SnakeCaseParser
  protected def createBuilder(): IdentifierBuilder = new PascalCaseBuilder()
  override val backwardConverter: Option[Converter] = Some(PascalCaseToSnakeCaseConverter)
}
