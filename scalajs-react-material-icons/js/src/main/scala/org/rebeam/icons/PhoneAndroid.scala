
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PhoneAndroid {

  @JSImport("@material-ui/icons/PhoneAndroid", JSImport.Default)
  @js.native
  object PhoneAndroidJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PhoneAndroidJS)
  
  def apply() = jsFnComponent()

}
    