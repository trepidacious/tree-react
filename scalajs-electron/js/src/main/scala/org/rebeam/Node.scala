package org.rebeam

import scalajs.js

import scala.scalajs.js.JavaScriptException

import io.scalajs.nodejs.fs._
import io.scalajs.nodejs.buffer.Buffer

import cats.effect.IO

object Node {

  val dirName = js.Dynamic.global.__dirname

  def relativePath(path: String): String = s"$dirName/$path"

  /**
    * Get the contents of a file at a path relative to the main directory of the electron application
    * (normally `src`, but can be the root of the project - see `package.json`, `main` field).
    * @param path The relative path - no leading `/`. So for files in the main directory, just the file name,
    *             often you will want something like `../someOtherDir/file.txt`.
    */
  def relativePathAsBuffer(path: String): IO[Buffer] = fileAsBuffer(s"$dirName/$path")

  /**
    * Get the contents of a file at a path relative to the main directory of the electron application
    * (normally `src`, but can be the root of the project - see `package.json`, `main` field).
    * @param path The relative path - no leading `/`. So for files in the main directory, just the file name,
    *             often you will want something like `../someOtherDir/file.txt`.
    */
  def relativePathAsString(path: String): IO[String] = fileAsString(s"$dirName/$path")

  /**
    * Get the contents of a file at a given filename, as a Buffer, using IO
    * @param filename The filename to open.
    * @return         The file contents as a Buffer
    */
  def fileAsBuffer(filename: String): IO[Buffer] = IO.async {
    cb => Fs.readFile(filename, (err, data) => {
      if (err != null){
        cb(Left(JavaScriptException(err)))
      } else {
        cb(Right(data))
      }
    })
  }

  def fileAsString(filename: String): IO[String] = fileAsBuffer(filename).map(_.toString)

}