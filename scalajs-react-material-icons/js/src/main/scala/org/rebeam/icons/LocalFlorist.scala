
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocalFlorist {

  @JSImport("@material-ui/icons/LocalFlorist", JSImport.Default)
  @js.native
  object LocalFloristJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocalFloristJS)
  
  def apply() = jsFnComponent()

}
    