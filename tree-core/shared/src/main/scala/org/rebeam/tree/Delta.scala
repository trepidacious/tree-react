package org.rebeam.tree

import cats.{Monad, Traverse}
import cats.implicits._
import monocle.{Lens, Optional, Prism}
import org.rebeam.tree.ot.{OTList, Operation}
//import org.rebeam.tree.ot.{OTList, Operation}

/**
  * A Delta will take a data value, and produce a new data
  * value using EditOps.
  * This is essentially a Transaction that requires a data item
  * to operate on. Converted to a Transaction using a DeltaCursor.
  *
  * @tparam A The data value
  */
trait Delta[A] {
  def apply[F[_]: Monad](a: A)(implicit stm: EditOps[F]): F[A]
}

object Delta {

  case class ValueDelta[A](newA: A) extends Delta[A] {
    def apply[F[_]: Monad](a: A)(implicit stm: EditOps[F]): F[A] = stm.pure(newA)
  }

  case class LensDelta[A, B](lens: Lens[A, B], delta: Delta[B]) extends Delta[A] {
    override def apply[F[_] : Monad](a: A)(implicit stm: EditOps[F]): F[A] =
      delta[F](lens.get(a)).map(lens.set(_)(a))
  }

  case class PrismDelta[A, B](prism: Prism[A, B], delta: Delta[B]) extends Delta[A] {
    override def apply[F[_] : Monad](a: A)(implicit stm: EditOps[F]): F[A] = {
      prism.getOption(a).fold(
        stm.pure(a)
      )(
        delta[F](_).map(prism.set(_)(a))
      )
    }
  }

  case class OptionalDelta[A, B](optional: Optional[A, B], delta: Delta[B]) extends Delta[A] {
    override def apply[F[_] : Monad](a: A)(implicit stm: EditOps[F]): F[A] =
      optional.getOption(a).fold(
        stm.pure(a)
      )(
        delta[F](_).map(optional.set(_)(a))
      )
  }

  case class OptionDelta[A](delta: Delta[A]) extends Delta[Option[A]] {
    override def apply[F[_] : Monad](a: Option[A])(implicit stm: EditOps[F]): F[Option[A]] =
      a.fold(
        stm.pure(a)
      )(
        delta[F](_).map(Some(_))
      )
  }

  /**
    * A Delta[T[A]] on a some collection T with Traverse (e.g. a List).
    * This applies the provided Delta[A] to the element at specified index (if it exists),
    * and leaves other elements unaltered.
    *
    * @param index  The index of the element to which to apply delta
    * @param delta  The delta to apply at index
    */
  case class TraversableIndexDelta[T[_]: Traverse, A](index: Int, delta: Delta[A]) extends Delta[T[A]] {
    override def apply[F[_] : Monad](s: T[A])(implicit stm: EditOps[F]): F[T[A]] =
      // This maps the provided (A, Int) => F[A] over each pair of (element: A and index), 
      // and turns the resulting T[F[A]] inside out to an F[T[A]]
      s.traverseWithIndexM {
        case (a, i) if i == index => delta[F](a)
        case (a, _) => stm.pure(a)
      }
  }

  case class OTListDelta[A](op: Operation[A]) extends Delta[OTList[A]] {
    override def apply[F[_] : Monad](a: OTList[A])(implicit stm: EditOps[F]): F[OTList[A]] = stm.otListOperation(a, op)
  }

//  def transform[F[_] : Traverse, A](oldList: F[A], modify: A => A, predicate: Int => Boolean): F[A] = {
//    oldList.mapWithIndex {
//      case (a, i) if predicate(i) => modify(a)
//      case (a, i) => a
//    }
//  }
}