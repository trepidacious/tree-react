package org.rebeam.tree

import io.circe.{Decoder, DecodingFailure, Encoder, Json}
import org.rebeam.tree.Guid.{SessionId, SessionTransactionId}

import scala.util.Try
import scala.util.matching.Regex

/**
  * An identifier for a revision of an item of data, using a TransactionId
  *
  * This allows for detection of changes to items, since all items are immutable, so changes only
  * occur when a transaction updates the item associated with an Id, and hence giving it a new RevId.
  * Transactions are considered to be atomic (i.e. they can only be seen as a complete set of changes, altogether)
  * and so the RevId simply records the TransactionId of the most recent transaction that changed the item.
  * An item may technically have been changed multiple times within a transaction, but since RevIds are not
  * used within a transaction this is not relevant.
  *
  * Note that RevIds just contain a TransactionId, and so like Ids, they are generated on
  * the client then regenerated as the same value on the server. Since clients generate transactions
  * concurrently, there is no ordering to RevIds. Transactions only receive a serial ordering when
  * they are executed by a store (server), producing an incrementing StoreRevId.
  *
  * @param tid The TransactionId
  * @tparam A Type of the item
  */
case class RevId[+A](tid: TransactionId) {
  override def toString: String = RevId.toString(this)
  def toJson: Json = Json.fromString(toString)
}

object RevId {
  val regex: Regex = "([Rr]-[0-9a-fA-F]+-[0-9a-fA-F]+)".r
  val regexGrouped: Regex = "[Rr]-([0-9a-fA-F]+)-([0-9a-fA-F]+)".r

  private def hex(x: String): Long = java.lang.Long.parseUnsignedLong(x, 16)

  def fromString[A](s: String): Option[RevId[A]] = s match {
    case regexGrouped(clientId, clientDeltaId) =>
      Try {
        RevId(
          TransactionId(
            SessionId(
              hex(clientId)
            ),
            SessionTransactionId(
              hex(clientDeltaId)
            )
          )
        )
      }.toOption
    case _ => None
  }

  def toString[A](r: RevId[A]): String = f"r-${r.tid.sessionId.id}%x-${r.tid.sessionTransactionId.id}%x"

  //Encoder and decoder using plain string format for id
  implicit def decodeId[A]: Decoder[RevId[A]] = Decoder.instance(
    c => c.as[String].flatMap(string => fromString[A](string).fold[Either[DecodingFailure, RevId[A]]](Left(DecodingFailure("RevId invalid string", c.history)))(Right(_)))
  )
  implicit def encodeId[A]: Encoder[RevId[A]] = Encoder.instance(
    r => Json.fromString(toString(r))
  )
}






