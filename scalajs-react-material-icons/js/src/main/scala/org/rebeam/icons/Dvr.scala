
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Dvr {

  @JSImport("@material-ui/icons/Dvr", JSImport.Default)
  @js.native
  object DvrJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DvrJS)
  
  def apply() = jsFnComponent()

}
    