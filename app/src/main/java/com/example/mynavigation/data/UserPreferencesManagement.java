package com.example.mynavigation.data;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPreferencesManagement {
    private final String PREF_NAME = "com.example.sharePref";
    private final String USERNAME_KEY = "USERNAME_KEY";
    private final String PASSWORD_KEY = "PASSWORD_KEY";
    private final String LOGGED_IN_KEY = "LOGGED_IN_KEY";
    public static UserPreferencesManagement instance;

    public UserPreferencesManagement() {
    }

    public static UserPreferencesManagement getInstance() {
        if (instance == null){
            instance = new UserPreferencesManagement();
        }
        return instance;
    }

    public void saveUsernamePassword(Context context, String username, String password){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USERNAME_KEY,username);
        editor.putString(PASSWORD_KEY, password);
    }
    public void saveLoginStatus(Context context, Boolean loggedIn){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(LOGGED_IN_KEY, loggedIn);

    }
    public String getUserName(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(USERNAME_KEY,"");
    }
    public String getPassword(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(PASSWORD_KEY,"");
    }

    public Boolean getLoginStatus(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(LOGGED_IN_KEY, false);
    }

}
