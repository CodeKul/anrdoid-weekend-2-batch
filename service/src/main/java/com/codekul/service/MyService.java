package com.codekul.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.IBinder;

import java.io.File;
import java.io.IOException;

public class MyService extends Service {

    private MediaPlayer player;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
       return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player = new MediaPlayer();
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC),"a.mp3");
        try {
            player.setDataSource(file.getAbsolutePath());
            player.prepare();
            player.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        player.stop();
        player.release();
    }
}
