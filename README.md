onDestroy
========================

Sets an service that create a local notification when is "destroyed".

#### The notification translations
The translations are added as string resource through the plugin.xml. 
Change the translations by changing the content there. 

(Can we change from upper level like override in cordova config?)

#### The notification sound
The plugin uses a custom sound file placed below ``assets`` folder. with name ``app_closed.wav``. 
You can change this file but keep the same name to prevent code changes. 

#### The notification icon
The plugin uses a icon. To use this plugin the icon needs to be set in config.xml with the name small_icon.
````
<resource-file src="res/small-icon/android/mdpi.png" target="app/src/main/res/drawable-mdpi/small_icon.png" />
<resource-file src="res/small-icon/android/hdpi.png" target="app/src/main/res/drawable-hdpi/small_icon.png" />
<resource-file src="res/small-icon/android/xhdpi.png" target="app/src/main/res/drawable-xhdpi/small_icon.png" />
<resource-file src="res/small-icon/android/xxhdpi.png" target="app/src/main/res/drawable-xxhdpi/small_icon.png" />
<resource-file src="res/small-icon/android/xxxhdpi.png" target="app/src/main/res/drawable-xxxhdpi/small_icon.png" />
````

Usage in JS
----------------------  

#### Start the service. 
After device ready
````
window.plugins.OnDestroyPlugin.startService ()
````
