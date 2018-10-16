
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Translate {

  @JSImport("@material-ui/icons/Translate", JSImport.Default)
  @js.native
  object TranslateJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TranslateJS)
  
  def apply() = jsFnComponent()

}
    