package com.example.reflowoct;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private List<Room> roomList;
    private RecyclerView recyclerView;
    private RoomAdapter mAdapter;
    private TextView hellouser;
    FirebaseUser user;
    TextView vtn;

//    RelativeLayout home_rl, time_rl, setting_rl, scene_rl;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        user = FirebaseAuth.getInstance().getCurrentUser();
        roomList = new ArrayList<>();
        vtn = view.findViewById(R.id.more);

        Log.i("username",user.getDisplayName().toString());
        Log.i("email",user.getEmail().toString());

//        home_rl = view.findViewById(R.id.home_rl);
//        time_rl = view.findViewById(R.id.time_rl);
//        scene_rl = view.findViewById(R.id.scene_rl);
//        setting_rl = view.findViewById(R.id.setting_rl);
         hellouser = view.findViewById(R.id.hellouser);
//         hellouser.setText("Hi, "+user.getDisplayName().toString());

        recyclerView = view.findViewById(R.id.recycler_view);
//
//        home_rl.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                home_rl.setBackgroundResource(0);
//            }
//        });

        mAdapter = new RoomAdapter(roomList, getContext());
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
//        setting_rl.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(),profile.class);
//                startActivity(intent);
//
//
//            }
//        });

//        Intent i =getIntent();
//        String email = i.getStringExtra("Email");
//        Log.i("email",email);

        prepareRoomData();
//        vtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FirebaseAuth.getInstance().signOut();
//                Intent intent = new Intent(getActivity(), login.class);
//                startActivity(intent);
//                getActivity().finish();
//            }
//        });
        return view;
    }

    private void prepareRoomData() {
        Room room = new Room("1", "BedRoom",R.drawable.bedroom);
        roomList.add(room);
        room = new Room("2", "Living Room",R.drawable.livingromm);
        roomList.add(room);
        room = new Room("1", "Office",R.drawable.office);
        roomList.add(room);
        room = new Room("2", "Kitchen",R.drawable.kitchen);
        roomList.add(room);
        room = new Room("1", "Bathroom",R.drawable.bathroom);
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


        // Inflate the layout for this fragment



}