package com.hypertino.inflector.naming

object DashCaseToUpperSnakeCaseConverter extends BaseConverter {
  val parser = DashCaseParser
  def createBuilder(): IdentifierBuilder = new SnakeUpperCaseBuilder()
  override val backwardConverter: Option[Converter] = Some(SnakeCaseToDashCaseConverter)
}
