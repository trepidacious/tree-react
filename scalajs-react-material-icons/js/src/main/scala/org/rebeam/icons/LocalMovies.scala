
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocalMovies {

  @JSImport("@material-ui/icons/LocalMovies", JSImport.Default)
  @js.native
  object LocalMoviesJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocalMoviesJS)
  
  def apply() = jsFnComponent()

}
    