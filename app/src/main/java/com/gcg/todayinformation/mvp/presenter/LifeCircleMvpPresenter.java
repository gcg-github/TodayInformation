package com.gcg.todayinformation.mvp.presenter;

import com.gcg.todayinformation.mvp.view.IMvpView;

import java.lang.ref.WeakReference;

/**
 * 抽象中介者，继承自ILifeCircle ，用于保存和获取View 引用
 * */
public abstract class LifeCircleMvpPresenter<T extends IMvpView> implements ILifeCircle{

    private WeakReference<T> weakReference;

    public LifeCircleMvpPresenter(IMvpView view) {
        super();
        attachView(view);
    }

    @Override
    public void attachView(IMvpView view) {
        if (weakReference == null)
            weakReference = new WeakReference(view);
        else{
            T v = weakReference.get();
            if (v != view){
                weakReference = new WeakReference(view);
            }
        }
        if (view != null)
            view.getMvpController().addLifeCircle(this);
    }

    @Override
    public void onDestroy() {
        weakReference = null;
    }

    public T getView(){
        T view = weakReference!=null?weakReference.get():null;
        if (view == null)
            return getEmptyView();

        return view;
    }

    protected abstract T getEmptyView();
}
