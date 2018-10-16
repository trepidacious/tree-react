
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AddToPhotos {

  @JSImport("@material-ui/icons/AddToPhotos", JSImport.Default)
  @js.native
  object AddToPhotosJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AddToPhotosJS)
  
  def apply() = jsFnComponent()

}
    