package com.example.sborphuk.loginactivity.login;

/**
 * Created by sborphuk on 8/2/2016.
 */
public interface LoginInteractor
   {
       interface OnLoginFinishedListener
           {
               void OnUserNameError();
               void OnPasswordError();
               void onSucess();
           }

       void login(String username, String password, OnLoginFinishedListener onLoginFinishedListener);

    }
