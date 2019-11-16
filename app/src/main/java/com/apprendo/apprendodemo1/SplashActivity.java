package com.apprendo.apprendodemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.VideoView;

public class SplashActivity extends AppCompatActivity {

    VideoView videoView;

    private final int splash_screen_time=3000; //in milliseconds
    Thread splashTread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //getSupportActionBar().hide ();

        videoView = (VideoView)findViewById (R.id.videoView);

        Uri video =Uri.parse("android.resource://" + getPackageName () +"/" + R.raw.video);

        videoView.setVideoURI(video);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()  {
            @Override
            public void onCompletion (MediaPlayer mediaPlayer)  {
                if(isFinishing())
                    return;

                startActivity(new Intent (SplashActivity.this, MainActivity.class));
                finish ();
            }

        });

        videoView.start();

        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        wait(splash_screen_time);
                    }
                } catch (InterruptedException e) {

                } finally {
                    Intent i = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        splashTread.start();
    }
}
