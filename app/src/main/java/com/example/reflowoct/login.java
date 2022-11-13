package com.example.reflowoct;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    private EditText emailTextView, passwordTextView;
    private TextView Btn , tosignup;
    private ProgressBar progressbar;


    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();
        mAuth = FirebaseAuth.getInstance();

        // initialising all views through id defined above
        emailTextView = findViewById(R.id.loginemail);
        passwordTextView = findViewById(R.id.loginpassword);
        Btn = findViewById(R.id.loginbutton);
        tosignup = findViewById(R.id.toSignup);
        progressbar = findViewById(R.id.progressBar3);

        // Set on Click Listener on Sign-in button
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                loginUserAccount();
            }
        });

        tosignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Intent intent = new Intent(login.this,signup.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void loginUserAccount()
    {

        // show the visibility of progress bar to show loading
        progressbar.setVisibility(View.VISIBLE);
        Btn.setVisibility(View.INVISIBLE);


        // Take the value of two edit texts in Strings
        String email, password;
        email = emailTextView.getText().toString();
        password = passwordTextView.getText().toString();

        // validations for input email and password
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

        // signin existing user
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(
                                    @NonNull Task<AuthResult> task)
                            {
                                if (task.isSuccessful()) {
                                    if(mAuth.getCurrentUser().isEmailVerified()) {
                                        Toast.makeText(getApplicationContext(),
                                                        "Login successful!",
                                                        Toast.LENGTH_LONG)
                                                .show();

                                        // hide the progress bar
                                        progressbar.setVisibility(View.GONE);

                                        // if sign-in is successful
                                        // intent to home activity
                                        Intent intent
                                                = new Intent(login.this,
                                                mainpage.class);
                                        startActivity(intent);
                                    }else{
                                        Toast.makeText(getApplicationContext(),
                                                        "Please Verify Email!",
                                                        Toast.LENGTH_LONG)
                                                .show();
                                    }
                                }

                                else {

                                    // sign-in failed
                                    Toast.makeText(getApplicationContext(),
                                                    "Login failed!",
                                                    Toast.LENGTH_LONG)
                                            .show();

                                    // hide the progress bar
                                    progressbar.setVisibility(View.GONE);
                                    Btn.setVisibility(View.VISIBLE);

                                }
                            }
                        });
    }
}