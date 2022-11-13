package com.example.reflowoct;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class signup extends AppCompatActivity {


    private EditText emailTextView, passwordTextView;
    private TextView changeToLogin;
    private EditText username;
    private TextView Btn;
    private ProgressBar progressbar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            Log.i("sds",user.getEmail());
            Intent i = new Intent(signup.this, mainpage.class);
//            i.putExtra("Email",user.getEmail().toString());
//            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        } else {
            // User is signed out
            Log.d("ds", "onAuthStateChanged:signed_out");
        }

        mAuth = FirebaseAuth.getInstance();



        // initialising all views through id defined above
        emailTextView = findViewById(R.id.email);
        passwordTextView = findViewById(R.id.passwd);
        Btn = findViewById(R.id.buttonregisterprofile);
        changeToLogin = findViewById(R.id.toLogin);
        progressbar = findViewById(R.id.progressBar);
        username = findViewById(R.id.username);

        // Set on Click Listener on Registration button
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                registerNewUser();
            }
        });
        changeToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                    Intent intent = new Intent(signup.this,login.class);
                    startActivity(intent);
            }
        });


    }

    private void registerNewUser()
    {

        // show the visibility of progress bar to show loading
        progressbar.setVisibility(View.VISIBLE);
        Btn.setVisibility(View.INVISIBLE);

        // Take the value of two edit texts in Strings
        String email, password;
        email = emailTextView.getText().toString();
        password = passwordTextView.getText().toString();

        // Validations for input email and password
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(),
                            "Please enter email!",
                            Toast.LENGTH_LONG)
                    .show();
            progressbar.setVisibility(View.INVISIBLE);
            Btn.setVisibility(View.VISIBLE);
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(),
                            "Please enter password!",
                            Toast.LENGTH_LONG)
                    .show();
            progressbar.setVisibility(View.INVISIBLE);
            Btn.setVisibility(View.VISIBLE);
            return;
        }

        // create new user or register new user
        mAuth
                .createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful()) {

                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(username.getText().toString())
                                    .build();

                            user.updateProfile(profileUpdates)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Log.d("scsd", "User profile updated.");
                                            }
                                        }
                                    });

                            mAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getApplicationContext(),
                                                        "Registration successful!, Please verify your email!",
                                                        Toast.LENGTH_LONG)
                                                .show();
                                        Intent intent = new Intent(signup.this, login.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(getApplicationContext(),
                                                        task.getException().getMessage(),
                                                        Toast.LENGTH_LONG)
                                                .show();
                                    }
                                }
                            });


                            // hide the progress bar
                            progressbar.setVisibility(View.GONE);
                            Btn.setVisibility(View.VISIBLE);

                            // if the user created intent to login activity

                        }
                        else {

                            // Registration failed
                            Toast.makeText(
                                            getApplicationContext(),
                                            "Registration failed!"
                                                    + "",
                                            Toast.LENGTH_LONG)
                                    .show();

                            // hide the progress bar
                            progressbar.setVisibility(View.GONE);
                            Btn.setVisibility(View.VISIBLE);
                        }
                    }
                });
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//
//        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
//                .setDisplayName("Jane Q. User")
//                .build();
//
//        user.updateProfile(profileUpdates)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if (task.isSuccessful()) {
//                            Log.d("info", "User profile updated.");
//                        }
//                    }
//                });

    }
}

