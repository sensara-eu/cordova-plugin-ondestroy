onDestroy
========================

Sets an service that create a local notification when is "destroyed".

The translations are added as string resource through the plugin.xml. 
Change the translations by changing the content there. 

(Can we change from upper level like override in cordova config?) 


Usage
----------------------
#### Add the notification sound
Place wav sound below your ``res/raw`` folder. Use ``app_closed.wav`` as name.

#### Start the service. 
After device ready
````
window.plugins.OnDestroyPlugin.startService ()
````
