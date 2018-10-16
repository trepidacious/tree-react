
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Publish {

  @JSImport("@material-ui/icons/Publish", JSImport.Default)
  @js.native
  object PublishJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PublishJS)
  
  def apply() = jsFnComponent()

}
    