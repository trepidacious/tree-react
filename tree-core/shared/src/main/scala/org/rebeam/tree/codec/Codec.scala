package org.rebeam.tree.codec

import io.circe.{Decoder, Encoder, Json}
import io.circe.syntax._
import Codec._
import cats.Traverse
import cats.implicits._
import monocle.{Lens, Optional, Prism}
import org.rebeam.tree.{Delta, Moment}
import org.rebeam.tree.Delta._
//import org.rebeam.tree.ot.{OTCodecs, OTList, Operation}

trait Codec[A] {
  def encoder: PartialEncoder[A]
  val decoder: Decoder[A]
  def or(other: => Codec[A]): Codec[A] =
    EitherCodec(this, other)
}

object Codec {

  case class EitherCodec[A](lc: Codec[A], rc: Codec[A]) extends Codec[A] {
    val encoder: PartialEncoder[A] = lc.encoder or rc.encoder
    val decoder: Decoder[A] = lc.decoder or rc.decoder
  }

  type DeltaCodec[A] = Codec[Delta[A]]

  case class EitherDeltaCodec[A](lc: DeltaCodec[A], rc: DeltaCodec[A]) extends DeltaCodec[A] {
    val encoder: PartialEncoder[Delta[A]] = lc.encoder or rc.encoder
    val decoder: Decoder[Delta[A]] = lc.decoder or rc.decoder
  }

  def value[A: Encoder: Decoder]: DeltaCodec[A] = new DeltaCodec[A] {

    val encoder: PartialEncoder[Delta[A]] = {
      case ValueDelta(v) =>
        Some(Json.obj(
          "ValueDelta" -> v.asJson
        ))
      case _ => None
    }

    val decoder: Decoder[Delta[A]] = Decoder.instance {
      c => c.downField("ValueDelta").as[A]
        .map(v => ValueDelta(v))
    }
  }

  def empty[A]: DeltaCodec[A] = new DeltaCodec[A]{
    val encoder: PartialEncoder[Delta[A]] = _ => None
    val decoder: Decoder[Delta[A]] = Decoder.failedWithMessage("Empty delta codec")
  }

  implicit val stringDeltaCodec: DeltaCodec[String] = value[String]
  implicit val booleanDeltaCodec: DeltaCodec[Boolean] = value[Boolean]
  implicit val byteDeltaCodec: DeltaCodec[Byte] = value[Byte]
  implicit val shortDeltaCodec: DeltaCodec[Short] = value[Short]
  implicit val intDeltaCodec: DeltaCodec[Int] = value[Int]
  implicit val longDeltaCodec: DeltaCodec[Long] = value[Long]
  implicit val floatDeltaCodec: DeltaCodec[Float] = value[Float]
  implicit val doubleDeltaCodec: DeltaCodec[Double] = value[Double]

  implicit val momentDeltaCodec: DeltaCodec[Moment] = value[Moment]

  def lens[A, B]
    (name: String, lens: Lens[A, B])
    (implicit partialBCodec: DeltaCodec[B]): DeltaCodec[A] = new DeltaCodec[A] {

    val encoder: PartialEncoder[Delta[A]] = {
      case LensDelta(l, d) if l == lens =>
        //Note we know that delta is a Delta[B] since LensDelta has the same lens used to
        //create this instance, which was Lens[A, B]
        partialBCodec.encoder(d.asInstanceOf[Delta[B]])
          .map(dJson =>
            Json.obj(
              "LensDelta" -> Json.obj(
                name -> dJson
              )
            )
          )
      case x => None
    }

    val decoder: Decoder[Delta[A]] = Decoder.instance {
      c => c.downField("LensDelta")
        .downField(name)
        .as[Delta[B]](partialBCodec.decoder)
        .map(db => LensDelta(lens, db))
    }
  }

  def optional[A, B]
    (name: String, optional: Optional[A, B])
    (implicit partialBCodec: DeltaCodec[B]): DeltaCodec[A] = new DeltaCodec[A] {

    val encoder: PartialEncoder[Delta[A]] = {
      case OptionalDelta(o, d) if o == optional =>
        partialBCodec.encoder(d.asInstanceOf[Delta[B]])
          .map(dJson =>
            Json.obj(
              "OptionalDelta" -> Json.obj(
                name -> dJson
              )
            )
          )
      case _ => None
    }

    val decoder: Decoder[Delta[A]] = Decoder.instance {
      c => c.downField("OptionalDelta")
        .downField(name)
        .as[Delta[B]](partialBCodec.decoder)
        .map(db => OptionalDelta(optional, db))
    }
  }

