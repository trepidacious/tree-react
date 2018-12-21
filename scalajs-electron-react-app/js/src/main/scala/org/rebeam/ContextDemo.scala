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

    case class Props[A](a: A, data: Data)

    /**
      * This class provides for memoisation of a DataRenderer, working with the expected React lifecycle to
      * avoid calling DataRenderer.apply when we know it will return the same result. This is done by providing
      * a render method that calls the DataRenderer and caches necessary data, and a shouldComponentUpdate method
      * that can be called from a component, which uses cached data to evaluate the need for an update without
      * having to call the DataRenderer again. Where this is not possible based on the cache (which should only be
      * if the React lifecycle is not as expected), an update is triggered for safety.
      *
      * The expected lifecycle is:
      * 1. render
      * 2. 0 or more SCU calls that return false.
      * 3. 1 SCU call that returns true
      * 4. Repeat from stage 1
      *
      * It is expected that the first call to SCU after a render will have currentProps eq renderProps, where
      * renderProps is what was passed to render.
      * It is expected that subsequent calls to SCU (before another call to render) will each have currentProps equal
      * to the nextProps from the previous call to SCU. In other words, React will pass a continuous chain of changes
      * to SCU - when an update is skipped, the nextProps will be applied to the component anyway, so will be the
      * currentProps in the next call. When an update is not skipped, render will be called with nextProps, and then
      * this will be the same props used for the next call to SCU after render.
      *
      * Note that we need a reference to the last props passed to render or SCU to make this work, and this will be
      * held until the component is unmounted and GCed, but React will be holding a reference to the props at least as
      * long as the component is mounted anyway, so this is not a memory leak.
      *
      * @param r    The DataRenderer
      * @param ev$1 Reusability for props, to allow us to compare them in SCU
      * @tparam A   The type of model in the props (alongside the data)
      */
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

      def shouldComponentUpdate(currentProps: Props[A], nextProps: Props[A]): Boolean =
        // This shouldn't happen, since we should have render called before SCU, but if it happens
        // just permit the update to get our first memoised render.
        if (lastProps == null || lastUsedKeys == null) {
          println("DataRendererMemo.shouldComponentUpdate - UPDATE: first render")
          true

        // If the current props are not the ones we saw last, then cache is invalid, so just allow another render.
        // We do not expect this to happen, based on lifecycle in the DataRendererMemo scaladoc, but if something
        // unexpected happens it's safer to just update, this will refresh the cache when render is called.
        } else if (lastProps ne currentProps) {
          println(
            "DataRendererMemo.shouldComponentUpdate - UPDATE: lastProps "
              + lastProps + " ne currentProps " + currentProps
          )
          true

        // If the instance of A in the props has changed, we should update
        } else if (!implicitly[Reusability[A]].test(currentProps.a, nextProps.a)) {
          println(
            "DataRendererMemo.shouldComponentUpdate - UPDATE: props not reusable ("
              + currentProps.a + " -> " + nextProps.a + ")"
          )
          true

        // If any values used in the memoised render have changed in the new data, can't reuse
        } else if (valuesChanged(lastUsedKeys, currentProps.data, nextProps.data)) {
          println("DataRendererMemo.shouldComponentUpdate - UPDATE: new data value revision(s)")
          true

        // Data and props will produce the same result from renderer. Note we update lastProps to
        // nextProps - we have established that they produce the same result from the DataRenderer,
        // but note above that we require lastProps eq currentProps, so we need to update to allow the
        // next call to SCU to work, since nexProps may have different data contents (that are still
        // equivalent for our DataRenderer). This assumes that React will set the component's props
        // to nextProps, so we will see this as currentProps on the next call.
        } else {
          println(
            "DataRendererMemo.shouldComponentUpdate - skip: updating lastProps from "
              + lastProps + " to nextProps " + nextProps
          )
          lastProps = nextProps
          false
        }
    }

    class Backend[A: Reusability](bs: BackendScope[Props[A], Unit], r: DataRenderer[A]) {
      val dataRendererMemo = new DataRendererMemo[A](r)
      def render(p: Props[A]): VdomElement = {
        dataRendererMemo.render(p).v
      }
    }
    
    def component[A: Reusability](name: String, r: DataRenderer[A]) = ScalaComponent.builder[Props[A]](name)
      .backend(scope => new Backend[A](scope, r))
      .render(s => s.backend.render(s.props))
      .shouldComponentUpdatePure(f => f.backend.dataRendererMemo.shouldComponentUpdate(f.currentProps, f.nextProps))
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
              println(">>>dataComponent.render_P, data " + data + ", a = " + a)
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
