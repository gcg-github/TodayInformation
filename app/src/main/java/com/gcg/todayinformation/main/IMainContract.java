package com.gcg.todayinformation.main;

import androidx.fragment.app.Fragment;

import com.gcg.todayinformation.mvp.presenter.ILifeCircle;
import com.gcg.todayinformation.mvp.proxy.MvpController;
import com.gcg.todayinformation.mvp.view.IMvpView;

public interface IMainContract {
    interface IView extends IMvpView{

        void hideFragment(Fragment fragment);

        void showFragment(Fragment fragment);

        void addFragment(Fragment fragment);
    }

    interface IPresenter extends ILifeCircle{
        void initHomeFragment();

        void switchFragment(int id);
    }

    IView emptyView = new IView() {
        @Override
        public void hideFragment(Fragment fragment) {

        }

        @Override
        public void showFragment(Fragment fragment) {

        }

        @Override
        public void addFragment(Fragment fragment) {

        }

        @Override
        public MvpController getMvpController() {
            return null;
        }
    };
}
