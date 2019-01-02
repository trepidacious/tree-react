package org.rebeam.demo

import cats.Monad
import cats.implicits._
import io.circe.{Decoder, Encoder}
import japgolly.scalajs.react.CtorType
import japgolly.scalajs.react.component.Scala.Component
//import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.Reusability
import japgolly.scalajs.react.vdom.html_<^._
import org.rebeam.tree._
import org.rebeam.tree.codec.Codec.DeltaCodec
import org.rebeam.tree.codec.Codec._
import org.rebeam.tree.codec._
import org.rebeam.tree.react._

object LocalDataRootDemo {

  implicit val StringIdCodec: IdCodec[String] = new IdCodec[String] {
    override def idType: IdType = IdType("String")
    override def encoder: Encoder[String] = implicitly[Encoder[String]]
    override def decoder: Decoder[String] = implicitly[Decoder[String]]
    override def deltaCodec: DeltaCodec[String] = stringDeltaCodec
  }

  val exampleData: Transaction = new Transaction {
    override def apply[F[_] : Monad](implicit stm: STMOps[F]): F[Unit] = {
      import stm._
      for {
        _ <- put[String](_ => "Zero")
        _ <- put[String](_ => "One")
        _ <- put[String](_ => "Two")
      } yield ()
    }
  }

  def exclaim(id: Id[String]): Transaction = new Transaction {
    override def apply[F[_] : Monad](implicit stm: STMOps[F]): F[Unit] = {
      import stm._
      for {
        _ <- modify[String](id, s => s + "!")
      } yield ()
    }
  }

  implicit def idReusability[A]: Reusability[Id[A]] = Reusability.by_==

  val itemDisplay: Component[Id[String], Unit, Unit, CtorType.Props] = new View[Id[String]] {
    def apply[F[_]: Monad](a: Id[String])(implicit v: ReactViewOps[F], tx: ReactTransactor): F[VdomElement] = {
      import v._
      for {
        data <- get(a)
      } yield {
        <.div(
          <.pre(s"$a = $data"),
          <.button(
            ^.onClick --> tx.transact(exclaim(a)),
            s"Exclaim $a"
          )
        )
      }
    }
  }.build("itemDisplay")

  //TODO replace this with a "directory" of the contents allowing us to get at ids? This
  //could be updated when values are "put". This would lead to a type parameter D for the
  //directory, and the IdCodec[A, D] would have to provide a (A, Id[A], D) => D to add A
  //to the directory under Id[A]. Then the directory would be an entry point to data, for
  //example allowing you to look up a data item that describes all the data belonging to
  //a given user, based on that users email.
  //Another approach would be to just pass new/modified items and Ids to get matched at the top
  //level, as would be needed for persistence. This could then build the directory.

  val id0 = Id[String](Guid.raw(0,0,0))
  val id1 = Id[String](Guid.raw(0,0,2))
  val id2 = Id[String](Guid.raw(0,0,4))

  val dataProvider = LocalDataRoot.component[Unit](
    _ =>
      <.div(
        itemDisplay(id0),
        itemDisplay(id1),
        itemDisplay(id2)
      )
  )(
    exampleData
  )

}
