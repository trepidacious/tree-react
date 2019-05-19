package org.rebeam.tree

import org.rebeam.tree.ot.{ClientState, CursorUpdate}

case class MapDataSource(map: Map[Guid, (Any, RevId[_])], otMap: Map[Guid, ClientState[_]]) extends DataSource {

  override def get[A](id: Id[A]): Option[A] = getWithRev(id).map(_._1)
  override def getWithRev[A](id: Id[A]): Option[(A, RevId[A])] = map.get(id.guid).map(_.asInstanceOf[(A, RevId[A])])

  override def revGuid(guid: Guid): Option[Guid] = map.get(guid).map(_._2.guid)

  def getClientState[A](id: Id[List[A]]): Option[ClientState[A]] = otMap.get(id.guid).map(_.asInstanceOf[ClientState[A]])

  def put[A](id: Id[A], a: A, r: RevId[A]): MapDataSource =
    copy(map = map.updated(id.guid, (a, r)))

  def modify[A](id: Id[A], f: A=>A, r: RevId[A]): MapDataSource =
    copy(map = get(id).fold(map)(a => map.updated(id.guid, (f(a), r))))

  def getList[A](id: Id[List[A]]): Option[(List[A], CursorUpdate[A])] = for {
    list <- get(id)
    clientState <- getClientState(id)
  } yield (list, clientState)
}

object MapDataSource {
  val empty: MapDataSource = MapDataSource(Map.empty, Map.empty)
}