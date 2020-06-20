package org.rebeam.tree

import cats.implicits._

import org.rebeam.tree.Guid._
import org.rebeam.tree.MapStateSTM._
import org.scalatest.exceptions.TestFailedException
import org.scalatest.exceptions.StackDepthException
import org.scalactic._

object SpecUtils {

  def guid(sid: Long, stid: Long, tc: Long): Guid =
    Guid(SessionId(sid), SessionTransactionId(stid), TransactionClock(tc))

  def rightOrFail[A, B](either: Either[A, B])(implicit pos: source.Position): B = {
    either.fold(
      error => throw new TestFailedException((_: StackDepthException) => Some(s"Either left-value '$error', expected right"), None, pos),
      value => value
    )
  }

  def leftOrFail[A, B](either: Either[A, B])(implicit pos: source.Position): A = {
    either.fold(
      error => error,
      value => throw new TestFailedException((_: StackDepthException) => Some(s"Either right-value '$value', expected left"), None, pos)
    )
  }

  def runS[A](s: MapState[A], stateData: StateData = emptyState)(implicit pos: source.Position): (StateData, A) = 
    rightOrFail(s.run(stateData))

  def runView[A](s: DataSourceViewOps.S[A], stateData: DataSourceViewOps.StateData)(implicit pos: source.Position): (DataSourceViewOps.StateData, A) = 
    rightOrFail(s.run(stateData))

  def failView[A](s: DataSourceViewOps.S[A], stateData: DataSourceViewOps.StateData)(implicit pos: source.Position): DataSourceViewOps.Error = 
    leftOrFail(s.run(stateData))
}
