
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AddAPhoto {

  @JSImport("@material-ui/icons/AddAPhoto", JSImport.Default)
  @js.native
  object AddAPhotoJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AddAPhotoJS)
  
  def apply() = jsFnComponent()

}
    