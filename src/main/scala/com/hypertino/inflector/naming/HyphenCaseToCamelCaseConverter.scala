package com.hypertino.inflector.naming

object HyphenCaseToCamelCaseConverter extends BaseConverter {
  protected val parser = new DashCaseParser
  protected def createBuilder(): IdentifierBuilder = new CamelCaseBuilder()
}
