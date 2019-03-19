package com.flyingsoftgames.ondestroyplugin;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class OnDestroyPlugin extends CordovaPlugin {

    private CallbackContext onDestroyCallback = null;
    private final String LOG_TAG = "onDestroyPlugin";

    public boolean execute(String action, JSONArray inputs, CallbackContext callbackContext) throws JSONException {
        onDestroyCallback = callbackContext;
        Log.d(LOG_TAG, "execute");
        Context context = this.cordova.getActivity().getApplicationContext();
        final Intent i = new Intent(context, OnDestroyCheckerService.class);
        i.putExtra("KEY1", "Value to be used by the service"); // add data to the intent
        context.startService(i);
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
