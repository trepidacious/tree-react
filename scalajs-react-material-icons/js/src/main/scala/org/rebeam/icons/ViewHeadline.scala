
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ViewHeadline {

  @JSImport("@material-ui/icons/ViewHeadline", JSImport.Default)
  @js.native
  object ViewHeadlineJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ViewHeadlineJS)
  
  def apply() = jsFnComponent()

}
    