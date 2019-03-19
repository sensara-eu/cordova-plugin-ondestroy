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
    return START_STICKY;
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    Log.i(TAG, "Service destroying");
  }
}
