
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Drafts {

  @JSImport("@material-ui/icons/Drafts", JSImport.Default)
  @js.native
  object DraftsJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DraftsJS)
  
  def apply() = jsFnComponent()

}
    