
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object RssFeed {

  @JSImport("@material-ui/icons/RssFeed", JSImport.Default)
  @js.native
  object RssFeedJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RssFeedJS)
  
  def apply() = jsFnComponent()

}
    