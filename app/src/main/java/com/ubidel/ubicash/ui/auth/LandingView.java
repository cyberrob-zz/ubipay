package com.ubidel.ubicash.ui.auth;

import com.ubidel.ubicash.ui.mvp.BaseView;

/**
 * Created by bowenwang on 2017/6/3.
 */

public interface LandingView extends BaseView {

    void showPhoneInputError(String errorString);

    void showPasswordInputError();

    void redirectToMainPage();
}
