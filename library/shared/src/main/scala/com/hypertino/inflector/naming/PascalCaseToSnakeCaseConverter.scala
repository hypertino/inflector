package com.hypertino.inflector.naming

object PascalCaseToSnakeCaseConverter extends BaseConverter {
  protected val parser = new PascalCaseParser
  protected def createBuilder(): IdentifierBuilder = new SnakeCaseBuilder()
}
