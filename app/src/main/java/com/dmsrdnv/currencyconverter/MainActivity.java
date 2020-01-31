package com.dmsrdnv.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;

public class MainActivity extends AppCompatActivity {

    public MediaPlayer mediaPlayer;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();
        final Runnable r = new Runnable() {
            public void run() {
                startPlaying(getApplicationContext(), "https://ru.megapesni.com/get/No1P-TUp5STilSUqhv6qOA/1580539795/fe6a462f/mjevl-patamushka.mp3");
                handler.postDelayed(this, 1000);
            }
        };
        handler.postDelayed(r, 1000);

    }

    public void startPlaying(final Context context, String url) {
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare();
        } catch (IOException ignored) {
            Toast.makeText(context, "HAHA", Toast.LENGTH_LONG).show();
        }
        mediaPlayer.start();
    }
}