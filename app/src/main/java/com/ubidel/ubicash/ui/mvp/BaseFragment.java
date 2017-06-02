package com.ubidel.ubicash.ui.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.hannesdorfmann.mosby3.mvp.MvpView;

import butterknife.ButterKnife;

/**
 * Created by bowenwang on 2017/6/2.
 */

public abstract class BaseFragment<V extends MvpView, P extends BasePresenter<V>> extends MvpFragment<V, P> {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View view = inflater.inflate(getLayout(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public abstract int getLayout();
}
