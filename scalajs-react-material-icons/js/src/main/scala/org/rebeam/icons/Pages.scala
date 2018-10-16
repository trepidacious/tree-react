
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Pages {

  @JSImport("@material-ui/icons/Pages", JSImport.Default)
  @js.native
  object PagesJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PagesJS)
  
  def apply() = jsFnComponent()

}
    