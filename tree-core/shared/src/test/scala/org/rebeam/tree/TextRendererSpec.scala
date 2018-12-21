package org.rebeam.tree

//import cats.Monad
import cats.implicits._
import org.rebeam.tree.DataSourceViewOps._
import org.rebeam.tree.SpecUtils._
import org.scalatest._
import org.scalatest.prop.Checkers

class TextRendererSpec extends WordSpec with Matchers with Checkers {

  val dataSource: DataSource =
    MapDataSource.empty

  "TextRenderer" should {

    "render Person" in {

      import org.rebeam.tree.view.TextTest._
      val bob = Person("Bob", 99)
      val renderBob = personR.render[S](bob, ())

      1 to 2 foreach {
        _ =>
          val (state, result) = runView(renderBob, initialStateData(dataSource))
          println(result)
      }

    }
  }
}
