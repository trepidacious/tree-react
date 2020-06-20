package org.rebeam.tree.slinkify

import org.rebeam.tree._
import DataRenderer._
import _root_.slinky.core.facade.ReactElement

object DataRenderer {
  /**
    * Result of a render - the actual ReactElement, and the Ids for values in the
    * DataSource that we used to render. This can be used with a
    * new DataSource to see if any used values have changed.
    *
    * @param v          Rendered ReactElement
    * @param usedIds    Guids from Ids of data retrieved from the DataSource and used to render
    */
  case class Result(v: ReactElement, usedIds: Set[Guid])
}

/**
  * Renders using props of type A, and ReactData, tracking which
  * ids were used from the DataSource to allow us to determine exactly
  * when an update is needed.
  * @tparam A The props.
  */
trait DataRenderer[A] {
  /**
    * Perform a render
    * Must meet the following contract:
    * 1. Function is pure
    * 2. Function only accesses values in DataSource using the ids returned in Result.usedIds
    * 3. Function produces identical results for values of A where Reusability[A].test returns true,
    *    assuming all values in DataSource returned using Result.usedIds are also the same.
    *
    * These requirements allow us to memoise the render, so it is only reapplied if the data it uses changes.
    *
    * @param a    The data model ("props") to render
    * @param data The ReactData to use to look up references and execute transactions
    * @param tx   The ReactTransactor to use to execute transactions
    * @return     The result of rendering - Vdom, and a set of keys used.
    */
  def apply(a: A, data: ReactData, tx: ReactTransactor): Result
}


