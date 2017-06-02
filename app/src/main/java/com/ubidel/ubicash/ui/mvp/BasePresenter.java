package com.ubidel.ubicash.ui.mvp;

import android.content.Context;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.hannesdorfmann.mosby3.mvp.MvpNullObjectBasePresenter;

/**
 * Created by bowenwang on 2017/6/2.
 */

public class BasePresenter<V extends MvpView> extends MvpNullObjectBasePresenter<V> {
    private Context context;

    public BasePresenter(final Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }
}
