package com.hypertino.inflector.naming

object SnakeCaseToDashCaseConverter extends BaseConverter {
  protected val parser = SnakeCaseParser
  protected def createBuilder(): IdentifierBuilder = new DashCaseBuilder()
  override val backwardConverter: Option[Converter] = Some(DashCaseToSnakeCaseConverter)
}
