package org.rebeam.tree

import io.circe.{Decoder, DecodingFailure, Encoder, Json}
import org.rebeam.tree.Guid.{SessionId, SessionTransactionId, TransactionClock}

import scala.util.Try
import scala.util.matching.Regex

/**
  * An identifier for a revision of an item of data, using a Guid
  *
  * This allows for detection of changes to items, since all items are immutable, so changes only
  * occur by updating the item associated with an Id, and hence giving it a new RevId.
  *
  * Note that RevIds are assigned by the transaction context, and so like Ids, they are generated on
  * the client then regenerated as the same value on the server. Since clients generate transactions
  * concurrently, there is no ordering to RevIds. Transactions only receive a serial ordering when
  * they are executed by the server, producing an incrementing ServerRevId.
  *
  * @param guid The Guid
  * @tparam A Type of the item
  */
case class RevId[+A](guid: Guid) {
  override def toString: String = RevId.toString(this)
  def toJson: Json = Json.fromString(toString)
}

object RevId {
  val regex: Regex = "([Rr]-[0-9a-fA-F]+-[0-9a-fA-F]+-[0-9a-fA-F]+)".r
  val regexGrouped: Regex = "[Rr]-([0-9a-fA-F]+)-([0-9a-fA-F]+)-([0-9a-fA-F]+)".r

  private def hex(x: String): Long = java.lang.Long.parseUnsignedLong(x, 16)

  def fromString[A](s: String): Option[RevId[A]] = s match {
    case regexGrouped(clientId, clientDeltaId, id) =>
      Try {
        RevId(Guid(SessionId(hex(clientId)), SessionTransactionId(hex(clientDeltaId)), TransactionClock(hex(id))))
      }.toOption
    case _ => None
  }

  def toString[A](r: RevId[A]): String = f"r-${r.guid.sessionId.id}%x-${r.guid.sessionTransactionId.id}%x-${r.guid.transactionClock.id}%x"

  //Encoder and decoder using plain string format for id
  implicit def decodeId[A]: Decoder[RevId[A]] = Decoder.instance(
    c => c.as[String].flatMap(string => fromString[A](string).fold[Either[DecodingFailure, RevId[A]]](Left(DecodingFailure("RevId invalid string", c.history)))(Right(_)))
  )
  implicit def encodeId[A]: Encoder[RevId[A]] = Encoder.instance(
    r => Json.fromString(toString(r))
  )
}






