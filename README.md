# tree-react
Utilities and facades for use of react and electron libraries in scalajs-react

This consists of several individual sub-projects which can be used separately if needed. Together they aim to give a reasonable toolkit for implementing web or electron apps with scalajs and material design.

Includes and replaces several originally separate projects:

 * [scalajs-react-material-ui](https://github.com/trepidacious/scalajs-react-material-ui)
 * [scalajs-react-material-icons](https://github.com/trepidacious/scalajs-react-material-icons)
 * [scalajs-react-material-ui-extra](https://github.com/trepidacious/scalajs-react-material-ui-extra)
 * [scalajs-react-downshift](https://github.com/trepidacious/scalajs-react-downshift)
 * [scalajs-electron](https://github.com/trepidacious/scalajs-electron)

## Electron App Demo

The scalajs-electron-react-app project provides a very simple demo of some material-ui components. This may be extended in future to demonstrate more components.

This also includes a demo of an approach to using Context to allow access to a key-value store, with optimised updates of components when values they render change.

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

The console shows debug output from the update process for components using the data context.

## scalajs-react-material-ui

Facade for [material-ui](https://material-ui.com/) 3.1.2 in [scalajs-react](https://github.com/japgolly/scalajs-react).

Contains code to generate a facade for each material-ui component, based on the json API description generated by [react-docgen](https://github.com/reactjs/react-docgen) from material-ui itself, and the results of that generation.

This uses a few heuristics to assign more detailed types (mostly for functions), and to include props from base classes (e.g. `Button` includes `ButtonBase` props). Hopefully this will allow for relatively easy updates to new material-ui versions.

Project is in a very early state. See [scalajs-react-components](https://github.com/chandu0101/scalajs-react-components) for a more complete library, however this still uses an older version of material-ui.

Current notable areas for improvement:

1. Only a few components have been tested, incompletely.
2. Some types are approximate, in particular `PropTypes.oneOfType` is just presented as `js.Any`.
3. Common React events are presented with correct event types, other event props just expect a Callback and will therefore discard event parameters (if any).
4. See **Todo** below for more...

### Building

Until this is published properly, you will need to clone the project, run `sbt`, then `publishLocal`. The generated facade is checked in so you don't need to run the code generation unless you want to work on the generator itself.

Code generation is not done the right way - .scala files are just generated directly into the js src folder, under package `org.rebeam.mui`, by running `scalajsReactMaterialUIJVM/run` from sbt.

To regenerate the `muiapi.json` data describing the components, check out the material-ui project, then in the mateerial-ui project root, run react-docgen:

```
npx react-docgen .\packages\material-ui\src\ -o muiapi.json --pretty
```

You may need to trim some non-component data, for 3.1.2 this was just a `reactHelpers.js` at the end of the file.

Then copy the `muiapi.json` file to resources. 

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

The fix for this is to add an entry in `DocGenContext.MaterialUI` in `propsIncludingInheritance`, for example:

```scala
        case Component(_, "CardContent", _) => additionalPropsFrom("DOCGEN_Children")
```

This makes `CardContent` inherit props from `DOCGEN_Children` - this is a virtual component that exists just to provide this prop conveniently. If the component already inherits from another component, just add `DOCGEN_Children` to the list.

#### Missing props

Some components are missing props because they "inherit" from another component in material-ui - this can be modelled by adding that component to `DocGenContext.MaterialUI` as described above for "Children not detected". Other components simply have a missing prop in the API (e.g. a built-in react prop), and this can be added by making a new `DOCGEN_Foo` component in the `allPlusDocgen` method, and then inheriting from that. 

### Todo

1. Support `PropTypes.oneOfType`
2. Better support and testing of array props
3. Colors
5. More testing/demos
6. Check all components are included - see https://github.com/mui-org/material-ui/blob/master/packages/material-ui/src/index.js
7. ExpansionPanel onChange parameters
8. Any other missing events from native elements? E.g. onClick on MenuItem is not documented.
9. Aria properties
10. id, ref, etc.
11. Detect `classes` prop and accept an appropriate type?
12. Consider changing PascalCase prop names to camelCase to be more idiomatic. Consider typing these based on a map from prop names to the Component name of the sub element. This would still allow use of a `js.Object` containing props, in an `additionalProps` field.
13. Support component methods
14. Support for withStyles?

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
