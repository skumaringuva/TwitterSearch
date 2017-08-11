package com.sheshu.twittersearch.model;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Sheshu on 8/6/17.
 */
public class AuthenticationPreferences {
    private static final String AUTHENTICATION_PREF_FILE = "auth_pref.pref";
    private static final String KEY_BEARER_TOKEN = "key_bearer_token";
    private static final String KEY_AUTH_TYPE = "key_auth_type";
    private static SharedPreferences sAuthPref;

    private static SharedPreferences getSharedPreferences(Context context) {
        if (sAuthPref == null) {
            // Make sure you create with application context.
            Context appContext = context.getApplicationContext();
            sAuthPref = appContext.getSharedPreferences(AUTHENTICATION_PREF_FILE, Context.MODE_PRIVATE);
        }
        return sAuthPref;
    }

    private static void setStringPreference(Context context, String key, String value) {
        SharedPreferences sharedPref = getSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    private static String getStringPreference(Context context, String key) {
        SharedPreferences sharedPref = getSharedPreferences(context);
        return sharedPref.getString(key, null);
    }

    public static String getBearerToken(Context context) {
        return getStringPreference(context, KEY_BEARER_TOKEN);
    }

    public static String getAuthType(Context context) {
        return getStringPreference(context, KEY_AUTH_TYPE);
    }

    public static void setBearerToken(Context context, String value) {
        setStringPreference(context, KEY_BEARER_TOKEN, value);
    }

    public static void setAuthType(Context context, String value) {
        setStringPreference(context, KEY_AUTH_TYPE, value);
    }
}
