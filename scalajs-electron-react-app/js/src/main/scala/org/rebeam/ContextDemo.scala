package org.rebeam

import japgolly.scalajs.react.React.Context
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.Reusability

object ContextDemo {

  type Key = Int
  type Rev = Int

  case class Item(value: String, rev: Rev) {
    def modify(f: String => String): Item = copy(value = f(value), rev = rev + 1)
  }

  case class Data(map: Map[Key, Item]) {
    def exclaim(k: Key): Data = this.copy(
      map = this.map.updated(k, this.map(k).modify(_ + "!"))
    )
  }

  object Data {
    def apply(entries: (Key, String)*): Data =
      Data(Map(entries.map{case (i, v) => (i, Item(v, 0))}: _*))
  }

  /**
    * Result of a render - the actual Vdom, and the keys for values in the
    * Data that we used to render. This can be used with a
    * new Data to see if any used values have changed.
    * @param v          Rendered Vdom
    * @param usedKeys   Keys of data used to render
    */
  case class DataRenderResult(v: VdomElement, usedKeys: Set[Key])

  // TODO how can we connect this to Reusability? Output must not change for reusable instances of A
  /**
    * Renders using props of type A, and Data, tracking which
    * keys were used from the data to allow us to determine exactly
    * when an update is needed.
    * @tparam A The props.
    */
  trait DataRenderer[A] {
    /**
      * Perform a render
      * Must meet the following contract:
      * 1. Function is pure
      * 2. Function only accesses values in Data using the keys returned in DataRenderResult.
      * 3. Function produces identical results for values of A where Reusability[A].test returns true.
      * These requirements allow us to memoise the render, so it is only reapplied if the data it uses changes.
      *
      * @param a    The data model ("props") to render
      * @param data The Data to use to look up references
      * @return     The result of rendering - Vdom, and a set of keys used.
      */
    def apply(a: A, data: Data): DataRenderResult
  }

  object DataComponentB {

    // Essentially we memoise the DataRenderer function. Both render and the shouldComponentUpdate call
    // following it will need the results. Render needs the VdomElement to return, and shouldComponentUpdate
    // needs to know what data Keys are used when rendering "currentProps". We expect currentProps to generally
    // yield the same results as those previously supplied to render, so we can just check this and if it is true, return
    // the cached result. While this does involve mutation, this is not apparent outside the Backend, and this
    // increases efficiency.
    // Note that we need a reference to the last rendered props to make this work, and this will be held until the
    // component is unmounted and GCed, but React will be holding a reference to the props at least as long as the
    // component is mounted anyway, so this is not a memory leak.
    // Note that we only cache the usedKeys, not the VdomElement rendered, since we expect to receive new props
    // in react render, then see equivalent ones later in SCU. SCU only uses lastUsedKeys, so this is all we
    // need to cache.
    class DataRendererMemo[A: Reusability](r: DataRenderer[A]) {
      var lastProps: Props[A] = _
      var lastUsedKeys: Set[Key] = _

      def render(p: Props[A]): DataRenderResult = {
        val drr = r(p.a, p.data)
        lastProps = p
        lastUsedKeys = drr.usedKeys
        println("DataRendererMemo.render(" + p + ") gives used keys " + drr.usedKeys)
        drr
      }

      // Get the usedKeys for rendering Props - if renderer will produce the same value with new pros as with
      // lastProps, return the cached usedKeys
      def usedKeys(p: Props[A]): Set[Key] = {
        val reuse =
          // If we haven't run before, we can't reuse
          if (lastProps == null || lastUsedKeys == null) {
            println("DataRendererMemo.usedKeys - memo miss, first render")
            false

          // If props are not reusable, can't reuse
          } else if (!implicitly[Reusability[A]].test(lastProps.a, p.a)) {
            println("DataRendererMemo.usedKeys - memo miss, props not reusable (" + lastProps.a + " -> " + p.a + ")")
            false

          // If any values used in the last render have changed in the new data, can't reuse
          } else if (valuesChanged(lastUsedKeys, lastProps.data, p.data)) {
            println("DataRendererMemo.usedKeys - memo miss, data value(s) changed")
            false

          // Can reuse
          } else {
            true
          }

        if (reuse) {
          println("DataRendererMemo.usedKeys - memo hit, memoised used keys are " + lastUsedKeys)
          lastUsedKeys
        } else {
          println("DataRendererMemo.usedKeys - memo miss, calling cachedRender")
          render(p).usedKeys
        }
      }
    }

