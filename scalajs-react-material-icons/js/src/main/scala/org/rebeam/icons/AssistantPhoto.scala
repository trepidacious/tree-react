
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AssistantPhoto {

  @JSImport("@material-ui/icons/AssistantPhoto", JSImport.Default)
  @js.native
  object AssistantPhotoJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AssistantPhotoJS)
  
  def apply() = jsFnComponent()

}
    