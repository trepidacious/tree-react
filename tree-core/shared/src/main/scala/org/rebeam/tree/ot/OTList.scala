package org.rebeam.tree.ot

import _root_.org.rebeam.tree._

case class OTList[A](id: Id[OTList[A]], list: List[A]) extends Identified[OTList[A]]
