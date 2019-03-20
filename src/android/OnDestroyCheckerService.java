package com.flyingsoftgames.ondestroyplugin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class OnDestroyCheckerService extends Service {

  private static final String TAG = "onDestroyChecker";

  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    super.onStartCommand(intent, flags, startId);
    NotificationHelper.cancelNotification(getApplicationContext());
    return START_NOT_STICKY;
  }

  @Override
  public void onDestroy() {
    NotificationHelper.createNotification(getApplicationContext());
    super.onDestroy();
  }
}
