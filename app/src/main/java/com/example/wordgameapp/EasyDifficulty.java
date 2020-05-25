package com.example.wordgameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class EasyDifficulty extends AppCompatActivity {

    TextView tvScore;
    Button btn1 , btn2 , btn3 , btn4 , btn5 , btn6 , btn7 , btn8;
    Chronometer chronometer;
    String[][] array;
    Random random = new Random();
    int score;
    String[] correctWords = new String[4];
    String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_difficulty);

        tvScore = findViewById(R.id.tvScore);
        chronometer = findViewById(R.id.chronometer);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);

        btn3.setVisibility(View.GONE);
        btn4.setVisibility(View.GONE);
        btn5.setVisibility(View.GONE);
        btn6.setVisibility(View.GONE);
        btn7.setVisibility(View.GONE);
        btn8.setVisibility(View.GONE);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btn1);
                btn3.setVisibility(View.VISIBLE);
                btn4.setVisibility(View.VISIBLE);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btn2);
                btn3.setVisibility(View.VISIBLE);
                btn4.setVisibility(View.VISIBLE);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btn3);
                btn5.setVisibility(View.VISIBLE);
                btn6.setVisibility(View.VISIBLE);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btn4);
                btn5.setVisibility(View.VISIBLE);
                btn6.setVisibility(View.VISIBLE);;
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btn5);
                btn7.setVisibility(View.VISIBLE);
                btn8.setVisibility(View.VISIBLE);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btn6);
                btn7.setVisibility(View.VISIBLE);
                btn8.setVisibility(View.VISIBLE);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.stop();
                time = chronometer.getText().toString();
                checkAnswer(btn7);
                Intent intent = new Intent(EasyDifficulty.this, Results.class);
                intent.putExtra("correctWords", correctWords);
                intent.putExtra("time", time);
                intent.putExtra("score", score);
                startActivity(intent);
                finish();
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.stop();
                time = chronometer.getText().toString();
                checkAnswer(btn8);
                Intent intent = new Intent(EasyDifficulty.this, Results.class);
                intent.putExtra("correctWords", correctWords);
                intent.putExtra("time", time);
                intent.putExtra("score", score);
                startActivity(intent);
                finish();
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
                {"razor", "razer"},
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
                    correctWords[i] = array[randomI][0];
                    buttonArray[counter++].setText(array[randomI][1]);
                }else{
                    buttonArray[counter++].setText(array[randomI][1]);
                    buttonArray[counter++].setText(array[randomI][0]);
                    correctWords[i] = array[randomI][0];
                }
                isDone[randomI] = true;
            }else{
                i--;
            }
        }
    }
}
