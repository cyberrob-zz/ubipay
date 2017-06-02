package com.ubidel.ubicash;

import android.app.Application;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

/**
 * Created by bowenwang on 2017/5/31.
 */

public class UbiApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Fabric.with(this, new Crashlytics());
    }
}
