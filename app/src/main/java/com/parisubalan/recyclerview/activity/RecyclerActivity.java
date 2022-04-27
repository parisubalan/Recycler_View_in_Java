package com.parisubalan.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.parisubalan.recyclerview.R;
import com.parisubalan.recyclerview.adapter.Adapter;
import com.parisubalan.recyclerview.pojo.RecyclerPojo;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity implements Adapter.OnSetClickListener {

    RecyclerView recyclerView;
    ArrayList<RecyclerPojo> recyclerPojoArrayList;
    String orientation ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_main);
        initialization();
        listLoading();
        changingViewType();
    }
    public void initialization()
    {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerPojoArrayList = new ArrayList<>();

    }
    public void listLoading()
    {
        recyclerPojoArrayList.add(new RecyclerPojo("AI App", "Upcoming Technology", R.drawable.ai_logo));
        recyclerPojoArrayList.add(new RecyclerPojo("Facebook", "SocialMedia", R.drawable.facebook));
        recyclerPojoArrayList.add(new RecyclerPojo("Whatsapp", "Communication", R.drawable.whatsapp));
        recyclerPojoArrayList.add(new RecyclerPojo("Youtube", "Entertainment", R.drawable.youtube));
        recyclerPojoArrayList.add(new RecyclerPojo("Twitter", "News Platform", R.drawable.twitter));
        recyclerPojoArrayList.add(new RecyclerPojo("Earnings", "Share Market", R.drawable.shar_market));
        recyclerPojoArrayList.add(new RecyclerPojo("AI App", "Upcoming Technology", R.drawable.ai_logo));
        recyclerPojoArrayList.add(new RecyclerPojo("Facebook", "SocialMedia", R.drawable.facebook));
        recyclerPojoArrayList.add(new RecyclerPojo("Whatsapp", "Communication", R.drawable.whatsapp));
        recyclerPojoArrayList.add(new RecyclerPojo("Youtube", "Entertainment", R.drawable.youtube));
        recyclerPojoArrayList.add(new RecyclerPojo("Twitter", "News Platform", R.drawable.twitter));
        recyclerPojoArrayList.add(new RecyclerPojo("Earnings", "Share Market", R.drawable.shar_market));
    }

    public void changingViewType()
    {
        Bundle b = getIntent().getExtras();
        orientation = b.getString("orientation");

        switch (orientation) {
            case "vertical": {
                Adapter adapter = new Adapter(this, recyclerPojoArrayList, this);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(adapter);
                break;
            }
            case "horizontal": {
                Adapter adapter = new Adapter(this, recyclerPojoArrayList, this);
                LinearLayoutManager hv = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
                recyclerView.setLayoutManager(hv);
                recyclerView.setAdapter(adapter);
                break;
            }
            case "grid": {
                Intent i = new Intent(getApplicationContext(), GridActivity.class);
                startActivity(i);
                finish();
                break;
            }
            case "staggered": {
                Intent i = new Intent(getApplicationContext(), StaggeredGridActivity.class);
                startActivity(i);
                finish();
                break;
            }
            default:
                Toast.makeText(this, "Closed", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onSetClick(int position) {
        Toast.makeText(this, "Clicked : " + position, Toast.LENGTH_SHORT).show();

    }
}