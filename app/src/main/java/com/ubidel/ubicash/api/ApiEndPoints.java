package com.ubidel.ubicash.api;

import com.ubidel.ubicash.api.model.QRCodeObject;
import com.ubidel.ubicash.api.model.SigInData;
import com.ubidel.ubicash.api.model.SignUpData;
import com.ubidel.ubicash.api.model.SignUpInResult;
import com.ubidel.ubicash.api.model.HttpResponse;
import com.ubidel.ubicash.api.model.SupportInfo;
import com.ubidel.ubicash.api.model.Transaction;
import com.ubidel.ubicash.api.model.UserDetails;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Tiny on 3/25/16.
 */
public interface ApiEndPoints {

    @POST("signup")
    Observable<SignUpInResult> SignUp(@Body SignUpData signUpData);

    @POST("signin")
    Observable<SignUpInResult> SignIn(@Body SigInData signinData);

    @GET("auth/signout")
    Observable<Boolean> SignOut(@Header("x-access-token") String accessToken);

    @GET("auth/profile")
    Observable<UserDetails> getProfile(@Header("x-access-token") String accessToken);

    @POST("auth/verify")
    Observable<HttpResponse> verifyAccount(@Header("x-access-token") String accessToken, @Field("verifyPass") String code);

    @GET("auth/v/profile/users")
    Observable<List<UserDetails>> getUserProfile(@Header("x-access-token") String accessToken);

    /**
     * Get transactions within a month
     * @return
     */
    @GET("auth/v/transactions")
    Observable<List<Transaction>> getTransactions(@Header("x-access-token") String accessToken);

    @POST("auth/v/profile/show")
    Observable<QRCodeObject> getQRCodeString(@Header("x-access-token") String accessToken, @Field("password") String password);

    @POST("auth/v/charge")
    Observable<HttpResponse> chargeUser(@Header("x-access-token") String accessToken, @Field("qrCode") String qrCode, @Field("amount") double amount);

    // signed in merchant refunding payment(user taking payment must be type 2)
    @POST("auth/v/refund")
    Observable<HttpResponse> refundToUser(@Header("x-access-token") String accessToken, @Field("transactionId") String transactionId, @Field("password") String password);

    @GET("auth/info")
    Observable<SupportInfo> getSupportInfo(@Header("x-access-token") String accessToken);

}