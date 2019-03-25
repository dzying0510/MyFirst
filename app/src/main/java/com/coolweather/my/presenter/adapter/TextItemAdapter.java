package com.coolweather.my.presenter.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.coolweather.my.R;

public class TextItemAdapter extends RecyclerView.Adapter<TextItemAdapter.ViewHolder> {

    private int[] images = {R.mipmap.zd_1_1, R.mipmap.zd_1_2, R.mipmap.zd_1_3, R.mipmap.zd_1_4, R.mipmap.zd_1_5};

    @Override
    public TextItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_img_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(TextItemAdapter.ViewHolder holder, int position) {
        holder.image.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.text_img);
        }
    }
}
