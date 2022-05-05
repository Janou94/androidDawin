package com.example.sokomanmtj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovementButtons extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movement_buttons);
        String map = "###########x.x#....##...CC.P.##........###########";
        String[] array = map.split("");
        //initializing an ArrayList from array
        List<String> list = new ArrayList<String>(Arrays.asList(array));

        //refer GridView from xml layout file
        GridView gd = (GridView) findViewById(R.id.gridView);
        //data bind GridView with ArrayAdapter
        ArrayAdapter<String> aA = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        gd.setAdapter(aA);

        Button btnLeft= (Button) findViewById(R.id.btnLeft);
        btnLeft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println(list);
                Integer index = list.indexOf("P");
                String whereToMove = list.get(index-1);
                System.out.println(whereToMove);
                if (whereToMove.equals("#")) {
                    System.out.println("no");
                }
                else if(whereToMove.equals("C")) {
                    String whereCrateMoves = list.get(index-2);
                    if (whereCrateMoves.equals("#") || whereCrateMoves.equals("C")) {
                        System.out.println("test");
                    }
                    else {
                        list.set(index-2, "C");
                        list.set(index, ".");
                        list.set(index-1, "P");
                    }
                }
                else {
                    list.set(index, list.get(index-1));
                    list.set(index-1, "P");
                    System.out.println(list);
                };
                gd.setAdapter(aA);
            }
        });

        Button btnRight= (Button) findViewById(R.id.btnRight);
        btnRight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println(list);
                Integer index = list.indexOf("P");
                String whereToMove = list.get(index+1);
                System.out.println(whereToMove);
                if (whereToMove.equals("#")) {
                    System.out.println("no");
                }
                else if(whereToMove.equals("C")) {
                    String whereCrateMoves = list.get(index+2);
                    if (whereCrateMoves.equals("#") || whereCrateMoves.equals("C")) {
                        System.out.println("test");
                    }
                    else {
                        list.set(index+2, "C");
                        list.set(index, ".");
                        list.set(index+1, "P");
                    }
                }
                else {
                    list.set(index, list.get(index+1));
                    list.set(index+1, "P");
                    System.out.println(list);

                };
                gd.setAdapter(aA);
            }
        });

        Button btnUp= (Button) findViewById(R.id.btnUp);
        btnUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println(list);
                Integer index = list.indexOf("P");
                String whereToMove = list.get(index - 10);
                System.out.println(whereToMove);
                if (whereToMove.equals("#")) {
                    System.out.println("no");
                } else if (whereToMove.equals("C")) {
                    String whereCrateMoves = list.get(index - 20);
                    if (whereCrateMoves.equals("#") || whereCrateMoves.equals("C")) {
                        System.out.println("test");
                    } else {
                        list.set(index -20, "C");
                        list.set(index, ".");
                        list.set(index - 10, "P");
                    }
                } else {
                    list.set(index, list.get(index - 10));
                    list.set(index - 10, "P");
                    System.out.println(list);
                }
                ;
                gd.setAdapter(aA);
            }
        });

        Button btnDown= (Button) findViewById(R.id.btnDown);
         btnDown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println(list);
                Integer index = list.indexOf("P");
                String whereToMove = list.get(index+10);
                System.out.println(whereToMove);
                if (whereToMove.equals("#")) {
                    System.out.println("no");
                }
                else if(whereToMove.equals("C")) {
                    String whereCrateMoves = list.get(index+20);
                    if (whereCrateMoves.equals("#") || whereCrateMoves.equals("C")) {
                        System.out.println("test");
                    }
                    else {
                        list.set(index+20, "C");
                        list.set(index, ".");
                        list.set(index+10, "P");
                    }
                }
                else {
                    list.set(index, list.get(index+10));
                    list.set(index+10, "P");
                    System.out.println(list);
                };
                gd.setAdapter(aA);
            }
        });
    }
}