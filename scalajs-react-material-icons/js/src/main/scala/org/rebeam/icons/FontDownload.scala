
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FontDownload {

  @JSImport("@material-ui/icons/FontDownload", JSImport.Default)
  @js.native
  object FontDownloadJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FontDownloadJS)
  
  def apply() = jsFnComponent()

}
    