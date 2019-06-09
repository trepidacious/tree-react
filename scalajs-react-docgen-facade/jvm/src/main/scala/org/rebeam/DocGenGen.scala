package org.rebeam

import ComponentModel._
import scala.util.Try

object DocGenGen {

  sealed trait NormalChildrenType
  case object NodeChildren extends NormalChildrenType
  case object ElementChildren extends NormalChildrenType

  // The ways children prop can be typed in DocGen
  sealed trait Children {
    val isSupportedChildren: Boolean
  }
  object Children {
    /**
     * There are specifically no children, using a recognised pattern such as CustomType("unsupportedProp")
     */
    case object NoChildren extends Children {
      val isSupportedChildren: Boolean = false
    }

    /**
     * Children are defined in a normal way - with type node or element
     * @param childrenType  The type of children - node or element
     * @param required      True if children are required, false otherwise
     */
    case class NormalChildren(childrenType: NormalChildrenType, required: Boolean) extends Children {
      val isSupportedChildren: Boolean = true
    }

    /**
     * Children that are an element or a function - currently supported as a normal node/element child only
     */    
    case class ElementOrFuncChildren(required: Boolean) extends Children {
      val isSupportedChildren: Boolean = true
    }

    /**
     * Children that are a node or a function - currently supported as a normal node/element child only
     */    
    case class NodeOrFuncChildren(required: Boolean) extends Children {
      val isSupportedChildren: Boolean = true
    }

    /**
     * Children that have an unknown type, not matching a known pattern - support for now
     */
    case object UnknownChildren extends Children {
      val isSupportedChildren: Boolean = true
    }
  }

  import Children._

  /**
   * Inspect a Prop, assuming it is for the "children" field, and classify it
   * by the way the children are represented in the prop.
   */
  def propChildren(prop: Prop): Children = prop match {
    case Prop(CustomType("unsupportedProp"), false, _, _) => 
      NoChildren

    // This seems to be used to indicate children should not be used - certainly no children prop is
    // shown in the API docs for say TextField. Can allow these children if any are actually useful.  
    case Prop(NodeType, false, "@ignore", _) => 
      NoChildren
    case Prop(ElementType, required, _, _) => 
      NormalChildren(ElementChildren, required)
    case Prop(NodeType, required, _, _) => 
      NormalChildren(NodeChildren, required)
    case Prop(UnionType(s), required, _, _) if (s == Set(ElementType, FuncType)) => 
      ElementOrFuncChildren(required)
    case Prop(UnionType(s), required, _, _) if (s == Set(NodeType, FuncType)) => 
      ElementOrFuncChildren(required)
    case _ => 
      UnknownChildren
  }

  def hasChildren(c: Component): Boolean = {
    c.props.find(_._1 == "children").map(_._2).fold(
      false
    )(
      p => propChildren(p).isSupportedChildren
    )

    // c.props.exists(_._1 == "children")
  }

  def initialUpper(s: String): String = s.head.toUpper + s.tail 

  def sanitiseIdentifier(s: String, isObject: Boolean): String = {
    val words = s.replace(':','_').split('-').flatMap(_.split(' ')).filterNot(_.isEmpty).toList
    val s2 = if (isObject) {
      words.map(initialUpper).mkString("")
    } else {
      (words.head :: words.tail.map(initialUpper)).mkString("")
    }
    if (s2.head.isDigit) {
      "_" + s2
    } else s2
  }

  def enumValueString(s: String): String = sanitiseIdentifier(s, isObject = true)

  def enumNameString(s: String): String = initialUpper(s)

  def propNameScala(s: String): String = sanitiseIdentifier(s, isObject = false)

  def propTypeScala(name: String, p: Prop): String = {
    val t = p.propType match {
      case AnyType => "js.Any"
      case ArrayType => "List[js.Any]"
      case BooleanType => "Boolean"
      case StringType => "String"
      case NumberType => "Double"
      case FuncType =>  "js.Any"
      case ObjectType => "js.Object"
      case SymbolType => "js.Any" //What is this?
      case ElementType => "VdomElement"
      case NodeType => "VdomNode"
      case EnumType(values) => enumNameString(name)
      case UnionType(types) => {
//        types.toList.map(
//          t => propTypeScala(s"${name}_UNION", Prop(t, required = true, "", None))
//        ).mkString(" | ")
        "js.Any"
      }
      case ArrayOfType(elementType) => s"Seq[${propTypeScala(name, Prop(elementType, required = true, "", None))}]" //Not yet tested
      case StructuralType(fieldTypes) => "js.Any"
      case CustomType(raw) => "js.Any"

      case KnownFuncType(scalaType, _, _) => scalaType
      case StyleType => "org.rebeam.react.Style"
    }
    if (p.required) t else s"js.UndefOr[$t]"
  }

