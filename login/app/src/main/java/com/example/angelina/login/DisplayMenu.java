package com.example.angelina.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class DisplayMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_menu);

        Button buttonb= (Button) findViewById(R.id.button2);
        buttonb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent startNewPage = new Intent(DisplayMenu.this, DisplayBreakfast.class);
                startActivity(startNewPage);
            }
        });
        Button buttonc= (Button) findViewById(R.id.button3);
            buttonc.setOnClickListener(new View.OnClickListener(){
                public void onClick(View arg0){
                    Intent startNewPage = new Intent(DisplayMenu.this, DisplayLunch.class);
                    startActivity(startNewPage);
                }
                });
        Button buttond= (Button) findViewById(R.id.button4);
        buttond.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent startNewPage = new Intent(DisplayMenu.this, DisplayDinner.class);
                startActivity(startNewPage);
            }
        });
        }
    }


