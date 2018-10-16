
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object TabletAndroid {

  @JSImport("@material-ui/icons/TabletAndroid", JSImport.Default)
  @js.native
  object TabletAndroidJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TabletAndroidJS)
  
  def apply() = jsFnComponent()

}
    