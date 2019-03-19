package com.flyingsoftgames.ondestroyplugin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class OnDestroyCheckerService extends Service {

  private static final String TAG = "onDestroyChecker";

  @Override
  public IBinder onBind(Intent intent) {
    Log.d(TAG, "onBind called");
    return null;
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    super.onStartCommand(intent, flags, startId);
    Log.d(TAG, "onStartCommand run");
    NotificationHelper.cancelNotification(getApplicationContext());
    return START_NOT_STICKY;
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    NotificationHelper.createNotification("App is closed or not responding.", "Open the app again to keep getting alarms", getApplicationContext());
    Log.i(TAG, "Service destroying");
  }
}
