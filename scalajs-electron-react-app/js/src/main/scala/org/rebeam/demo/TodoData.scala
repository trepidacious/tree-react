package org.rebeam.demo

import cats.Monad
import cats.implicits._
import io.circe.generic.JsonCodec
import monocle.macros.Lenses
import org.rebeam.tree._
import org.rebeam.tree.codec.Codec._
import org.rebeam.tree.codec._

object TodoData {

  // All data must have a codec
  @JsonCodec
  // Any data used with DeltaCursor must have lenses
  @Lenses
  case class TodoItem(id: Id[TodoItem], created: Moment, completed: Option[Moment], text: String)

  // We can edit a TodoItem by specifying a new value, or using a lens to get to completed or text fields
  implicit val todoItemDeltaCodec: DeltaCodec[TodoItem] =
    value[TodoItem] or
      lensOption("completed", TodoItem.completed) or  // completed is an Optional field, so use lensOption
      lens("text", TodoItem.text)

  @JsonCodec
  case class TodoList(id: Id[TodoList], items: List[Id[TodoItem]])

  // We can edit a TodoList by specifying a new value
  implicit val todoListDeltaCodec: DeltaCodec[TodoList] = value[TodoList]

  // Both TodoItem and TodoList can be referenced by Id, so we need IdCodecs
  implicit val todoItemIdCodec: IdCodec[TodoItem] = IdCodec[TodoItem]("TodoItem")
  implicit val todoListIdCodec: IdCodec[TodoList] = IdCodec[TodoList]("TodoList")

  // Transaction to build our initial example data
  object example extends Transaction {
    def apply[F[_] : Monad](implicit stm: STMOps[F]): F[Unit] = {
      import stm._
      for {
        itemIds <- (1 to 10).toList.traverse(i =>
          for {
            c <- context
            item <- put[TodoItem](id => TodoItem(id, c.moment, None, s"Todo $i"))
          } yield item.id
        )
        _ <- put[TodoList](TodoList(_, itemIds))
      } yield ()
    }
  }

  // We need to be able to encode/decode any acceptable transaction on the data.
  // The simplest case is just to support applying a delta at an id.
  // If needed, you can define custom Transactions, and provide codecs for them.
  implicit val transactionCodec: TransactionCodec = TransactionCodec.deltaAtIdCodec

}
