package org.rebeam.tree

import cats.Monad
import cats.implicits._

/**
  * An Edit can produce a value using EditOps, in any Monad F. This represents
  * an atomic operation performed using the EditOps, getting/setting data, etc.
  * and then returning a result.
  */
trait Edit[A] {

  def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[A]

  // The following are useful when we have a parametric return type A for the transaction instead of
  // unit, but not serialisable
  def map[B](f: A => B): Edit[B] = {
    val t = this
    new Edit[B] {
      override def apply[F[_] : Monad](implicit editOps: EditOps[F]): F[B] = t[F].map(f)
    }
  }

  def flatMap[B](f: A => Edit[B]): Edit[B] = {
    val t = this
    new Edit[B] {
      override def apply[F[_] : Monad](implicit editOps: EditOps[F]): F[B] = t[F].flatMap(a => f(a)[F])
    }
  }

}

object Edit {
  def pure[A](a: A) = new Edit[A] {
    def apply[F[_]: Monad](implicit editOps: EditOps[F]): F[A] = editOps.pure(a)
  }
}