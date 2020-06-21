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
import API._
import Edit._

object TodoData {

  // All data must have a codec
  @JsonCodec
  // Any data used with DeltaCursor must have lenses
  @Lenses
  case class TodoItem(id: Id[TodoItem], created: Moment, completed: Option[Moment], text: String)

  // Action to set TodoItem completed or uncompleted
  // This needs a JsonCodec
  @JsonCodec
  case class TodoItemCompletion(complete: Boolean) extends DeltaEdit[TodoItem] {
    def edit(a: TodoItem) = 
      if (complete) {
        // Get the context, c, and get the current time, c.moment to make an updated, completed copy of the TodoItem
        context.map(c => a.copy(completed = Some(c.moment)))
      } else {
        // Just make an updated, incomplete copy of the TodoItem - pure since we don't need any EditOps
        pure(a.copy(completed = None))
      }
  }

  // We can edit a TodoItem by specifying a new value, or using a lens to get to text field or completed time, or by
  // using the TodoItemCompletion delta as an action
  implicit val todoItemDeltaCodec: DeltaCodec[TodoItem] =
    value[TodoItem] or
    lensOption(TodoItem.completed, "completed") or  // completed is an Optional field, so use lensOption
    lens(TodoItem.text, "text") or
    // Action requires the type it operates on, the Delta to 
    // apply the action and a name (often the type name)
    delta[TodoItem, TodoItemCompletion]("TodoItemCompletion")

  @JsonCodec
  @Lenses
  case class TodoList(id: Id[TodoList], items: List[Id[TodoItem]], name: OTList[Char])

  // Action to add a new TodoItem to a TodoList
  @JsonCodec
  case class TodoListAdd(name: String) extends DeltaEdit[TodoList] {
    def edit(a: TodoList) = 
      for {
        c <- context  // Get context, we need c.moment for the current time in the TodoItem's created field
        item <- put[TodoItem](id => TodoItem(id, c.moment, None, name)) // put a new TodoItem - we receive an Id[TodoItem], and build the TodoItem
      } yield a.copy(items = item.id :: a.items)  // Make an updated TodoList with the new TodoItem prepended
  }

  // Action to clear all completed TodoItems from TodoList
  @JsonCodec
  case class TodoListClearCompleted() extends DeltaEdit[TodoList] {
    def edit(a: TodoList) =
      for {
        // Traverse with get to yield a F[List[TodoItem]], and map the contained List[TodoItem] by filtering for incomplete items
        incompleteItems <- a.items.traverse(get).map(_.filter(_.completed.isEmpty))

      // Make the updated TodoList using ids of the incomplete items
      } yield a.copy(items = incompleteItems.map(_.id))
  }

  // We can edit a TodoList by specifying a new value, or via a lens to the list's name, or by adding a todo item
  implicit val todoListDeltaCodec: DeltaCodec[TodoList] = 
    value[TodoList] or 
    lens(TodoList.name, "name") or 
    delta[TodoList, TodoListAdd]("TodoListAdd") or
    delta[TodoList, TodoListClearCompleted]("TodoListClearCompleted")

  // Both TodoItem and TodoList can be referenced by Id, so we need IdCodecs
  implicit val todoItemIdCodec: IdCodec[TodoItem] = IdCodec[TodoItem]("TodoItem")
  implicit val todoListIdCodec: IdCodec[TodoList] = IdCodec[TodoList]("TodoList")

  val exampleEdit: Edit[TodoList] = 
    for {
      itemIds <- (1 to 5).toList.traverse(i =>
        for {
          c <- context
          item <- put[TodoItem](id => TodoItem(id, c.moment, None, s"Todo $i"))
        } yield item.id
      )
      name <- createOTString("Todos")
      todoList <- put[TodoList](TodoList(_, itemIds, name))
    } yield todoList

  // Transaction to build our initial example data
  val example = Transaction(exampleEdit)

  // We need to be able to encode/decode any acceptable transaction on the data.
  // The simplest case is just to support applying a delta at an id.
  // If needed, you can define custom Transactions, and provide codecs for them.
  implicit val transactionCodec: TransactionCodec = TransactionCodec.deltaAtIdCodec

}
