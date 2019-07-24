package org.rebeam.tree.slinky

import slinky.core._
import slinky.core.facade.Hooks._
import slinky.web.html._

object SlinkyProto {
  val component: FunctionalComponent[String] = FunctionalComponent[String] { props =>
    val (state, updateState) = useState(0)
    div(
      props,
      state/*,
      button(
        onClick := (event) => updateState(2)
      )*/
    )
  }
}