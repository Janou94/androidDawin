package com.example.sokomanmtj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LevelChoose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_lvl);

        Button hc1 = (Button) findViewById(R.id.hc1);
        hc1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String map = "###########x.x.....##..C.CP.##........###########";
                Intent myIntent = new Intent(LevelChoose.this, MovementButtons.class);
                myIntent.putExtra("map", map); //Optional parameters
                LevelChoose.this.startActivity(myIntent);
            }
        });

        Button hc2 = (Button) findViewById(R.id.hc2);
        hc2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String map = "###########x..x....##..C....##..P.C...###########";
                Intent myIntent = new Intent(LevelChoose.this, MovementButtons.class);
                myIntent.putExtra("map", map); //Optional parameters
                LevelChoose.this.startActivity(myIntent);
            }
        });
    }
}