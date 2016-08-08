package com.example.sborphuk.loginactivity.login;

/**
 * Created by sborphuk on 8/2/2016.
 */
public interface LoginView
    {

    //Contract to handle LoginView
        void showProgress();
        void hideProgress();
        void usernameError();
        void passwordError();
        void navHomeScreen();

    }
