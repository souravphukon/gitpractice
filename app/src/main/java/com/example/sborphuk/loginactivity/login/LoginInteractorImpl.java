package com.example.sborphuk.loginactivity.login;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by sborphuk on 8/2/2016.
 */
public class LoginInteractorImpl implements LoginInteractor
    {
        @Override
        public void login(final String username, final String password, final OnLoginFinishedListener onLoginFinishedListener)
            {
                new Handler().postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                            {
                                boolean error = false;
                                if (TextUtils.isEmpty(username))
                                    {
                                        onLoginFinishedListener.OnUserNameError();
                                        error = true;


                                    }
                                if (TextUtils.isEmpty(password))
                                    {
                                        onLoginFinishedListener.OnPasswordError();
                                        error = true;
                                    }

                                if (!error)
                                    {
                                        onLoginFinishedListener.onSucess();

                                    }

                            }
                    }, 2000);
            }
    }
