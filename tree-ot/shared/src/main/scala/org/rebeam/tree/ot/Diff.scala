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
    * Note: This uses a simple algorithm - it just finds the shared prefix and suffix of the lists (i.e. the
    * sections at the start and end of the two lists that are the same, if any), and retains these. Then it
    * deletes and inserts as necessary to make the middle match.
    * This will always generate a operation that will "work", but may generate a larger change than is needed. However
    * in the cases of a single (or contiguous) insert, delete or alteration it will produce the "optimum" operation.
    * This will work well for user editing of a string via typing, deletion, cutting and pasting, including doing
    * those operations after selecting a contiguous range. Ideally browsers would all give a reasonable representation
    * of such edits we could use directly, but unfortunately at the moment they don't seem to.
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
      
      val o1 = OperationBuilder[A].retainIfPositive(s)

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
