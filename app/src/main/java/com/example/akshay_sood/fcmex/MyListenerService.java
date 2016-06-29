package com.example.akshay_sood.fcmex;

import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

/**
 * Created by AKSHAY_SOOD on 25/06/16.
 */
public class MyListenerService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        String messageFrom = remoteMessage.getFrom();
        String messageId = remoteMessage.getMessageId();
        Map data = remoteMessage.getData();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Push Using FCM");
        builder.setContentText("Message =>" + data.get("message"));
        builder.setSmallIcon(R.mipmap.ic_launcher);
        NotificationManager manager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(10, builder.build());
        Log.e("FCM", "FROm " + messageFrom + " ID " + messageId + " Body " + data.get("message"));

    }
}
