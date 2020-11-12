package com.gcg.todayinformation.mvp.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.gcg.todayinformation.mvp.proxy.MvpController;

/**
 * Create by gcg 2020/11/12
 * 抽象同事 维护P层生命周期
 * 使用静态代理使P层和V层的生命周期相关联，这样就不需要每个具体同事去关联具体中介的生命周期了
 */
public abstract class LifeCircleMvpActivity extends AppCompatActivity implements IMvpView{

    private MvpController mvpController;

    @Override
    public MvpController getMvpController() {
        if (mvpController == null)
            mvpController = new MvpController();
        return mvpController;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent == null)
            intent = new Intent();
        MvpController controller = getMvpController();
        if (controller != null)
            controller.onCreate(savedInstanceState, intent, null);
    }

    @Override
    protected void onStart() {
        super.onStart();
        MvpController controller = getMvpController();
        if (controller != null)
            controller.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        MvpController controller = getMvpController();
        if (controller != null)
            controller.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        MvpController controller = getMvpController();
        if (controller != null)
            controller.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        MvpController controller = getMvpController();
        if (controller != null)
            controller.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MvpController controller = getMvpController();
        if (controller != null)
            controller.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        MvpController controller = getMvpController();
        if (controller != null)
            controller.onNewIntent(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MvpController controller = getMvpController();
        if (controller != null)
            controller.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        MvpController controller = getMvpController();
        if (controller != null)
            controller.onSaveInstanceState(outState);
    }
}
