package org.rebeam.tree.slinkify

import org.rebeam.tree._
import org.log4s._
import org.rebeam.tree.slinkify.DataComponent.logger
import org.rebeam.tree.slinkify.ReactData.ReactDataContexts
import slinky.core._
import slinky.core.facade.Hooks._
import slinky.core.facade.{React, ReactRef}

case class ValueAndData[A](a: A, data: ReactData)

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
  * However this does indicate a bit of a problem with the approach of pulling the Data from context and passing to
  * DataComponentB as part of props - we will hold on to the whole Data at the last revision used to render
  * each component. If we have a lot of churn in the Data, this will increase memory requirements (it's not a leak
  * since it doesn't grow indefinitely, but it will be holding on to data that is not needed - we only need the
  * revision numbers of the values used by the last render for SCU).
  *
  * TODO this can be improved by using useContext in SCU of DataComponent - see TODO below
  */
class DataRendererMemo[A: Reusability](r: DataRenderer[A]) {
  var lastProps: ValueAndData[A] = _
  var lastUsedIds: Set[Guid] = _

  def render(p: ValueAndData[A]): DataRenderer.Result = {
    val drr = r(p.a, p.data, p.data)
    lastProps = p
    lastUsedIds = drr.usedIds
    logger.trace(s"DataRendererMemo.render($p) gives used ids ${drr.usedIds}")
    drr
  }

  // TODO optimise - e.g. could return ids and revisions from DataRendererMemo.usedKeys to skip a map.get
  // Check whether any of the values referenced by the set of keys has changed revision between
  // currentData and nextData.
  def valuesChanged(guids: Set[Guid], currentData: DataSource, nextData: DataSource): Boolean = guids.exists(
    // Note that if both are None, this is not counted as a change (data is still missing)
    guid => currentData.getTransactionIdFromGuid(guid) != nextData.getTransactionIdFromGuid(guid)
  )

  def shouldComponentUpdate(currentProps: ValueAndData[A], nextProps: ValueAndData[A]): Boolean =
  // This shouldn't happen, since we should have render called before SCU, but if it happens
  // just permit the update to get our first memoised render.
    if (lastProps == null || lastUsedIds == null) {
      logger.trace("DataRendererMemo.shouldComponentUpdate - UPDATE: first render")
      true


      // If the current props are not the ones we saw last, then cache is invalid, so just allow another render.
      // We do not expect this to happen, based on lifecycle in the DataRendererMemo scaladoc, but if something
      // unexpected happens it's safer to just update, this will refresh the cache when render is called.
    } else if (lastProps ne currentProps) {
      logger.trace(
        s"DataRendererMemo.shouldComponentUpdate - UPDATE: lastProps $lastProps ne currentProps $currentProps"
      )
      true

      // If the instance of A in the props has changed, we should update
    } else if (!implicitly[Reusability[A]].test(currentProps.a, nextProps.a)) {
      logger.trace(
        s"DataRendererMemo.shouldComponentUpdate - UPDATE: props not reusable, ($currentProps.a -> $nextProps.a)"
      )
      true

      // If any values used in the memoised render have changed in the new data, can't reuse
    } else if (valuesChanged(lastUsedIds, currentProps.data, nextProps.data)) {
      logger.trace("DataRendererMemo.shouldComponentUpdate - UPDATE: new data value revision(s)")
      true

      // Data and props will produce the same result from renderer. Note we update lastProps to
      // nextProps - we have established that they produce the same result from the DataRenderer,
      // but note above that we require lastProps eq currentProps, so we need to update to allow the
      // next call to SCU to work, since nexProps may have different data contents (that are still
      // equivalent for our DataRenderer). This assumes that React will set the component's props
      // to nextProps, so we will see this as currentProps on the next call. If this is not the case
      // we will detect it this as `lastProps ne currentProps` when we are next called, and will return
      // true for safety

    } else {
      logger.trace(
        s"DataRendererMemo.shouldComponentUpdate - skip: updating lastProps from $lastProps to nextProps $nextProps"
      )
      lastProps = nextProps
      false
    }
}

object DataComponent {

  val logger: Logger = getLogger

  def apply[A](r: DataRenderer[A], contexts: ReactDataContexts = ReactData.defaultContexts)
                      (implicit reusability: Reusability[A]): FunctionalComponent[A] = FunctionalComponent[A] {
    val memo: ReactRef[DataRendererMemo[A]] = useRef(new DataRendererMemo[A](r))

    val inner = FunctionalComponent[ValueAndData[A]](
      props => memo.current.render(props).v
    )

    val memoInner = React.memo(inner, (a: ValueAndData[A], b: ValueAndData[A]) => memo.current.shouldComponentUpdate(a, b))

    props => memoInner(ValueAndData(props, useContext(contexts.data)))
  }
}

//class DataComponentB[A](r: DataRenderer[A])(implicit reusability: Reusability[A]) {
//
//  @react class C extends StatelessComponent {
//
//    type Props = ValueAndData[A]
//
//    val dataRendererMemo = new DataRendererMemo[A](r)
//
//    override def shouldComponentUpdate(nextProps: ValueAndData[A], nextState: Unit): Boolean =
//      dataRendererMemo.shouldComponentUpdate(props, nextProps)
//
//    def render: ReactElement =
//      dataRendererMemo.render(props).v
//  }
//
//  def apply(valueAndData: ValueAndData[A]): ReactElement = C(valueAndData)
//
//}
//
//class DataComponent[A](
//  r: DataRenderer[A],
//  contexts: ReactDataContexts = ReactData.defaultContexts
//)(implicit reusability: Reusability[A]) extends BasicFunctionalComponent[A] {
//
//  @react class C extends StatelessComponent {
//    type Props = A
//
//    private val b = new DataComponentB[A](r)
//
//    override def shouldComponentUpdate(nextProps: A, nextState: Unit): Boolean = {
//      //TODO should be able to use useContext here to run comparison without deferring to DataComponentB
//      reusability.test(props, nextProps)
//    }
//
//    def render: ReactElement = {
//      val data = useContext(contexts.data)
//      logger.trace(s">>>dataComponent.render_P, data $data, a = $props")
//      b(ValueAndData(props, data))
//    }
//  }
//
//  def apply(a: A): ReactElement = C(a)
//
//}
//
//object DataComponent {
//  val logger: Logger = getLogger
//
//  def apply[A](r: DataRenderer[A], contexts: ReactDataContexts = ReactData.defaultContexts)
//              (implicit reusability: Reusability[A]): BasicFunctionalComponent[A] = new DataComponent[A](r, contexts)
//}