  def option[A](implicit dCodecA: DeltaCodec[A]): DeltaCodec[Option[A]] = new DeltaCodec[Option[A]] {
    val encoder: PartialEncoder[Delta[Option[A]]] = {
      case OptionDelta(delta) =>
        //Note we know that delta is a Delta[A] since OptionDelta is a Delta[Option[A]]
        dCodecA.encoder(delta.asInstanceOf[Delta[A]]).map(deltaJson =>
          Json.obj(
            "OptionDelta" -> Json.obj(
              "delta" -> deltaJson
            )
          )
        )
      case _ => None
    }

    val decoder: Decoder[Delta[Option[A]]] = Decoder.instance { c =>
      val o = c.downField("OptionDelta")
      for {
        delta <- o.downField("delta").as[Delta[A]](dCodecA.decoder)
      } yield OptionDelta[A](delta)
    }
  }

  def lensOption[A, B]
  (name: String, lensToOption: Lens[A, Option[B]])
  (implicit partialBCodec: DeltaCodec[B]): DeltaCodec[A] = {
    implicit val optionDelta: DeltaCodec[Option[B]] = option[B]
    lens(name, lensToOption)
  }

  def prism[A, B]
  (name: String, prism: Prism[A, B])
  (implicit partialBCodec: DeltaCodec[B]): DeltaCodec[A] = new DeltaCodec[A] {

    val encoder: PartialEncoder[Delta[A]] = {
      case PrismDelta(p, d) if p == prism =>
        //Note we know that delta is a Delta[B] since PrismDelta has the same prism used to
        //create this instance, which was Prism[A, B]
        partialBCodec.encoder(d.asInstanceOf[Delta[B]])
          .map(dJson =>
            Json.obj(
              "PrismDelta" -> Json.obj(
                name -> dJson
              )
            )
          )
      case _ => None
    }

    val decoder: Decoder[Delta[A]] = Decoder.instance {
      c => c.downField("PrismDelta")
        .downField(name)
        .as[Delta[B]](partialBCodec.decoder)
        .map(db => PrismDelta(prism, db))
    }
  }

  def traversableIndex[T[_]: Traverse, A](implicit dCodecA: DeltaCodec[A]): DeltaCodec[T[A]] = new DeltaCodec[T[A]] {
    val encoder: PartialEncoder[Delta[T[A]]] = {
      case TraversableIndexDelta(index, delta) =>
        //Note we know that delta is a Delta[A] since TraversableIndexDelta is a Delta[T[A]]
        dCodecA.encoder(delta.asInstanceOf[Delta[A]]).map(deltaJson =>
          Json.obj(
            "TraversableIndexDelta" -> Json.obj(
              "index" -> index.asJson,
              "delta" -> deltaJson
            )
          )
        )
      case _ => None
    }

    val decoder: Decoder[Delta[T[A]]] = Decoder.instance { c =>
      val o = c.downField("TraversableIndexDelta")
      for {
        index <- o.downField("index").as[Int]
        delta <- o.downField("delta").as[Delta[A]](dCodecA.decoder)
      } yield TraversableIndexDelta[T, A](index, delta)
    }
  }

  def listIndex[A](implicit dCodecA: DeltaCodec[A]): DeltaCodec[List[A]] = traversableIndex[List, A]
  def vectorIndex[A](implicit dCodecA: DeltaCodec[A]): DeltaCodec[Vector[A]] = traversableIndex[Vector, A]

  def action[M, A <: Delta[M]](name: String)(filter: PartialFunction[Delta[M], A])(implicit encodeA: Encoder[A], decodeA: Decoder[A]): DeltaCodec[M] = new DeltaCodec[M] {
    val encoder: PartialEncoder[Delta[M]] =
      (m: Delta[M]) => for {
        a <- filter.lift(m)
      } yield Json.obj(
        "ActionDelta" -> Json.obj(
          name -> encodeA(a)
        )
      )

    val decoder: Decoder[Delta[M]] = Decoder.instance(c =>
      //Expect an object with a value field, containing an encoded M instance. We
      //map this to a ValueDelta using that instance (i.e. this provides a delta
      //replacing the old instance with the decoded instance)
      c.downField("ActionDelta").downField(name).as[A]

      //Map to Delta[M] for neatness
    ).map(a => a: Delta[M])
  }

//  def otList[A](implicit encoderA: Encoder[A], decoderA: Decoder[A]): DeltaCodec[OTList[A]] = new DeltaCodec[OTList[A]] {
//    import OTCodecs._
//    val encoder: PartialEncoder[Delta[OTList[A]]] = {
//      case OTListDelta(op) =>
//        //Note we know that op is a Operation[A] since OTListDelta is a Delta[OTList[A]]
//        Some(Json.obj(
//          "OTListDelta" -> Json.obj(
//            "op" -> op.asInstanceOf[Operation[A]].asJson
//          )
//        ))
//      case _ => None
//    }
//
//    val decoder: Decoder[Delta[OTList[A]]] = Decoder.instance { c =>
//      val o = c.downField("OTListDelta")
//      for {
//        delta <- o.downField("op").as[Operation[A]]
//      } yield OTListDelta[A](delta)
//    }
//  }

}