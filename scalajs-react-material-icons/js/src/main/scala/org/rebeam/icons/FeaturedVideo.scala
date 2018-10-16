
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FeaturedVideo {

  @JSImport("@material-ui/icons/FeaturedVideo", JSImport.Default)
  @js.native
  object FeaturedVideoJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FeaturedVideoJS)
  
  def apply() = jsFnComponent()

}
    