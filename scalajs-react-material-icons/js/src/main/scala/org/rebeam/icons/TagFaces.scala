
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object TagFaces {

  @JSImport("@material-ui/icons/TagFaces", JSImport.Default)
  @js.native
  object TagFacesJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TagFacesJS)
  
  def apply() = jsFnComponent()

}
    