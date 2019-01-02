package org.rebeam.tree.react

import org.rebeam.tree.Guid

final case class DataError(
  errorGuid: Guid,
  viewedGuids: Set[Guid],
  missingGuids: Set[Guid]
)