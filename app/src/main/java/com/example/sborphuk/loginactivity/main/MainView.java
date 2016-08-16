package com.example.sborphuk.loginactivity.main;

import java.util.List;

/**
 * Created by sborphuk on 8/2/2016.
 */
public interface MainView
    {
        void showProgress();
        void hideProgress();
        void setItem(List<String> item);
        void showMessage(String msg);
    }
