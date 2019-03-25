package com.coolweather.my.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.coolweather.my.R;
import com.coolweather.my.presenter.adapter.TextItemAdapter;

public class TextActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        recyclerView = findViewById(R.id.text_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        TextItemAdapter adapter = new TextItemAdapter();
        recyclerView.setAdapter(adapter);
    }
}
