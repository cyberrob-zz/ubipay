package com.ubidel.ubicash.ui.mvp;

import android.content.Context;

import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Created by bowenwang on 2017/6/2.
 */

public interface BaseView extends MvpView {
    void showErrorMessage(final Context context, final String message);

    void showWaitingDialog(final Context context);

    void hideWaitingDialog();
}
