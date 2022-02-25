package com.example.timestable_m;

import static java.util.Arrays.asList;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView1);
        SeekBar timesX = findViewById(R.id.seekBar);



        int step = 1;
        int max = 21;
        int min = 1;

        timesX.setMax( (max - min) / step );
        timesX.setProgress(10);

        timesX.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int j, boolean b) {

                int min =1;
                int number ;

                if(j<min){
                    number = min ;
                    timesX.setProgress(min);
                }

                else{

                    number = j ;
                    Log.i("Progress as::", Integer.toString(j));

                    final ArrayList<String> table = new ArrayList<>();
                    for(int i=1 ; i<=100 ;i++){

                        // table.add(number*i); -> good but better to display in form of string
                        table.add(Integer.toString(number*i));

                    }

                     ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this , android.R.layout.simple_list_item_1 , table);
                     listView.setAdapter(arrayAdapter);

                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
