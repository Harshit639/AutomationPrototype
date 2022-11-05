package com.example.reflowoct;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class mainpage extends AppCompatActivity {
    private List<Room> roomList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RoomAdapter mAdapter;

    RelativeLayout home_rl, time_rl, setting_rl, scene_rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        home_rl = findViewById(R.id.home_rl);
        time_rl = findViewById(R.id.time_rl);
        scene_rl = findViewById(R.id.scene_rl);
        setting_rl = findViewById(R.id.setting_rl);

        recyclerView = findViewById(R.id.recycler_view);

        home_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_rl.setBackgroundResource(0);
            }
        });

        mAdapter = new RoomAdapter(roomList, getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareRoomData();
    }

    private void prepareRoomData() {
        Room room = new Room("1", "BedRoom");
        roomList.add(room);
        room = new Room("2", "Kitchen");
        roomList.add(room);
        room = new Room("1", "Bathroom");
        roomList.add(room);
        room = new Room("2", "Hall");
        roomList.add(room);
        room = new Room("1", "Dining");
        roomList.add(room);
//        room = new Room("2", "Kitchen");
//        roomList.add(room);
//        room = new Room("1", "BedRoom");
//        roomList.add(room);
//        room = new Room("2", "Kitchen");
//        roomList.add(room);
//        room = new Room("1", "BedRoom");
//        roomList.add(room);
//        room = new Room("2", "Kitchen");
//        roomList.add(room);
//        room = new Room("1", "BedRoom");
//        roomList.add(room);
//        room = new Room("2", "Kitchen");
//        roomList.add(room);

        mAdapter.notifyDataSetChanged();
    }
}


