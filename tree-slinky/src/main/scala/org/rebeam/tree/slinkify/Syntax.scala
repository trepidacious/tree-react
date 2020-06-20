package org.rebeam.tree.slinkify

import org.scalajs.dom.console

import scalajs.js

// import typings.react.reactMod.ChangeEvent
// import typings.std
//import typings.antdLib.antdLibStrings

object Syntax {
  type Callback = () => Unit

  object Callback{
    def apply(f: => Unit): Callback = () => f

    /**
      * Convenience for calling `dom.console.log`.
      */
    def log(message: js.Any, optionalParams: js.Any*): Callback =
      Callback(console.log(message, optionalParams: _*))

    /**
      * Convenience for calling `dom.console.info`.
      */
    def info(message: js.Any, optionalParams: js.Any*): Callback =
      Callback(console.info(message, optionalParams: _*))

    /**
      * Convenience for calling `dom.console.warn`.
      */
    def warn(message: js.Any, optionalParams: js.Any*): Callback =
      Callback(console.warn(message, optionalParams: _*))
  }

}
