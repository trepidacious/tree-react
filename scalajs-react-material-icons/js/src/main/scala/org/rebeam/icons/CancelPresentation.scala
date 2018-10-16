
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CancelPresentation {

  @JSImport("@material-ui/icons/CancelPresentation", JSImport.Default)
  @js.native
  object CancelPresentationJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CancelPresentationJS)
  
  def apply() = jsFnComponent()

}
    