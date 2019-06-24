
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Avatar {
  
  @js.native
  trait Props extends js.Object {
    var alt: js.UndefOr[String] = js.native
    var childrenClassName: js.UndefOr[String] = js.native
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var component: js.UndefOr[js.Any] = js.native
    var imgProps: js.UndefOr[js.Object] = js.native
    var key: js.UndefOr[String] = js.native
    var sizes: js.UndefOr[String] = js.native
    var src: js.UndefOr[String] = js.native
    var srcSet: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("@material-ui/core/Avatar", JSImport.Default)
  @js.native
  object AvatarJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](AvatarJS)
  
  /**
   * 
   * @param alt
   *        Used in combination with `src` or `srcSet` to
   *        provide an alt attribute for the rendered `img` element.
   * @param children
   *        Used to render icon or text elements inside the Avatar.
   *        `src` and `alt` props will not be used and no `img` will
   *        be rendered by default.
   *        
   *        This can be an element, or just a string.
   * @param childrenClassName
   *        Property spread to root element
   *        The className of the child element.
   *        Used by Chip and ListItemIcon to style the Avatar icon.
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param component
   *        The component used for the root node.
   *        Either a string to use a DOM element or a component.
   * @param imgProps
   *        Attributes applied to the `img` element if the component
   *        is used to display an image.
   * @param key
   *        React key
   * @param sizes
   *        The `sizes` attribute for the `img` element.
   * @param src
   *        The `src` attribute for the `img` element.
   * @param srcSet
   *        The `srcSet` attribute for the `img` element.
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
    alt: js.UndefOr[String] = js.undefined,
    childrenClassName: js.UndefOr[String] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    component: js.UndefOr[js.Any] = js.undefined,
    imgProps: js.UndefOr[js.Object] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    sizes: js.UndefOr[String] = js.undefined,
    src: js.UndefOr[String] = js.undefined,
    srcSet: js.UndefOr[String] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (alt.isDefined) {p.alt = alt}
    if (childrenClassName.isDefined) {p.childrenClassName = childrenClassName}
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (component.isDefined) {p.component = component}
    if (imgProps.isDefined) {p.imgProps = imgProps}
    if (key.isDefined) {p.key = key}
    if (sizes.isDefined) {p.sizes = sizes}
    if (src.isDefined) {p.src = src}
    if (srcSet.isDefined) {p.srcSet = srcSet}
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
        