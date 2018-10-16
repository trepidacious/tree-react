
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Description {

  @JSImport("@material-ui/icons/Description", JSImport.Default)
  @js.native
  object DescriptionJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DescriptionJS)
  
  def apply() = jsFnComponent()

}
    