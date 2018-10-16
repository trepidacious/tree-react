
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object GTranslate {

  @JSImport("@material-ui/icons/GTranslate", JSImport.Default)
  @js.native
  object GTranslateJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](GTranslateJS)
  
  def apply() = jsFnComponent()

}
    