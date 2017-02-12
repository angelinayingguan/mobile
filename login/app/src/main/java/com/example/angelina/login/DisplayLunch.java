package com.example.angelina.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class DisplayLunch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_lunch);

        FragmentManager fmlunch = getSupportFragmentManager();
        Fragment fragment = fmlunch.findFragmentById(R.id.fragment_container_lunch);
        if (fragment == null) {
            fragment = new MenuFragmentLunch();
            fmlunch.beginTransaction().add(R.id.fragment_container_lunch, fragment).commit();
        }

    }

}
