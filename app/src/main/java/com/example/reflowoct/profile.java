package com.example.reflowoct;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class profile extends AppCompatActivity {
    FirebaseUser user;
    TextView pname, pemail;
    TextView Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().hide();

        user= FirebaseAuth.getInstance().getCurrentUser();
        pname= findViewById(R.id.pusername);
        pemail = findViewById(R.id.pemail);
        Btn =  findViewById(R.id.buttonregisterprofile);

        pname.setText(user.getDisplayName());
        pemail.setText("Email      :  "+user.getEmail());

        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent
                        = new Intent(profile.this,
                        login.class);
                startActivity(intent);
                finish();
            }
        });


    }
}