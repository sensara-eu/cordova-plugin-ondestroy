package com.flyingsoftgames.ondestroyplugin;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class OnDestroyPlugin extends CordovaPlugin {
    
    private final String LOG_TAG = "onDestroyPlugin";
    private String notificationTitle = "Sensara app is closed";
    private String notificationDescription = "The app is closed or not responding. Open the app to keep getting alarms.";

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("setNotificationTitle".equals(action)) {
            Log.d(LOG_TAG, "setNotificationTitle: " + args.getString(0));
            setNotificationTitle(args.getString(0));
            callbackContext.success();
            return true;
        } else if ("setNotificationDescription".equals(action)) {
            Log.d(LOG_TAG, "setNotificationDescription: " + args.getString(0));
            setNotificationDescription(args.getString(0));
            callbackContext.success();
            return true;
        } else if ("startService".equals(action)) {
            Log.d(LOG_TAG, "startService");
            Context context = cordova.getActivity().getApplicationContext();
            final Intent i = new Intent(context, OnDestroyCheckerService.class);
            i.putExtra("notificationTitle", notificationTitle); // add data to the intent
            i.putExtra("notificationDescription", notificationDescription); // add data to the intent
            context.startService(i);
            callbackContext.success();
            return true;
        }
        return false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void setNotificationTitle(String title) {
        this.notificationTitle = title;
    }

    private void setNotificationDescription(String description) {
        this.notificationDescription = description;
    }

}
