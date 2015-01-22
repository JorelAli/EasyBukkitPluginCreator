# EasyBukkitPluginCreator file guide

### Main frames
* SplashScreen - Shows the splash screen for the project. Contains the main(String[] args) method. Where the program is run from
* InitDialog - Shows the dialog just after the splash screen. Can show info about the software, how to use it and get started with making a new plugin.
* MainProgrammingScreen - The main user interface. The place where everything happens.
  * AddCommandDialog - Dialog to add a new command

### Panels
* GradientPanel - A fancy panel which has a gradient background
* CommandPanel - A panel which is used to edit commands. Shown on the MainProgrammingScreen
* WelcomePanel - A panel which welcomes the user. Similar to that welcome screen which is initially shown in Eclipse when it is started for the first time. Used when creating a new plugin and shown to the user to help them get used to the user interface.
