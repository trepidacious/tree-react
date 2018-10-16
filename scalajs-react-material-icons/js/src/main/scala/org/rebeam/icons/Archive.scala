
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Archive {

  @JSImport("@material-ui/icons/Archive", JSImport.Default)
  @js.native
  object ArchiveJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ArchiveJS)
  
  def apply() = jsFnComponent()

}
    