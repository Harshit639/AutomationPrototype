package com.example.reflowoct;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;


public class testWifi extends AppCompatActivity {

    public void wifichanger(View view){
        Intent intent = new Intent(Settings.Panel.ACTION_WIFI);
        startActivityForResult(intent,1);

//        WifiManager manager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
//        manager.setWifiEnabled(getApplicationInfo().enabled);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_wifi);




    }
}