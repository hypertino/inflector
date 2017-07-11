package com.hypertino.inflector.naming

object DashCaseParser extends IdentifierParser {
  override def parse(identifier: String, builder: IdentifierBuilder): Unit = {
    var prevIsDash = false
    var dashConsumed = false
    for (c <- identifier) {
      if (prevIsDash) {
        builder.divider()
        builder.regular(c)
        dashConsumed = true
        prevIsDash = false
      }
      else {
        if (c == '-') {
          prevIsDash = true
          dashConsumed = false
        } else {
          builder.regular(c)
          prevIsDash = false
        }
      }
    }
    if (prevIsDash && !dashConsumed) {
      builder.regular('-')
    }
  }
}
