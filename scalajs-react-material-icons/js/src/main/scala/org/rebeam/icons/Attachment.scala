
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Attachment {

  @JSImport("@material-ui/icons/Attachment", JSImport.Default)
  @js.native
  object AttachmentJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AttachmentJS)
  
  def apply() = jsFnComponent()

}
    