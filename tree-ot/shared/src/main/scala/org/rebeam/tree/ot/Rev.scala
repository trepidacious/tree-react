package org.rebeam.tree.ot

case class Rev(i: Int) {
  def next: Rev = copy(i = i + 1)
}
