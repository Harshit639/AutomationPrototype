package com.example.reflowoct;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class mainpage extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
//    private List<Room> roomList = new ArrayList<>();
//    private RecyclerView recyclerView;
//    private RoomAdapter mAdapter;
//    private TextView hellouser;
//    FirebaseUser user;
    HomeFragment fragment = new HomeFragment();
    profilefragment profilefragment = new profilefragment();
    private BottomNavigationView mBtmView;





//
//    RelativeLayout home_rl, time_rl, setting_rl, scene_rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.bottombar);
        getSupportActionBar().hide();
        mBtmView = (BottomNavigationView) findViewById(R.id.navigationcontroller);
        mBtmView.setOnNavigationItemSelectedListener(this);



        getSupportFragmentManager().beginTransaction().replace(R.id.container_layout,fragment).commit();











//
//        user = FirebaseAuth.getInstance().getCurrentUser();
//
//        Log.i("username",user.getDisplayName().toString());
//        Log.i("email",user.getEmail().toString());
//
//        home_rl = findViewById(R.id.home_rl);
//        time_rl = findViewById(R.id.time_rl);
//        scene_rl = findViewById(R.id.scene_rl);
//        setting_rl = findViewById(R.id.setting_rl);
//        hellouser = findViewById(R.id.hellouser);
//        hellouser.setText("Hi, "+user.getDisplayName().toString());
//
//        recyclerView = findViewById(R.id.recycler_view);
//
//        home_rl.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                home_rl.setBackgroundResource(0);
//            }
//        });
//
//        mAdapter = new RoomAdapter(roomList, getApplicationContext());
//        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
//        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(mAdapter);
//        setting_rl.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(mainpage.this,profile.class);
//                startActivity(intent);
//
//
//            }
//        });
//
////        Intent i =getIntent();
////        String email = i.getStringExtra("Email");
////        Log.i("email",email);
//
//        prepareRoomData();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.profile){
            item.setChecked(item.isChecked());

            getSupportFragmentManager().beginTransaction().replace(R.id.container_layout,profilefragment).commit();

        }
        if(item.getItemId()==R.id.home){
            item.setChecked(item.isChecked());
            getSupportFragmentManager().beginTransaction().replace(R.id.container_layout,fragment).commit();
        }
        return false;
    }


//    private void prepareRoomData() {
//        Room room = new Room("1", "BedRoom",R.drawable.bedroom);
//        roomList.add(room);
//        room = new Room("2", "Living Room",R.drawable.livingromm);
//        roomList.add(room);
//        room = new Room("1", "Office",R.drawable.office);
//        roomList.add(room);
//        room = new Room("2", "Kitchen",R.drawable.kitchen);
//        roomList.add(room);
//        room = new Room("1", "Bathroom",R.drawable.bathroom);
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
//        room = new Room("1", "BedRoom");
//        roomList.add(room);
//        room = new Room("2", "Kitchen");
//        roomList.add(room);
//
//        mAdapter.notifyDataSetChanged();
//    }
}
//

