package com.example.administrator.fzcbaseframework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private MainAdapter adapter;
    private ArrayList<String> data;
    private Ptr
    @Bind(R.id.listView)
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        adapter = new MainAdapter(this);
        data = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            data.add(i + "");
        }
        adapter.appendData(data);
        mListView.setAdapter(adapter);
    }
}
