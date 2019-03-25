package com.coolweather.my.presenter.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.coolweather.my.R;
import com.coolweather.my.model.main.MainItem1;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MainItemAdapter1 extends RecyclerView.Adapter<MainItemAdapter1.ViewHolder> implements View.OnClickListener {

    private List<MainItem1> mMainItemList;
    private OnItemClickListener mItemClickListener;
    private Context context;

    @Override
    public void onClick(View v) {
        if (mItemClickListener!=null){
            mItemClickListener.onItemClick((Integer) v.getTag());
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title;
        public ViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.main_tab_img);
            title = (TextView) view.findViewById(R.id.main_tab_text);
        }
    }

    public MainItemAdapter1(List<MainItem1> mainItem1s){
        mMainItemList = mainItem1s;
    }

    @Override
    public MainItemAdapter1.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_tab_recycler,parent,false);
        context = view.getContext();
        view.setOnClickListener(this);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MainItemAdapter1.ViewHolder holder, int position) {
        MainItem1 mainItem1 = mMainItemList.get(position);
        Glide.with(context).load(mainItem1.getImageUrl()).into(holder.image);
        holder.title.setText(mainItem1.getTitle());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mMainItemList.size();
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

}
