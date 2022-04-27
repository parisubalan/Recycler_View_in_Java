package com.parisubalan.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.parisubalan.recyclerview.R;
import com.parisubalan.recyclerview.pojo.RecyclerPojo;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{

    Context mAdapterContext;
    private final ArrayList<RecyclerPojo> adapterList;
    private final OnSetClickListener onSetClick;


    public Adapter(Context mActivityContext, ArrayList<RecyclerPojo> mActivityArrayList, OnSetClickListener onSetClickListener){
        mAdapterContext = mActivityContext;
        adapterList = mActivityArrayList;
        this.onSetClick = onSetClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)  {
        View v= LayoutInflater.from(mAdapterContext).inflate(R.layout.recycler_adapter_activity, parent, false);
        return new MyViewHolder(v, onSetClick);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(adapterList.get(position).getTitle());
        holder.sub_title.setText(adapterList.get(position).getSubTitle());
        holder.image_view.setImageResource(adapterList.get(position).getImageView());

    }

    @Override
    public int getItemCount() {
        return adapterList.size();

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title, sub_title;
        ImageView image_view;
        OnSetClickListener onSetClickListener;

        public MyViewHolder(@NonNull View itemView, OnSetClickListener onSetClick ) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            sub_title = itemView.findViewById(R.id.sub_title);
            image_view = itemView.findViewById(R.id.image_view);
            this.onSetClickListener = onSetClick;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onSetClickListener.onSetClick(getAdapterPosition()+1);
        }
    }

    public interface OnSetClickListener{
        void onSetClick(int position);

    }

}
