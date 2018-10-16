
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Mms {

  @JSImport("@material-ui/icons/Mms", JSImport.Default)
  @js.native
  object MmsJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MmsJS)
  
  def apply() = jsFnComponent()

}
    