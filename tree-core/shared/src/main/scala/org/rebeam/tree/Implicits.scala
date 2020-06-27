package org.rebeam.tree

import scala.reflect.ClassTag
import monocle.Prism
import cats.Monad
import cats.implicits._
import scala.collection.mutable
import API._

object Implicits {

  /**
    * Create a Prism from a classtag, for a prism where `A <: S`
    *
    * @param ct   Implicit classtag for A
    */
  def prismFromClassTag[S, A <: S](implicit ct: ClassTag[A]): Prism[S, A] = prismFromOptional(ct.unapply)

  /**
    * Create a Prism from a PartialFunction, for a prism where `A <: S`
    *
    * @param pf   PartialFunction from S to A
    */
  def prismFromPartial[S, A <: S](pf: PartialFunction[S, A]): Prism[S, A] = Prism(pf.lift)(a => a: S)

  /**
    * Create a Prism from a function, for a prism where `A <: S`
    *
    * @param f   Function from S to Option[A]
    */
  def prismFromOptional[S, A <: S](f: S => Option[A]): Prism[S, A] = Prism(f)(a => a: S)

  implicit class RefList[A](l: List[Ref[A]]) {

    val deref: Read[List[A]] = l.traverse(ref => Edit.get(ref.id))

    def derefMap[B](f: A => B): Read[List[B]] = l.traverse(ref => Edit.get(ref.id)).map(_.map(f))

  }

  implicit class SwappableList[A](l: List[A]) {
    def swapped(oldIndex: Int, newIndex: Int): List[A] = {
      val lb = mutable.ListBuffer(l: _*)
      val e = lb.remove(oldIndex)
      lb.insert(newIndex, e)
      lb.toList
    }
  }

}
