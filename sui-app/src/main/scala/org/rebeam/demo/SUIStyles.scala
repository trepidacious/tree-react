package org.rebeam.demo

import StyleSettings.CssSettings._
import scala.language.postfixOps

object SUIStyles extends StyleSheet.Inline {
  import dsl._

  val checkboxLabelFitted: StyleA = style(
    paddingRight(2 em).important
  )

  val checkboxToggleLabelFitted: StyleA = style(
    paddingRight(4.5 em).important
  )
}
