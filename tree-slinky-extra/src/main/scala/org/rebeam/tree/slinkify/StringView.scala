package org.rebeam.tree.slinkify

// import org.rebeam.tree.slinkify.Syntax.onInputValueChange
import slinky.core.FunctionalComponent
import slinky.core.facade.ReactElement
import slinky.web.html._
// import typings.antd.components.{List => _, _}

object StringView {

  val stringView: FunctionalComponent[Cursor[String]] = new ViewPC[String] {

    override def apply(c: Cursor[String])(implicit tx: ReactTransactor): ReactElement = {

      scribe.debug(s"stringView applying from $c, transactor $tx")

      // Editing the value is straightforward - just call set on the cursor. The cursor
      // creates a ValueDelta that will set the String directly to a new value, makes
      // a Transaction from the delta using the context provided by the cursor, and
      // then uses the implicit ReactTransactor to convert the Transactor to a Callback
      // we can give to React.
      input(
        value := c.a,
        onChange := (event => c.set(event.target.value).apply())
      )

    }

  }.build()

}
