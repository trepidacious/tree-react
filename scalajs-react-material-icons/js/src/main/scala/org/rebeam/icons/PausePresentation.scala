
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PausePresentation {

  @JSImport("@material-ui/icons/PausePresentation", JSImport.Default)
  @js.native
  object PausePresentationJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PausePresentationJS)
  
  def apply() = jsFnComponent()

}
    