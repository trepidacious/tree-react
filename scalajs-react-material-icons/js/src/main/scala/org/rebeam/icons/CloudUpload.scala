
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CloudUpload {

  @JSImport("@material-ui/icons/CloudUpload", JSImport.Default)
  @js.native
  object CloudUploadJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CloudUploadJS)
  
  def apply() = jsFnComponent()

}
    