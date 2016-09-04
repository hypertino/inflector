package com.hypertino.inflector.naming

class SnakeCaseToPascalCaseConverter extends BaseConverter {
  protected val parser = new SnakeCaseParser
  protected def createBuilder(): IdentifierBuilder = new PascalCaseBuilder()
}
