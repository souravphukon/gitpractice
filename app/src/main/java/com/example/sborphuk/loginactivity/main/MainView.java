
package com.example.sborphuk.loginactivity.main;

import java.util.List;

public interface MainView {

    void showProgress();

    void hideProgress();

    void setItems(List<String> items);

    void showMessage(String message);

   // void showPushItem();

   // void ShowPopList();
}
