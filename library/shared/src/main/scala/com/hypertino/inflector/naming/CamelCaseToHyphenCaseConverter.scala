package com.hypertino.inflector.naming

object CamelCaseToHyphenCaseConverter extends BaseConverter {
  protected val parser = CamelCaseParser
  protected def createBuilder(): IdentifierBuilder = new HyphenCaseBuilder()
}
