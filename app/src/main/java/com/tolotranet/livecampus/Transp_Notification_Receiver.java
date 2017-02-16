package com.tolotranet.livecampus;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Tolotra Samuel on 15/02/2017.
 */
public class Transp_Notification_Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent fromTranspNotificationIntent = new Intent(context, Transp_SpreadSheetActivity.class);
        fromTranspNotificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,App_Tools.randomInt(100,10000), fromTranspNotificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.transp_bus)
                .setContentTitle("Your bus is leaving!!")
                .setContentText("I hope you are already in the bus")
                .setAutoCancel(true)
                .setVibrate(new long[]{1000, 1000, 1000, 1000} )
                .setLights(Color.RED, 3000, 3000)
                .setSound(alarmSound)
                ;
        notificationManager.notify(App_Tools.randomInt(100,10000), builder.build());


    }
}