    // TODO optimise - e.g. could return keys and revisions from DataRendererMemo.usedKeys to skip a map.get
    // Check whether any of the values referenced by the set of keys has changed revision between
    // currentData and nextData.
    def valuesChanged(keys: Set[Key], currentData: Data, nextData: Data): Boolean = keys.exists(
      key => {
        val currentItem = currentData.map.get(key)
        val nextItem = nextData.map.get(key)
        (currentItem, nextItem) match {
          case (Some(Item(_, currentRev)), Some(Item(_, nextRev))) if currentRev == nextRev => false
          case _ => true
        }
      }
    )

    case class Props[A](a: A, data: Data)

    class Backend[A: Reusability](bs: BackendScope[Props[A], Unit], r: DataRenderer[A]) {
      val dataRendererMemo = new DataRendererMemo[A](r)
      def render(p: Props[A]): VdomElement = {
        println("Backend.render(" + p + ")")
        dataRendererMemo.render(p).v
      }
    }


    def component[A: Reusability](name: String, r: DataRenderer[A]) = ScalaComponent.builder[Props[A]](name)
      .backend(scope => new Backend[A](scope, r))
      .render(s => s.backend.render(s.props))
      .shouldComponentUpdatePure(f => {

        // If props have changed (according to reusability), there's no point in checking data, we need to update
        if (!implicitly[Reusability[A]].test(f.currentProps.a, f.nextProps.a)) {
          false

        // Otherwise, only need to update if any of the data we used in the last render has changed
        } else {

          // This is where we (usually) use the memoised result of calling dataRendererMemo.render from Backend.render.
          // If it turns out that the memoised value is out of date we will get a fresh render's usedKeys as required.
          val lastUsedKeys = f.backend.dataRendererMemo.usedKeys(f.currentProps)

          val currentData = f.currentProps.data
          val nextData = f.nextProps.data

          val dataChanged = valuesChanged(lastUsedKeys, currentData, nextData)

          println("ShouldComponentUpdate for data " + currentData + " -> " + nextData + ", a " + f.currentProps.a + " -> " + f.nextProps.a + ", lastUsedKeys " + lastUsedKeys + ", dataChanged? " + dataChanged)
          if (dataChanged) {
            println(" => CHANGED")
          } else {
            println(" => same")
          }
          dataChanged
        }

      })
      .build

  }

  def dataComponent[A: Reusability](r: DataRenderer[A], name: String, dataContext: Context[Data] = DataContext.default) = {
    // Each dataComponent wraps a DataComponentB, and provides it with props that are built from A and the DataContext
    val b = DataComponentB.component(name + "B", r)
    ScalaComponent.builder[A](name + "A")
      .render_P {
        a => {
          dataContext.consume(
            data => {
              println("dataComponent.render_P, data " + data + ", a = " + a)
              b(DataComponentB.Props(a, data))
            }
          )
        }
      }
      // Note that the component will always be updated when the data context changes - React updates everything that
      // consumes a context, when that context changes. However when only the props change, SCU will be called, and
      // we can skip this when the props are reusable, as normal.
      .configure(Reusability.shouldComponentUpdate)
      .build
  }

//  val itemDisplay = ScalaFnComponent[Int](id => <.pre(dataContext.consume(data => s"$id = ${data.map(id)}")))

  val itemDisplay = {
    val r = new DataRenderer[Int] {
      def apply(a: Int, data: Data): DataRenderResult = DataRenderResult(
        <.pre(s"$a = ${data.map(a)}"),
        Set(a)
      )
    }
    dataComponent[Int](r, "itemDisplay")
  }

  object DataContext {
    val default: Context[Data] = React.createContext(Data())
  }


  val dataProvider = ScalaComponent.builder[Unit]("dataProvider")
    .initialState(Data(
      0 -> "Zero",
      1 -> "One",
      2 -> "Two"
    ))
    .renderS{ case(scope, data) =>
      DataContext.default.provide(data)(
        <.div(
          itemDisplay(0),
          itemDisplay(1),
          itemDisplay(2),
          <.button(
            ^.onClick --> (scope.modState(_.exclaim(0).exclaim(1).exclaim(2)) >> Callback.log("Exclaim all")),
            "Exclaim!"
          ),
          <.button(
            ^.onClick --> (scope.modState(_.exclaim(0)) >> Callback.log("Exclaim 0")),
            "Exclaim 0!"
          ),
          <.button(
            ^.onClick --> (scope.modState(_.exclaim(1)) >> Callback.log("Exclaim 1")),
            "Exclaim 1!"
          ),
          <.button(
            ^.onClick --> (scope.modState(_.exclaim(2)) >> Callback.log("Exclaim 2")),
            "Exclaim 2!"
          )
        )
      )
    }
    .build

}

