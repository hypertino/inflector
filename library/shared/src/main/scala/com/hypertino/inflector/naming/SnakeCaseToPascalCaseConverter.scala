package com.hypertino.inflector.naming

object SnakeCaseToPascalCaseConverter extends BaseConverter {
  protected val parser = new SnakeCaseParser
  protected def createBuilder(): IdentifierBuilder = new PascalCaseBuilder()
}
