
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CloudDownload {

  @JSImport("@material-ui/icons/CloudDownload", JSImport.Default)
  @js.native
  object CloudDownloadJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CloudDownloadJS)
  
  def apply() = jsFnComponent()

}
    