package com.example.sborphuk.loginactivity.main;

/**
 * Created by sborphuk on 8/2/2016.
 */
public class MainPresenterImpl implements MainPresenter
    {
        MainView mainView;
        public MainPresenterImpl(MainView mainView)
            {
            }

        @Override
        public void onItemClicked(int position)
            {

           if(mainView!=null)
               {
                   mainView.showMessage("clicked in position"+position);
                }
            }

        @Override
        public void onResume()
            {

            }

        @Override
        public void onDestroy()
            {

            }
    }
