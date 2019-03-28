package com.flyingsoftgames.ondestroyplugin;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import eu.luminis.SensaraProCare.MainActivity;
import eu.luminis.SensaraProCare.R;

public abstract class NotificationHelper {

  public static final String CHANNEL_NAME = "Sensara app closed";
  public static final String CHANNEL_ID = "app_closed_notification_channel";
  public static final int NOTIFICATION_ID = 1001;

  /**
   * Create and push the notification
   */
  public static void createNotification(final Context context) {
    /**Creates an explicit intent for an Activity in your app**/
    Intent resultIntent = new Intent(context, MainActivity.class);
    resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

    PendingIntent resultPendingIntent = PendingIntent.getActivity(
            context,
            0,
            resultIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
    );

    Uri sound = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + context.getPackageName() + "/" + R.raw.app_closed);

    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, CHANNEL_ID);
    mBuilder.setSmallIcon(R.mipmap.icon);
    mBuilder.setContentTitle(context.getResources().getString(R.string.app_closed_notification_title))
            .setSound(sound)
            .setAutoCancel(false)
            .setStyle(new NotificationCompat.BigTextStyle().bigText(context.getResources().getString(R.string.app_closed_notification_description)))
            .setContentIntent(resultPendingIntent);

    NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

    if (mNotificationManager == null) {
      return;
    }

    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
      NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
      notificationChannel.enableLights(true);
      notificationChannel.setLightColor(Color.RED);
      AudioAttributes att = new AudioAttributes.Builder()
              .setUsage(AudioAttributes.USAGE_NOTIFICATION)
              .build();
      notificationChannel.setSound(sound, att);
      notificationChannel.enableVibration(true);
      notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
      mNotificationManager.createNotificationChannel(notificationChannel);
      mBuilder.setChannelId(CHANNEL_ID);
    }
    mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
  }

  public static void cancelNotification(Context context) {
    NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    if (mNotificationManager == null) {
      return;
    }
    mNotificationManager.cancel(NOTIFICATION_ID);
  }
}
