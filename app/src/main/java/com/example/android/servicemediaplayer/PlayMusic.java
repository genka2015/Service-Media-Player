package com.example.android.servicemediaplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.widget.Toast;


public class PlayMusic extends Service {

    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service started", Toast.LENGTH_SHORT).show();
        if(mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.osen);
            mediaPlayer.start(); // no need to call prepare(); create() does that for you
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service is DESTROYED!", Toast.LENGTH_SHORT).show();
        mediaPlayer.release();
        mediaPlayer = null;
        super.onDestroy();
    }
}
