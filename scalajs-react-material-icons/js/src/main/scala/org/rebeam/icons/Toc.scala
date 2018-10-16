
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Toc {

  @JSImport("@material-ui/icons/Toc", JSImport.Default)
  @js.native
  object TocJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TocJS)
  
  def apply() = jsFnComponent()

}
    