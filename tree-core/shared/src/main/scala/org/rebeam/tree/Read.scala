package org.rebeam.tree

import cats.Monad
import cats.implicits._

/**
  * A Read can produce a value using ReadOps, in any Monad F. This represents
  * an atomic operation performed using the ReadOps, getting data, etc.
  * and then returning a result.
  */
trait Read[A] {

  def apply[F[_]: Monad](implicit readOps: ReadOps[F]): F[A]

  def map[B](f: A => B): Read[B] = {
    val t = this
    new Read[B] {
      override def apply[F[_] : Monad](implicit readOps: ReadOps[F]): F[B] = t[F].map(f)
    }
  }

  def flatMap[B](f: A => Read[B]): Read[B] = {
    val t = this
    new Read[B] {
      override def apply[F[_] : Monad](implicit readOps: ReadOps[F]): F[B] = t[F].flatMap(a => f(a)[F])
    }
  }

}

object Read {
  def pure[A](a: A) = new Read[A] {
    def apply[F[_]: Monad](implicit readOps: ReadOps[F]): F[A] = readOps.pure(a)
  }
}