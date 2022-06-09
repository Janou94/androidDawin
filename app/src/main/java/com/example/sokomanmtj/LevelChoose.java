package com.example.sokomanmtj;


import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class LevelChoose extends AppCompatActivity {
    JSONArray json;
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

        //load maps from API
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://192.168.43.38/apiAndroid/";
        StringRequest stringRequest = new StringRequest(DownloadManager.Request.VISIBILITY_VISIBLE, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONArray e = new JSONArray(response);
                            int l = e.length();

                            for (int x = 0; x < l; x++) {
                                JSONObject object1 = e.getJSONObject(x);
                                String map = object1.getString("map");
                                String id = object1.getString("id");

                                Context context = getApplicationContext();

                                LinearLayout layout = (LinearLayout) findViewById(R.id.apiLvls);
                                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                                lp.setMargins(50,50,50,50);
                                Button btnTag = new Button(context);
                                btnTag.setLayoutParams(lp);
                                btnTag.setText(""+id);
                                btnTag.setHeight(250);
                                btnTag.setId(Integer.parseInt(id));
                                int green = Color.parseColor("#0EEA9D");
                                int white = Color.parseColor("#FFFFFF");
                                btnTag.setBackgroundColor(green);
                                btnTag.setTextColor(white);
                                btnTag.setWidth(250);
                                btnTag.setOnClickListener(
                                        new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                loadApiMap(map);
                                            }
                                        }
                                );
                                layout.addView(btnTag);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.toString());
            }
        });
        queue.add(stringRequest);
        //end load map from API

        Button btnM2 =findViewById(R.id.btnMenu2);
        btnM2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(LevelChoose.this, MainActivity.class);
                LevelChoose.this.startActivity(myIntent);
            }
        });

    }

    public void loadApiMap(String map) {
        Intent myIntent = new Intent(LevelChoose.this, MovementButtons.class);
        myIntent.putExtra("map", map);
        LevelChoose.this.startActivity(myIntent);
    }
}