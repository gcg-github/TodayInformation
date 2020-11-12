package com.gcg.todayinformation.splash;

import com.gcg.todayinformation.mvp.base.BaseMvpPresenter;
import com.gcg.todayinformation.mvp.view.IMvpView;

public class SplashPresenter extends BaseMvpPresenter<ISplashContract.IView> implements ISplashContract.IPresenter{

    private CustomDownTimeTicker downTimeTicker;

    public SplashPresenter(IMvpView view) {
        super(view);
    }

    @Override
    protected ISplashContract.IView getEmptyView() {
        return ISplashContract.emptyView;
    }

    @Override
    public void initTimer() {
        downTimeTicker = new CustomDownTimeTicker(5, new CustomDownTimeTicker.ITimeHandler() {
            @Override
            public void onTicker(int curTime) {
                getView().onTimerTicker(curTime);
            }

            @Override
            public void onFinish() {
                getView().onTimerFinish();
            }
        });
        downTimeTicker.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (downTimeTicker != null){
            downTimeTicker.cancel();
        }
    }
}
