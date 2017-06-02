package com.ubidel.ubicash.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.ubidel.ubicash.api.model.UserDetails;


/**
 * Created by bowenwang on 2016/1/1.
 */
public class PrefUtils {

    private static com.securepreferences.SecurePreferences securePreferences;

    public static SharedPreferences getDefaultPreference(Context context) {
        if (securePreferences == null)
            securePreferences = new com.securepreferences.SecurePreferences(context);
        return securePreferences;
    }

    // region Key Def
    private static final String TOKEN = "TOKEN";
    private static final String USER_DETAIL = "USER_DETAIL";

    private static final String SIGN_IN_RESULT = "AUTH_SIGN_IN_RESULT";
    private static final String USER_DATA = "USER_DATA";
    private static final String TRIAL_USER_DATA = "TRIAL_USER_DATA";
    //
    private static final String TRIAL_PLAYER_2 = "TRIAL_PLAYER_2";
    private static final String TRIAL_PLAYER_3 = "TRIAL_PLAYER_3";
    private static final String TRIAL_PLAYER_4 = "TRIAL_PLAYER_4";

    private static final String NAV_ID = "NAV_ID";
    private static final String LAST_NAV_ID = "LAST_NAV_ID";

    // endregion

    public static void setToken(Context context, String token) {
        getDefaultPreference(context).edit()
                .putString(TOKEN, token).commit();
    }

    public static String getToken(Context context) {
        return getDefaultPreference(context).getString(TOKEN, "");
    }

    public static void setUserDetail(Context context, UserDetails userDetails) {
        if (userDetails == null) {
            getDefaultPreference(context).edit().putString(USER_DETAIL, "").commit();
        } else {
            getDefaultPreference(context).edit().putString(USER_DETAIL, new Gson().toJson(userDetails, UserDetails.class)).commit();
        }
    }

    public static UserDetails getUserDetails(Context context) {
        return TextUtils.isEmpty(getDefaultPreference(context).getString(USER_DETAIL, "")) ?
                null:
                new Gson().fromJson(getDefaultPreference(context).getString(USER_DETAIL, ""), UserDetails.class);
    }

}
