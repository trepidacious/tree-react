
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LiveTv {

  @JSImport("@material-ui/icons/LiveTv", JSImport.Default)
  @js.native
  object LiveTvJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LiveTvJS)
  
  def apply() = jsFnComponent()

}
    