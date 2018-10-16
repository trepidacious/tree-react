
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object InsertPhoto {

  @JSImport("@material-ui/icons/InsertPhoto", JSImport.Default)
  @js.native
  object InsertPhotoJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](InsertPhotoJS)
  
  def apply() = jsFnComponent()

}
    