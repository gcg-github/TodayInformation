package com.gcg.todayinformation.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.gcg.todayinformation.mvp.view.LifeCircleMvpFragment;

import butterknife.ButterKnife;

public abstract class BaseFragment extends LifeCircleMvpFragment {

    protected Context mContext;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = null;

        //处理自定义注解InjectView
        InjectView injectView = getClass().getAnnotation(InjectView.class);
        if (injectView != null){
            int layoutId = injectView.layoutId();
            if (layoutId > 0){
                view = inflater.inflate(layoutId, container, false);
                ButterKnife.bind(view);
                afterInitView();
                return view;
            }else{
                throw new RuntimeException("layoutid must upper than 0!");
            }
        }else{
            throw new RuntimeException(getClass().getSimpleName()+" lose of InjectView annotation!");
        }
    }

    protected abstract void afterInitView();
}
