package com.gcg.todayinformation.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.gcg.todayinformation.mvp.proxy.MvpController;

public abstract class LifeCircleMvpFragment extends Fragment implements IMvpView{

    private MvpController mvpController;

    @Override
    public MvpController getMvpController() {
        if (mvpController == null)
            mvpController = new MvpController();
        return mvpController;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        MvpController controller = getMvpController();
        if (controller != null)
            controller.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle argments = getArguments();
        if (argments == null)
            argments = new Bundle();
        MvpController controller = getMvpController();
        if (controller != null)
            controller.onCreate(savedInstanceState, new Intent(), argments);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MvpController controller = getMvpController();
        if (controller != null)
            controller.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle argments = getArguments();
        if (argments == null)
            argments = new Bundle();
        MvpController controller = getMvpController();
        if (controller != null)
            controller.onActivityCreated(savedInstanceState, new Intent(), argments);
    }

    @Override
    public void onStart() {
        super.onStart();
        MvpController controller = getMvpController();
        if (controller != null)
            controller.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        MvpController controller = getMvpController();
        if (controller != null)
            controller.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        MvpController controller = getMvpController();
        if (controller != null)
            controller.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        MvpController controller = getMvpController();
        if (controller != null)
            controller.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        MvpController controller = getMvpController();
        if (controller != null)
            controller.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MvpController controller = getMvpController();
        if (controller != null)
            controller.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        MvpController controller = getMvpController();
        if (controller != null)
            controller.onDetach();
    }
}
