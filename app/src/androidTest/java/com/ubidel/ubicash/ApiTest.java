package com.ubidel.ubicash;

import android.text.TextUtils;
import android.util.Log;

import com.ubidel.ubicash.api.UbiService;
import com.ubidel.ubicash.api.model.HttpResponse;
import com.ubidel.ubicash.api.model.QRCodeObject;
import com.ubidel.ubicash.api.model.SignInData;
import com.ubidel.ubicash.api.model.SignUpData;
import com.ubidel.ubicash.api.model.SignUpInResult;
import com.ubidel.ubicash.api.model.SupportInfo;
import com.ubidel.ubicash.api.model.Transaction;
import com.ubidel.ubicash.api.model.UserDetails;

import org.junit.Test;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by bowenwang on 2017/6/2.
 */

public class ApiTest {

    private static String accessToken;

    @Test
    public void testSignUp() throws Exception {
        final SignUpData signUpData = new SignUpData();
        signUpData.setFirstName("test");
        signUpData.setLastName("user");
        signUpData.setPassword("im-test-user");
        signUpData.setPhone(1234567890);
        signUpData.setSex("M");
        signUpData.setType(1);
        UbiService.getEndPoints().signUp(signUpData)
                .subscribe(new Observer<SignUpInResult>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull SignUpInResult signUpInResult) {
                        assertNotNull(signUpInResult);
                        accessToken = signUpInResult.getTokenId();
                        assertNotNull(accessToken);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("TEST_SIGN_UP", e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Test
    public void testSignIn() throws Exception {
        SignInData signInData = new SignInData();
        signInData.setPhone(123456789);
        signInData.setPassword("im-test-user");
        UbiService.getEndPoints().signIn(signInData)
                .subscribe(new Observer<SignUpInResult>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull SignUpInResult signUpInResult) {
                        assertNotNull(signUpInResult);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("TEST_SIGN_IN", e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Test
    public void testSignOut() throws Exception {
        if (TextUtils.isEmpty(accessToken)) {
            assertNotNull(accessToken);
        }
        UbiService.getEndPoints().signOut(accessToken)
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Boolean signOutSucceed) {
                        assertThat(signOutSucceed, is(true));
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("TEST_SIGN_OUT", e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Test
    public void testGetProfile() throws Exception {
        if (TextUtils.isEmpty(accessToken)) {
            assertNotNull(accessToken);
        }
        UbiService.getEndPoints().getProfile(accessToken)
                .subscribe(new Observer<UserDetails>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull UserDetails userDetails) {
                        assertNotNull(userDetails);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("TEST_GET_PROFILE", e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Test
    public void testVerifyAccount() throws Exception {
        if (TextUtils.isEmpty(accessToken)) {
            assertNotNull(accessToken);
        }
        UbiService.getEndPoints().verifyAccount(accessToken, "12345")
                .subscribe(new Observer<HttpResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull HttpResponse httpResponse) {
                        assertThat(httpResponse.getStatus(), is(true));
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("TEST_VERIFY_ACCOUNT", e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Test
    public void testGetAllUsers() throws Exception {
        if (TextUtils.isEmpty(accessToken)) {
            assertNotNull(accessToken);
        }

        UbiService.getEndPoints().getUsers(accessToken)
                .subscribe(new Observer<List<UserDetails>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<UserDetails> userDetails) {
                        assertNotNull(userDetails);
                        assertThat(userDetails.size(), not(0));
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("TEST_GET_USERS", e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Test
    public void testGetQRCode() throws Exception {
        if (TextUtils.isEmpty(accessToken)) {
            assertNotNull(accessToken);
        }
        UbiService.getEndPoints().getQRCodeString(accessToken, "im-test-user")
                .subscribe(new Observer<QRCodeObject>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull QRCodeObject qrCodeObject) {
                        assertNotNull(qrCodeObject);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("TEST_GET_QRCODE", e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Test
    public void testGetTransaction() throws Exception {
        if (TextUtils.isEmpty(accessToken)) {
            assertNotNull(accessToken);
        }
        UbiService.getEndPoints().getTransactions(accessToken)
                .subscribe(new Observer<List<Transaction>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<Transaction> transactions) {
                        assertNotNull(transactions);
                        assertThat(transactions.size(), not(0));
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("TEST_GET_TRANSACTIONS", e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    String qrCodeString = ""; // find out is it another account's qrcode

    @Test
    public void testChargeUser() throws Exception {
        if (TextUtils.isEmpty(accessToken)) {
            assertNotNull(accessToken);
        }
        UbiService.getEndPoints().chargeUser(accessToken, qrCodeString, 12345)
                .subscribe(new Observer<HttpResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull HttpResponse httpResponse) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("TEST_CHARGE_USER", e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    String transactionId = "";

    @Test
    public void testRefundToUser() throws Exception {
        if (TextUtils.isEmpty(accessToken)) {
            assertNotNull(accessToken);
        }
        UbiService.getEndPoints().refundToUser(accessToken, transactionId, "im-test-user")
                .subscribe(new Observer<HttpResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull HttpResponse httpResponse) {
                        assertTrue(httpResponse.getStatus());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("TEST_REFUND_TO_USER", e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Test
    public void testGetSupportInfo() throws Exception {
        if (TextUtils.isEmpty(accessToken)) {
            assertNotNull(accessToken);
        }
        UbiService.getEndPoints().getSupportInfo(accessToken)
                .subscribe(new Observer<SupportInfo>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull SupportInfo supportInfo) {
                        assertNotNull(supportInfo);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("TEST_GET_SUPPORT_INFO", e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
