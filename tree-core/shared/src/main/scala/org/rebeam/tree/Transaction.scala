package org.rebeam.tree

import cats.Monad
import cats.implicits._

/**
  * A Transaction is an Edit producing no result (Unit). 
  * This can produce an effect using EditOps. This represents
  * an atomic operation performed using the EditOps, getting/setting data, etc.
  * We require an Edit[Unit] to make it clear that no value is returned
  * when a Transaction runs.
  * We use a trait to distinguish Edits that are used to build up Transactions
  * from the Transactions themselves - Transactions are sutiable to be
  * run as entire self-contained operations, passed to a server for execution, etc.
  */
trait Transaction extends Edit[Unit]

object Transaction {

  def apply[A](edit: Edit[A]): Transaction = new Transaction {
    def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[Unit] = edit.map(_ => ())[F]
  }

  /**
    * Applies a delta to the data at an Id in STM
    * @param id     The Id
    * @param delta  The delta to apply to data at Id
    * @tparam A     The type of data
    */
  case class DeltaAtId[A](id: Id[A], delta: Delta[A]) extends Transaction {
    def apply[F[_]: Monad](implicit stm: EditOps[F]): F[Unit] =
      stm.modifyF(id, (a: A) => delta[F](a)).map(_ => ())
  }

  val doNothing: Transaction = new Transaction {
    override def apply[F[_] : Monad](implicit stm: EditOps[F]): F[Unit] = stm.pure(())
  }

}