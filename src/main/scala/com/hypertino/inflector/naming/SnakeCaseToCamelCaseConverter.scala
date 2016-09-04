package com.hypertino.inflector.naming

object SnakeCaseToCamelCaseConverter extends BaseConverter {
  protected val parser = new SnakeCaseParser
  protected def createBuilder(): IdentifierBuilder = new CamelCaseBuilder()
}
