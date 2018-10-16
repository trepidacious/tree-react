
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ImportExport {

  @JSImport("@material-ui/icons/ImportExport", JSImport.Default)
  @js.native
  object ImportExportJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ImportExportJS)
  
  def apply() = jsFnComponent()

}
    