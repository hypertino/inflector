package com.hypertino.inflector

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

class EnglishInflector(val anglicizedEnglish: Boolean) extends TwoFormInflector with Inflector {
  def plural(word: String, count: Int): String = {
    if (count == 1) {
      word
    }
    else {
      plural(word)
    }
  }

  val rules: Seq[Rule] =
    uncountable("fish", "ois", "sheep", "deer", "pox", "itis", "bison", "flounder",
      "pliers", "bream", "gallows", "proceedings", "breeches", "graffiti", "rabies", "britches",
      "headquarters", "salmon", "carp", "herpes", "scissors", "chassis", "high-jinks", "sea-bass",
      "clippers", "homework", "series", "cod", "innings", "shears", "contretemps", "jackanapes",
      "species", "corps", "mackerel", "swine", "debris", "measles", "trout", "diabetes", "mews",
      "tuna", "djinn", "mumps", "whiting", "eland", "news", "wildebeest", "elk", "pincers", "sugar", "each") ++
    irregular(("child", "children"), ("ephemeris", "ephemerides"), ("mongoose", "mongoose"),
      ("mythos", "mythoi"), ("soliloquy", "soliloquies"), ("trilby", "trilbys"), ("genus", "genera"),
      ("quiz", "quizzes"), ("basis", "bases"), ("slice", "slices"), ("cookie", "cookies"), ("response", "responses"),
      ("case", "cases"), ("license", "licenses"), ("licence", "licences")) ++ {
      if (anglicizedEnglish) {
        irregular(("beef", "beefs"), ("brother", "brothers"), ("cow", "cows"),
          ("genie", "genies"), ("money", "moneys"), ("octopus", "octopuses"), ("opus", "opuses"))
      }
      else {
        irregular(("beef", "beeves"), ("brother", "brethren"), ("cos", "kine"),
          ("genie", "genii"), ("money", "monies"), ("octopus", "octopodes"), ("opus", "opera"))
      }
    } ++
    categoryRule(EnglishInflector.CATEGORY_MAN_MANS, "", "s") ++
    rulep(("man$", "man", "men$", "men"), ("([lm])ouse$", "$1ouse", "([lm])ice", "$1ice"),
      ("tooth$", "tooth", "teeth$", "teeth"), ("goose$", "goose", "geese$", "geese"),
      ("foot$", "foot", "feet$", "feet"), ("zoon$", "zoon", "zoa$", "zoa")) ++
    rule("([csx])is$", "$1es") ++
    categoryRule(EnglishInflector.CATEGORY_EX_ICES, "ex", "ices") ++
    categoryRule(EnglishInflector.CATEGORY_IX_ICES, "ix", "ices") ++
    categoryRule(EnglishInflector.CATEGORY_UM_A, "um", "a") ++
    categoryRule(EnglishInflector.CATEGORY_ON_A, "on", "a") ++
    categoryRule(EnglishInflector.CATEGORY_A_AE, "a", "ae") ++ {
      if (!anglicizedEnglish) {
        rulep(("trix$", "trix", "trices$", "trices"), ("eau$", "eau", "eaux$", "eaux"),
          ("ieu$", "ieu", "ieux$", "ieux")) ++
        rule("(..[iay])nx$", "$1nx", "(..[iay])nges$", "$1nges") ++
        categoryRule(EnglishInflector.CATEGORY_EN_INA, "en", "ina") ++
        categoryRule(EnglishInflector.CATEGORY_A_ATA, "a", "ata") ++
        categoryRule(EnglishInflector.CATEGORY_IS_IDES, "is", "ides") ++
        categoryRule(EnglishInflector.CATEGORY_US_US, "", "") ++
        categoryRule(EnglishInflector.CATEGORY_O_I, "o", "i") ++
        categoryRule(EnglishInflector.CATEGORY_NONE_I, "", "i") ++
        categoryRule(EnglishInflector.CATEGORY_NONE_IM, "", "im") ++
        categoryRule(EnglishInflector.CATEGORY_EX_EXES, "ex", "ices") ++
        categoryRule(EnglishInflector.CATEGORY_IX_IXES, "ix", "ices")
      } else {
        Seq.empty
      }
    } ++
    categoryRule(EnglishInflector.CATEGORY_US_I, "us", "i") ++
    rulep(("([cs]h)$", "$1", "([cs]h)es$", "$1es"),
      ("([zx])$", "$1", "([zx])es$", "$1es")) ++
    categoryRule(EnglishInflector.CATEGORY_S_ES, "", "es") ++
    categoryRule(EnglishInflector.CATEGORY_IS_IDES, "", "es") ++
    categoryRule(EnglishInflector.CATEGORY_US_US, "", "es") ++
    rule("(us)$", "$1x", "xes($)", "$1es") ++
    categoryRule(EnglishInflector.CATEGORY_A_ATA, "", "s") ++
    rule("([cs])h$", "$1hes") ++
    rule("ss$", "ss", "sses$", "sses") ++
    rule("([aeo]l)f$", "$1f", "([aeo]l)ves$", "$1ves") ++
    rulep(("([^d]ea)f$", "$1f", "([^d]ea)ves$", "$1ves"),
      ("(ar)f$", "$1f$", "(ar)ves$", "$1ves"),
      ("([nlw]i)fe$", "$1fe", "([nlw]i)ves$", "$1ves"),
      ("([aeiou])y$", "$1y", "([aeiou])ys$", "$1ys"),
      ("y$", "y", "ies$", "ies")) ++
    categoryRule(EnglishInflector.CATEGORY_O_I, "o", "os") ++
    categoryRule(EnglishInflector.CATEGORY_O_OS, "o", "os") ++
    rule("([aeiou])o$", "$1o", "([aeiou])os$", "$1os") ++
    rule("o$", "o", "oes$", "oes") ++
    rule("ulum", "ulum", "ula", "ula") ++
    categoryRule(EnglishInflector.CATEGORY_A_ATA, "", "es") ++
    rule("s$", "s", "ses$", "ses") ++
    rule("$", "", "s$", "s")

