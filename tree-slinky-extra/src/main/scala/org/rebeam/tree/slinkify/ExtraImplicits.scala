package org.rebeam.tree.slinkify

import scala.scalajs.js
import slinky.core._

object ExtraImplicits {

  implicit class PlainIcon[E <: TagElement, R <: js.Object](icon: ExternalComponentWithAttributesWithRefType[E, R]{type Props = typings.antDesignIcons.anon.PickAntdIconPropsmaxrequi}) {
    def plain = icon.apply(js.Object().asInstanceOf[typings.antDesignIcons.anon.PickAntdIconPropsmaxrequi])
  }

}
