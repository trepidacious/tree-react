package org.rebeam.tree

import cats.Monad
import cats.implicits._

/**
  * An STMFunction0 can produce a value using STMOps. This represents
  * an atomic operation performed using the STMOps, getting/setting data, etc.
  */
trait STMFunction0[A] {

  def apply[F[_]: Monad](implicit stm: STMOps[F]): F[A]

  // The following are useful when we have a parametric return type A for the transaction instead of
  // unit, but not serialisable
  def map[B](f: A => B): STMFunction0[B] = {
    val t = this
    new STMFunction0[B] {
      override def apply[F[_] : Monad](implicit stm: STMOps[F]): F[B] = t[F].map(f)
    }
  }

  def flatMap[B](f: A => STMFunction0[B]): STMFunction0[B] = {
    val t = this
    new STMFunction0[B] {
      override def apply[F[_] : Monad](implicit stm: STMOps[F]): F[B] = t[F].flatMap(a => f(a)[F])
    }
  }

}

object STMFunction0 {
  def pure[A](a: A) = new STMFunction0[A] {
    def apply[F[_]: Monad](implicit stm: STMOps[F]): F[A] = stm.pure(a)
  }
}