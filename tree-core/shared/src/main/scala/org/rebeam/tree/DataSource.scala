package org.rebeam.tree

import org.rebeam.tree.ot.{CursorUpdate, OTList}

trait DataSource {
  /**
    * Get the current data for an Id (if any)
    * @param id   The Id
    * @tparam A   The type of data
    * @return     The data at the Id, or None if no such Id exists in this source
    */
  def get[A](id: Id[A]): Option[A]

  /**
    * Get the current data and TransactionId for an Id (if any)
    * @param id   The Id
    * @tparam A   The type of data
    * @return     The data at the Id, and the TransactionId of the transaction that set this data,
    *             or None if no such Id exists in this source
    */
  def getWithTransactionId[A](id: Id[A]): Option[(A, TransactionId)]

  /**
    * Get the TransactionId of the transaction that set the current data for a given Id, using the
    * Guid of that Id.
    *
    * @param guid The Guid of the Id of the data
    * @return The TransactionId of the transaction that set this data, or None if no such Id exists
    *         in this source
    */
  def getTransactionIdFromGuid(guid: Guid): Option[TransactionId]

  /**
    * Get the most recent cursor update for a given OTList
    * @param list The OTList
    * @tparam A   The type of data in the OTList
    * @return     The most recent CursorUpdate for the OTList, or None if the OTList does not exist
    *             or does not have any update yet.
    */
  def getOTListCursorUpdate[A](list: OTList[A]): Option[CursorUpdate[A]]
}