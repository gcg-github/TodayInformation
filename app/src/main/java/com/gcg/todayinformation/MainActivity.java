package com.gcg.todayinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@InjectView(layoutId = R.layout.activity_main)
public class MainActivity extends BaseActivity {
    @BindView(R.id.rg_act_main_sh_hz)
    public RadioGroup rg_act_main_sh_hz;
    @BindView(R.id.rg_act_main_bj_sz)
    public RadioGroup rg_act_main_bj_sz;

    private boolean isShowSHHZ;

    @OnClick(R.id.floatBtn_act_main)
    public void onClickFloatBtn(){
        isShowSHHZ = !isShowSHHZ;
        if (isShowSHHZ){
            changeAnim(rg_act_main_sh_hz, rg_act_main_bj_sz);
        }else{
            changeAnim(rg_act_main_bj_sz, rg_act_main_sh_hz);
        }
    }

    private void changeAnim(RadioGroup show, RadioGroup hide) {
        //先清除上一次动画
        hide.clearAnimation();
        //设置这一次动画
        Animation animationhide = AnimationUtils.loadAnimation(this, R.anim.rg_act_main_anim_hide);
        hide.startAnimation(animationhide);
        hide.setVisibility(View.GONE);

        //先清除上一次动画
        show.clearAnimation();
        //设置这一次动画
        Animation animationShow = AnimationUtils.loadAnimation(this, R.anim.rg_act_main_anim_show);
        show.startAnimation(animationShow);
        show.setVisibility(View.VISIBLE);
    }

    @Override
    protected void afterInitView() {
        isShowSHHZ = true;
        rg_act_main_sh_hz.setVisibility(View.VISIBLE);
        rg_act_main_bj_sz.setVisibility(View.GONE);
    }

    public static void start(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}