package com.gcg.todayinformation.splash;

import com.gcg.todayinformation.mvp.presenter.ILifeCircle;
import com.gcg.todayinformation.mvp.proxy.MvpController;
import com.gcg.todayinformation.mvp.view.IMvpView;

public interface ISplashContract {

    interface IView extends IMvpView{
        void onTimerTicker(int ticker);
        void onTimerFinish();
    }

    interface IPresenter extends ILifeCircle{
        void initTimer();
    }

    IView emptyView = new IView() {
        @Override
        public void onTimerTicker(int ticker) {

        }

        @Override
        public void onTimerFinish() {

        }

        @Override
        public MvpController getMvpController() {
            return null;
        }
    };

}
