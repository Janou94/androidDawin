package com.example.sokomanmtj;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovementButtons extends AppCompatActivity {
    List<String> list;
    GridView gd;
    ArrayAdapter<String> aA;
    ArrayList<Integer> winningIndex;
    String map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movement_buttons);
        map = getIntent().getStringExtra("map");
        String[] array = map.split("");
        //initializing an ArrayList from array
        list = new ArrayList<String>(Arrays.asList(array));

        winningIndex = new ArrayList<Integer>();
        for(int i = 0; i < map.length(); i++){
            if(map.charAt(i) == 'x'){
                winningIndex.add(i);
            }
        }

        //refer GridView from xml layout file
        gd = (GridView) findViewById(R.id.gridView);
        //data bind GridView with ArrayAdapter
        aA = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        gd.setAdapter(aA);

        Button btnLeft = (Button) findViewById(R.id.btnLeft);
        btnLeft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                movChar("left");
            }
        });

        Button btnRight = (Button) findViewById(R.id.btnRight);
        btnRight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                movChar("right");
            }
        });

        Button btnUp = (Button) findViewById(R.id.btnUp);
        btnUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                movChar("up");
            }
        });

        Button btnDown = (Button) findViewById(R.id.btnDown);
        btnDown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                movChar("down");
            }
        });

        Button btnReset = (Button) findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MovementButtons.this, MovementButtons.class);
                myIntent.putExtra("map", map); //Optional parameters
                MovementButtons.this.startActivity(myIntent);
            }
        });

        Button btnMenu = (Button) findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MovementButtons.this, LevelChoose.class);
                //myIntent.putExtra("key", value); //Optional parameters
                MovementButtons.this.startActivity(myIntent);
            }
        });
    }


    void movChar (String direction) {
        Integer index = list.indexOf("P");
        String whereToMove =list.get(index-1);
        String whereCrateMoves =list.get(index-2);
        Integer nextPos = index-1;
        Integer crateNextPose = index-2;
        switch (direction) {
            case "left" :
                whereToMove=list.get(index-1);
                whereCrateMoves=list.get(index-2);
                nextPos = index-1;
                crateNextPose = index-2;
                break;
            case "right" :
                whereToMove=list.get(index+1);
                whereCrateMoves=list.get(index+2);
                nextPos = index+1;
                crateNextPose = index+2;
                break;
            case "up" :
                whereToMove=list.get(index-10);
                whereCrateMoves=list.get(index-20);
                nextPos = index-10;
                crateNextPose = index-20;
                break;
            case "down" :
                whereToMove=list.get(index+10);
                whereCrateMoves=list.get(index+20);
                nextPos = index+10;
                crateNextPose = index+20;
                break;
            default :
                break;
        }

        if (whereToMove.equals("#")) {
            System.out.println("no");
        }
        else if(whereToMove.equals("C")) {
            if (whereCrateMoves.equals("#") || whereCrateMoves.equals("C")) {
                System.out.println("test");
            }
            else {
                list.set(crateNextPose, "C");
                list.set(index, ".");
                list.set(nextPos, "P");
            }
        }
        else {
            list.set(index, list.get(nextPos));
            list.set(nextPos, "P");
        };
        gd.setAdapter(aA);
        checkWin();
    }

    void checkWin() {
        if (list.get(winningIndex.get(0)).equalsIgnoreCase("C") && list.get(winningIndex.get(1)).equalsIgnoreCase("C")) {
            ShowPopup("Vous avez gagné !");
        }
    }

    private PopupWindow POPUP_WINDOW_SCORE = null;


    private void ShowPopup(String message)
    {
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.layout_popup, null);

        POPUP_WINDOW_SCORE = new PopupWindow(this);
        POPUP_WINDOW_SCORE.setContentView(layout);
        POPUP_WINDOW_SCORE.setWidth(width);
        POPUP_WINDOW_SCORE.setHeight(height);
        POPUP_WINDOW_SCORE.setFocusable(true);
        POPUP_WINDOW_SCORE.setBackgroundDrawable(null);

        POPUP_WINDOW_SCORE.showAtLocation(layout, Gravity.CENTER, 1, 1);

        TextView txtMessage = (TextView) layout.findViewById(R.id.layout_popup_txtMessage);
        txtMessage.setText(message);
        Button butOne = (Button) layout.findViewById(R.id.layout_popup_butOne);
        butOne.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent myIntent = new Intent(MovementButtons.this, MainActivity.class);
                //myIntent.putExtra("key", value); //Optional parameters
                MovementButtons.this.startActivity(myIntent);
            }
        });

    }
}