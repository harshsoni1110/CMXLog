package com.example.cmx.cmxlog;

import android.app.FragmentTransaction;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.jar.Manifest;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            FragmentUpdate fragmentUpdate = new FragmentUpdate();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.mainActivity,fragmentUpdate).commit();
        }


    }
}
