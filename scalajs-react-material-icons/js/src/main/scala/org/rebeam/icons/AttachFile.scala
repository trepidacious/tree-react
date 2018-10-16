
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AttachFile {

  @JSImport("@material-ui/icons/AttachFile", JSImport.Default)
  @js.native
  object AttachFileJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AttachFileJS)
  
  def apply() = jsFnComponent()

}
    