package com.example.wordgameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.Random;

public class EasyDifficulty extends AppCompatActivity {

    private TextView tvScore;
    private Button btn1 , btn2 , btn3 , btn4 , btn5 , btn6 , btn7 , btn8;
    private Chronometer chronometer;
    private Random random = new Random();
    private final String[][] arrayWords = {
                                            {"rainbow", "rianbow"},
                                            {"Lucid", "lusid"},
                                            {"ball", "baal"},
                                            {"mass", "mas"},
                                            {"razor", "razer"},
                                            {"fan", "faan"},
                                            {"zipper", "ziper"},
                                            {"testing", "testting"},
                                            };
    private String time;
    private int score;
    private int items = 4;
    private String[] correctWords = new String[items];

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

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
                btn1.setEnabled(false);
                btn2.setEnabled(false);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btn2);
                btn3.setVisibility(View.VISIBLE);
                btn4.setVisibility(View.VISIBLE);
                btn1.setEnabled(false);
                btn2.setEnabled(false);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btn3);
                btn5.setVisibility(View.VISIBLE);
                btn6.setVisibility(View.VISIBLE);
                btn3.setEnabled(false);
                btn4.setEnabled(false);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btn4);
                btn5.setVisibility(View.VISIBLE);
                btn6.setVisibility(View.VISIBLE);
                btn3.setEnabled(false);
                btn4.setEnabled(false);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btn5);
                btn7.setVisibility(View.VISIBLE);
                btn8.setVisibility(View.VISIBLE);
                btn5.setEnabled(false);
                btn6.setEnabled(false);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btn6);
                btn7.setVisibility(View.VISIBLE);
                btn8.setVisibility(View.VISIBLE);
                btn5.setEnabled(false);
                btn6.setEnabled(false);
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
                intent.putExtra("total", 4);
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
                intent.putExtra("total", 4);
                startActivity(intent);
                finish();
            }
        });
        chronometer.start();

        setButtonRandomText();
    }

    public void checkAnswer(Button x){
        String str = x.getText().toString();
        for(String[] i : arrayWords){
            if(i[0] == str){
                score++;
                tvScore.setText("Score: " + score);
            }
        }
    }

    public void setButtonRandomText(){
        boolean[] isDone = new boolean[items*2];
        Button[] buttonArray = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8};
        int randomNumber;
        int randomI;
        int counter = 0;
        for(int i = 0; i < items; i++){
            randomNumber = random.nextInt(2);
            randomI = random.nextInt(items*2);
            if(!isDone[randomI]){
                if(randomNumber == 0){
                    buttonArray[counter++].setText(arrayWords[randomI][0]);
                    correctWords[i] = arrayWords[randomI][0];
                    buttonArray[counter++].setText(arrayWords[randomI][1]);
                }else{
                    buttonArray[counter++].setText(arrayWords[randomI][1]);
                    buttonArray[counter++].setText(arrayWords[randomI][0]);
                    correctWords[i] = arrayWords[randomI][0];
                }
                isDone[randomI] = true;
            }else{
                i--;
            }
        }
    }
}
