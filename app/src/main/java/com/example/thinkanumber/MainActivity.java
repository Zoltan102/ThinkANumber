package com.example.thinkanumber;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnPlus;
    private Button btnMinus;
    private Button btnTipp;
    private ImageView hp1;
    private ImageView hp2;
    private ImageView hp3;
    private ImageView hp4;
    private ImageView[] eletek;
    private TextView tippErtek;
    private int tipp;
    private int num;
    private int hp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addListeners();

    }

    private void addListeners() {
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tipp < 10) {
                    tipp++;
                    tippErtek.setText(String.valueOf(tipp));
                } else {
                    Toast.makeText(MainActivity.this, "A gondolt szám nem lehet nyagyobb mint 10!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tipp > 1) {
                    tipp--;
                    tippErtek.setText(String.valueOf(tipp));
                } else {
                    Toast.makeText(MainActivity.this, "A gondolt szám nem lehet kisebb mint 1!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnTipp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tipp < num) {
                    eletCsokkent();
                    Toast.makeText(MainActivity.this, "A gondolt szám nagyobb!", Toast.LENGTH_SHORT).show();

                } else if (tipp > num) {
                    eletCsokkent();
                    Toast.makeText(MainActivity.this, "A gondolt szám kisebb!", Toast.LENGTH_SHORT).show();
                } else {
                    //TODO: győzelem
                }
            }
        });
    }

    private void eletCsokkent() {
        if (hp > 0) {
            hp--;
            eletek[hp].setImageResource(R.drawable.heart1);
        }
        if (hp == 0) {
            //TODO: Vereség
        }
    }

    private void eletCsokkentSwitchCase() {
        hp--;
        switch (hp) {
            case 3:
                hp4.setImageResource(R.drawable.heart1);
                break;
            case 2:
                hp3.setImageResource(R.drawable.heart1);
                break;
            case 1:
                hp2.setImageResource(R.drawable.heart1);
                break;
            case 0:
                hp1.setImageResource(R.drawable.heart1);
                break;
        }
        if (hp == 0) {
            //TODO: Vereség
        }
    }

    private void init() {
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnTipp = findViewById(R.id.btnTipp);
        hp1 = findViewById((R.id.hp_1));
        hp2 = findViewById((R.id.hp_2));
        hp3 = findViewById((R.id.hp_3));
        hp4 = findViewById((R.id.hp_4));
        tippErtek = findViewById(R.id.tippErtek);
        tipp = 1;
        Random rnd = new Random();
        num = rnd.nextInt(10) + 1;
        Log.d("gondolt", String.valueOf(num));
        hp = 4;
        eletek = new ImageView[];
    }
}