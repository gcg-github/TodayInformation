package com.gcg.todayinformation;

import android.net.Uri;
import android.widget.TextView;
import android.widget.VideoView;

import butterknife.BindView;

@InjectView(layoutId = R.layout.activity_splash)
public class SplashActivity extends BaseActivity {

    @BindView(R.id.activity_splash_videoview)
    public VideoView mVideoview;
    @BindView(R.id.activity_splash_textview)
    public TextView mTextView;

    private CustomDownTimeTicker downTimeTicker;

    @Override
    protected void afterInitView() {
        initView();
        initTimer();
    }

    private void initView(){
        mVideoview.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.splash));
        mVideoview.setOnPreparedListener(mp -> mp.start());
        mVideoview.setOnCompletionListener(mp -> mp.start());

        mTextView.setOnClickListener(v -> {
            MainActivity.start(SplashActivity.this);
            SplashActivity.this.finish();
        });
    }

    private void initTimer(){
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
