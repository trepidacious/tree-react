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
}

object Read {

  lazy implicit val monadInstance: Monad[Read] = new Monad[Read] {
    override def pure[A](x: A): Read[A] = Read.pure(x)
    override def flatMap[A, B](fa: Read[A])(f: A => Read[B]): Read[B] = new Read[B] {
      def apply[F[_]: Monad](implicit readOps: ReadOps[F]): F[B] = fa[F].flatMap(a => f(a)[F])
    }
    override def tailRecM[A, B](a: A)(f: A => Read[Either[A,B]]): Read[B] = {
      new Read[B] {
        override def apply[F[_] : Monad](implicit readOps: ReadOps[F]): F[B] = {
          implicitly[Monad[F]].tailRecM(a)(a => f(a).apply[F])
        }
      }
    }
  }

  def pure[A](a: A) = new Read[A] {
    def apply[F[_]: Monad](implicit readOps: ReadOps[F]): F[A] = readOps.pure(a)
  }

  /**
    * Get data at an [[Id]].
    * 
    * This will cause the ReadOps to fail
    * if the data is not available.
    * 
    * If possible, systems that cache only part of the STM
    * will retry the operation when missing data has been 
    * retrieved.
    * 
    * U operation when part of an Edit - makes STM data at id available to subsequent transactions.
    * 
    * @param id   The data's [[Id]]
    * @tparam A   Type of data
    * @return     The data at specified [[Id]]
    */
  def get[A](id: Id[A]): Read[A] = new Read[A] {
    def apply[F[_]: Monad](implicit readOps: ReadOps[F]): F[A] = readOps.get(id)
  }

}