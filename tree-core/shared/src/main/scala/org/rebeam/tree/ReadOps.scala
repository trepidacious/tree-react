package org.rebeam.tree

import cats.Monad

/**
  * Provides ops to get the data at an Id
  * @tparam F The Monad used for ops
  */
abstract class ReadOps[F[_]: Monad] {

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
    * @param id   The data's [[Id]]
    * @tparam A   Type of data
    * @return     The data at specified [[Id]]
    */
  def get[A](id: Id[A]): F[A]

  // For convenience, could use Monad directly
  def pure[A](a: A): F[A] = implicitly[Monad[F]].pure(a)

}
