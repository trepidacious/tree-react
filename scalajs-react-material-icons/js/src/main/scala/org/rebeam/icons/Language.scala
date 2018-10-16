
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Language {

  @JSImport("@material-ui/icons/Language", JSImport.Default)
  @js.native
  object LanguageJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LanguageJS)
  
  def apply() = jsFnComponent()

}
    