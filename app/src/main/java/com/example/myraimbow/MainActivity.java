package com.example.myraimbow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.myraimbow.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Boolean onProgress = true;
    private ArrayList<LinearLayout> list = new ArrayList<LinearLayout>();

    private int i;
    private int color;
    private int num = 1;
    private int speed = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        create();
    }
    private void create(){
        list.add(binding.l1);
        list.add(binding.l2);
        list.add(binding.l3);
        list.add(binding.l4);
        list.add(binding.l5);
        list.add(binding.l6);
        list.add(binding.l7);
        list.add(binding.l8);
        list.add(binding.l9);
        list.add(binding.l10);
        list.add(binding.l11);
        list.add(binding.l12);
        list.add(binding.l13);
        list.add(binding.l14);
        list.add(binding.l15);
        list.add(binding.l16);
    }

    public void onClick(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (onProgress){
                    try {
                        update();
                        Thread.sleep(speed);
                        list.get(i).setBackgroundColor(getResources().getColor(color));
                        i = i + 1;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    private void update(){
        binding.textSpeed.setText("S:" + speed);

        if (num == 8 && i > 15){
            num = 0;
        }
        if (i > 15) {
            i = 0;
            num = num + 1;
        }


        if (num == 1){
            color = R.color.red;
        }
        if (num == 2){
            color = R.color.orage;
        }
        if (num == 3){
            color = R.color.yellow;
        }
        if (num == 4){
            color = R.color.green;
        }
        if (num == 5){
            color = R.color.blue;
        }
        if (num == 6){
            color = R.color.black_blue;
        }
        if (num == 7){
            color = R.color.purple;
        }
        if (num == 8){
            color = R.color.black;
        }

    }

    public void PLUS(View view){
        speed = speed - 1;
    }
    public void MINUS(View view){
        speed = speed + 1;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onProgress = false;
        list.clear();
    }

    @Override
    protected void onPause() {
        super.onPause();
        onProgress = false;
    }
}