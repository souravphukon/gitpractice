
package com.example.sborphuk.loginactivity.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.sborphuk.loginactivity.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements MainView, AdapterView.OnItemClickListener,View.OnClickListener {

    private ListView listView;
    private ProgressBar progressBar;
    private MainPresenter presenter;
    private Button push,pop;
    ArrayList<String> items = new ArrayList<>();
    private  ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = (ListView) findViewById(R.id.list);
        listView.setOnItemClickListener(this);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        push=(Button)findViewById(R.id.push);
        push.setOnClickListener(this);
        pop=(Button)findViewById(R.id.pop);
        pop.setOnClickListener(this);
        presenter = new MainPresenterImpl(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        listView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        listView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setItems(List<String> items) {

        this.items.addAll(items);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, this.items);
        listView.setAdapter(adapter);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        presenter.onItemClicked(position);
    }

    @Override
    public void onClick(View view)
        {
            switch (view.getId())
                {
                    case R.id.push:

                        int item=items.size()+1;
                        items.add("Item "+item);
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.pop:
                        if(items.size()!=0)
                            {
                                items.remove(0);
                                adapter.notifyDataSetChanged();
                            }


                        break;

                }
        }

}
