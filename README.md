# tree-react
Utilities and facades for use of react and electron libraries in scalajs-react

This consists of several individual sub-projects which can be used separately if needed. Together they aim to give a reasonable toolkit for implementing web or electron apps with scalajs and material design.

Includes and replaces several originally separate projects:

 * [scalajs-react-material-ui](https://github.com/trepidacious/scalajs-react-material-ui)
 * [scalajs-react-material-icons](https://github.com/trepidacious/scalajs-react-material-icons)
 * [scalajs-react-material-ui-extra](https://github.com/trepidacious/scalajs-react-material-ui-extra)
 * [scalajs-react-downshift](https://github.com/trepidacious/scalajs-react-downshift)
 * [scalajs-electron](https://github.com/trepidacious/scalajs-electron)
 * [tree-stm](https://github.com/trepidacious/tree-stm) - as tree-core

## Installation

Install [sbt](https://www.scala-sbt.org/) and [yarn](https://yarnpkg.com/).
Clone this git repository.
Run `sbt publishLocal`
To run demo, change to electron-app directory, then run `yarn` and `yarn start`
 
Note that autogenerated code uses LF line endings, so CRLF/LF line ending conversion is disabled in this repository using a `.gitattributes` file containing `* -text`. This prevents Git from treating any files as text, and so disables conversion (see [docs](https://git-scm.com/docs/gitattributes) for details).
You can also use the following to disable CRLF/LF conversion globally `git config --global core.autocrlf input` (see [docs](https://git-scm.com/docs/git-config) for details).
 
## Electron App Demo

The scalajs-electron-react-app project provides a very simple demo of some material-ui components. This may be extended in future to demonstrate more components.

This also includes a demo of DataContext from the tree-react project, which uses React Context to allow access to a DataSource, with optimised updates of components when values they render change.

Run the following from the project root directory:

```
# Build the scalajs sources
sbt fastOptJS

# Switch to the electron app root directory
cd electron-app

# Install yarn dependencies
yarn

# Run the electron app
yarn start
```

The console shows debug output from the update process for components using the DataSource context.

## tree-core

A simple, functional software transactional memory, plus an approach to updating it using serialisable transactions, synchronising data between server and clients, and editing immutable data structures using lenses.

This is still in progress, see [notes](https://github.com/trepidacious/tree-react/blob/master/tree-core/Notes.md).

## tree-react

React components for use with tree-core.

Also still in progress, there is an example of current functionality in electron-app.

## scalajs-react-material-ui

Facade for [material-ui](https://material-ui.com/) 3.7.1 in [scalajs-react](https://github.com/japgolly/scalajs-react).

Contains code to generate a facade for each material-ui component, based on the json API description generated by 'material-ui-docgen' subproject, which uses [react-docgen](https://github.com/reactjs/react-docgen) to extrat an API from material-ui itself, and the results of that generation.

This uses a few heuristics to assign more detailed types (mostly for functions), and to add some apparently missing props (including inheritance). Hopefully this will allow for relatively easy updates to new material-ui versions.

Project is in a very early state. See [scalajs-react-components](https://github.com/chandu0101/scalajs-react-components) for a more complete library, however this still uses an older version of material-ui.

Current notable areas for improvement:

1. Only a few components have been tested, incompletely.
2. Some types are approximate, in particular `PropTypes.oneOfType` is just presented as `js.Any`.
3. Common React events are presented with correct event types, other event props just expect a Callback and will therefore discard event parameters (if any).
4. See **Todo** below for more...

### Building

Until this is published properly, you will need to clone the project, run `sbt`, then `publishLocal`. The generated facade is checked in so you don't need to run the code generation unless you want to work on the generator itself.

Code generation is not done the right way - .scala files are just generated directly into the js src folder, under package `org.rebeam.mui`, by running `scalajsReactMaterialUIJVM/run` from sbt.

To regenerate the `muiapi.json` data describing the components, check out the material-ui project, in a directory named 'material-ui', alongside the tree-react project. The sources here will be used by the API extraction.
In the material-ui-docgen folder, run `yarn start`. This uses a .js script to run react-docgen on the material-ui core sources, using the same logic as the material-ui API generation to find the correct files, and tweak the output to handle custom propTypes used by material-ui. Relevant code is in the `docs` folder of the material-ui project, in particular `docs/scripts/buildApi.js` and `docs/src/modules/utils/generateMarkdown.js`. Running this successfully will produce a new `muiapi.json` file in the scalajs-react-material-ui jvm resources directory.

Note that at present Material-UI has an odd thing where MuiThemeProvider has been renamed to MuiThemeProviderOld, this is handled as a special case by code generation.

### Notes

Material-ui of the correct version (see above) must be available for import - each component is imported individually, e.g.:
```scala
@JSImport("@material-ui/core/Snackbar", JSImport.Default)
```

For icons, see `scalajs-react-material-icons` sub-project.

Some component props are PascalCase, for example `TextField` has a `InputProps` prop. These have been left in PascalCase for now - they generally accept a `js.Object` containing props that will be passed through to a sub-element of the component.

All components provide an optional extra prop, `additionalProps` that is not found in the original material-ui component API. This can be passed a `js.Object`, and each field of that object will be passed as a prop to the underlying material-ui JS component. Any fields with names matching actual documented props of the component will only be used if those props are not specified already. This emulates the spread operator in JS.

When using event props like `onClick`, be careful to retrieve any required data from the event _outside_ the `Callback` itself - otherwise the event may have been reused before the `Callback` runs, leading to errors. For example we might want to set some state to remember the anchor for a menu when a button is clicked:

```scala
mui.IconButton(
  onClick = (e: ReactMouseEvent) => {
    // Get the target here, outside the Callback
    val anchor = e.currentTarget
    
    // Now we can use the anchor value in the modState callback
    scope.modState(_.copy(menuAnchor = Some(anchor)))
  }
)(
  icons.AccountCircle()
)
```

### Debugging

If the code generation is incorrect, several issues can occur when attempting to use the components:

#### Children not detected
Some components are not correctly detected by react-docgen as having children. This results in an error like the following (for `CardContent` component):

```
[error]  found   : japgolly.scalajs.react.vdom.TagMod
[error]  required: japgolly.scalajs.react.vdom.html_<^.VdomNode
[error]     (which expands to)  japgolly.scalajs.react.vdom.VdomNode
[error]             mui.CardContent()(
```  

The fix for this is to process the component appropriately in `preprocessComponent` in `DocGenContext.MaterialUI`. For example in this case we use:
```scala
  // CardContent has no children property, but is clearly used with children in examples
  if (c.displayName == "CardContent") {
    addChildrenProp(c)
  }
}
```
This detects the `CardComponent`, and adds a `children` prop directly.

#### Missing props

Many components "inherit" from another component in material-ui, or outside (e.g. the React `Transition`). This is generally handled automatically by including inheritance information in muiapi.json extracted from annotations in the material-ui source. 
However if this is missing the inheritance can be inserted manually in `preprocessComponent` in `DocGenContext.MaterialUI`.
For example, `ListItem` is processed as follows:
```scala
  // When ListItem "button" prop is true, API indicates that ListItem uses ButtonBase.
  // For now, just add the ButtonBase props regardless, but in future we might want to
  // split ListItem into a button and non-button version with different props
  if (c.displayName == "ListItem") {
    //Fail if component gets a real ancestor...
    assert(c.inheritance.isEmpty)
    c.copy(inheritance = Some(Inheritance("ButtonBase", "https://material-ui.com/api/ButtonBase")))
  }
```

### Todo

1. Support `PropTypes.oneOfType`
2. Better support and testing of array props
3. Colors
4. More testing/demos
5. Aria properties
6. id, ref, etc.
7. Detect `classes` prop and accept an appropriate type?
8. Consider changing PascalCase prop names to camelCase to be more idiomatic. Consider typing these based on a map from prop names to the Component name of the sub element. This would still allow use of a `js.Object` containing props, in an `additionalProps` field.
9. Support component methods
10. Support for withStyles?

## scalajs-react-material-icons
Scalajs react facade for material-ui icons

Each icon is a separate component, as in the original js material-ui project.

Icon names are taken from the .js files in the material-ui icons package src folder.

Only the standard versions are present - this is already a huge number of classes.

### TODO

1. Have a look at https://gist.github.com/AmirOfir/daee915574b1ba0d877da90777dc2181 to see whether we can split icons into categories.
2. Consider producing a project for each icon version.
3. Implement props if any.

## scalajs-react-downshift
Scalajs-react facade for Downshift

## scalajs-react-material-ui-extra
This project provides extra components built using the scalajs-react-material-ui, scalajs-react-material-icons and scalajs-react-downshift sub-projects.

This is separate to scalajs-react-material-ui to allow use of just the plain material-ui facade if required.

### Contents

1. MultiSelect, using Downshift to provide an auto-completing multi-selection input.
2. Darkness, default dark material-ui theme provider, to make a branch of the UI dark.

## scalajs-react-downshift
Scalajs facade for some useful parts of the Electron and Node API. Uses [nodejs](https://github.com/scalajs-io/nodejs) facade for low-level Node API, but provides some [cats-effect](https://typelevel.org/cats-effect/) wrappers around this (currently just loading strings from files).
