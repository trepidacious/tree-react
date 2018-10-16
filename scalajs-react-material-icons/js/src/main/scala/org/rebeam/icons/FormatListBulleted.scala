
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FormatListBulleted {

  @JSImport("@material-ui/icons/FormatListBulleted", JSImport.Default)
  @js.native
  object FormatListBulletedJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FormatListBulletedJS)
  
  def apply() = jsFnComponent()

}
    