package com.hypertino.inflector.naming

object CamelCaseToSnakeCaseConverter extends BaseConverter {
  protected val parser = new CamelCaseParser
  protected def createBuilder(): IdentifierBuilder = new SnakeCaseBuilder()
}
