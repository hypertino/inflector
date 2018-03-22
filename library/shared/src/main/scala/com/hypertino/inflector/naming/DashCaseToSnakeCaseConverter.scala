package com.hypertino.inflector.naming

object DashCaseToSnakeCaseConverter extends BaseConverter {
  protected val parser = DashCaseParser
  protected def createBuilder(): IdentifierBuilder = new SnakeCaseBuilder()
  override val backwardConverter: Option[Converter] = Some(SnakeCaseToDashCaseConverter)
}
