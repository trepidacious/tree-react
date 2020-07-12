package org.rebeam.tree.slinkify

import org.rebeam.tree.Guid
import org.rebeam.tree.util.CRC32
import org.rebeam.tree.Id
import org.rebeam.tree.Ref
import org.rebeam.tree.Identified
import org.rebeam.tree.Identifiable

/**
  * Typeclass for converting an item to an Int hash suitable for display as an ArcHash
  */
trait ArcHashable[A] {
  /**
    * Calculate an ArcHash for the item
    * The hash should be stable, in the sense that it should return the same value for items that would be recognised as
    * being "the same" by a user. This supports the use case of ArcHashes in providing a quickly identifiable visual indication
    * of identity.
    * In this way arcHash is similar to hashCode, however it should may return the same value for items that are not strictly
    * equal (and might therefore have different hashCodes), where those items should be considered to be equal by the user.
    * Suitable means of hashing would be to combine the relevant fields of a product type, convert an enumeration into a
    * stable index, or hash a unique identifier such as a Guid. The canonical method is to CRC32 the relevant data.
    * @param a  The item to hash
    * @return   An Int hash to display as an ArcHash
    */
  def arcHash(a: A): Int
}

object ArcHashable {

  def hashGuid(guid: Guid): Int = CRC32.empty
    .updateLong(guid.sessionId.id)
    .updateLong(guid.sessionTransactionId.id)
    .updateLong(guid.transactionClock.id).value

  implicit val arcHashableGuid: ArcHashable[Guid] = guid => hashGuid(guid)
  implicit def arcHashableId[A]: ArcHashable[Id[A]] = id => hashGuid(id.guid)
  implicit def arcHashableRef[A]: ArcHashable[Ref[A]] = ref => hashGuid(ref.id.guid)
  implicit val arcHashableString: ArcHashable[String] = s => CRC32(s.getBytes("utf-8").toSeq).value
  implicit def arcHashableIdentified[A]: ArcHashable[Identified[A]] = a => hashGuid(a.id.guid)
  implicit def arcHashableIdentifiable[A](implicit identifiable: Identifiable[A]): ArcHashable[A] = a => hashGuid(identifiable.id(a).guid)

}