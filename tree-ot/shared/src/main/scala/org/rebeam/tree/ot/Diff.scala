package org.rebeam.tree.ot

import scala.annotation.tailrec

object Diff {

  @tailrec
  def prefixLength(o: List[_], n: List[_], max: Int = -1, len: Int = 0): Int = {
    if (o.isEmpty || n.isEmpty || len == max) {
      len
    } else if (o.head != n.head) {
      len
    } else {
      prefixLength(o.tail, n.tail, max, len + 1)
    }
  }

  /**
    * Generate a diff between two lists, as an Operation
    * @param o    The old list
    * @param n    The new list
    * @tparam A   The type of element
    * @return     An operation producing the change
    */
  def apply[A](o: List[A], n: List[A], priority: Int = 0): Operation[A] = {
    if (o eq n) {
      OperationBuilder[A].retain(o.size).build(priority)
    } else {

      val ol = o.length
      val nl = n.length

      val s = prefixLength(o, n)

      val e = prefixLength(o.reverse, n.reverse, Math.min(ol, nl) - s)

      val o1 = OperationBuilder[A].retain(s)

      // If o contains non-common elements, delete them
      val o2 = if (ol != s + e) {
        o1.delete(ol - s - e)
//        ctx.remove(commonStart, o.length - commonStart - commonEnd)
      } else o1

      //Previous operation will transform o to just the common elements. If
      //n is just the common elements we are done, otherwise we need anything
      //extra from n into our list
      val o3 = if (nl != s + e) {
        o2.insert(n.slice(s, nl - e)) //FIXME check indices for scala slice
//        ctx.insert(commonStart, n.slice(commonStart, n.length - commonEnd))
      } else {
        o2
      }

      o3.build(priority)
    }
  }
}
