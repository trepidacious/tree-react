
package org.rebeam.electron.react

// import japgolly.scalajs.react._
// import scalajs.js

import japgolly.scalajs.react.vdom.svg_<^._

// import scalacss.ScalaCssReact._

object TitleIcons {

  //TODO restore ^.aria.hidden := "true",  in each <.svg
  //TODO restore ^.version := "1.1", in each <.svg

  //TODO use scalacss Styles.windowControlsButtonSVG if possible

  // "currentColor" is to inherit fill color from color of parent
  val minimize = 
    <.svg(^.fill := "currentColor", ^.width := "10", ^.height := "10")(
      <.path(^.d := "M 0,5 10,5 10,6 0,6 Z")
    )

  val unmaximize = 
    <.svg(^.fill := "currentColor", ^.width := "10", ^.height := "10")(
      <.path(^.d := "m 2,1e-5 0,2 -2,0 0,8 8,0 0,-2 2,0 0,-8 z m 1,1 6,0 0,6 -1,0 0,-5 -5,0 z m -2,2 6,0 0,6 -6,0 z")
    )

  val maximize = 
    <.svg(^.shapeRendering := "crispEdges", ^.stroke := "currentColor", ^.fill := "transparent", ^.width := "10", ^.height := "10")(
//      <.path(^.d := "M 0,0 0,10 10,10 10,0 Z M 1,1 9,1 9,9 1,9 Z")
      <.path(^.d := "M0.5 10V0.5H10V10H0.5Z")
//      <.rect(^.x:=1.5, ^.y := 1.5, ^.width := 9, ^.height := 9)
    )

  val close = 
    <.svg(^.fill := "currentColor", ^.width := "10", ^.height := "10")(
      <.path(^.d := "M 0,0 0,0.7 4.3,5 0,9.3 0,10 0.7,10 5,5.7 9.3,10 10,10 10,9.3 5.7,5 10,0.7 10,0 9.3,0 5,4.3 0.7,0 Z")
    )

}