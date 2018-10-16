
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocalSee {

  @JSImport("@material-ui/icons/LocalSee", JSImport.Default)
  @js.native
  object LocalSeeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocalSeeJS)
  
  def apply() = jsFnComponent()

}
    