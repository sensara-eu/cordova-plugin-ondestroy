package com.flyingsoftgames.ondestroyplugin;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;

public class OnDestroyPlugin extends CordovaPlugin {

    private CallbackContext onDestroyCallback = null;
    private final String LOG_TAG = "onDestroyPlugin";

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        if ("startService".equals(action)) {
            Log.d(LOG_TAG, "execute: startService");
            Context context = cordova.getActivity().getApplicationContext();
            final Intent i = new Intent(context, OnDestroyCheckerService.class);
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

}
