
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Today {

  @JSImport("@material-ui/icons/Today", JSImport.Default)
  @js.native
  object TodayJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TodayJS)
  
  def apply() = jsFnComponent()

}
    