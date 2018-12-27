package org.rebeam



import org.rebeam.tree.react.DataContext._
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.Reusability
import japgolly.scalajs.react.vdom.html_<^._
import org.rebeam.tree._

object DataContextDemo {

  val id0 = Id(Guid.raw(0,0,0))
  val id1 = Id(Guid.raw(0,0,1))
  val id2 = Id(Guid.raw(0,0,2))
  val ids = List(id0, id1, id2)

  val initial = MapDataSource.empty
    .put[String](id0, "Zero", RevId(Guid.raw(0,0,100)))
    .put[String](id1, "One", RevId(Guid.raw(0,0,101)))
    .put[String](id2, "Two", RevId(Guid.raw(0,0,102)))

  def incrementRev[A](r: RevId[A]): RevId[A] = {
    RevId(r.guid.copy(transactionClock =  r.guid.transactionClock.next))
  }

  def exclaim(i: Int, m: MapDataSource): MapDataSource = {
    val mod = for {
      id <- ids.lift.apply(i)
      r <- m.getWithRev(id)
    } yield m.modify[String](id, (s: String) => s + "!", incrementRev(r._2))
    mod.getOrElse(m)
  }

  implicit def idReusability[A]: Reusability[Id[A]] = Reusability.by_==

  val itemDisplay = {
    val r = new DataRenderer[Id[Int]] {
      def apply(a: Id[Int], data: DataSource): DataRenderResult = DataRenderResult(
        <.pre(s"$a = ${data.get(a)}"),
        Set(a)
      )
    }
    dataComponent[Id[Int]](r, "itemDisplay")
  }

  val dataProvider = ScalaComponent.builder[Unit]("dataProvider")
    .initialState(initial)
    .renderS{ case(scope, data) =>
      default.provide(data)(
        <.div(
          itemDisplay(id0),
          itemDisplay(id1),
          itemDisplay(id2),
          <.button(
            ^.onClick --> (scope.modState(exclaim(0, _)) >> Callback.log("Exclaim 0")),
            "Exclaim 0!"
          ),
          <.button(
            ^.onClick --> (scope.modState(exclaim(1, _)) >> Callback.log("Exclaim 1")),
            "Exclaim 1!"
          ),
          <.button(
            ^.onClick --> (scope.modState(exclaim(2, _)) >> Callback.log("Exclaim 2")),
            "Exclaim 2!"
          )
        )
      )
    }
    .build

}
