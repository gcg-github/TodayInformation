package com.gcg.todayinformation.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RadioGroup;
import androidx.fragment.app.Fragment;
import com.gcg.todayinformation.R;
import com.gcg.todayinformation.base.BaseActivity;
import com.gcg.todayinformation.base.InjectView;
import butterknife.BindView;
import butterknife.OnClick;

@InjectView(layoutId = R.layout.activity_main)
public class MainActivity extends BaseActivity implements IMainContract.IView{
    @BindView(R.id.rg_act_main_sh_hz)
    public RadioGroup rg_act_main_sh_hz;
    @BindView(R.id.rg_act_main_bj_sz)
    public RadioGroup rg_act_main_bj_sz;

    private boolean isShowSHHZ;
    private IMainContract.IPresenter mPresenter = new IMainPresenter(this);

    @OnClick(R.id.floatBtn_act_main)
    public void onClickFloatBtn(){
        isShowSHHZ = !isShowSHHZ;
        if (isShowSHHZ){
            changeAnim(rg_act_main_sh_hz, rg_act_main_bj_sz);
            mPresenter.switchFragment(rg_act_main_sh_hz.getCheckedRadioButtonId());
        }else{
            changeAnim(rg_act_main_bj_sz, rg_act_main_sh_hz);
            mPresenter.switchFragment(rg_act_main_bj_sz.getCheckedRadioButtonId());
        }
    }

    @OnClick({R.id.rb_rg_act_main_shhz_sh,
            R.id.rb_rg_act_main_shhz_hz,
            R.id.rb_rg_act_main_bjsz_bj,
            R.id.rb_rg_act_main_bjsz_sz})
    public void onClickCity(View view){
        mPresenter.switchFragment(view.getId());
    }

    /**
     * 底部导航栏切换动画
     */
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
        mPresenter.initHomeFragment();
    }

    /**
     * mainactivity 快捷启动方式
     */
    public static void start(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void hideFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().hide(fragment).commit();
    }

    @Override
    public void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().show(fragment).commit();
    }

    @Override
    public void addFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.fl_act_main_content, fragment).commit();
    }
}