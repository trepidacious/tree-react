
package org.rebeam.electron.react

// import japgolly.scalajs.react._
// import scalajs.js

import japgolly.scalajs.react.vdom.svg_<^._

// import scalacss.ScalaCssReact._

object TitleIcons {

  //TODO restore ^.aria.hidden := "true",  in each <.svg
  //TODO restore ^.version := "1.1", in each <.svg

  val minimize = 
    <.svg(^.width := "10", ^.height := "10")(
      <.path(^.d := "M 0,5 10,5 10,6 0,6 Z")
    )

  val unmaximize = 
    <.svg(^.width := "10", ^.height := "10")(
      <.path(^.d := "m 2,1e-5 0,2 -2,0 0,8 8,0 0,-2 2,0 0,-8 z m 1,1 6,0 0,6 -1,0 0,-5 -5,0 z m -2,2 6,0 0,6 -6,0 z")
    )

  val maximize = 
    <.svg(^.width := "10", ^.height := "10")(
      <.path(^.d := "M 0,0 0,10 10,10 10,0 Z M 1,1 9,1 9,9 1,9 Z")
    )

  val close = 
    <.svg(^.width := "10", ^.height := "10")(
      <.path(^.d := "M 0,0 0,0.7 4.3,5 0,9.3 0,10 0.7,10 5,5.7 9.3,10 10,10 10,9.3 5.7,5 10,0.7 10,0 9.3,0 5,4.3 0.7,0 Z")
    )

}