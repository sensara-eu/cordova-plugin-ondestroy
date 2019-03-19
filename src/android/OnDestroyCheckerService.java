package com.flyingsoftgames.ondestroyplugin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class OnDestroyCheckerService extends Service {

  private static final String TAG = "onDestroyChecker";
  private static String title;
  private static String description;

  @Override
  public IBinder onBind(Intent intent) {
    Log.d(TAG, "onBind called");
    return null;
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    Log.d(TAG, "onStartCommand");
    super.onStartCommand(intent, flags, startId);
    if (intent != null && intent.getExtras() != null) {
      title = intent.getExtras().getString("notificationTitle");
      description = intent.getExtras().getString("notificationDescription");
    }
    NotificationHelper.cancelNotification(getApplicationContext());
    Log.i(TAG, "Service: " + title);
    Log.i(TAG, "Service: " + description);
    return START_NOT_STICKY;
  }

  @Override
  public void onDestroy() {
    NotificationHelper.createNotification(title, description, getApplicationContext());
    Log.i(TAG, "Service: " + title);
    Log.i(TAG, "Service: " + description);
    Log.i(TAG, "Service destroying");
    super.onDestroy();
  }
}
