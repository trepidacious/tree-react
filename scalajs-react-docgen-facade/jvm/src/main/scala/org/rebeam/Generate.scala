package org.rebeam

import DocGenGen._
import ComponentModel._
import ComponentModelDecoders._

import io.circe.parser.decode

import java.nio.charset.StandardCharsets
import java.nio.file._

import org.reflections.Reflections
import org.reflections.scanners.ResourcesScanner
import java.util.regex.Pattern
import scala.collection.JavaConverters._

object Generate {

  def writeToFile(filename: String, contents: String): Unit = {
    Files.write(Paths.get(filename), contents.getBytes(StandardCharsets.UTF_8))
    ()
  }

  def main(args: Array[String]): Unit = {

    val reflections = new Reflections("sui.componentExport", new ResourcesScanner)
    val componentJsonResources = reflections.getResources(Pattern.compile(".*\\.json"))

    implicit val context: DocGenContext = SemanticUiDocGenContext

    def component(all: Map[String, Component], path: String, c: Component): Unit = {
      val code = genComponent(all, path, c)
      val name = c.displayName
      code.foreach(s => writeToFile(s"./scalajs-react-semantic-ui/js/src/main/scala/org/rebeam/sui/$name.scala", s.replaceAllLiterally("\r\n", "\n")))
    }

    val rawD = Map[String, Component](
      componentJsonResources.asScala.toList.flatMap( jsonResource => {
        println(s"Trying $jsonResource")
        val s = scala.io.Source.fromInputStream(getClass.getResourceAsStream("/" + jsonResource), "utf-8").mkString
        decode[Component](s).toOption.map(c => c.displayName -> c)
      }): _*
    )

//    val s = scala.io.Source.fromInputStream(getClass.getResourceAsStream("/sui/componentExport/Button.json"), "utf-8").mkString

//    val rawD = Map("Button" -> decode[Component](s).toOption.get)

    val processedD = context.preprocessComponents(rawD)

    processedD.foreach{
      case (path, c) => component(processedD, path, c)
    }

  }
}