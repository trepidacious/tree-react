package org.rebeam

import scalajs.js
import scalajs.js.annotation.JSImport


object IPCRenderer {

  type Listener = scalajs.js.Function2[Event, String, Unit]

  @js.native
  trait EventEmitter extends js.Object {
    def send(channel: String, msg: String): Unit = js.native
  }

  @js.native
  trait Event extends js.Object {
    val sender: EventEmitter = js.native
  }

  @JSImport("electron", "ipcRenderer")
  @js.native
  object IPCRendererJS extends js.Object {
    def send(channel: String, msg: String): Unit = js.native
    def on(channel: String, listener: Listener): Unit = js.native
    def removeListener(channel: String, listener: Listener): Unit = js.native
  }


  def send(channel: String, msg: String): Unit = IPCRendererJS.send(channel, msg)

  def on(channel: String, f: (Event, String) => Unit): Listener = {
    val listener: Listener = (event: Event, msg: String) => f(event, msg)
    IPCRendererJS.on(channel, listener)
    listener
  }

  def removeListener(channel: String, listener: Listener): Unit = 
    IPCRendererJS.removeListener(channel, listener)

}