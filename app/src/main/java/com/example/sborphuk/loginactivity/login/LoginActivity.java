package com.example.sborphuk.loginactivity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.sborphuk.loginactivity.R;
import com.example.sborphuk.loginactivity.application.GoogleAnalyticsHelper;
import com.example.sborphuk.loginactivity.main.MainActivity;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener
    {


        private ProgressBar progressBar;
        private EditText username;
        private EditText password;
        private LoginPresenter loginPresenter;
        @Override
        protected void onCreate(Bundle savedInstanceState)
            {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                progressBar = (ProgressBar) findViewById(R.id.progress);
                username = (EditText) findViewById(R.id.username);
                password = (EditText) findViewById(R.id.password);
                findViewById(R.id.button).setOnClickListener(this);
                loginPresenter=new LoginPresenterImp(this);
            }

        @Override
        protected void onDestroy()
            {
                loginPresenter.onDestroy();
                super.onDestroy();
            }

        @Override
        public void showProgress()
            {
                progressBar.setVisibility(View.VISIBLE);
            }

        @Override
        public void hideProgress()
            {
                progressBar.setVisibility(View.INVISIBLE);
//////////////////
            }

        @Override
        public void usernameError()
            {
                 username.setError(getString(R.string.username_error));
            }

        @Override
        public void passwordError()
            {
                password.setError(getString(R.string.password_error));
            }

        @Override
        protected void onResume()
            {
                super.onResume();
                GoogleAnalyticsHelper.getInstance().trackScreenView(getLocalClassName());
            }

        @Override
        public void navHomeScreen()
            {
                startActivity(new Intent(this, MainActivity.class));
                finish();
            }

        @Override
        public void onClick(View view)
            {
                loginPresenter.validateCredentials(username.getText().toString(),password.getText().toString());
            }
    }
