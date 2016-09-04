package com.hypertino.inflector.naming

trait IdentifierBuilder {
  def regular(c: Char)

  def divider()

  def toString: String
}