  def propNameJS(s: String): String = if (s.contains("-")) {
    s"`$s`"
  } else {
    s
  }

  def propTypeJS(name: String, p: Prop): String = {
    val t = p.propType match {
      case AnyType => "js.Any"
      case ArrayType => "List[js.Any]"
      case BooleanType => "Boolean"
      case StringType => "String"
      case NumberType => "Double"
      case FuncType =>  "js.Any"
      case ObjectType => "js.Object"
      case SymbolType => "js.Any" //What is this?
      case ElementType => "japgolly.scalajs.react.raw.React.Element"
      case NodeType => "japgolly.scalajs.react.raw.React.Node"
      case EnumType(values) => "String"
      case UnionType(types) => {
//        types.toList.map(
//          t => propTypeJS(s"${name}_UNION", Prop(t, required = true, "", None))
//        ).mkString(" | ")
        "js.Any"
      }
      case ArrayOfType(elementType) => s"js.Array[${propTypeJS(name, Prop(elementType, required = true, "", None))}]" //Not yet tested
      case StructuralType(fieldTypes) => "js.Any"
      case CustomType(raw) => "js.Any"

      case KnownFuncType(_, jsType, _) => jsType
      case StyleType => "js.Object"
    }
    if (p.required) t else s"js.UndefOr[$t]"
  }

  def propAssignment(name: String, p: Prop): String = {
    
    val a: Option[String => String] = p.propType match {
      // case AnyType =>
      // case ArrayType =>
      // case BooleanType =>
      // case StringType =>
      // case NumberType =>
      // case FuncType => 
      // case ObjectType =>
      // case SymbolType =>
      case ElementType => Some(n => s"$n.rawElement")
      case NodeType => Some(n => s"$n.rawNode")
      case EnumType(values) => Some(n => s"$n.value")
      // case UnionType(types) =>
      case ArrayOfType(elementType) => Some(n => s"$n.map(e => ${propAssignment("e", Prop(elementType, required = true, "", None))}).toJSArray") //Not yet tested
      // case StructuralType(fieldTypes) =>
      // case CustomType(raw) =>

      case KnownFuncType(_, _, assignment) => Some(assignment)
      case StyleType => Some(n => s"$n.o")

      case _ => None
    }

    if (p.required) {
      a.fold(
        s"p.${propNameJS(name)} = ${propNameScala(name)}"
      )(
        f => s"p.${propNameJS(name)} = ${f(propNameScala(name))}"
      )
    } else {
      a.fold(
        s"if (${propNameScala(name)}.isDefined) {p.${propNameJS(name)} = ${propNameScala(name)}}"
      )(
        f => s"if (${propNameScala(name)}.isDefined) {p.${propNameJS(name)} = ${propNameScala(name)}.map(v => ${f("v")})}"
      )
    }
  }

  private def parseBoolean(s: String): Option[Boolean] =
    if (s != null) s.toLowerCase match {
      case "true" => Some(true)
      case "false" => Some(false)
      case _ => None
    } else None

  private def parseDouble(s: String): Option[Double] = 
    Try { s.toDouble }.toOption

  def defaultValue(p: Prop): String = {
    // Non-required props always default to undefined,
    // since this is assumed to pick up the proper default.
    if (!p.required) {
      " = js.undefined"

    //If required, provide the default
    } else {
      p.defaultValue.map {
        v => p.propType match {
          case BooleanType => 
            parseBoolean(v.value).map(b => s" = $b")
            .getOrElse(s" // Invalid default boolean ignored '${v.value}'")
          case StringType => s""" = "${v.value}""""
          case NumberType => 
            parseDouble(v.value).map(d => s" = $d")
            .getOrElse(s" // Invalid default number (double) ignored '${v.value}'")
          case _ => ""
        }
      }.getOrElse("")
    }
  }

  def lines(s: String): List[String] = s.split("\\r?\\n").toList

  def sanitiseDescription(s: String): String = s
    .replaceAllLiterally("@ignore", "Property spread to root element")
    .replaceAllLiterally("@param", "parameter")
    .replaceAllLiterally("@internal", "internal")
    .replaceAllLiterally("@returns", "returns")
    .replaceAllLiterally("<", "&lt;")
    .replaceAllLiterally(">", "&gt;")


