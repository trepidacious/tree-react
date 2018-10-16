
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object TrackChanges {

  @JSImport("@material-ui/icons/TrackChanges", JSImport.Default)
  @js.native
  object TrackChangesJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TrackChangesJS)
  
  def apply() = jsFnComponent()

}
    