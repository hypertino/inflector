package com.hypertino.inflector.naming

object DashCaseToPascalCaseConverter extends BaseConverter {
  val parser = DashCaseParser
  def createBuilder(): IdentifierBuilder = new PascalCaseBuilder()
}
