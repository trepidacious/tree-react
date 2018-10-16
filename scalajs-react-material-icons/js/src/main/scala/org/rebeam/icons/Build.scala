
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Build {

  @JSImport("@material-ui/icons/Build", JSImport.Default)
  @js.native
  object BuildJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BuildJS)
  
  def apply() = jsFnComponent()

}
    