# Introduction

Provides a software-transactional memory implementation and an approach to client-server synchronisation allowing for concurrent editing of a shared document model.

## antd-app

This provides a demo of `tree-core` and `tree-slinky` with a simple Todo app.

1. Install [sbt](https://www.scala-sbt.org/) and [yarn](https://yarnpkg.com/).
2. Run `sbt`.
3. In sbt, run `antdApp/start`
4. To update, run `antdApp/fastOptJS` - this should be picked up automatically, and app will reload

## tree-core

A simple, functional software transactional memory, plus an approach to updating it using serialisable transactions, synchronising data between server and clients, and editing immutable data structures using lenses.

This is still in progress, see [notes](https://github.com/trepidacious/tree-react/blob/master/tree-core/Notes.md).

## tree-slinky

Slinky React components for use with tree-core. These are the preferred components for use with tree-core.

## tree-react

Scalajs-react components for use with tree-core. These are less supported and may be removed.

## Todo

See `tree-core/Notes.md` for todo
