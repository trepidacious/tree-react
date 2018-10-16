
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PlayCircleFilled {

  @JSImport("@material-ui/icons/PlayCircleFilled", JSImport.Default)
  @js.native
  object PlayCircleFilledJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PlayCircleFilledJS)
  
  def apply() = jsFnComponent()

}
    