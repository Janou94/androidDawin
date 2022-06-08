package com.example.sokomanmtj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.buttonStart);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, LevelChoose.class);
                //myIntent.putExtra("key", value); //Optional parameters
                MainActivity.this.startActivity(myIntent);
            }
        });

        Button quit = (Button) findViewById(R.id.buttonQuit);
        quit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.finish();
                System.exit(0);
            }
        });
    }
}