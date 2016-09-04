package com.hypertino.inflector

import scala.util.matching.Regex

/*
 * Copyright 2016 Magomed Abdurakhmanov
 *
 * Modified from original sources located at: https://github.com/atteo/evo-inflector
 *
 * Copyright 2011 Atteo.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */


private[inflector] trait Rule {
  def getPlural(singular: String): Option[String]
  def getSingular(plural: String): Option[String]
}

private[inflector] case class RegExpRule (
                                        singularRegex: Regex,
                                        singular: Option[String],
                                        pluralRegex: Option[Regex],
                                        plural: String
                                      ) extends Rule {

  def getPlural(word: String): Option[String] = {
    if (singularRegex.findFirstIn(word).isDefined) {
      Some(singularRegex.replaceFirstIn(word, plural))
    } else {
      None
    }
  }

  def getSingular(word: String): Option[String] = {
    if (pluralRegex.exists(_.findFirstIn(word).isDefined)) {
      Some(pluralRegex.get.replaceFirstIn(word, singular.get))
    } else {
      None
    }
  }
}

private[inflector] case class CategoryRule(singularList: Seq[String], singular: String, plural: String) extends Rule {
  val pluralList = singularList.map { s ⇒
    val w = s.substring(0, s.length - singular.length)
    w + plural
  }

  def getPlural(word: String): Option[String] = {
    val lowerWord: String = word.toLowerCase
    singularList.find(lowerWord.endsWith).map { _ ⇒
      if (!lowerWord.endsWith(singular)) {
        throw new RuntimeException(s"Internal error: $lowerWord doesn't endsWith $singular")
      }
      word.substring(0, word.length - singular.length) + plural
    }
  }

  def getSingular(word: String): Option[String] = {
    val lowerWord: String = word.toLowerCase
    pluralList.find(lowerWord.endsWith).map { _ ⇒
      if (!lowerWord.endsWith(plural)) {
        throw new RuntimeException(s"Internal error: $lowerWord doesn't endsWith $plural")
      }
      word.substring(0, word.length - plural.length) + singular
    }
  }
}

abstract class TwoFormInflector {
  def rules: Seq[Rule]

  def plural(word: String): String = {
    rules.toStream.flatMap(_.getPlural(word)).headOption.getOrElse(word)
  }

  def singular(word: String): String = {
    rules.toStream.flatMap(_.getSingular(word)).headOption.getOrElse(word)
  }

  protected def uncountable(list: String*) : Seq[Rule] = {
    Seq(CategoryRule(list, "", ""))
  }

  protected def irregular(singular: String, plural: String) : Seq[Rule] = {
    if (singular.charAt(0) == plural.charAt(0)) {
      Seq(RegExpRule(
        new Regex("(?i)(" + singular.charAt(0) + ")" + singular.substring(1) + "$"),
        Some("$1" + singular.substring(1)),
        Some(new Regex("(?i)(" + plural.charAt(0) + ")" + plural.substring(1) + "$")),
        "$1" + plural.substring(1)
      ))
    }
    else {
      Seq(
        RegExpRule(
          new Regex(singular.charAt(0).toUpper + "(?i)" + singular.substring(1) + "$"),
          Some(singular.charAt(0).toUpper + singular.substring(1)),
          Some(new Regex(plural.charAt(0).toUpper + "(?i)" + plural.substring(1) + "$")),
          plural.charAt(0).toUpper + plural.substring(1)
        ),

        RegExpRule(
          new Regex(singular.charAt(0).toLower + "(?i)" + singular.substring(1) + "$"),
          Some(singular.charAt(0).toLower + singular.substring(1)),
          Some(new Regex(plural.charAt(0).toLower + "(?i)" + plural.substring(1) + "$")),
          plural.charAt(0).toLower + plural.substring(1)
        )
      )
    }
  }

  protected def irregular(list: (String, String)*) : Seq[Rule] = {
    list.flatMap( pair ⇒
      irregular(pair._1, pair._2)
    )
  }

  protected def rule(singularPattern: String, singular: String, pluralPattern: String, plural: String) : Seq[Rule] = {
    Seq(
      RegExpRule(new Regex("(?i)" +singularPattern), Some(singular),
        Some(new Regex("(?i)" + pluralPattern)), plural)
    )
  }

  protected def rule(singularPattern: String, plural: String) : Seq[Rule] = {
    Seq(
      RegExpRule(new Regex("(?i)" +singularPattern), None, None, plural)
    )
  }

  protected def rulep(list: (String, String, String, String)*) : Seq[Rule] = {
    list.map{ pair ⇒
      RegExpRule(new Regex("(?i)" +pair._1), Some(pair._2), Some(new Regex("(?i)" + pair._3)), pair._4)
    }
  }

  protected def rule(list: (String, String)*) : Seq[Rule] = {
    list.map{ pair ⇒
      RegExpRule(new Regex("(?i)" +pair._1), None, None, pair._2)
    }
  }

  protected def categoryRule(list: Seq[String], singular: String, plural: String) : Seq[Rule] = {
    Seq(CategoryRule(list, singular, plural))
  }
}
