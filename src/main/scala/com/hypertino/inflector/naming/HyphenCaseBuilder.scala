package com.hypertino.inflector.naming

class HyphenCaseBuilder(possibleLength: Option[Int] = None) extends IdentifierBuilder {
  private val sb = possibleLength.map {
    new StringBuilder(_)
  } getOrElse {
    new StringBuilder
  }

  protected var nextIsUpperCase = true

  override def divider(): Unit = {
    nextIsUpperCase = true
    sb.append('-')
  }

  override def regular(c: Char): Unit = {
    if (nextIsUpperCase)
      sb.append(c.toUpper)
    else
      sb.append(c.toLower)
    nextIsUpperCase = false
  }

  override def toString = {
    sb.toString
  }
}
