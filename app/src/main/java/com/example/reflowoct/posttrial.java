package com.example.reflowoct;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class posttrial extends AppCompatActivity {
    RequestQueue requestQueue;
    TextView ax;


    public void onclick(View view){
        String url = "http://192.168.4.1/SSID";
        StringRequest stringRequest = new StringRequest(Request.Method.POST,url,
                response -> Toast.makeText(this, "success", Toast.LENGTH_SHORT).show(),
                error -> Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()){
            @Override
            protected Map<String,String> getParams() throws AuthFailureError{
                Map<String,String> params = new HashMap<>();
                params.put("ssid",ax.getText().toString());
                return params;
            }
        };
        requestQueue = Volley.newRequestQueue(posttrial.this);
        requestQueue.add(stringRequest);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posttrial);
        ax = findViewById(R.id.fert);


    }
}