  def this() {
    this(anglicizedEnglish = true)
  }
}

object EnglishInflector {
  private val CATEGORY_EX_ICES= Seq("codex", "murex", "silex")
  private val CATEGORY_IX_ICES= Seq("radix", "helix")
  private val CATEGORY_UM_A= Seq("bacterium", "agendum", "desideratum", "erratum", "stratum", "datum", "ovum",
    "extremum", "candelabrum")
  private val CATEGORY_US_I= Seq("alumnus", "alveolus", "bacillus", "bronchus", "locus", "nucleus", "stimulus",
    "meniscus", "thesaurus")
  private val CATEGORY_ON_A= Seq("criterion", "perihelion", "aphelion", "phenomenon", "prolegomenon", "noumenon",
    "organon", "asyndeton", "hyperbaton")
  private val CATEGORY_A_AE= Seq("alumna", "alga", "vertebra", "persona")
  private val CATEGORY_O_OS= Seq("albino", "archipelago", "armadillo", "commando", "crescendo", "fiasco", "ditto",
    "dynamo", "embryo", "ghetto", "guano", "inferno", "jumbo", "lumbago", "magneto", "manifesto", "medico", "octavo",
    "photo", "pro", "quarto", "canto", "lingo", "generalissimo", "stylo", "rhino", "casino", "auto", "macro", "zero",
    "todo")
  private val CATEGORY_O_I= Seq("solo", "soprano", "basso", "alto", "contralto", "tempo", "piano", "virtuoso")
  private val CATEGORY_EN_INA= Seq("stamen", "foramen", "lumen")
  private val CATEGORY_A_ATA= Seq("anathema", "enema", "oedema", "bema", "enigma", "sarcoma", "carcinoma", "gumma",
    "schema", "charisma", "lemma", "soma", "diploma", "lymphoma", "stigma", "dogma", "magma", "stoma", "drama",
    "melisma", "trauma", "edema", "miasma")
  private val CATEGORY_IS_IDES= Seq("iris", "clitoris")
  private val CATEGORY_US_US= Seq("apparatus", "impetus", "prospectus", "cantus", "nexus", "sinus", "coitus", "plexus",
    "status", "hiatus")
  private val CATEGORY_NONE_I= Seq("afreet", "afrit", "efreet")
  private val CATEGORY_NONE_IM= Seq("cherub", "goy", "seraph")
  private val CATEGORY_EX_EXES= Seq("apex", "latex", "vertex", "cortex", "pontifex", "vortex", "index", "simplex")
  private val CATEGORY_IX_IXES= Seq("appendix")
  private val CATEGORY_S_ES= Seq("acropolis", "chaos", "lens", "aegis", "cosmos", "mantis", "alias", "dais", "marquis",
    "asbestos", "digitalis", "metropolis", "atlas", "epidermis", "pathos", "bathos", "ethos", "pelvis", "bias", "gas",
    "polis", "caddis", "glottis", "rhinoceros", "cannabis", "glottis", "sassafras", "canvas", "ibis", "trellis")
  private val CATEGORY_MAN_MANS= Seq("human", "Alabaman", "Bahaman", "Burman", "German", "Hiroshiman", "Liman",
    "Nakayaman", "Oklahoman", "Panaman", "Selman", "Sonaman", "Tacoman", "Yakiman", "Yokohaman", "Yuman")
}
