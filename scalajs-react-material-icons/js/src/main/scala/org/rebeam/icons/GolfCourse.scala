
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object GolfCourse {

  @JSImport("@material-ui/icons/GolfCourse", JSImport.Default)
  @js.native
  object GolfCourseJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](GolfCourseJS)
  
  def apply() = jsFnComponent()

}
    