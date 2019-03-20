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


Usage in JS
----------------------  

#### Start the service. 
After device ready
````
window.plugins.OnDestroyPlugin.startService ()
````
