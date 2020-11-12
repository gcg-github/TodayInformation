package com.gcg.todayinformation.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.gcg.todayinformation.R;
import com.gcg.todayinformation.main.beijing.view.BeiJingFragment;
import com.gcg.todayinformation.main.hangzhou.view.HangZhouFragment;
import com.gcg.todayinformation.main.shanghai.view.ShangHaiFragment;
import com.gcg.todayinformation.main.shenzhen.view.ShenZhenFragment;
import com.gcg.todayinformation.mvp.base.BaseMvpPresenter;
import com.gcg.todayinformation.mvp.view.IMvpView;

public class IMainPresenter extends BaseMvpPresenter<IMainContract.IView> implements IMainContract.IPresenter {

    private static final int MaxFrag = 4;

    @CityType
    private int mCurFragIndex;

    private Fragment[] mFragments = new Fragment[MaxFrag];

    public IMainPresenter(IMvpView view) {
        super(view);
    }

    @Override
    protected IMainContract.IView getEmptyView() {
        return IMainContract.emptyView;
    }

    @Override
    public void initHomeFragment() {
        setCurFragIndex(CityType.ShangHai);
        replaceFragment(mCurFragIndex);
    }

    @Override
    public void switchFragment(int id) {
        switch (id){
            case R.id.rb_rg_act_main_shhz_sh:
                setCurFragIndex(CityType.ShangHai);
                break;
            case R.id.rb_rg_act_main_shhz_hz:
                setCurFragIndex(CityType.HangZhou);
                break;
            case R.id.rb_rg_act_main_bjsz_bj:
                setCurFragIndex(CityType.BeiJing);
                break;
            case R.id.rb_rg_act_main_bjsz_sz:
                setCurFragIndex(CityType.ShenZhen);
                break;
        }
        replaceFragment(mCurFragIndex);
    }

    private void setCurFragIndex(int index){
        mCurFragIndex = index;
    }

    private void replaceFragment(@CityType int curFragIndex) {
        for (int i=CityType.ShangHai; i<MaxFrag; i++){
            if (i != curFragIndex){
                if (mFragments[i] != null){
                    hideFragment(mFragments[i]);
                }
            }
        }
        if (mFragments[curFragIndex] != null){
            showFragment(mFragments[curFragIndex]);
        }else{
            addFragment(curFragIndex);
        }
    }

    private void addFragment(@CityType int index) {
        Fragment fragment = null;
        switch (index){
            case CityType.ShangHai:
                fragment = new ShangHaiFragment();
                break;
            case CityType.HangZhou:
                fragment = new HangZhouFragment();
                break;
            case CityType.BeiJing:
                fragment = new BeiJingFragment();
                break;
            case CityType.ShenZhen:
                fragment = new ShenZhenFragment();
                break;
        }
        mFragments[index] = fragment;
        getView().addFragment(fragment);
    }

    private void showFragment(@NonNull Fragment fragment) {
        if (fragment!=null && fragment.isAdded())
            getView().showFragment(fragment);
    }

    private void hideFragment(@NonNull Fragment fragment) {
        if (fragment!=null && fragment.isVisible())
            getView().hideFragment(fragment);
    }
}
