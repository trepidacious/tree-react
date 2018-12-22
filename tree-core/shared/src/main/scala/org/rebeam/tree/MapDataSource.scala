package org.rebeam.tree

case class MapDataSource(map: Map[Guid, (Any, RevId[_])]) extends DataSource {

  override def get[A](id: Id[A]): Option[A] = getWithRev(id).map(_._1)
  override def getWithRev[A](id: Id[A]): Option[(A, RevId[A])] = map.get(id.guid).map(_.asInstanceOf[(A, RevId[A])])

  def put[A](id: Id[A], a: A, r: RevId[A]): MapDataSource =
    copy(map = map.updated(id.guid, (a, r)))

  def modify[A](id: Id[A], f: A=>A, r: RevId[A]): MapDataSource =
    copy(map = get(id).fold(map)(a => map.updated(id.guid, (f(a), r))))

}

object MapDataSource {
  val empty: MapDataSource = MapDataSource(Map.empty)
}