  def applyDocs(c: Component, usedProps: List[(String, Prop)]): String = 
    (
      lines(c.description) ++
      usedProps.flatMap {
        case (n, p) => List(
          List(s"@param $n"),
          lines(sanitiseDescription(p.description)).map("       " + _)
        ).flatten
      } ++ 
      List(
        "@param additionalProps",
        "       Optional parameter - if specified, this must be a js.Object containing additional props",
        "       to pass to the underlying JS component. Each field of additionalProps will be added to the",
        "       JS props object, if a field with the same name is not already present (from one of the other",
        "       parameters of this function). This functions like `...additionalProps` at the beginning of the",
        "       component in JS. Used for e.g. Downshift integration, where Downshift will provide properties",
        "       in this format to be added to rendered components.",
        "       Since this is untyped, use with care - e.g. make sure props are in the correct format for JS components"
      )
    ).mkString("\n   * ")  

  def enumDefinition(c: Component): String = {
    c.props.collect {
      case (name, Prop(EnumType(values), _, _, _)) =>
        val enumName = enumNameString(name)
        val enumElements = values.map(
          v => s"""case object ${enumValueString(v.value)} extends $enumName { val value: String = "${v.value}" }"""
        ).mkString("\n    ")
        s"""
          |  sealed trait $enumName{ val value: String }
          |
          |  object $enumName {
          |    $enumElements
          |  }
          """.stripMargin('|')
    }.mkString("  ")
  }

  def genComponent(all: Map[String, Component], path: String, cRaw: Component)(implicit context: DocGenContext): Option[String] = {

    // println(cRaw.props.map(_._1))

    context.processComponent(all, path, cRaw).map(
      cd => {

        val c = cd.component
        // println(c.props.map(_._1))

        val componentName = c.displayName

        // Children prop is handled specially
        val usedProps = c.props.filter(_._1 != "children")

        val propFields = usedProps.map { 
          case (name, prop) =>
            s"var ${propNameJS(name)}: ${propTypeJS(name, prop)} = js.native"
        }.mkString("\n    ")

        val propParams = (usedProps.map { 
          case (name, prop) =>
            s"${propNameScala(name)}: ${propTypeScala(name, prop)}${defaultValue(prop)}"
        } :+ "additionalProps: js.UndefOr[js.Object] = js.undefined").mkString(",\n    ")

        val propAssignments = usedProps.map { 
          case (name, prop) =>
            propAssignment(name, prop)
        }.mkString("\n    ")

        val hc = hasChildren(c)

        val docs = applyDocs(c, if (hc) c.props else usedProps)

        val childrenType = if (hc) "Children.Varargs" else "Children.None"
        val childrenParamGroup = if (hc) "(children: VdomNode *)" else ""
        val childrenArgumentGroup = if (hc) "(children: _*)" else ""

        val jsComponentType = if (cd.functional) {
          s"JsFnComponent[Props, $childrenType]"
        } else {
          s"JsComponent[Props, $childrenType, Null]"
        }

        s"""
        |package ${cd.packageName}
        |
        |import japgolly.scalajs.react._
        |import scalajs.js
        |import scalajs.js.annotation.JSImport
        |
        |import japgolly.scalajs.react.vdom.html_<^._
        |
        |object $componentName {
        |  ${enumDefinition(c)}
        |  @js.native
        |  trait Props extends js.Object {
        |    $propFields
        |  }
        |
        |  @JSImport("${cd.importData.module}", ${cd.importData.name})
        |  @js.native
        |  object ${componentName}JS extends js.Object
        |
        |  val jsComponent = $jsComponentType(${componentName}JS)
        |  
        |  /**
        |   * $docs
        |   */
        |  def apply(
        |    $propParams
        |  )$childrenParamGroup = {
        |
        |    val p = (new js.Object).asInstanceOf[Props]
        |    $propAssignments
        |
        |    additionalProps.foreach {
        |      a => {
        |        val dict = a.asInstanceOf[js.Dictionary[js.Any]]
        |        val pDict = p.asInstanceOf[js.Dictionary[js.Any]]
        |        for ((prop, value) <- dict) {
        |          if (!p.hasOwnProperty(prop)) pDict(prop) = value
        |        }
        |      }
        |    }
        |    
        |    jsComponent(p)$childrenArgumentGroup
        |  }
        |
        |}
        """.stripMargin('|')
      }
    )

  }

}