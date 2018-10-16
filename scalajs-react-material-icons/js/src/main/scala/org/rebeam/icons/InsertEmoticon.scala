
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object InsertEmoticon {

  @JSImport("@material-ui/icons/InsertEmoticon", JSImport.Default)
  @js.native
  object InsertEmoticonJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](InsertEmoticonJS)
  
  def apply() = jsFnComponent()

}
    