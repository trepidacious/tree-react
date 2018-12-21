package org.rebeam.tree.view

import cats.Monad
import org.rebeam.tree.ViewOps

object RendererSketch {

  trait Renderer[A, S, R]{
    def render[F[_]: Monad](a: A, state: S)(implicit stm: ViewOps[F]): F[R]
  }

  case class Person(name: String, age: Int)

  sealed trait TextNode
  object TextNode {
    case class Text(s: String) extends TextNode {
      override def toString: String = s""""$s""""
    }
    case class All(l: List[TextNode]) extends TextNode {
      override def toString: String = s"[${l.mkString(", ")}]"
    }
    object All {
      def apply(t: TextNode *): All = All(List(t:_*))
    }
    case class Suspend[A, S](a: A, r: TextRenderer[A, S]) extends TextNode {
      override def toString: String = s"$r($a)"
    }
  }

  import TextNode._

  trait TextRenderer[A, S] extends Renderer[A, S, TextNode] {
    def apply(a: A): Suspend[A, S] = Suspend(a, this)
  }

  trait PureTextRenderer[A] extends TextRenderer[A, Unit] {
    override def apply(a: A): Suspend[A, Unit] = Suspend(a, this)
  }

  val stringR: TextRenderer[String, Unit] = new TextRenderer[String, Unit] {
    def render[F[_]: Monad](a: String, state: Unit)(implicit stm: ViewOps[F]): F[TextNode] = {
      stm.pure(Text(a))
    }
  }

  val intR: TextRenderer[Int, Unit] = new TextRenderer[Int, Unit] {
    def render[F[_]: Monad](a: Int, state: Unit)(implicit stm: ViewOps[F]): F[TextNode] = {
      stm.pure(Text(a.toString))
    }
  }

  val personR: TextRenderer[Person, Unit] = new TextRenderer[Person, Unit] {
    def render[F[_]: Monad](a: Person, state: Unit)(implicit stm: ViewOps[F]): F[TextNode] = {
      stm.pure(
        All(
          Text("Person("),
          stringR(a.name), // Equivalent to Suspend(a.name, stringR),
          Text(", "),
          intR(a.age),
          Text(")")
        )
      )
    }
  }

  // TODO implement a render tree - this contains the rendered results,
  // but also the last-rendered state for all stateful renderers, and the
  // map from Ids they viewed to the revision they saw. This plus a root
  // renderer should be enough to re-render with memoisation.


}