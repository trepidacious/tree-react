package org.rebeam.react

import japgolly.scalajs.react.{Callback, ReactEventFromInput}

object InputEventCallback {
  def apply(f: String => Callback): ReactEventFromInput => Callback = e => {
    val s = e.target.value
    f(s)
  }
}
