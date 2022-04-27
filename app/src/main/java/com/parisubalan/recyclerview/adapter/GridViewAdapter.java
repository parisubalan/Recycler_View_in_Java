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

import java.util.ArrayList;

public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.MyViewHolder>{

    ArrayList<RecyclerPojo> gridList;
    OnSetClickListener onSetClick;
    Context context;

    public GridViewAdapter(Context context, ArrayList<RecyclerPojo> pojoArrayList, OnSetClickListener onSetClickListener)
    {
        this.context = context;
        this.gridList = pojoArrayList;
        this.onSetClick = onSetClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_view, parent,false);
        return new MyViewHolder(v, onSetClick);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.image_view_grid.setImageResource(gridList.get(position).getImageView());

    }

    @Override
    public int getItemCount() {
        return gridList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image_view_grid;
        OnSetClickListener onSetClickListener;

        public MyViewHolder(@NonNull View itemView, OnSetClickListener onSetClick) {
            super(itemView);
            image_view_grid = itemView.findViewById(R.id.image_view_grid);
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
