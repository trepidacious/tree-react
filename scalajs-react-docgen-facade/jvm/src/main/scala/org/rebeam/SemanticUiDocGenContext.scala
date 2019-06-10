package org.rebeam

import org.rebeam.ComponentModel._
import org.rebeam.DocGenContext.{addMissingProps, callbackFuncType, eventFuncType}

// TODO refactor most of this to generic context
object SemanticUiDocGenContext extends DocGenContext {

  // Additional components for use as ancestors.
  // This includes synthetic components that just provide props where they are missing from the API
  val additionalAncestorComponents: Map[String, Component] = Map(
    "InputHasValue" -> Component (
      "Ancestor to add value prop to Input",
      "InputHasValue",
      List(
        "value" -> Prop(
          StringType,
          required = false,
          "Input value",
          None
        )
      ),
      inheritance = None
    ),
  )

  // Props that are added to all components, if not already present
  val defaultProps: List[(String, Prop)] = List(
    "key" -> Prop(StringType, false, "React key", None),
    "style" -> Prop(StyleType, false, "React element CSS style", None)
  )

  def extractImportData(pathRaw: String, c: Component): ImportData = ImportData("semantic-ui-react", s""""${c.displayName}"""")

  def isFunctional(pathRaw: String, c: Component): Boolean = false

  override def preprocessComponents(all: Map[String, Component]): Map[String, Component] =
    all.mapValues(preprocessComponent)

  def preprocessComponent(c: Component): Component = c match {
    case Component(_, "Input", _, _) => c.copy(inheritance = Some(Inheritance("InputHasValue", "n/a")))
    case _ => c
  }

  def processComponent(all: Map[String, Component], path: String, c: Component): Option[ComponentData] = {

    val importData = extractImportData(path, c)

    val functional = isFunctional(path, c)

    if(c.description.contains("@ignore")) {
      println("Ignoring " + c.displayName)
      None
    } else {
      Some(
        ComponentData(
          component = c.copy(
            props = propsIncludingInheritance(all, c)
              .map {
                case (name, prop) => transformProp(c, name, prop)
              }.filter {
              case (name, prop) => useProp(c, name, prop)
            }
          ),
          importData = importData,
          functional = functional,
          packageName = "org.rebeam.sui"
        )
      )
    }
  }



  /**
    * Produce a list of inherited props for a component, consisting of all the props in the immediate
    * inherited ancestor, then any new props in that ancestor's ancestor, and so on until no ancestors
    * remain. In other words, this gives transitively inherited props, with precedence given to the
    * prop from the nearest ancestor (where multiple ancestors have props with the same name).
    * Each component's ancestor is taken from its inheritance field.
    * @param all    A map from name to component, for all possible ancestors from which we can inherit
    * @param c      The component whose inherited props we require
    * @return       The inherited props
    */
  def inheritedProps(all: Map[String, Component], c: Component): List[(String, Prop)] = {
    (c.inheritance, c.inheritance.flatMap(i => all.get(i.component))) match {
      case (Some(inheritance), None) =>
        println(s"WARNING: Missing inherited component ${inheritance.component}, pathname ${inheritance.pathname}, inherited by ${c.displayName}")
        List.empty
      case (Some(_), Some(ancestor)) =>
        addMissingProps(ancestor.props.map{case (name, prop) => (name, prop.copy(description = prop.description + s"\nPassed to ${ancestor.displayName}"))}, inheritedProps(all, ancestor))
      case _ =>
        List.empty
    }
  }

  def propsIncludingInheritance(all: Map[String, Component], c: Component): List[(String, Prop)] = {
    val allByDisplayName = all.values.map(c => (c.displayName, c)).toMap ++ additionalAncestorComponents
    val inherited = inheritedProps(allByDisplayName, c)

    val propsWithInherited = addMissingProps(c.props, inherited)

    val propsWithDefaults = addMissingProps(propsWithInherited, defaultProps)

    propsWithDefaults.sortBy(_._1)
  }

  def useProp(c: Component, name: String, prop: Prop): Boolean = true

  val mouseEventNames: Set[String] = Set(
    "onClick", "onContextMenu", "onDoubleClick", "onDrag", "onDragEnd", "onDragEnter", "onDragExit",
    "onDragLeave", "onDragOver", "onDragStart", "onDrop", "onMouseDown", "onMouseEnter", "onMouseLeave",
    "onMouseMove", "onMouseOut", "onMouseOver", "onMouseUp",
  )

  val touchEventNames: Set[String] = Set(
    "onTouchCancel", "onTouchEnd", "onTouchMove", "onTouchStart"
  )

  val keyboardEventNames: Set[String] = Set(
    "onKeyDown", "onKeyPress", "onKeyUp"
  )

  val clipboardEventNames: Set[String] = Set(
    "onCopy", "onCut", "onPaste"
  )

  val compositionEventNames: Set[String] = Set(
    "onCompositionEnd", "onCompositionStart", "onCompositionUpdate"
  )

  // TODO factor out the useful general cases here - e.g. onBlah props
  def transformProp(c: Component, name: String, prop: Prop): (String, Prop) = {

    def namedFunc(s: String): Boolean = name == s && prop.propType == FuncType
    def eventProp(s: String): (String, Prop) = name -> prop.copy(propType = eventFuncType(s))
    def funcInSet(s: Set[String]): Boolean = s.contains(name) && prop.propType == FuncType

    // StepGroup.widths has a weird type, an enum having values:
    // ..._.keys(numberMap)
    // ..._.keys(numberMap).map(Number)
    // ..._.values(numberMap)
    // These aren't processed by the docgen export in semantic-ui-react and
    // so are just displayed as-is in the docs. They break generated code
    // for our facade.
    // I'm not sure what these mean even when using the component fom JS,
    // and I can't see an example in the semantic-ui-react docs, so just
    // default to "any" for now.
    if (c.displayName == "StepGroup" && name == "widths") {
      name -> prop.copy(propType = AnyType)

    // Icon has some alternate string values with hyphens, which map to the
    // same sanitised enum object name in Scala - these represent the same
    // actual icons as the un-hyphenated version, so just remove them.
    // Also remove versions that only differ by case when sanitised, because
    // they have a space removed in a compound version or a hyphenated version

    } else if (c.displayName == "Icon" && name == "name") {
      val excludedValues = Set(
        "sign-in", "sign-out",
        "sign-in alternate", "sign-out alternate",
        "zoom-in", "zoom-out",
        "wi-fi",
        "thumb tack",
        "eye dropper"
      )
      prop.propType match {
        case EnumType(values) =>
          name -> prop.copy(
            propType = EnumType(values.filterNot(v => excludedValues.contains(v.value)))
          )
        case _ => name -> prop
      }

    // Style properties use specific style type, since React expects an object and
    // we can make this nicer to use
    } else if (name == "style" && prop.propType == ObjectType) {
      name -> prop.copy(propType = StyleType)

    // Specific Input events
    } else if (c.displayName == "Input" && namedFunc("onChange")) {
      eventProp("ReactEventFromInput")

      // Change event
    } else if (namedFunc("onChange")) {
      eventProp("ReactEvent")

      // Type events according to
      // https://reactjs.org/docs/events.html and
      // https://github.com/japgolly/scalajs-react/blob/master/doc/TYPES.md#events

      //TODO Add a map from component names to underlying "EventSource" of the events,
      // e.g. TextField would have event source "Input" - if we have one of these, we will
      // add "FromSource" to the event type where appropriate, e.g. for ReactEventFromInput,
      // ReactFocusEventFromInput etc.

    // Focus Events
    } else if (namedFunc("onFocus")) {
      eventProp("ReactFocusEvent")
    } else if (namedFunc("onBlur")) {
      eventProp("ReactFocusEvent")

    // Clipboard Events
    } else if (funcInSet(clipboardEventNames)) {
      eventProp("ReactClipboardEvent")

    // Composition Events
    } else if (funcInSet(compositionEventNames)) {
      eventProp("ReactCompositionEvent")

    // Keyboard Events
    } else if (funcInSet(keyboardEventNames)) {
      eventProp("ReactKeyboardEvent")

    // Touch Events
    } else if (funcInSet(touchEventNames)) {
      eventProp("ReactTouchEvent")

    // Special case Touch Tap Event
    } else if (namedFunc("onTouchTap")) {
      eventProp("TouchTapEvent")

    // Mouse Events
    } else if (funcInSet(mouseEventNames)) {
      eventProp("ReactMouseEvent")

    // UI Events
    } else if (namedFunc("onScroll")) {
      eventProp("ReactUIEvent")

    // Wheel Events
    } else if (namedFunc("onWheel")) {
      eventProp("ReactWheelEvent")

    // General "on" handler func - ignore parameters
    } else if (name.startsWith("on") && prop.propType == FuncType) {
      name -> prop.copy(propType = callbackFuncType)

    // type is not a legal name in Scala
    } else if (name == "type") {
      "`type`" -> prop

    } else {
      name -> prop
    }
  }


}