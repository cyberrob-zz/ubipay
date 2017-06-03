package com.ubidel.ubicash.ui;

import com.ubidel.ubicash.ui.mvp.BaseView;

/**
 * Created by bowenwang on 2017/6/2.
 */

public interface MainView extends BaseView {

    void showHomeView();

    void showSupportView();

    void showCashOutLocationView();

    void showLogoutView();

    void redirectToSignInView();

    void shownAsSignIn();
}
