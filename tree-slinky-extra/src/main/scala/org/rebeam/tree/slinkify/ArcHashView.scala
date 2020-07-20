package org.rebeam.tree.slinkify

// import org.rebeam.tree.slinkify.Syntax.onInputValueChange
import slinky.core.FunctionalComponent
import slinky.core.facade.ReactElement
import slinky.web.html._
import org.rebeam.tree.view.Color
// import typings.antd.components.{List => _, _}
import org.rebeam.tree.view.MaterialColor

object ArcHashView {
  def apply[A: ArcHashable: Reusability]: FunctionalComponent[A] = ViewPure {
    a => ArcHash.icon(a)
  }
}

object ArcHash {

  val backgrounds: Seq[Color] = Seq(
    MaterialColor.Red(600),
    MaterialColor.Pink(500),
    MaterialColor.Purple(500),
    MaterialColor.DeepPurple(500),
    MaterialColor.Indigo(500),
    MaterialColor.Blue(500),
    MaterialColor.LightBlue(300),
    MaterialColor.Cyan(500),
    MaterialColor.Teal(500),
    MaterialColor.Green(600),
    MaterialColor.LightGreen(600),
    MaterialColor.Lime(600),
    MaterialColor.Yellow(700),
    MaterialColor.Amber(500),
    MaterialColor.Orange(500),
    MaterialColor.DeepOrange(500)
  )

  def backgroundForIndex(i: Int) = backgrounds(i % backgrounds.size)

  val accents: Seq[Color] = Seq(
    MaterialColor.Red.a100,
    MaterialColor.Pink.a100,
    MaterialColor.Purple.a100,
    MaterialColor.DeepPurple.a100,
    MaterialColor.Indigo.a100,
    MaterialColor.Blue.a100,
    MaterialColor.LightBlue.a100,
    MaterialColor.Cyan.a100,
    MaterialColor.Teal.a100,
    MaterialColor.Green.a100,
    MaterialColor.LightGreen.a100,
    MaterialColor.Lime.a100,
    MaterialColor.Yellow.a100,
    MaterialColor.Amber.a100,
    MaterialColor.Orange.a100,
    MaterialColor.DeepOrange.a100
  )

  def accentForIndex(i: Int) = accents(i % accents.size)

  def background[A](a: A)(implicit ah: ArcHashable[A]): Color = background(ah.arcHash(a))

  def background(hash: Int): Color = {
    backgroundForIndex((hash >> 24) & 0xFF)
  }

  def accent[A](a: A)(implicit ah: ArcHashable[A]): Color = accent(ah.arcHash(a))

  def accent(hash: Int): Color = {
    accentForIndex((hash >> 24) & 0xFF)
  }

  def icon[A](a: A, color: Option[Color] = None, bgColor: Option[Color] = None, size: Int = 32)(implicit ah: ArcHashable[A]): ReactElement = iconForHash(ah.arcHash(a), color, bgColor, size)

  val defaultBackground: Color = MaterialColor.BlueGrey(700)

  def iconForHash(hash: Int, color: Option[Color] = None, bgColor: Option[Color] = None, size: Int = 32): ReactElement = {
    import slinky.web.svg._
    val arcSize = size * 0.75
    val center = size / 2.0
    val radius = arcSize / 8.0
    val halfSize = size / 2.0
    val sizeCSS = s"${size}px"
    val viewBoxCSS = s"0 0 $size $size"
    val strokeW = if (size > 28) 2.0 else if (size > 20) 1.5 else 1.0

    svg(
      width := sizeCSS,
      height := sizeCSS,
      fill := "none",
//      ^.stroke := MaterialColor.DeepPurple(100).,
      strokeWidth := strokeW,
      strokeLinecap := "round",
      viewBox := viewBoxCSS,
      circle(cx:= center, cy:= center, r := halfSize, fill := bgColor.getOrElse(defaultBackground).toString()),
      path(transform := "translate(0, 0)", stroke := color.getOrElse(accentForIndex((hash >> 28) & 0xF)).toString, d := arcHashSymRingPath(center, radius, hash, 0)),
      path(transform := "translate(0, 0)", stroke := color.getOrElse(accentForIndex((hash >> 24) & 0xF)).toString, d := arcHashSymRingPath(center, radius, hash, 1)),
      path(transform := "translate(0, 0)", stroke := color.getOrElse(accentForIndex((hash >> 20) & 0xF)).toString, d := arcHashSymRingPath(center, radius, hash, 2))
    )
  }

  val cos60: Double = 0.5
  val sin60: Double = 0.866025403784439

  def arcDir(i: Int): (Double, Double) = i % 6 match {
    case 0 => (1, 0)
    case 1 => (cos60, -sin60)
    case 2 => (-cos60, -sin60)
    case 3 => (-1, 0)
    case 4 => (-cos60, sin60)
    case 5 => (cos60, sin60)
  }

  def arc(xc: Double, yc: Double, start: Int, end: Int, radius: Double): String = {
    val ds = arcDir(start)
    val xs = xc + radius * ds._1
    val ys = yc + radius * ds._2

    val de = arcDir(end)
    val xe = xc + radius * de._1
    val ye = yc + radius * de._2

    s"M$xs,$ys A$radius,$radius,0,0,0,$xe,$ye"
  }

  def arcHashRingPath(c: Double, r: Double, hash: Int): String = {
    (0 until 6).map(
      i => if (((hash >> i) & 1) == 1) arc(c, c, i, i + 1, r) else ""
    ).mkString(" ")
  }

  def arcHashRingPath(c: Double, r: Double, hash: Int, i: Int): String = {
    arcHashRingPath(c, r * (i + 1), hash >> (i * 6))
  }

  def arcHashSymRingPath(c: Double, r: Double, hash: Int): String = {
    def b(i: Int) = ((hash >> i) & 1) == 1
    def a(i: Int) = arc(c, c, i, i + 1, r)

    List(
      if (b(0)) a(0) + " " + a(2) else "",
      if (b(1)) a(1) else "",
      if (b(2)) a(3) + " " + a(5) else "",
      if (b(3)) a(4) else ""
    ).mkString(" ")
  }

  def arcHashSymRingPath(c: Double, r: Double, hash: Int, i: Int): String = {
    arcHashSymRingPath(c, r * (i + 1), hash >> (i * 4))
  }

  def arcHashIconPath(size: Double, hash: Int): String = {
    val c = size / 2
    val r = size / 8
    (0 until 3).map(
      i => arcHashRingPath(c, r, hash, i)
    ).mkString(" ")
  }

}