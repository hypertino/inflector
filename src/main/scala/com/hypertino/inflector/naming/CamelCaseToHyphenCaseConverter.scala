package com.hypertino.inflector.naming

object CamelCaseToHyphenCaseConverter extends BaseConverter {
  protected val parser = new CamelCaseParser
  protected def createBuilder(): IdentifierBuilder = new HyphenCaseBuilder()
}
