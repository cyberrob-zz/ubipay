package com.ubidel.ubicash;

import com.ubidel.ubicash.api.UbiService;
import com.ubidel.ubicash.util.PrefUtils;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by bowenwang on 2017/6/3.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(UbiApp ubiApp);

    void inject(UbiService ubiService);

    void inject(PrefUtils prefUtils);
}
