
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Share {

  @JSImport("@material-ui/icons/Share", JSImport.Default)
  @js.native
  object ShareJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ShareJS)
  
  def apply() = jsFnComponent()

}
    