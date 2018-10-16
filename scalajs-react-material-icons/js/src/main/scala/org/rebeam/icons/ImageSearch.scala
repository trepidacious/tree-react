
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ImageSearch {

  @JSImport("@material-ui/icons/ImageSearch", JSImport.Default)
  @js.native
  object ImageSearchJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ImageSearchJS)
  
  def apply() = jsFnComponent()

}
    