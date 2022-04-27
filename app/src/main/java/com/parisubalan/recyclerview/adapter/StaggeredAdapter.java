package com.parisubalan.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.parisubalan.recyclerview.R;
import com.parisubalan.recyclerview.pojo.RecyclerPojo;
import com.parisubalan.recyclerview.activity.StaggeredGridActivity;

import java.util.ArrayList;

public class StaggeredAdapter extends RecyclerView.Adapter<StaggeredAdapter.MyViewHolder> {

    ArrayList<RecyclerPojo> staggeredList;
    Context mAdapterContext;
    OnSetClickListener onSetClick;

    public StaggeredAdapter(StaggeredGridActivity staggeredGrid_activity, ArrayList<RecyclerPojo> staggeredList, OnSetClickListener onSetClickListener) {
        mAdapterContext = staggeredGrid_activity;
        this.staggeredList = staggeredList;
        this.onSetClick = onSetClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mAdapterContext).inflate(R.layout.stagged_view, parent, false);

        return new MyViewHolder(v,onSetClick);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.image_view_stag.setImageResource(staggeredList.get(position).getImageView());

    }

    @Override
    public int getItemCount() {
        return staggeredList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image_view_stag;
        OnSetClickListener onSetClickListener;

        public MyViewHolder(@NonNull View itemView, OnSetClickListener onSetClick) {
            super(itemView);
            image_view_stag = itemView.findViewById(R.id.image_view_stag);
            this.onSetClickListener = onSetClick;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onSetClickListener.onSetClick(getAdapterPosition());

        }
    }
    public interface OnSetClickListener{
        void onSetClick(int position);
    }
}


