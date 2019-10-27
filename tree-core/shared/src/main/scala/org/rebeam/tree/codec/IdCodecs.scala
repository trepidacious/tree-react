package org.rebeam.tree.codec

import org.rebeam.tree.{Id, Moment}

trait IdCodecs {
  def codecFor[A](id: Id[A]): Option[IdCodec[A]]
}

object IdCodecs {
  import Codec._
  implicit val charIdCodec: IdCodec[Char] = IdCodec[Char]("Char")
  implicit val stringDeltaCodec: IdCodec[String] = IdCodec[String]("String")
  implicit val booleanDeltaCodec: IdCodec[Boolean] = IdCodec[Boolean]("Boolean")
  implicit val byteDeltaCodec: IdCodec[Byte] = IdCodec[Byte]("Byte")
  implicit val shortDeltaCodec: IdCodec[Short] = IdCodec[Short]("Short")
  implicit val intDeltaCodec: IdCodec[Int] = IdCodec[Int]("Int")
  implicit val longDeltaCodec: IdCodec[Long] = IdCodec[Long]("Long")
  implicit val floatDeltaCodec: IdCodec[Float] = IdCodec[Float]("Float")
  implicit val doubleDeltaCodec: IdCodec[Double] = IdCodec[Double]("Double")

  implicit val momentDeltaCodec: IdCodec[Moment] = IdCodec[Moment]("Moment")
}