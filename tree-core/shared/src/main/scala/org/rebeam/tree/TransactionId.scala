package org.rebeam.tree

import io.circe._
import org.rebeam.tree.Guid._

import scala.util.Try
import scala.util.matching.Regex

/**
  * Identifier for a transaction, unique for a given scope (at least a single server).
  * Consists of a SessionId and SessionTransactionId within that Session.
  *
  * @param sessionId Session id
  * @param sessionTransactionId Id of transaction within the Session
  */
case class TransactionId(sessionId: SessionId, sessionTransactionId: SessionTransactionId) {
  override def toString: String = TransactionId.toString(this)
}

object TransactionId {

  val first: TransactionId = TransactionId.raw(0, 0)

  val regex: Regex = "([Tt][Ii][Dd]-[0-9a-fA-F]+-[0-9a-fA-F]+)".r
  val regexGrouped: Regex = "[Tt][Ii][Dd]-([0-9a-fA-F]+)-([0-9a-fA-F]+)".r

  private def hex(x: String): Long = java.lang.Long.parseUnsignedLong(x, 16)

  def fromString(s: String): Option[TransactionId] = s match {
    case regexGrouped(sessionId, sessionTransactionId) =>
      Try {
        TransactionId(SessionId(hex(sessionId)), SessionTransactionId(hex(sessionTransactionId)))
      }.toOption
    case _ => None
  }

  def toString(t: TransactionId): String = f"tid-${t.sessionId.id}%x-${t.sessionTransactionId.id}%x"

  //Encoder and decoder using plain string format for TransactionId

  implicit val decodeTransactionId: Decoder[TransactionId] = Decoder.instance(
    c => c.as[String].flatMap(string => fromString(string).fold[Either[DecodingFailure, TransactionId]](Left(DecodingFailure("TransactionId invalid string", c.history)))(Right(_)))
  )
  implicit val encodeTransactionId: Encoder[TransactionId] = Encoder.instance(
    g => Json.fromString(toString(g))
  )

  implicit val transactionIdKeyEncoder: KeyEncoder[TransactionId] = KeyEncoder.instance(TransactionId.toString)
  implicit val transactionIdKeyDecoder: KeyDecoder[TransactionId] = KeyDecoder.instance(TransactionId.fromString)

  def raw(sid: Long, stid: Long): TransactionId =
    TransactionId(SessionId(sid), SessionTransactionId(stid))

}
