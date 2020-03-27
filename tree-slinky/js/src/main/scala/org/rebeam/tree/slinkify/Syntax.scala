package org.rebeam.tree.slinkify

import org.scalajs.dom.console

import scalajs.js

// import typings.react.reactMod.ChangeEvent
// import typings.std
//import typings.antdLib.antdLibStrings

object Syntax {
  type Callback = () => Unit

  object Callback{
    def apply(f: => Unit): Callback = f _

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

  //FIXME restore
  // /**
  //   * Wrapper for onChange on an Input in scalablyTyped react facade
  //   * @param f  The function to handle the new input value
  //   * @return   An appropriately typed function for onChange
  //   */
  // def onInputValueChange(f: String => Unit): ChangeEvent[std.HTMLInputElement] => Unit =
  //   e => f(e.target_ChangeEvent.value)

}
