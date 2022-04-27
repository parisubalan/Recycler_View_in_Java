package com.parisubalan.recyclerview.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parisubalan.recyclerview.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button verticalView;
    Button horizontalView;
    Button gridView;
    Button staggeredView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    public void initialize()
    {
        verticalView = findViewById(R.id.vertical_view);
        horizontalView = findViewById(R.id.horizontal_view);
        gridView = findViewById(R.id.grid_view);
        staggeredView = findViewById(R.id.staegged_view);

        verticalView.setOnClickListener(this);
        horizontalView.setOnClickListener(this);
        gridView.setOnClickListener(this);
        staggeredView.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.vertical_view :
                Intent verticalView = new Intent(getApplicationContext(), RecyclerActivity.class);
                verticalView.putExtra("orientation", "vertical");
                startActivity(verticalView);

            case R.id.horizontal_view:
                Intent horizontalView = new Intent(getApplicationContext(), RecyclerActivity.class);
                horizontalView.putExtra("orientation", "horizontal");
                startActivity(horizontalView);

            case R.id.grid_view:
                Intent gridView = new Intent(getApplicationContext(), RecyclerActivity.class);
                gridView.putExtra("orientation", "grid");
                startActivity(gridView);

            case R.id.staegged_view:
                Intent i = new Intent(getApplicationContext(), RecyclerActivity.class);
                i.putExtra("orientation", "staggered");
                startActivity(i);
        }
    }
}
