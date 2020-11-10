package com.gcg.todayinformation;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private VideoView mVideoview;
    private TextView mTextView;
    private CustomDownTimeTicker downTimeTicker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mVideoview = findViewById(R.id.activity_splash_videoview);
        mVideoview.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.splash));
        mVideoview.setOnPreparedListener(mp -> mp.start());

        mVideoview.setOnCompletionListener(mp -> mp.start());

        mTextView = findViewById(R.id.activity_splash_textview);
        mTextView.setOnClickListener(v -> {
            MainActivity.start(SplashActivity.this);
            SplashActivity.this.finish();
        });
        downTimeTicker = new CustomDownTimeTicker(5, new CustomDownTimeTicker.ITimeHandler() {
            @Override
            public void onTicker(int curTime) {
                mTextView.setText(curTime + "秒");
            }

            @Override
            public void onFinish() {
                mTextView.setText("跳过");
            }
        });
        downTimeTicker.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        downTimeTicker.cancel();
    }
}
