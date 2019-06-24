
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object RootRef {
  
  @js.native
  trait Props extends js.Object {
    var key: js.UndefOr[String] = js.native
    var rootRef: js.Any = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("@material-ui/core/RootRef", JSImport.Default)
  @js.native
  object RootRefJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](RootRefJS)
  
  /**
   * Helper component to allow attaching a ref to a
   * wrapped element to access the underlying DOM element.
   * 
   * It's highly inspired by https://github.com/facebook/react/issues/11401#issuecomment-340543801.
   * For example:
   * ```jsx
   * import React from 'react';
   * import RootRef from '@material-ui/core/RootRef';
   * 
   * class MyComponent extends React.Component {
   *   constructor() {
   *     super();
   *     this.domRef = React.createRef();
   *   }
   * 
   *   componentDidMount() {
   *     console.log(this.domRef.current); // DOM node
   *   }
   * 
   *   render() {
   *     return (
   *       <RootRef rootRef={this.domRef}>
   *         <SomeChildComponent />
   *       </RootRef>
   *     );
   *   }
   * }
   * ```
   * @param children
   *        The wrapped element.
   * @param key
   *        React key
   * @param rootRef
   *        Provide a way to access the DOM node of the wrapped element.
   *        You can provide a callback ref or a `React.createRef()` ref.
   * @param style
   *        React element CSS style
   * @param additionalProps
   *        Optional parameter - if specified, this must be a js.Object containing additional props
   *        to pass to the underlying JS component. Each field of additionalProps will be added to the
   *        JS props object, if a field with the same name is not already present (from one of the other
   *        parameters of this function). This functions like `...additionalProps` at the beginning of the
   *        component in JS. Used for e.g. Downshift integration, where Downshift will provide properties
   *        in this format to be added to rendered components.
   *        Since this is untyped, use with care - e.g. make sure props are in the correct format for JS components
   */
  def apply(
    key: js.UndefOr[String] = js.undefined,
    rootRef: js.Any,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (key.isDefined) {p.key = key}
    p.rootRef = rootRef
    if (style.isDefined) {p.style = style.map(v => v.o)}

    additionalProps.foreach {
      a => {
        val dict = a.asInstanceOf[js.Dictionary[js.Any]]
        val pDict = p.asInstanceOf[js.Dictionary[js.Any]]
        for ((prop, value) <- dict) {
          if (!p.hasOwnProperty(prop)) pDict(prop) = value
        }
      }
    }
    
    jsComponent(p)(children: _*)
  }

}
        