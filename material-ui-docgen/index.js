const path = require('path')
const fs = require('fs')
const recast = require('recast')
const docgen = require('react-docgen')


//TODO we could use this to transform chainPropTypes, rather than doing this in the final output json
const chainPropTypesHandler = (doc, path) => {
  // console.log(doc.toObject().props)
  // console.log(path)
} 

/* append display name handler to handlers list */
const handlers = docgen.defaultHandlers.concat(chainPropTypesHandler)

const docgenParse = docgen.parse

function reparsePropType(src) {
  const parsed = docgenParse(`
    import PropTypes from 'prop-types';
    const Foo = () => <div />
    Foo.propTypes = {
      bar: ${src}
    }
    export default Foo
  `);

  return parsed.props.bar.type
}

function getDeprecatedInfo(type) {
  const marker = 'deprecatedPropType(PropTypes.';
  const indexStart = type.raw.indexOf(marker);

  if (indexStart !== -1) {
    return {
      type: reparsePropType(recast.print(recast.parse(type.raw).program.body[0].expression.arguments[0]).code), //type.raw.substring(indexStart + marker.length, type.raw.indexOf(',')),
      explanation: recast.parse(type.raw).program.body[0].expression.arguments[1].value,
    };
  }

  return false;
}

function getChained(type) {
  const marker = 'chainPropTypes';
  const indexStart = type.raw.indexOf(marker);

  if (indexStart !== -1) {
    return reparsePropType(recast.print(recast.parse(type.raw).program.body[0].expression.arguments[0]).code);
  }

  return false;
}

//Inspect the API for chainPropTypes and deprecated info, and rewrite it to be compatible with scala docgen processing
function processProps(props) {
  Object.keys(props).forEach(key =>{
    var prop = props[key]
    if (prop.type.name === 'custom') {

      const chained = getChained(prop.type)
      if (chained !== false) {
        // console.log('\nChained:')
        // console.log(prop.type)
        prop.type = chained
        // console.log(prop.type)
      } else {
        const deprecated = getDeprecatedInfo(prop.type)
        if (deprecated !== false) {
          // console.log('\nDeprecated:')
          // console.log(prop.type)
          prop.type = deprecated.type
          if (prop.description) {
            prop.description += " Deprecated: " + deprecated.explanation
          } else {
            prop.description = "Deprecated: " + deprecated.explanation
          }
          // console.log(prop.type)
        }
      }
    }
  })
}

const inheritedComponentRegexp = /\/\/ @inheritedComponent (.*)/;

function getInheritance(src) {
  const inheritedComponent = src.match(inheritedComponentRegexp);

  if (!inheritedComponent) {
    return null;
  }

  const component = inheritedComponent[1];
  let pathname;

  switch (component) {
    case 'Transition':
      pathname = 'https://reactcommunity.org/react-transition-group/#Transition';
      break;

    case 'EventListener':
      pathname = 'https://github.com/oliviertassinari/react-event-listener';
      break;

    default:
      // pathname = `https://material-ui.com/api/${kebabCase(component)}`;
      pathname = `https://material-ui.com/api/${component}`;
      break;
  }

  return {
    component,
    pathname,
  };
}

function processComponent(component) {
  const src = fs.readFileSync(component.filename, 'utf8');
  if (src.match(/@ignore - internal component\./) || src.match(/@ignore - do not document\./)) {
    return;
  }
  try {
    component.api = docgen.parse(src, null, handlers)
    // TODO could use parse handlers here to recognise and process Material-UI props
    processProps(component.api.props)

    const inheritance = getInheritance(src)
    if (inheritance !== null) {
      component.inheritance = inheritance
    }
  } catch (err) {
    console.log('Error parsing src for', component.filename);
    throw err;
  }
}

// Returns the component source in a flat array.
// Uses a regex for path and component to avoid es, internal, etc.
function findComponents(directory, subdirectory = [], components = []) {

  const componentRegex = /^([A-Z][a-z]+)+\.js/;
  const pathRegex = /^([A-Z][a-z]+)/;

  const items = fs.readdirSync(directory);

  items.forEach(item => {
    const itemPath = path.resolve(directory, item);
    const subItem = subdirectory.slice()
    subItem.push(item)

    if (fs.statSync(itemPath).isDirectory() && pathRegex.test(item)) {
      findComponents(itemPath, subItem, components);
      return;
    }

    if (!componentRegex.test(item)) {
      return;
    }

    components.push({
      filename: itemPath,
      path: subItem.join('/')
    });
  });

  return components;
}

function processComponents(path) {
  const components = findComponents(path)
  components.forEach(component => processComponent(component))
  return components.filter(c => c.api)
}

function writeResult(result, output) {
  result = JSON.stringify(result, null, 2);
  fs.writeFileSync(output, result);
}

console.log("Running react-docgen with handlers...")

// Note this assumes that material-ui of the desired version is checked out alongside tree-react, in directory 'material-ui'
// We need to process the actual original source of material-ui (as is done for the material-ui API docs) since the sources
// distributed in npm have been processed with a production check to remove propTypes that confuses react-docgen.
const coreComponents = processComponents(path.resolve('..', '..', 'material-ui', 'packages', 'material-ui', 'src'))
const styleComponents = processComponents(path.resolve('..', '..', 'material-ui', 'packages', 'material-ui', 'src', 'styles'))

const api = {}

coreComponents.forEach(c => {
  console.log(c.path)
  if (c.inheritance) c.api.inheritance = c.inheritance
  api[c.path] = c.api
})

styleComponents.forEach(c => {
  console.log(c.path)
  if (c.inheritance) c.api.inheritance = c.inheritance
  api[c.path] = c.api
})

const muiapiFile = path.resolve('..', 'scalajs-react-material-ui', 'jvm', 'src', 'main', 'resources', 'muiapi.json')

writeResult(api, muiapiFile)
