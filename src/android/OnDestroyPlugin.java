package com.flyingsoftgames.ondestroyplugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class OnDestroyPlugin extends CordovaPlugin {

 private CallbackContext onDestroyCallback = null;
 private final String LOG_TAG = "onDestroyPlugin";

 public boolean execute (String action, JSONArray inputs, CallbackContext callbackContext) throws JSONException {
  onDestroyCallback = callbackContext;
  return true;
 }

 @Override
 public void onStart() {
  Log.d("TEST", "onCreate");
  // use this to start and trigger a service
  Context context = this.cordova.getActivity().getApplicationContext();
  final Intent i = new Intent(context, OnDestroyCheckerService.class);
  // potentially add data to the intent
  i.putExtra("KEY1", "Value to be used by the service");
  context.startService(i);
 }

 @Override
 public void onDestroy() {
//    Context context = this.cordova.getActivity().getApplicationContext();
//    NotificationHelper.createNotification("App is closed or not responding.", "Open the app again to keep getting alarms", context);
//    if (onDestroyCallback != null) onDestroyCallback.sendPluginResult(pluginResultKeep());
  super.onDestroy();
 }

 private PluginResult pluginResultKeep() {
  PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
  pluginResult.setKeepCallback(true);
  return pluginResult;
 }
}
