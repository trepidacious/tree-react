
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Class {

  @JSImport("@material-ui/icons/Class", JSImport.Default)
  @js.native
  object ClassJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ClassJS)
  
  def apply() = jsFnComponent()

}
    