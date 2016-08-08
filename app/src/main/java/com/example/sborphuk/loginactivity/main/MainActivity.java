package com.example.sborphuk.loginactivity.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.sborphuk.loginactivity.R;

import java.util.List;

/**
 * Created by sborphuk on 8/2/2016.
 */
public class MainActivity extends AppCompatActivity implements MainView,AdapterView.OnItemClickListener
    {

        private ListView listView;
        private ProgressBar progressBar;
        private MainPresenter presenter;


        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState)
            {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                listView = (ListView) findViewById(R.id.list);
                listView.setOnItemClickListener(this);
                progressBar = (ProgressBar) findViewById(R.id.progress);
                presenter = new MainPresenterImpl(this);
            }



        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {

            }

        @Override
        public void showProgress()
            {

            }

        @Override
        public void hideProgress()
            {

            }

        @Override
        public void setItem(List<String> item)
            {

            }

        @Override
        public void showMessage(String msg)
            {

            }
    }
