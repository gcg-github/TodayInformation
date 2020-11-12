package com.gcg.todayinformation.splash;

import android.net.Uri;
import android.widget.TextView;
import android.widget.VideoView;

import com.gcg.todayinformation.main.MainActivity;
import com.gcg.todayinformation.R;
import com.gcg.todayinformation.base.BaseActivity;
import com.gcg.todayinformation.base.InjectView;

import butterknife.BindView;

@InjectView(layoutId = R.layout.activity_splash)
public class SplashActivity extends BaseActivity implements ISplashContract.IView{

    @BindView(R.id.activity_splash_videoview)
    public VideoView mVideoview;
    @BindView(R.id.activity_splash_textview)
    public TextView mTextView;

    private ISplashContract.IPresenter mSplashPresenter = new SplashPresenter(this);

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
        mSplashPresenter.initTimer();
    }

    @Override
    public void onTimerTicker(int ticker) {
        mTextView.setText("跳过("+ticker+"s)");
    }

    @Override
    public void onTimerFinish() {
        MainActivity.start(SplashActivity.this);
        SplashActivity.this.finish();
    }
}
