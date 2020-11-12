package com.gcg.todayinformation.mvp.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gcg.todayinformation.mvp.view.IMvpView;

/*
* 抽象中介者(presenter)
* ILifeCircle的生命周期是很全的，汇总了activity和fragment的生命周期
* */
public interface ILifeCircle {

    void onAttach(Context context);

    void onCreate(Bundle savedInstanceState, Intent intent, Bundle argments);

    void onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, View view);

    void onActivityCreated(Bundle savedInstanceState, Intent intent, Bundle argments);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroyView();

    void onDestroy();

    void onDetach();

    void onNewIntent(Intent intent);

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onSaveInstanceState(Bundle outState);

    void attachView(IMvpView view);
}
