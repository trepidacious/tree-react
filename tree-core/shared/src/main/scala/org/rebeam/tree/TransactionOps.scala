package org.rebeam.tree

import cats.Monad

/**
  * Operations available in any transaction.
  * Provides pseudo-random values based on a seed derived from the transaction context - these are repeatable
  * between runs of the transaction as long as the operations are called in the same order. For this reason the
  * operations are classified as "D" operations - see [[EditOps]] docs for more details.
  *
  * Pseudo-random values should match those produced by java.util.Random
  *
  * @tparam F The monad used to express operations
  */
abstract class TransactionOps[F[_]: Monad] extends ReadOps [F] {

  /**
    * Create a pseudo-random Int
    *
    * This is an S operation - see EditOps docs for details
    */
  def randomInt: F[Int]

  /**
    * Create a pseudo-random Int x, where 0 <= x < bound
    *
    * This is an S operation - see EditOps docs for details
    */
  def randomIntUntil(bound: Int): F[Int]

  /**
    * Create a pseudo-random Long
    *
    * This is an S operation - see EditOps docs for details
    */
  def randomLong: F[Long]

  /**
    * Create a pseudo-random Boolean
    *
    * This is an S operation - see EditOps docs for details
    */
  def randomBoolean: F[Boolean]

  /**
    * Create a pseudo-random Float
    *
    * This is an S operation - see EditOps docs for details
    */
  def randomFloat: F[Float]

  /**
    * Create a pseudo-random Double
    *
    * This is an S operation - see EditOps docs for details
    */
  def randomDouble: F[Double]

  /**
    * Get the TransactionContext for this transaction
    *
    * This is neither a U nor an S operation - see EditOps docs for details of what is meant by this terminology.
    * FIXME this should maybe be U - it provides the Moment, which could then be used to drive differences in
    * execution. However transactionId is fine - split these up?
    */
  def context: F[TransactionContext]

}
