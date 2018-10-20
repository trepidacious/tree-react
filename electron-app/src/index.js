const { app, BrowserWindow, ipcMain } = require('electron');
const {autoUpdater} = require("electron-updater");
const log = require('electron-log');
const path = require('path')

const net = require('net');

// Keep a global reference of the window object, if you don't, the window will
// be closed automatically when the JavaScript object is garbage collected.
let mainWindow;

const isDev = require('electron-is-dev');

const createWindow = async () => {
  // Create the browser window.
  mainWindow = new BrowserWindow({
    width: 600,
    height: 700,
    frame: false,
    // titleBarStyle: 'hidden',
    // backgroundColor: '#312450',
    icon: path.join(__dirname, 'assets/icons/png/512x512.png')
  });

  if (!isDev) {
    mainWindow.setMenu(null);
  }

  // and load the index.html of the app.
  mainWindow.loadURL(`file://${__dirname}/index.html`);

  // Open the DevTools.
  if (isDev) {
    mainWindow.webContents.openDevTools()
  }

  // Emitted when the window is closed.
  mainWindow.on('closed', () => {
    // Dereference the window object, usually you would store windows
    // in an array if your app supports multi windows, this is the time
    // when you should delete the corresponding element.
    mainWindow = null;
  });
};

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
log.info(__dirname);

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
