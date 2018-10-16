
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object NewReleases {

  @JSImport("@material-ui/icons/NewReleases", JSImport.Default)
  @js.native
  object NewReleasesJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](NewReleasesJS)
  
  def apply() = jsFnComponent()

}
    