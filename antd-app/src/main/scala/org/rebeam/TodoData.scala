package org.rebeam

import cats.Monad
import cats.implicits._
import org.rebeam.tree.ot.OTList
import io.circe.generic.JsonCodec
import monocle.macros.Lenses
import org.rebeam.tree._
import org.rebeam.tree.codec.Codec._
import org.rebeam.tree.codec._
import org.rebeam.tree.ot.OTCodecs._

object TodoData {

  // All data must have a codec
  @JsonCodec
  // Any data used with DeltaCursor must have lenses
  @Lenses
  case class TodoItem(id: Id[TodoItem], created: Moment, completed: Option[Moment], text: String)

  // Action to set TodoItem completed or uncompleted
  // This needs a JsonCodec
  @JsonCodec
  case class TodoItemCompletion(complete: Boolean) extends Delta[TodoItem] {
    override def apply[F[_] : Monad](a: TodoItem)(implicit stm: STMOps[F]): F[TodoItem] = {
      import stm._
      if (complete) {
        context.map(c => a.copy(completed = Some(c.moment)))
      } else {
        pure(a.copy(completed = None))
      }
    }
  }


  // We can edit a TodoItem by specifying a new value, or using a lens to get to text field, or by
  // using the TodoItemCompletion delta as an action
  implicit val todoItemDeltaCodec: DeltaCodec[TodoItem] =
    value[TodoItem] or
//      lensOption("completed", TodoItem.completed) or  // completed is an Optional field, so use lensOption
    lens("text", TodoItem.text) or
    action[TodoItem, TodoItemCompletion]("completion"){
      case a:TodoItemCompletion => a
    }


  @JsonCodec
  @Lenses
  case class TodoList(id: Id[TodoList], items: List[Id[TodoItem]], name: OTList[Char])

  // We can edit a TodoList by specifying a new value, or via a lens to the list's name
  implicit val todoListDeltaCodec: DeltaCodec[TodoList] = value[TodoList] or lens("name", TodoList.name)

  // Both TodoItem and TodoList can be referenced by Id, so we need IdCodecs
  implicit val todoItemIdCodec: IdCodec[TodoItem] = IdCodec[TodoItem]("TodoItem")
  implicit val todoListIdCodec: IdCodec[TodoList] = IdCodec[TodoList]("TodoList")

  // Transaction to build our initial example data
  object example extends Transaction {
    def apply[F[_] : Monad](implicit stm: STMOps[F]): F[Unit] = {
      import stm._
      for {
        itemIds <- (1 to 5).toList.traverse(i =>
          for {
            c <- context
            item <- put[TodoItem](id => TodoItem(id, c.moment, None, s"Todo $i"))
          } yield item.id
        )
        name <- createOTString("Todos")
        _ <- put[TodoList](TodoList(_, itemIds, name))
      } yield ()
    }
  }

  // We need to be able to encode/decode any acceptable transaction on the data.
  // The simplest case is just to support applying a delta at an id.
  // If needed, you can define custom Transactions, and provide codecs for them.
  implicit val transactionCodec: TransactionCodec = TransactionCodec.deltaAtIdCodec

}
