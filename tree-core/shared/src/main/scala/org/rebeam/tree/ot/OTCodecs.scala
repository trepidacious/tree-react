package org.rebeam.tree.ot

import io.circe._
import io.circe.generic.semiauto._
import _root_.org.rebeam.tree.Delta
import _root_.org.rebeam.tree.codec.Codec.DeltaCodec
import _root_.org.rebeam.tree.codec.PartialEncoder

object OTCodecs {


  implicit def atomEncoder[A: Encoder]: Encoder[Atom[A]] = deriveEncoder[Atom[A]]
  implicit def atomDecoder[A: Decoder]: Decoder[Atom[A]] = deriveDecoder[Atom[A]]
  implicit def operationEncoder[A: Encoder]: Encoder[Operation[A]] = deriveEncoder[Operation[A]]
  implicit def operationDecoder[A: Decoder]: Decoder[Operation[A]] = deriveDecoder[Operation[A]]
  implicit def otListEncoder[A: Encoder]: Encoder[OTList[A]] = deriveEncoder[OTList[A]]
  implicit def otListDecoder[A: Decoder]: Decoder[OTList[A]] = deriveDecoder[OTList[A]]

  def otDeltaCodec[A]: DeltaCodec[OTList[A]] = new DeltaCodec[OTList[A]] {

    val encoder: PartialEncoder[Delta[OTList[A]]] = _ => None

    val decoder: Decoder[Delta[OTList[A]]] =
      Decoder.failedWithMessage("Operational Transformation List does not support deltas")

  }
}
