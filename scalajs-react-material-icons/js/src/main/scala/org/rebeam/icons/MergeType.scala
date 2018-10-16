
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object MergeType {

  @JSImport("@material-ui/icons/MergeType", JSImport.Default)
  @js.native
  object MergeTypeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MergeTypeJS)
  
  def apply() = jsFnComponent()

}
    