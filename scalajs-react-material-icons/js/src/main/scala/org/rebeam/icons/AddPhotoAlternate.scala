
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AddPhotoAlternate {

  @JSImport("@material-ui/icons/AddPhotoAlternate", JSImport.Default)
  @js.native
  object AddPhotoAlternateJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AddPhotoAlternateJS)
  
  def apply() = jsFnComponent()

}
    