package org.rebeam.tree.slinkify

// import org.rebeam.tree.slinkify.Syntax.onInputValueChange
import slinky.core.FunctionalComponent
import slinky.core.facade.ReactElement
import typings.antd.AntdFacade.{Input, InputProps}

object StringView {

  val stringView: FunctionalComponent[Cursor[String]] = new ViewPC[String] {

    override def apply(c: Cursor[String])(implicit tx: ReactTransactor): ReactElement = {

      logger.debug(s"stringView applying from $c, transactor $tx")

      // Editing the value is straightforward - just call set on the cursor. The cursor
      // creates a ValueDelta that will set the String directly to a new value, makes
      // a Transaction from the delta using the context provided by the cursor, and
      // then uses the implicit ReactTransactor to convert the Transactor to a Callback
      // we can give to React.
      Input(
        InputProps(
          value = c.a,
          onChange = onInputValueChange(s => c.set(s).apply())
        )
      )

    }

  }.build()

}
