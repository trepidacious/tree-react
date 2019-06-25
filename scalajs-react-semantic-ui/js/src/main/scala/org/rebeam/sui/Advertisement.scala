
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Advertisement {
  
  sealed trait Unit{ val value: String }

  object Unit {
    case object Billboard extends Unit { val value: String = "billboard" }
    case object Banner extends Unit { val value: String = "banner" }
    case object MediumRectangle extends Unit { val value: String = "medium rectangle" }
    case object Netboard extends Unit { val value: String = "netboard" }
    case object Panorama extends Unit { val value: String = "panorama" }
    case object SmallButton extends Unit { val value: String = "small button" }
    case object VerticalRectangle extends Unit { val value: String = "vertical rectangle" }
    case object HalfPage extends Unit { val value: String = "half page" }
    case object Leaderboard extends Unit { val value: String = "leaderboard" }
    case object LargeLeaderboard extends Unit { val value: String = "large leaderboard" }
    case object Skyscraper extends Unit { val value: String = "skyscraper" }
    case object Button extends Unit { val value: String = "button" }
    case object WideSkyscraper extends Unit { val value: String = "wide skyscraper" }
    case object MobileBanner extends Unit { val value: String = "mobile banner" }
    case object SquareButton extends Unit { val value: String = "square button" }
    case object LargeRectangle extends Unit { val value: String = "large rectangle" }
    case object SmallRectangle extends Unit { val value: String = "small rectangle" }
    case object Square extends Unit { val value: String = "square" }
    case object TopBanner extends Unit { val value: String = "top banner" }
    case object MobileLeaderboard extends Unit { val value: String = "mobile leaderboard" }
    case object VerticalBanner extends Unit { val value: String = "vertical banner" }
    case object SmallSquare extends Unit { val value: String = "small square" }
    case object HalfBanner extends Unit { val value: String = "half banner" }
  }
          
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[String] = js.native
    var centered: js.UndefOr[Boolean] = js.native
    var className: js.UndefOr[String] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var test: js.UndefOr[js.Any] = js.native
    var unit: String = js.native
  }

  @JSImport("semantic-ui-react", "Advertisement")
  @js.native
  object AdvertisementJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](AdvertisementJS)
  
  /**
   * An ad displays third-party promotional content.
   * @param as
   *        An element type to render as (string or function).
   * @param centered
   *        Center the advertisement.
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param content
   *        Shorthand for primary content.
   * @param key
   *        React key
   * @param style
   *        React element CSS style
   * @param test
   *        Text to be displayed on the advertisement.
   * @param unit
   *        Varies the size of the advertisement.
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
    centered: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    test: js.UndefOr[js.Any] = js.undefined,
    unit: Unit,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (centered.isDefined) {p.centered = centered}
    if (className.isDefined) {p.className = className}
    if (content.isDefined) {p.content = content}
    if (key.isDefined) {p.key = key}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (test.isDefined) {p.test = test}
    p.unit = unit.value

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
        