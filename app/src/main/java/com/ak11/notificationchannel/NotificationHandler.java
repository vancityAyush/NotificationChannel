package com.ak11.notificationchannel;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;

public class NotificationHandler extends ContextWrapper {

    private NotificationManager notificationManager;
    public static final String WATCH_MOVIE_NOTIFICATION_CHANNEL_ID="WMNCID";
    public static final String WATCH_MOVIE_NOTIFICATION_CHANNEL_NAME="WMNCName";


    public NotificationHandler(Context base) {
        super(base);
        createNotificationChannel();
    }

    public  void createNotificationChannel(){
        NotificationChannel notificationChannel = new NotificationChannel(WATCH_MOVIE_NOTIFICATION_CHANNEL_ID,
                WATCH_MOVIE_NOTIFICATION_CHANNEL_NAME,notificationManager.IMPORTANCE_DEFAULT);

        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(Color.RED);
        notificationChannel.setShowBadge(true);
        notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
        getNotificationManager().createNotificationChannel(notificationChannel);
    }

    private NotificationManager getNotificationManager() {
        if(notificationManager==null){

            notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }

        return notificationManager;
    }

    public Notification.Builder createAndReturnWatchMovieNotification(String title , String body){

        return new Notification.Builder(getApplicationContext(),WATCH_MOVIE_NOTIFICATION_CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.drawable.watch_movie)
                .setAutoCancel(true);
    }

    public void notifyTheUser(int notificationID, Notification.Builder notificationBuilder){

        getNotificationManager().notify(notificationID,notificationBuilder.build());

    }


}
