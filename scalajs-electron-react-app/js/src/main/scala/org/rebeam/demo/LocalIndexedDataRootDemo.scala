package org.rebeam.demo

import cats.Monad
import cats.implicits._
import io.circe.generic.JsonCodec
import org.rebeam.tree.MapStateSTM.StateDelta

//import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.Reusability
import japgolly.scalajs.react.vdom.html_<^._
import org.rebeam.tree._
import org.rebeam.tree.codec.Codec.{DeltaCodec, _}
import org.rebeam.tree.codec._
import org.rebeam.tree.react._

object LocalIndexedDataRootDemo {

  @JsonCodec
  case class TodoItem(id: Id[TodoItem], created: Moment, completed: Option[Moment], text: String)

  // We can edit a TodoItem by specifying a new value
  implicit val todoItemDeltaCodec: DeltaCodec[TodoItem] = value[TodoItem]

  @JsonCodec
  case class TodoList(id: Id[TodoList], items: List[Id[TodoItem]])

  // We can edit a TodoList by specifying a new value
  implicit val todoListDeltaCodec: DeltaCodec[TodoList] = value[TodoList]

  // Both TodoItem and TodoList can be referenced by Id, so we need IdCodecs
  implicit val todoItemIdCodec: IdCodec[TodoItem] = IdCodec[TodoItem]("TodoItem")
  implicit val todoListIdCodec: IdCodec[TodoList] = IdCodec[TodoList]("TodoList")

  // Transaction to build our initial example data
  val exampleData = new Transaction {
    override def apply[F[_] : Monad](implicit stm: STMOps[F]): F[Unit] = {
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

  // Our index is simple - just store the most recently added list.
  // The index lets us access this list by retrieving its Id from the TodoList in the index.
  // Otherwise we wouldn't know the Id, since we don't get any return value from the exampleData Transaction.
  case class TodoIndex(todoList: Option[TodoList])

  // This indexer will just keep the last put or modified TodoList
  val todoIndexer = new LocalIndexedDataRoot.Indexer[TodoIndex] {
    def initial: TodoIndex = TodoIndex(None)
    def updated(index: TodoIndex, deltas: Seq[StateDelta[_]]): TodoIndex = {
      deltas.foldRight(index){
        case (delta, i) => delta.a match {
          case tl: TodoList => TodoIndex(Some(tl))
          case _ => i
        }
      }
    }
  }

  //TODO do we just assume that anything in our views is immutable? Would save some typing...
  // Data is immutable, so we only need to check reusability by reference - data has changed if and only if
  // we have a new instance.
  implicit val todoListReusability: Reusability[TodoList] = Reusability.byRef[TodoList]
  implicit val todoItemReusability: Reusability[TodoItem] = Reusability.byRef[TodoItem]

  val todoListView = new View[TodoList] {
    def apply[F[_]: Monad](l: TodoList, tx: ReactTransactor)(implicit v: ViewOps[F]): F[VdomElement] = {
      import v._

      // TODO add an implicit method (not sure of best name?) to call traverse(get)
      // l.items is a List[Id[TodoItem]]. get(id) gives an F[TodoItem], so l.items.map(get) would give a
      // List[F[TodoItem]]. Therefore instead of map we can call traverse, and get the result "inside-out", as
      // an F[List[TodoItem]]
      l.items.traverse(get)
        // We can then map this F[List[TodoItem]] to an F[VdomElement], using the normal approaches we would use
        // from a List to a VdomElement in scalajs-react - in this case toTagMod to produce a TagMod containing
        // a <li> for each TodoItem.
        .map(
          items =>
            <.ol(
              items.toTagMod(item => <.li(item.toString))
            )
        )
    }
  }.build("todoListView")

  // This component will manage and render an STM, initialised to the example data
  val dataProvider = LocalIndexedDataRoot.component[Unit, TodoIndex](
    (_, index) =>
      <.div(
        // When we have an indexed TodoList, display it
        index.todoList.whenDefined(todoListView(_))
      )
  )(
    todoIndexer,
    exampleData
  )

}
