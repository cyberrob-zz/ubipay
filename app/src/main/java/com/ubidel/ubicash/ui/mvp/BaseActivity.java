package com.ubidel.ubicash.ui.mvp;

import android.os.Bundle;
import com.hannesdorfmann.mosby3.mvp.MvpActivity;
import com.hannesdorfmann.mosby3.mvp.MvpView;

import butterknife.ButterKnife;

/**
 * Created by bowenwang on 2017/6/2.
 */

public abstract class BaseActivity<V extends MvpView, P extends BasePresenter<V>> extends MvpActivity<V, P> {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
    }

    public abstract int getLayout();
}
