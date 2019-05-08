package org.rebeam.tree.ot

import cats.Monad
import io.circe._
import io.circe.generic.semiauto._
import io.circe.syntax._
import org.rebeam.tree.{Delta, Id, STMOps}
import org.rebeam.tree.codec.Codec.DeltaCodec
import org.rebeam.tree.codec.PartialEncoder

object OTCodecs {

  implicit def atomEncoder[A: Encoder]: Encoder[Atom[A]] = deriveEncoder[Atom[A]]
  implicit def atomDecoder[A: Decoder]: Decoder[Atom[A]] = deriveDecoder[Atom[A]]
  implicit def operationEncoder[A: Encoder]: Encoder[Operation[A]] = deriveEncoder[Operation[A]]
  implicit def operationDecoder[A: Decoder]: Decoder[Operation[A]] = deriveDecoder[Operation[A]]

  case class OTDelta[A](id: Id[List[A]], op: Operation[A]) extends Delta[List[A]] {
    def apply[F[_]: Monad](a: List[A])(implicit stm: STMOps[F]): F[A] = stm.listOperation(id, op)
  }

  def otDeltaCodec[A](implicit e: Encoder[A], d: Decoder[A]): DeltaCodec[List[A]] = new DeltaCodec[List[A]] {

    val encoder: PartialEncoder[Delta[List[A]]] = {
      case OTDelta(id, op) =>
        Some(Json.obj(
          "OTDelta" -> Json.obj(
            "id" -> id.asJson,
            "op" -> op.asJson
          )
        ))
      case _ => None
    }

    val decoder: Decoder[Delta[List[A]]] = Decoder.instance {
      c => for {
        id <- c.downField("OTDelta").downField("id").as[Id[List[A]]]
        op <- c.downField("OTDelta").downField("op").as[Operation[A]]
      } yield OTDelta(id, op)
    }

  }
}
