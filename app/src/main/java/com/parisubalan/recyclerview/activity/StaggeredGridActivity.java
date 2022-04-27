package com.parisubalan.recyclerview.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.parisubalan.recyclerview.R;
import com.parisubalan.recyclerview.pojo.RecyclerPojo;
import com.parisubalan.recyclerview.adapter.StaggeredAdapter;

import java.util.ArrayList;

public class StaggeredGridActivity extends AppCompatActivity implements StaggeredAdapter.OnSetClickListener {

    RecyclerView recyclerView;
    ArrayList<RecyclerPojo> recyclerPojoArrayList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState   );
        setContentView(R.layout.recycler_main);
        initialization();
        listLoading();
        adapterSet();
    }

    public void initialization()
    {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerPojoArrayList = new ArrayList<>();
    }

    public void listLoading()
    {
        recyclerPojoArrayList.add(new RecyclerPojo(R.drawable.image_01));
        recyclerPojoArrayList.add(new RecyclerPojo(R.drawable.image_02));
        recyclerPojoArrayList.add(new RecyclerPojo(R.drawable.image_03));
        recyclerPojoArrayList.add(new RecyclerPojo(R.drawable.image_04));
        recyclerPojoArrayList.add(new RecyclerPojo(R.drawable.image_05));
        recyclerPojoArrayList.add(new RecyclerPojo(R.drawable.image_06));
        recyclerPojoArrayList.add(new RecyclerPojo(R.drawable.image_01));
        recyclerPojoArrayList.add(new RecyclerPojo(R.drawable.image_02));
        recyclerPojoArrayList.add(new RecyclerPojo(R.drawable.image_03));
        recyclerPojoArrayList.add(new RecyclerPojo(R.drawable.image_04));
        recyclerPojoArrayList.add(new RecyclerPojo(R.drawable.image_05));
        recyclerPojoArrayList.add(new RecyclerPojo(R.drawable.image_06));
    }

    public void adapterSet()
    {
        StaggeredAdapter adapter = new StaggeredAdapter(this, recyclerPojoArrayList, this);
        StaggeredGridLayoutManager sv = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL );
        recyclerView.setLayoutManager(sv);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onSetClick(int position) {
        Toast.makeText(this, "Clicked : " + position, Toast.LENGTH_SHORT).show();
    }
}
