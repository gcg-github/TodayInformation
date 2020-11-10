package com.gcg.todayinformation;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //处理自定义注解InjectView
        InjectView injectView = getClass().getAnnotation(InjectView.class);
        if (injectView != null){
            int layoutId = injectView.layoutId();
            if (layoutId > 0){
                setContentView(layoutId);
                ButterKnife.bind(this);
                afterInitView();
            }else{
                throw new RuntimeException("layoutid must upper than 0!");
            }
        }else{
            throw new RuntimeException(getClass().getSimpleName()+" lose of InjectView annotation!");
        }
    }

    protected abstract void afterInitView();
}
