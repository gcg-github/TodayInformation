package com.gcg.todayinformation.mvp.proxy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gcg.todayinformation.mvp.presenter.ILifeCircle;
import com.gcg.todayinformation.mvp.view.IMvpView;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Create by gcg 2020/11/12
 * 静态代理类
 * 实现P与V的生命周期相关联
 */
public class MvpController implements ILifeCircle {

    Set<ILifeCircle> lifeCircles = new HashSet<>();

    @Override
    public void onAttach(Context context) {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle lifeCircle = iterator.next();
            if (lifeCircle != null){
                lifeCircle.onAttach(context);
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState, Intent intent, Bundle argments) {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle lifeCircle = iterator.next();
            if (lifeCircle != null){
                lifeCircle.onCreate(savedInstanceState, intent, argments);
            }
        }
    }

    @Override
    public void onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, View view) {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle lifeCircle = iterator.next();
            if (lifeCircle != null){
                lifeCircle.onCreateView(inflater, container, savedInstanceState, view);
            }
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState, Intent intent, Bundle argments) {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle lifeCircle = iterator.next();
            if (lifeCircle != null){
                lifeCircle.onActivityCreated(savedInstanceState, intent, argments);
            }
        }
    }

    @Override
    public void onStart() {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle lifeCircle = iterator.next();
            if (lifeCircle != null){
                lifeCircle.onStart();
            }
        }
    }

    @Override
    public void onResume() {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle lifeCircle = iterator.next();
            if (lifeCircle != null){
                lifeCircle.onResume();
            }
        }
    }

    @Override
    public void onPause() {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle lifeCircle = iterator.next();
            if (lifeCircle != null){
                lifeCircle.onPause();
            }
        }
    }

    @Override
    public void onStop() {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle lifeCircle = iterator.next();
            if (lifeCircle != null){
                lifeCircle.onStop();
            }
        }
    }

    @Override
    public void onDestroyView() {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle lifeCircle = iterator.next();
            if (lifeCircle != null){
                lifeCircle.onDestroyView();
            }
        }
    }

    @Override
    public void onDestroy() {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle lifeCircle = iterator.next();
            if (lifeCircle != null){
                lifeCircle.onDestroy();
            }
        }
    }

    @Override
    public void onDetach() {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle lifeCircle = iterator.next();
            if (lifeCircle != null){
                lifeCircle.onDetach();
            }
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle lifeCircle = iterator.next();
            if (lifeCircle != null){
                lifeCircle.onNewIntent(intent);
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle lifeCircle = iterator.next();
            if (lifeCircle != null){
                lifeCircle.onActivityResult(requestCode, resultCode, data);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle lifeCircle = iterator.next();
            if (lifeCircle != null){
                lifeCircle.onSaveInstanceState(outState);
            }
        }
    }

    @Override
    public void attachView(IMvpView view) {

    }

    public void addLifeCircle(ILifeCircle lifeCircle) {
        lifeCircles.add(lifeCircle);
    }
}
