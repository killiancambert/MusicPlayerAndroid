package com.example.musicplayer;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class CreateNotification {

    public static final String CHANNEL_ID = "channel1";
    public static final String ACTIONPREVIOUS = "actionprevious";
    public static final String ACTIONPLAY = "actionplay";
    public static final String ACTIONNEXT = "actionnext";

    public static Notification notification;

    public static void createNotification(Context context, MusicFiles musicFiles, int playBtn, int position, int size)
    {
       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
       {
           NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
           MediaSessionCompat mediaSessionCompat = new MediaSessionCompat(context, "tag");

           notification = new NotificationCompat.Builder(context, CHANNEL_ID)
                   .setSmallIcon(R.drawable.ic_baseline_music_note_24)
                   .setContentTitle(musicFiles.getTitle())
                   .setContentText(musicFiles.getArtist())
                   .setOnlyAlertOnce(true)
                   .setShowWhen(false)
                   .setPriority(NotificationCompat.PRIORITY_LOW)
                   .build();

           notificationManagerCompat.notify(1, notification);
       }
    }


}
