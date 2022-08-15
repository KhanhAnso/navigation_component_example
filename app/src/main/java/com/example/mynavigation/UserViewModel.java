package com.example.mynavigation;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mynavigation.data.UserPreferencesManagement;

import java.io.Closeable;

public class UserViewModel extends ViewModel {

    private MutableLiveData<Boolean> _loggedIn = new MutableLiveData<>();
    public LiveData<Boolean> loggedIn = _loggedIn;

    public UserViewModel(Context context) {
        this._loggedIn.setValue(UserPreferencesManagement.getInstance().getLoginStatus(context));
    }

    public String getUserName(Context context){
        return UserPreferencesManagement.getInstance().getUserName(context);
    }

    public MutableLiveData<Boolean> login(Context context, String username, String password){
        MutableLiveData<Boolean> liveData = new MutableLiveData<>();
        if (username.isEmpty() && username == UserPreferencesManagement.getInstance().getUserName(context) && password.isEmpty() &&  password == UserPreferencesManagement.getInstance().getPassword(context)){
            UserPreferencesManagement.getInstance().saveLoginStatus(context,true);
            _loggedIn.setValue(true);
            liveData.setValue(true);
        }else {
            _loggedIn.setValue(false);
            liveData.setValue(false);
        }
        return liveData;
    }
    public MutableLiveData<Boolean> signUp(Context context, String username, String password){
        MutableLiveData<Boolean> liveData = new MutableLiveData<>();
        if (username.isEmpty() || password.isEmpty()){
            liveData.setValue(false);
        }else {
            UserPreferencesManagement.getInstance().saveUsernamePassword(context,username,password);
            liveData.setValue(true);
        }
        return liveData;
    }
    public MutableLiveData<Boolean> logOut(Context context){
        UserPreferencesManagement.getInstance().saveLoginStatus(context, false);
        _loggedIn.setValue(false);
        return new MutableLiveData<>(true);
    }
}
