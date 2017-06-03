package com.ubidel.ubicash.ui.auth;

import android.content.Context;
import android.text.TextUtils;

import com.ubidel.ubicash.R;
import com.ubidel.ubicash.api.UbiService;
import com.ubidel.ubicash.api.model.SignInData;
import com.ubidel.ubicash.api.model.SignUpInResult;
import com.ubidel.ubicash.ui.mvp.BasePresenter;
import com.ubidel.ubicash.util.PrefUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by bowenwang on 2017/6/3.
 */

public class LandingPresenter extends BasePresenter<LandingView> {

    private final Context context;

    public LandingPresenter(Context context) {
        super(context);
        this.context = context;
    }

    public void attemptLogin(String phone, String password) {
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            getView().showPasswordInputError();
        }

        if (TextUtils.isEmpty(phone)) {
            getView().showPhoneInputError(context.getString(R.string.error_field_required));
        } else if (!isPhoneValid(phone)) {
            getView().showPhoneInputError(context.getString(R.string.error_invalid_phone));
        }

        // Inputs are valid finally
        SignInData signInData = new SignInData();
        signInData.setPhone(phone);
        signInData.setPassword(password);
        UbiService.getEndPoints().signIn(signInData)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SignUpInResult>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull SignUpInResult signUpInResult) {
                        if (!TextUtils.isEmpty(signUpInResult.getError())) {
                            getView().showErrorMessage(context, signUpInResult.getError());
                        } else {
                            PrefUtils.setToken(context, signUpInResult.getTokenId());
                            PrefUtils.setUserDetail(context, signUpInResult.getUserDetails());
                            getView().redirectToMainPage();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Timber.e(e.getMessage());
                        getView().hideWaitingDialog();
                        getView().showErrorMessage(context, e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        getView().hideWaitingDialog();
                    }
                });
    }

    public void attemptSignUp(String phone, String password) {

    }


    private boolean isPhoneValid(String phone) {
        //TODO: Replace this with your own logic
        return phone.length() > 10;
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }


}
