package com.example.angelina.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttona= (Button) findViewById(R.id.b1);
        buttona.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent startNewPage= new Intent(MainActivity.this, DisplayMenu.class);
                startActivity (startNewPage);
            }

        });

        Button buttonb= (Button) findViewById(R.id.b3);
        buttonb.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent startNewPage= new Intent(MainActivity.this, MapsActivity.class);
                startActivity (startNewPage);
            }

        });

    }


    }
