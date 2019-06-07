package org.rebeam

import org.rebeam.ComponentModel._

trait DocGenContext {
  def processComponent(all: Map[String, Component], path: String, c: Component): Option[ComponentData]
  def preprocessComponents(all: Map[String, Component]): Map[String, Component]
}

object DocGenContext {

  val callbackFuncType = KnownFuncType("Callback", "scalajs.js.Function0[Unit]", (n: String) => s"$n.toJsFn")

  def eventFuncType(event: String) = KnownFuncType(
    s"$event => Callback", 
    s"scalajs.js.Function1[$event, Unit]", 
    (n: String) => s"(e: $event) => $n(e).runNow()")

  case class FuncData(scalaType: String, jsType: String, assignment: String)

  /**
    * Produce a new list of props, starting from existing, and adding any props
    * in additional where the name of the prop is not already in the list.
    * @param existing   Existing props
    * @param additional Additional props
    * @return           New props list having the existing props, plus any additional
    *                   props not already present in the existing list.
    */
  def addMissingProps(existing: List[(String, Prop)], additional: List[(String, Prop)]): List[(String, Prop)] = {
    additional.foldLeft(existing.toVector){
      case (l, additionalNameAndProp) =>
        if (l.exists{case (name, _) => name == additionalNameAndProp._1}) {
          l
        } else {
          l :+ additionalNameAndProp
        }
    }.toList
  }

  val childrenProps: List[(String, Prop)] = List(
    (
      "children",
      Prop(
        NodeType,
        false,
        "React children - added by scalajs-react-material-ui, based on component demo from material-ui.com",
        None
      )
    )
  )

  def addChildrenProp(c: Component): Component = {
    c.copy(props = addMissingProps(c.props, childrenProps))
  }

}