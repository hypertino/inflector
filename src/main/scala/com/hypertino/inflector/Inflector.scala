package com.hypertino.inflector

trait Inflector {
  def plural(word: String, count: Int): String
  def plural(word: String): String
  def singular(word: String): String
}
