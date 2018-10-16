
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object GroupAdd {

  @JSImport("@material-ui/icons/GroupAdd", JSImport.Default)
  @js.native
  object GroupAddJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](GroupAddJS)
  
  def apply() = jsFnComponent()

}
    