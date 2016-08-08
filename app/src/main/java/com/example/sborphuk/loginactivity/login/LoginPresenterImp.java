package com.example.sborphuk.loginactivity.login;

/**
 * Created by sborphuk on 8/2/2016.
 */
public class LoginPresenterImp implements LoginPresenter,LoginInteractor.OnLoginFinishedListener
    {

        LoginView loginView;
        LoginInteractor loginInteractor;

        LoginPresenterImp(LoginView view)
            {

                loginView = view;
                loginInteractor=new LoginInteractorImpl();


            }


        @Override
        public void validateCredentials(String username, String password)
            {

                if(loginView!=null)
                   loginView.showProgress();

                loginInteractor.login(username,password,this);
            }

        @Override
        public void onDestroy()
            {
                loginView=null;
            }

        @Override
        public void OnUserNameError()
            {
                if(loginView!=null)
                    {
                        loginView.hideProgress();
                        loginView.usernameError();
                    }

            }

        @Override
        public void OnPasswordError()
            {
                if(loginView!=null)
                    {
                        loginView.hideProgress();
                        loginView.passwordError();
                    }


            }

        @Override
        public void onSucess()
            {

                if(loginView!=null)
                    {
                        loginView.hideProgress();
                        loginView.navHomeScreen();
                    }
            }
    }
