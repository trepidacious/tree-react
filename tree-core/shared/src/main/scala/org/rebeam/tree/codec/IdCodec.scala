package org.rebeam.tree.codec

import io.circe.{ArrayEncoder, Decoder, Encoder, Json}
import org.rebeam.tree.Id
import org.rebeam.tree.codec.Codec.DeltaCodec
import org.rebeam.tree.ot.{OTCodecs, OTList}
import io.circe.syntax._

/**
  * Represents a type of data referenced by [[org.rebeam.tree.Id]] in an STM
  *
  * @param name   The name of the type, must only be associated with one real type in a given STM.
  */
case class IdType(name: String)

/**
  * Typeclass covering everything needed to handle a type of data referenced by [[org.rebeam.tree.Id]] in an STM
  * @tparam A     The type of data
  */
trait IdCodec[A] {
  def idType: IdType
  def encoder: Encoder[A]
  def decoder: Decoder[A]
  def deltaCodec: DeltaCodec[A]
}

object IdCodec {
  def apply[A](idType: String)
    (implicit encoder: Encoder[A], decoder: Decoder[A], deltaCodec: DeltaCodec[A]): IdCodec[A] =
    IdCodecBasic(IdType(idType), encoder, decoder, deltaCodec)

  def otList[A](implicit aCodec: IdCodec[A]): IdCodec[OTList[A]] = {
    implicit val listEncoder: ArrayEncoder[List[A]] = Encoder.encodeList[A](aCodec.encoder)
    implicit val listDecoder: Decoder[List[A]] = Decoder.decodeList[A](aCodec.decoder)
    IdCodecBasic(
      IdType(s"OTList[${aCodec.idType.name}]"),
      Encoder.instance(l =>
        Json.obj(
          "id" -> l.id.asJson,
          "list" ->l.list.asJson
        )
      ),
      Decoder.instance(
        c => for {
          id <- c.downField("id").as[Id[OTList[A]]]
          list <- c.downField("list").as[List[A]]
        } yield OTList[A](id, list)
      ),
      OTCodecs.otDeltaCodec
    )
  }
}

case class IdCodecBasic[A](idType: IdType, encoder: Encoder[A], decoder: Decoder[A], deltaCodec: DeltaCodec[A]) extends IdCodec[A]

