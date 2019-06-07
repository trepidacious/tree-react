package org.rebeam

import DocGenGen._
import ComponentModel._
import ComponentModelDecoders._

import io.circe.parser.decode

import java.nio.charset.StandardCharsets
import java.nio.file._

object Generate {

  def writeToFile(filename: String, contents: String): Unit = {
    Files.write(Paths.get(filename), contents.getBytes(StandardCharsets.UTF_8))
    ()
  }

  def main(args: Array[String]): Unit = {

    implicit val context: DocGenContext = SemanticUiDocGenContext

    def component(all: Map[String, Component], path: String, c: Component): Unit = {
      val code = genComponent(all, path, c)
      val name = c.displayName
      code.foreach(s => writeToFile(s"./scalajs-react-docgen-facade/js/src/main/scala/org/rebeam/sui/$name.scala", s.replaceAllLiterally("\r\n", "\n")))
    }

    val s = scala.io.Source.fromInputStream(getClass.getResourceAsStream("/componentExport/Button.json"), "utf-8").mkString

    val rawD = Map("Button" -> decode[Component](s).toOption.get)

    val processedD = context.preprocessComponents(rawD)

    processedD.foreach{
      case (path, c) => component(processedD, path, c)
    }

  }
}