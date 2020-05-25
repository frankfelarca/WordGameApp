package com.example.wordgameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class EasyDifficulty extends AppCompatActivity {

    TextView tvScore;
    int score;
    Button btn1 , btn2 , btn3 , btn4 , btn5 , btn6 , btn7 , btn8;
    Chronometer chronometer;
    String[][] array;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_difficulty);

        chronometer = findViewById(R.id.chronometer);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);

        tvScore = findViewById(R.id.tvScore);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btn1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btn2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btn3);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btn4);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btn5);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btn6);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btn7);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btn8);
            }
        });


        chronometer.start();
        startGame();
    }

    public void startGame(){
        array = new String[][]{
                {"cat", "caat"},
                {"hotdog", "hatdog"},
                {"ball", "bal"},
                {"one", "oen"},
                {"razer", "razor"},
                {"fan", "faan"},
                {"zipper", "ziper"},
                {"car", "cer"},
        };
        setButtonRandomText();
    }

    public void checkAnswer(Button x){
        String str = x.getText().toString();
        for(String[] i : array){
            if(i[0] == str){
                score++;
                tvScore.setText("Score: " + score);
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void setButtonRandomText(){
        boolean[] isDone = {false, false, false, false, false, false, false, false};
        Button[] buttonArray = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8};
        int randomNumber;
        int randomI;
        int counter = 0;
        for(int i = 0; i < 4; i++){
            randomNumber = random.nextInt(2);
            randomI = random.nextInt(8);
            if(isDone[randomI] == false){
                if(randomNumber == 0){
                    buttonArray[counter++].setText(array[randomI][0]);
                    buttonArray[counter++].setText(array[randomI][1]);
                }else{
                    buttonArray[counter++].setText(array[randomI][1]);
                    buttonArray[counter++].setText(array[randomI][0]);
                }
                isDone[randomI] = true;
            }else{
                i--;
            }
        }
    }
}
