
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PlayForWork {

  @JSImport("@material-ui/icons/PlayForWork", JSImport.Default)
  @js.native
  object PlayForWorkJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PlayForWorkJS)
  
  def apply() = jsFnComponent()

}
    