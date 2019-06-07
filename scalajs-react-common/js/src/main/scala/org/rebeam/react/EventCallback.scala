package org.rebeam.react

import japgolly.scalajs.react.{Callback, ReactEvent}

object EventCallback {
  def apply(f: => Unit): ReactEvent => Callback = _ => Callback{f}
}
