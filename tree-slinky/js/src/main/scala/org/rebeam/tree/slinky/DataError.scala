package org.rebeam.tree.slinky

import org.rebeam.tree.Guid

final case class DataError(
  errorGuid: Guid,
  viewedGuids: Set[Guid],
  missingGuids: Set[Guid]
)