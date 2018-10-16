
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object GroupWork {

  @JSImport("@material-ui/icons/GroupWork", JSImport.Default)
  @js.native
  object GroupWorkJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](GroupWorkJS)
  
  def apply() = jsFnComponent()

}
    