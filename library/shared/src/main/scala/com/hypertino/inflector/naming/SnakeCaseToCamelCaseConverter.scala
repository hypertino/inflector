package com.hypertino.inflector.naming

object SnakeCaseToCamelCaseConverter extends BaseConverter {
  protected val parser = SnakeCaseParser
  protected def createBuilder(): IdentifierBuilder = new CamelCaseBuilder()
}
