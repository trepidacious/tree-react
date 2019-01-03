const { app, BrowserWindow, ipcMain } = require('electron');
const {autoUpdater} = require("electron-updater");
const log = require('electron-log');
const path = require('path')

const net = require('net');

const { default: installExtension, REACT_DEVELOPER_TOOLS } = require('electron-devtools-installer');

// Keep a global reference of the window object, if you don't, the window will
// be closed automatically when the JavaScript object is garbage collected.
let mainWindow;

const isDev = require('electron-is-dev');

const createWindow = async () => {
  // Create the browser window.
  mainWindow = new BrowserWindow({
    width: 600,
    height: 700,
    minWidth: 400,
    minHeight: 500,
    frame: false,
    titleBarStyle: 'hidden',
    backgroundColor: '#2e3b84',
    icon: path.join(__dirname, 'build/icons/512x512.png'),
    show: false
  });

  mainWindow.once('ready-to-show', () => {
    mainWindow.show()
  })

  if (!isDev) {
    mainWindow.setMenu(null);
  }

  // and load the index.html of the app.
  mainWindow.loadURL(`file://${__dirname}/index.html`);

  // Open the DevTools.
  if (isDev) {
    // See https://github.com/electron/electron/issues/12438
    mainWindow.webContents.once('dom-ready', () => {
      mainWindow.openDevTools()
      installExtension(REACT_DEVELOPER_TOOLS)
        .then((name) => console.log(`Added Extension:  ${name}`))
        .catch((err) => console.log('An error occurred: ', err));
    })
  }

  // Emitted when the window is closed.
  mainWindow.on('closed', () => {
    // Dereference the window object, usually you would store windows
    // in an array if your app supports multi windows, this is the time
    // when you should delete the corresponding element.
    mainWindow = null;
  });
};


const firstInstance = app.requestSingleInstanceLock()

// We're the second instance, quit
if (!firstInstance) {
  app.quit()

// We're the first instance, run
} else {

  // If a second instance is opened, focus ourselves. We might also want to
  // use the commandLine - if we are set up to handle a file type then this
  // may contain a file to open
  app.on('second-instance', (event, commandLine, workingDirectory) => {
    if (mainWindow) {
      if (mainWindow.isMinimized()) mainWindow.restore()
      mainWindow.focus()
      mainWindow.webContents.send('notifications', 'Second instance, in ' + workingDirectory + ', args: ' + commandLine);  
    }
  })

  // This method will be called when Electron has finished
  // initialization and is ready to create browser windows.
  // Some APIs can only be used after this event occurs.
  app.on('ready', createWindow);

  // Quit when all windows are closed.
  app.on('window-all-closed', () => {
    // On OS X it is common for applications and their menu bar
    // to stay active until the user quits explicitly with Cmd + Q
    // if (process.platform !== 'darwin') {
      app.quit();
    // }
  });

  app.on('activate', () => {
    // On OS X it's common to re-create a window in the app when the
    // dock icon is clicked and there are no other windows open.
    if (mainWindow === null) {
      createWindow();
    }
  });

  //-------------------------------------------------------------------
  // Auto updates
  //
  // This will immediately download an update, then install when the
  // app quits.
  //-------------------------------------------------------------------
  autoUpdater.logger = log;
  autoUpdater.logger.transports.file.level = 'info';
  log.info('App starting...');
  if (isDev) {
    log.info('DEV MODE');
  }
  log.info('dir name: ' + __dirname);

  app.on('ready', function()  {
    if (!isDev) {
      // Check for updates every 5 minutes
      autoUpdater.checkForUpdatesAndNotify();
      setInterval(function(){
        autoUpdater.checkForUpdatesAndNotify();
      }, 1000 * 60 * 5);
    }
  });

  autoUpdater.on('update-available', (ev, info) => {
    log.info('update-available');
    if (mainWindow) {
      mainWindow.webContents.send('notifications', 'A new version is available - restart software to install. ' + info);
    }
  })



}



