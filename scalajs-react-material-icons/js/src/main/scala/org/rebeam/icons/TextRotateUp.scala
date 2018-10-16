
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object TextRotateUp {

  @JSImport("@material-ui/icons/TextRotateUp", JSImport.Default)
  @js.native
  object TextRotateUpJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TextRotateUpJS)
  
  def apply() = jsFnComponent()

}
    