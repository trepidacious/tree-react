
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Rating {
  
  sealed trait Icon{ val value: String }

  object Icon {
    case object Star extends Icon { val value: String = "star" }
    case object Heart extends Icon { val value: String = "heart" }
  }
            
  sealed trait Size{ val value: String }

  object Size {
    case object Mini extends Size { val value: String = "mini" }
    case object Tiny extends Size { val value: String = "tiny" }
    case object Massive extends Size { val value: String = "massive" }
    case object Small extends Size { val value: String = "small" }
    case object Huge extends Size { val value: String = "huge" }
    case object Large extends Size { val value: String = "large" }
  }
          
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[String] = js.native
    var className: js.UndefOr[String] = js.native
    var clearable: js.UndefOr[js.Any] = js.native
    var defaultRating: js.UndefOr[js.Any] = js.native
    var disabled: js.UndefOr[Boolean] = js.native
    var icon: js.UndefOr[String] = js.native
    var key: js.UndefOr[String] = js.native
    var maxRating: js.UndefOr[js.Any] = js.native
    var onRate: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var rating: js.UndefOr[js.Any] = js.native
    var size: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("semantic-ui-react", "Rating")
  @js.native
  object RatingJS extends js.Object

  val jsComponent = JsComponent[Props, Children.None, Null](RatingJS)
  
  /**
   * A rating indicates user interest in content.
   * @param as
   *        An element type to render as (string or function).
   * @param className
   *        Additional classes.
   * @param clearable
   *        You can clear the rating by clicking on the current start rating.
   *        By default a rating will be only clearable if there is 1 icon.
   *        Setting to `true`/`false` will allow or disallow a user to clear their rating.
   * @param defaultRating
   *        The initial rating value.
   * @param disabled
   *        You can disable or enable interactive rating.  Makes a read-only rating.
   * @param icon
   *        A rating can use a set of star or heart icons.
   * @param key
   *        React key
   * @param maxRating
   *        The total number of icons.
   * @param onRate
   *        Called after user selects a new rating.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props and proposed rating.
   * @param rating
   *        The current number of active icons.
   * @param size
   *        A progress bar can vary in size.
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
    as: js.UndefOr[String] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    clearable: js.UndefOr[js.Any] = js.undefined,
    defaultRating: js.UndefOr[js.Any] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    icon: js.UndefOr[Icon] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    maxRating: js.UndefOr[js.Any] = js.undefined,
    onRate: js.UndefOr[Callback] = js.undefined,
    rating: js.UndefOr[js.Any] = js.undefined,
    size: js.UndefOr[Size] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  ) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (className.isDefined) {p.className = className}
    if (clearable.isDefined) {p.clearable = clearable}
    if (defaultRating.isDefined) {p.defaultRating = defaultRating}
    if (disabled.isDefined) {p.disabled = disabled}
    if (icon.isDefined) {p.icon = icon.map(v => v.value)}
    if (key.isDefined) {p.key = key}
    if (maxRating.isDefined) {p.maxRating = maxRating}
    if (onRate.isDefined) {p.onRate = onRate.map(v => v.toJsFn)}
    if (rating.isDefined) {p.rating = rating}
    if (size.isDefined) {p.size = size.map(v => v.value)}
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
    
    jsComponent(p)
  }

}
        