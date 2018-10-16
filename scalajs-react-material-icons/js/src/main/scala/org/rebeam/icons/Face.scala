
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Face {

  @JSImport("@material-ui/icons/Face", JSImport.Default)
  @js.native
  object FaceJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FaceJS)
  
  def apply() = jsFnComponent()

}
    