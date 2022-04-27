package com.parisubalan.recyclerview.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.parisubalan.recyclerview.adapter.GridViewAdapter;
import com.parisubalan.recyclerview.R;
import com.parisubalan.recyclerview.pojo.RecyclerPojo;

import java.util.ArrayList;

public class GridActivity extends AppCompatActivity implements GridViewAdapter.OnSetClickListener {

    RecyclerView recyclerView;
    ArrayList<RecyclerPojo> gridPojoList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_main);
        initialization();
        listLoading();
        adapterSet();
    }

    public void initialization()
    {
        recyclerView = findViewById(R.id.recycler_view);
        gridPojoList = new ArrayList<>();
    }

    public void listLoading()
    {
        gridPojoList.add(new RecyclerPojo(R.drawable.image_01) );
        gridPojoList.add(new RecyclerPojo(R.drawable.image_03) );
        gridPojoList.add(new RecyclerPojo(R.drawable.image_06) );
        gridPojoList.add(new RecyclerPojo(R.drawable.image_01) );
        gridPojoList.add(new RecyclerPojo(R.drawable.image_01) );
        gridPojoList.add(new RecyclerPojo(R.drawable.image_03) );
        gridPojoList.add(new RecyclerPojo(R.drawable.image_06) );
        gridPojoList.add(new RecyclerPojo(R.drawable.image_01) );
        gridPojoList.add(new RecyclerPojo(R.drawable.image_01) );
        gridPojoList.add(new RecyclerPojo(R.drawable.image_03) );
        gridPojoList.add(new RecyclerPojo(R.drawable.image_06) );
        gridPojoList.add(new RecyclerPojo(R.drawable.image_01) );
    }

    public void adapterSet()
    {
        GridViewAdapter adapter = new GridViewAdapter(this, gridPojoList,this);
        int numberOfColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onSetClick(int position) {
        Toast.makeText(this, "Clicked : " + position, Toast.LENGTH_SHORT).show();
    }
}
