package com.ubidel.ubicash.ui;

import android.content.Context;
import android.text.TextUtils;

import com.ubidel.ubicash.ui.mvp.BasePresenter;
import com.ubidel.ubicash.util.PrefUtils;

/**
 * Created by bowenwang on 2017/6/2.
 */

public class MainPresenter extends BasePresenter<MainView> {

    private final Context context;

    public MainPresenter(Context context) {
        super(context);
        this.context = context;
    }

    public void checkAccount() {
        if (TextUtils.isEmpty(PrefUtils.getToken(context)) &&
                PrefUtils.getUserDetails(context) == null) {
            getView().redirectToSignInView();
        } else {
            getView().shownAsSignIn();
        }
    }

    public void clearCredential() {
        PrefUtils.setToken(context, "");
        PrefUtils.setUserDetail(context, null);
    }
}
