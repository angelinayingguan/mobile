package com.example.angelina.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class DisplayDinner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_dinner);
        FragmentManager fmdinner = getSupportFragmentManager();

        Fragment fragment = fmdinner.findFragmentById(R.id.fragment_container_dinner);
        if (fragment == null) {
            fragment = new MenuFragmentDinner();
            fmdinner.beginTransaction().add(R.id.fragment_container_dinner, fragment).commit();
        }


    }

}
