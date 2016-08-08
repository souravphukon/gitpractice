package com.example.sborphuk.loginactivity.login;

/**
 * Created by sborphuk on 8/2/2016.
 */
public interface LoginPresenter
    {
        void validateCredentials(String username ,String password);
        void onDestroy();
    }
