package com.flyingsoftgames.ondestroyplugin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class OnDestroyCheckerService extends Service {

  private static final String LOG_TAG = "onDestroyChecker";

  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    super.onStartCommand(intent, flags, startId);
    Log.d(LOG_TAG, "onStartCommand");
    NotificationHelper.cancelNotification(getApplicationContext());
    return START_NOT_STICKY;
  }

  /*
   * Needed onTaskRemoved and onDestroy some android api's onTaskRemoved is called and some the
   * onDestroy
   */

  @Override
  public void onTaskRemoved(Intent rootIntent) {
    super.onTaskRemoved(rootIntent);
    Log.d(LOG_TAG, "onTaskRemoved");
    NotificationHelper.createNotification(getApplicationContext());
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    Log.d(LOG_TAG, "onDestroy");
    NotificationHelper.createNotification(getApplicationContext());
  }
}
