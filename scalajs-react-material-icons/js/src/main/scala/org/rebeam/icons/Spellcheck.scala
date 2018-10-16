
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Spellcheck {

  @JSImport("@material-ui/icons/Spellcheck", JSImport.Default)
  @js.native
  object SpellcheckJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SpellcheckJS)
  
  def apply() = jsFnComponent()

}
    