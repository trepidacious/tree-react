
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Transform {

  @JSImport("@material-ui/icons/Transform", JSImport.Default)
  @js.native
  object TransformJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TransformJS)
  
  def apply() = jsFnComponent()

}
    