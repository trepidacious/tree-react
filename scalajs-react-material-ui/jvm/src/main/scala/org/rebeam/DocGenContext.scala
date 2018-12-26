package org.rebeam

import ComponentModel._

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

  object MaterialUI extends DocGenContext {

    // Additional components for use as ancestors.
    // This includes synthetic components that just provide props where they are missing from the API,
    // and components coming from outside Material-UI
    val additionalAncestorComponents: Map[String, Component] = Map(
      "DOCGEN_Children" -> Component (
        "DocGen component to add children",
        "DOCGEN_Children",
        List(
          "children" -> Prop(
            NodeType,
            false,
            "React children",
            None
          )
        ),
        None
      )
    )

    // Props that are added to all components, if not already present
    val defaultProps: List[(String, Prop)] = List(
      "key" -> Prop(StringType, false, "React key", None),
      "style" -> Prop(StyleType, false, "React element CSS style", None)
    )

    def extractImportData(pathRaw: String, c: Component): ImportData = {
      if (c.displayName == "MuiThemeProvider") {
        ImportData(s"@material-ui/core/styles", s""""${c.displayName}"""")
      } else {
        ImportData(s"@material-ui/core/${c.displayName}", "JSImport.Default")
      }
    }

    def isFunctional(pathRaw: String, c: Component): Boolean = c.displayName != "MuiThemeProvider"

    override def preprocessComponents(all: Map[String, Component]): Map[String, Component] =
      all.mapValues(transformComponent)

    def transformComponent(c: Component): Component = {
      // When ListItem "button" prop is true, API indicates that ListItem uses ButtonBase.
      // For now, just add the ButtonBase props regardless, but in future we might want to
      // split ListItem into a button and non-button version with different props
      if (c.displayName == "ListItem") {
        c.copy(inheritance = Some(Inheritance("ButtonBase", "https://material-ui.com/api/ButtonBase")))

      // CardContent has no children property, but is clearly used with children in examples
      } else if (c.displayName == "CardContent") {
        c.copy(inheritance = Some(Inheritance("DOCGEN_Children", "https://github.com/trepidacious/tree-react")))

      // MuiThemeProvider is named MuiThemeProviderOld in 3.7.1, but should be used as MuiThemeProvider
      } else if (c.displayName == "MuiThemeProviderOld") {
        c.copy(displayName = "MuiThemeProvider")

      } else {
        c
      }
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
            functional = functional
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
      val inherited: Option[List[(String, Prop)]] = for {
        inheritance <- c.inheritance
        ancestor <- all.get(inheritance.component)
      } yield {
        println(s"${c.displayName} inherits from ${ancestor.displayName}")
        addMissingProps(ancestor.props.map{case (name, prop) => (name, prop.copy(description = prop.description + s"\nPassed to ${ancestor.displayName}"))}, inheritedProps(all, ancestor))
      }
      inherited.getOrElse(List.empty)
    }

    def propsIncludingInheritance(all: Map[String, Component], c: Component): List[(String, Prop)] = {

      println(s"${c.displayName} inheritance:")

      val allByDisplayName = all.values.map(c => (c.displayName, c)).toMap ++ additionalAncestorComponents
      val inherited = inheritedProps(allByDisplayName, c)

      val propsWithInherited = addMissingProps(c.props, inherited)

      val propsWithDefaults = addMissingProps(propsWithInherited, defaultProps)

      propsWithDefaults.sortBy(_._1)
    }

    def useProp(c: Component, name: String, prop: Prop): Boolean =
      //TODO have a closer look at this - assuming that these are not meant to be used, but some of them look useful...  
      //     In fact, it looks a lot like these are real properties that are passed through to underlying elements
      //     but that material-ui doesn't want to document (confusingly), and so we should use these properties.
      //     I think the only exception may be for children, where we probably want to treat this as not having children.
      // } else if (prop.required == false && prop.description.trim.toLowerCase == "@ignore") {
      //   false


      // Not sure what's up with this one - marked as ignore so get rid of it
      if (c.displayName == "Menu" && name == "theme") {
        false
      } else {
        true
      }

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

    def transformProp(c: Component, name: String, prop: Prop): (String, Prop) = {

      def namedFunc(s: String): Boolean = name == s && prop.propType == FuncType
      def eventProp(s: String): (String, Prop) = name -> prop.copy(propType = eventFuncType(s))
      def funcInSet(s: Set[String]): Boolean = s.contains(name) && prop.propType == FuncType

      if (c.displayName == "TextField" && name == "value") {
        name -> prop.copy(propType = StringType)

      // Style properties use mui.style.Style type
      } else if (name == "style" && prop.propType == ObjectType) {
        name -> prop.copy(propType = StyleType)

      //These two are only needed to add a description
      } else if (c.displayName == "TextField" && name == "onBlur") {
        name -> eventProp("ReactFocusEvent")._2.copy(description = "Passed to underlying input element")
      } else if (c.displayName == "TextField" && name == "onFocus") {
        name -> eventProp("ReactFocusEvent")._2.copy(description = "Passed to underlying input element")

      // Specific TextField events
      } else if (c.displayName == "TextField" && namedFunc("onChange")) {
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

      // For some reason all the "classes" props are marked required, but they're not
      } else if (name == "classes" && prop.propType == ObjectType) {
        name -> prop.copy(required = false)

      // type is not a legal name in Scala
      } else if (name == "type") {
        "`type`" -> prop      
      
      } else {
        name -> prop
      }
    }

    
  }

}