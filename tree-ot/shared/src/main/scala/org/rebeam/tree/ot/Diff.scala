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
  def apply[A](o: List[A], n: List[A]): Operation[A] = {
    if (o eq n) {
      OperationBuilder[A].retain(o.size).build
    } else {

      val ol = o.length
      val nl = n.length

      val s = prefixLength(o, n)

      val e = prefixLength(o.reverse, n.reverse, Math.min(ol, nl) - s)

      // Retain common start
      val o1 = OperationBuilder[A].retain(s)

      // If o contains non-common elements, delete them
      val o2 = if (ol != s + e) {
        o1.delete(ol - s - e)
      } else o1

      // Previous operation will transform o to just the common elements. If
      // n is just the common elements we are done, otherwise we need anything
      // extra from n into our list
      val o3 = if (nl != s + e) {
        // The new part of n is everything between the common start and common end
        o2.insert(n.slice(s, nl - e))
      } else {
        o2
      }

      // Finally, retain the common end
      o3.retainIfPositive(e).build
    }
  }
}
