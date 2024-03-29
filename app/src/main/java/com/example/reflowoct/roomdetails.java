package com.example.reflowoct;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class roomdetails extends AppCompatActivity {
    private List<Room> roomList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SingleRoomAdapter mAdapter;
    private ImageView adddevice;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roomdetails);
        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.recycler_view);
        adddevice = findViewById(R.id.adddevice);

        mAdapter = new SingleRoomAdapter(roomList, getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareRoomData();

        adddevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intents = new Intent(getApplicationContext(), webactivity.class);
                startActivity(intents);
                finish();

                Intent intent = new Intent(Settings.Panel.ACTION_WIFI);
                startActivity(intent);





            }
        });
    }

    private void prepareRoomData() {
        Room room = new Room("1", "Light",R.drawable.bedroom);
        roomList.add(room);
        room = new Room("2", "Fan",R.drawable.bedroom);
        roomList.add(room);
        room = new Room("1", "Air Conditioner",R.drawable.bedroom);
        roomList.add(room);


        mAdapter.notifyDataSetChanged();
    }

    public void onBackClicked(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }
    }
