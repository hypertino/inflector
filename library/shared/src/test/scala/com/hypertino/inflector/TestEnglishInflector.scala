package com.hypertino.inflector

import org.scalatest.{FlatSpec, Matchers}

class TestEnglishInflector extends FlatSpec with Matchers {
  val exampleWords = Map(
    ("alga", "algae"),
    ("nova", "novas"),
    ("dogma", "dogmas"),
    ("Woman", "Women"),
    ("church", "churches"),
    ("quick_chateau", "quick_chateaus"),
    ("codex", "codices"),
    ("index", "indexes"),
    ("NightWolf", "NightWolves"),
    ("Milieu", "Milieus"),
    ("basis", "bases"),
    ("iris", "irises"),
    ("phalanx", "phalanxes"),
    ("tempo", "tempos"),
    ("foot", "feet"),
    ("series", "series"),
    ("WorldAtlas", "WorldAtlases"),
    ("wish", "wishes"),
    ("Bacterium", "Bacteria"),
    ("medium", "mediums"),
    ("Genus", "Genera"),
    ("stimulus", "stimuli"),
    ("opus", "opuses"),
    ("status", "statuses"),
    ("Box", "Boxes"),
    ("ferry", "ferries"),
    ("protozoon", "protozoa"),
    ("cherub", "cherubs"),
    ("human", "humans"),
    ("sugar", "sugar"),
    ("virus", "viruses"),
    ("gastrostomy", "gastrostomies"),
    ("baculum", "bacula"),
    ("pancreas", "pancreases"),
    ("todo", "todos"),
    ("status", "statuses"),
    ("slice", "slices"),
    ("cookie", "cookies"),
    ("response", "responses"),
    ("case", "cases"),
    ("each", "each"),
    ("license", "licenses")
  )

  "EnglishInflector " should " pluralize exampleWordList" in {
    exampleWords.foreach { kv ⇒
      kv._2 shouldBe English.plural(kv._1)
    }
  }

  "EnglishInflector " should " pluralize withCount" in {
    "cat" shouldBe English.plural("cat", 1)
    "cats" shouldBe English.plural("cat", 2)
    "demoness" shouldBe English.plural("demoness", 1)
    "demonesses" shouldBe English.plural("demoness", 2)
  }

  "EnglishInflector staticMethods " should " pluralize" in {
    "sulfimides" shouldBe English.plural("sulfimide")
    "semifluids" shouldBe English.plural("semifluid", 2)
  }

  "EnglishInflector " should " singularize exampleWordList" in {
    exampleWords.foreach { kv ⇒
      kv._1 shouldBe English.singular(kv._2)
    }
  }

  "EnglishInflector staticMethods " should " singularize" in {
    "sulfimide" shouldBe English.singular("sulfimides")
    "semifluid" shouldBe English.singular("semifluids")
    "cat" shouldBe English.singular("cats")
  }
}
