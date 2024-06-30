package com.example.weather_app.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.weather_app.Adaptars.FutureAdapter;
import com.example.weather_app.Adaptars.HourlyAdapter;
import com.example.weather_app.Domains.FutureDomain;
import com.example.weather_app.R;

import java.util.ArrayList;

public class FutureActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterTomorrow;
    public RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future);
        
        initRecyclerView();
        setVariable();
    }

    private void setVariable() {
        ConstraintLayout backBtn=findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{
                        new Intent(FutureActivity.this, MainActivity.class)
                });
            }
        });
    }

    private void initRecyclerView() {
        ArrayList<FutureDomain> items=new ArrayList<>();
        items.add(new FutureDomain("Mon","storm","Storm",25 ,22));
        items.add(new FutureDomain("Tue","sunny","Sunny",26 ,21));
        items.add(new FutureDomain("Wed","sunny","Sunny",27 ,22));
        items.add(new FutureDomain("Thu","cloudy","Cloudy",24 ,19));
        items.add(new FutureDomain("Fri","rainy","Rainy",22 ,19));
        items.add(new FutureDomain("Sat","cloudy","Cloudy",23 ,18));
        items.add(new FutureDomain("Sun","windy","Windy",22 ,18));
        recyclerView=findViewById(R.id.view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterTomorrow=new FutureAdapter(items);
        recyclerView.setAdapter(adapterTomorrow);
    }
}