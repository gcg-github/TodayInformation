package com.gcg.todayinformation;

import android.os.Handler;

public class CustomDownTimeTicker implements Runnable{
    private ITimeHandler mTimeHandler;
    private int mTime;
    private Handler mHandler;
    private boolean isRunning;
    private int curTime;

    //时间递减器：每秒回调一次，观察者设计模式
    //1.传入总时间、观察者
    //2.时间按秒递减并回调观察者
    //3.时间为0时回调完成状态
    public CustomDownTimeTicker(int time, ITimeHandler timeHandler){
        this.mTime = time;
        this.mTimeHandler = timeHandler;
        this.curTime = time;
        isRunning = false;
    }

    public void start(){
        if (!isRunning){
            isRunning = true;
            mHandler = new Handler();
            mHandler.post(this);
        }
    }

    public void cancel(){
        isRunning = false;
        if (mHandler != null) {
            mHandler.removeCallbacks(this);
            mHandler = null;
        }
        mTime = 0;
        mTimeHandler = null;
    }

    @Override
    public void run() {
        if (isRunning){
            if (curTime != 0 && mTimeHandler != null){
                mTimeHandler.onTicker(curTime);
                curTime--;
                mHandler.postDelayed(this, 1000);
            }else if (curTime == 0 && mTimeHandler != null){
                mTimeHandler.onFinish();
                cancel();
            }
        }
    }

    public interface ITimeHandler {
        void onTicker(int curTime);
        void onFinish();
    }
}
