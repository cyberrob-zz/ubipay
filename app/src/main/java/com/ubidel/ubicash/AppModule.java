package com.ubidel.ubicash;

import android.app.Application;
import android.preference.PreferenceManager;

import com.ubidel.ubicash.api.UbiService;
import com.ubidel.ubicash.util.PrefUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bowenwang on 2017/6/3.
 */

@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return application;
    }

    @Provides
    @Singleton
    UbiService providesUbiService() {
        return new UbiService();
    }

    @Provides
    @Singleton
    PrefUtils providesPrefUtils() {
        return new PrefUtils();
    }
}
