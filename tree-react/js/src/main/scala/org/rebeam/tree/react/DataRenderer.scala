package org.rebeam.tree.react

import japgolly.scalajs.react.vdom.html_<^.VdomElement
import org.rebeam.tree.{DataSource, Guid}

import DataRenderer._

/**
  * Renders using props of type A, and Data, tracking which
  * ids were used from the DataSource to allow us to determine exactly
  * when an update is needed.
  * @tparam A The props.
  */
trait DataRenderer[A] {
  /**
    * Perform a render
    * Must meet the following contract:
    * 1. Function is pure
    * 2. Function only accesses values in DataSource using the ids returned in DataRenderResult.usedIds
    * 3. Function produces identical results for values of A where Reusability[A].test returns true.
    * These requirements allow us to memoise the render, so it is only reapplied if the data it uses changes.
    *
    * @param a    The data model ("props") to render
    * @param data The DataSource to use to look up references
    * @return     The result of rendering - Vdom, and a set of keys used.
    */
  def apply(a: A, data: DataSource): Result
}

object DataRenderer {
  /**
    * Result of a render - the actual Vdom, and the Ids for values in the
    * DataSource that we used to render. This can be used with a
    * new DataSource to see if any used values have changed.
    *
    * @param v          Rendered Vdom
    * @param usedIds    Guids from Ids of data retrieved from the DataSource and used to render
    */
  case class Result(v: VdomElement, usedIds: Set[Guid])
}
