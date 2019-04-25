package org.rebeam.tree.ot

sealed trait ServerMessage[A]

object ServerMessage {
  case class ServerRemoteOp[A](op: Operation[A]) extends ServerMessage[A]
  case class ServerConfirmation[A]() extends ServerMessage[A]
}