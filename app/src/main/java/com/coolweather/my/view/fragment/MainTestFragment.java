package com.coolweather.my.view.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.coolweather.my.R;
import com.coolweather.my.model.main.MainItem1;
import com.coolweather.my.presenter.adapter.MainItemAdapter1;
import com.coolweather.my.view.activity.TextActivity;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class MainTestFragment extends Fragment implements MainItemAdapter1.OnItemClickListener {

    public MainTestFragment(MainItem1[] mainItem1s) {
        for(int i=0;i<mainItem1s.length;i++) {
            mMainItems.add(mainItem1s[i]);
        }
    }

    private List<MainItem1> mMainItems = new ArrayList<>();
    private View view;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.main_item1, container, false);
        recyclerView = view.findViewById(R.id.main_tab_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        MainItemAdapter1 adapter = new MainItemAdapter1(mMainItems);
        adapter.setItemClickListener(this);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this.getActivity(), TextActivity.class);
        startActivity(intent);
    }
}
