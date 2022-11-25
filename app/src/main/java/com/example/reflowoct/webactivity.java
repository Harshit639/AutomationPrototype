package com.example.reflowoct;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class webactivity extends AppCompatActivity {

    EditText ssid;
    EditText password;
    TextView btn;
    RequestQueue requestQueue;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webactivity);
        getSupportActionBar().hide();
        ssid =findViewById(R.id.ssid);
        password= findViewById(R.id.routerpassword);
        btn =findViewById(R.id.submitdetailsbutton);
        progressBar = findViewById(R.id.progressBar4);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                btn.setVisibility(View.INVISIBLE);
                String url = "http://192.168.4.1/SSID";
                StringRequest stringRequest = new StringRequest(Request.Method.POST,url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Intent intent = new Intent(webactivity.this,mainpage.class);
                                startActivity(intent);
                                finish();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(webactivity.this, "Error", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.INVISIBLE);
                        btn.setVisibility(View.VISIBLE);
                    }
                }){
                    @Override
                    protected Map<String,String> getParams() throws AuthFailureError {
                        Map<String,String> params = new HashMap<>();
                        params.put("ssid",ssid.getText().toString()+" "+password.getText().toString());
                        return params;
                    }
                };
                requestQueue = Volley.newRequestQueue(webactivity.this);
                requestQueue.add(stringRequest);

            }
        });



    }
}