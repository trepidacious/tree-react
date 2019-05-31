package org.rebeam.tree.ot

import io.circe._
import io.circe.generic.semiauto._
import org.rebeam.tree.Delta
import org.rebeam.tree.codec.Codec.DeltaCodec
import org.rebeam.tree.codec.PartialEncoder

object OTCodecs {

  implicit def atomEncoder[A: Encoder]: Encoder[Atom[A]] = deriveEncoder[Atom[A]]
  implicit def atomDecoder[A: Decoder]: Decoder[Atom[A]] = deriveDecoder[Atom[A]]
  implicit def operationEncoder[A: Encoder]: Encoder[Operation[A]] = deriveEncoder[Operation[A]]
  implicit def operationDecoder[A: Decoder]: Decoder[Operation[A]] = deriveDecoder[Operation[A]]
  implicit def otListEncoder[A: Encoder]: Encoder[OTList[A]] = deriveEncoder[OTList[A]]
  implicit def otListDecoder[A: Decoder]: Decoder[OTList[A]] = deriveDecoder[OTList[A]]

  def otDeltaCodec[A]: DeltaCodec[List[A]] = new DeltaCodec[List[A]] {

    val encoder: PartialEncoder[Delta[List[A]]] = _ => None

    val decoder: Decoder[Delta[List[A]]] = Decoder.failedWithMessage("Operational Transformation List does not support deltas")

  }
}
