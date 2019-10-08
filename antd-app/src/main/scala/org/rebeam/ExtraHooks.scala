package org.rebeam

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.JSConverters._

object ExtraHooks {

  @js.native
  @JSImport("react", JSImport.Namespace, "React")
  private object HooksRaw extends js.Object {
    def useCallback[T](callback: js.Function1[T, Unit], watchedObjects: js.Array[js.Any]): js.Function1[T, Unit] = js.native
  }

  @inline def useCallback[T](callback: T => Unit, watchedObjects: Iterable[Any]): T => Unit = {
    HooksRaw.useCallback(callback, watchedObjects.toJSArray.asInstanceOf[js.Array[js.Any]])
  }

}
