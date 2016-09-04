package com.hypertino.inflector.naming

trait BaseConverter extends Converter {
  protected def parser: IdentifierParser
  protected def createBuilder(): IdentifierBuilder

  def convert(identifier: String): String = {
    val b = createBuilder()
    parser.parse(identifier, b)
    b.toString()
  }
}
