package org.rebeam.tree

import cats.data.StateT
import cats.implicits._
import org.rebeam.tree.ot.{CursorUpdate, OTList}

/**
  * Implementation of ViewOps using a DataSource
  */
object DataSourceViewOps {

  case class Error(
    errorGuid: Guid,
    viewedGuids: Set[Guid],
    missingGuids: Set[Guid])

  case class StateData(
      dataSource: DataSource,
      viewedGuids: Set[Guid] = Set.empty,
      missingGuids: Set[Guid] = Set.empty) {
    def viewed(guid: Guid): StateData = copy(viewedGuids = viewedGuids + guid)
    def missed(guid: Guid): StateData = copy(missingGuids = missingGuids + guid)
  }

  def initialStateData(dataSource: DataSource): StateData = StateData(dataSource, Set.empty, Set.empty)

  type ErrorOr[A] = Either[Error, A]
  type S[A] = StateT[ErrorOr, StateData, A]

  implicit val viewOpsInstance: ViewOps[S] = new ViewOps[S] {

    // TODO use same code for get and getOTListCursorUpdate (and for optional versions), using a
    // type B that is A or CursorUpdate[A], and a function from StateData to B

    def get[A](id: Id[A]): S[A] =
      StateT[ErrorOr, StateData, A](sd => {
        //Get data as an option, map this to an Option[(StateData, A)] by adding a new state
        //updated to record viewing the id, then convert to an ErrorOr with appropriate
        //Error on missing data. This is the S => F[S, A] required by StateT.
        sd.dataSource.get(id)
          .map((sd.viewed(id.guid), _))
          .toRight(Error(
            id.guid,
            sd.viewedGuids + id.guid,
            sd.missingGuids + id.guid
          ))
      })

    def getOption[A](id: Id[A]): S[Option[A]] =
      StateT[ErrorOr, StateData, Option[A]](sd => {
        sd.dataSource.get(id).fold[ErrorOr[(StateData, Option[A])]](
          Right((sd.missed(id.guid).viewed(id.guid), None))
        )(
          a => Right((sd.viewed(id.guid), Some(a)))
        )
      })

    def getOTListCursorUpdate[A](list: OTList[A]): S[CursorUpdate[A]] =
      StateT[ErrorOr, StateData, CursorUpdate[A]](sd => {
        //Get update as an option, map this to an Option[(StateData, CursorUpdate[A])] by adding a new state
        //updated to record viewing the id, then convert to an ErrorOr with appropriate
        //Error on missing data. This is the S => F[S, CursorUpdate[A]] required by StateT.
        sd.dataSource.getOTListCursorUpdate(list)
          .map((sd.viewed(list.id.guid), _))
          .toRight(Error(
            list.id.guid,
            sd.viewedGuids + list.id.guid,
            sd.missingGuids + list.id.guid
          ))
      })

    def getOTListCursorUpdateOption[A](list: OTList[A]): S[Option[CursorUpdate[A]]] =
      StateT[ErrorOr, StateData, Option[CursorUpdate[A]]](sd => {
        sd.dataSource.getOTListCursorUpdate(list).fold[ErrorOr[(StateData, Option[CursorUpdate[A]])]](
          Right((sd.missed(list.id.guid).viewed(list.id.guid), None))
        )(
          a => Right((sd.viewed(list.id.guid), Some(a)))
        )
      })

  }
}
