package org.rebeam.tree.store

import io.circe.{Decoder, DecodingFailure, Encoder, Json}

import scala.util.Try
import scala.util.matching.Regex

/**
  * An identifier for an entire server revision, using an incrementing Long value.
  *
  * Where a RevId identifies a revision of a single item with an unordered Guid,
  * a StoreRevId applies to the entire data stored on a given Store (i.e. a complete
  * set of data).
  *
  * StoreRevIds are generated by the server providing the Store, and represent the serialisation
  * of transactions into an authoritative order.
  *
  * @param id The Long identifier for this store revision - starts from 0 and increments.
  */
case class StoreRevId(id: Long) {
  override def toString: String = StoreRevId.toString(this)
  def toJson: Json = Json.fromString(toString)

  def first: StoreRevId = StoreRevId(0)
  def next: StoreRevId = StoreRevId(id + 1)
}

object StoreRevId {
  val regex: Regex = "([Ss]-[0-9a-fA-F]+)".r
  val regexGrouped: Regex = "[Ss]-([0-9a-fA-F]+))".r

  private def hex(x: String): Long = java.lang.Long.parseUnsignedLong(x, 16)

  def fromString(s: String): Option[StoreRevId] = s match {
    case regexGrouped(id) =>
      Try {
        StoreRevId(hex(id))
      }.toOption
    case _ => None
  }

  def toString[A](r: StoreRevId): String = f"s-${r.id}%x"

  //Encoder and decoder using plain string format for id
  implicit def decodeId[A]: Decoder[StoreRevId] = Decoder.instance(
    c => c.as[String].flatMap(string => fromString(string).fold[Either[DecodingFailure, StoreRevId]](Left(DecodingFailure("ServerRevId invalid string", c.history)))(Right(_)))
  )
  implicit def encodeId[A]: Encoder[StoreRevId] = Encoder.instance(
    r => Json.fromString(toString(r))
  )
}