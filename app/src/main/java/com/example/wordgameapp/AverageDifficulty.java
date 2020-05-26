package com.example.wordgameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.Random;

public class AverageDifficulty extends AppCompatActivity {

    TextView tvScore;
    Button btn1 , btn2 , btn3 , btn4 , btn5 , btn6 , btn7 , btn8, btn9, btn10, btn11, btn12, btn13, btn14;
    Chronometer chronometer;
    Random random = new Random();
    String[][] array;
    String[] correctWords = new String[7];
    String time;
    int score;

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average_difficulty);

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
        btn9 = findViewById(R.id.btn9);
        btn10 = findViewById(R.id.btn10);
        btn11 = findViewById(R.id.btn11);
        btn12 = findViewById(R.id.btn12);
        btn13 = findViewById(R.id.btn13);
        btn14 = findViewById(R.id.btn14);

        btn3.setVisibility(View.GONE);
        btn4.setVisibility(View.GONE);
        btn5.setVisibility(View.GONE);
        btn6.setVisibility(View.GONE);
        btn7.setVisibility(View.GONE);
        btn8.setVisibility(View.GONE);
        btn9.setVisibility(View.GONE);
        btn10.setVisibility(View.GONE);
        btn11.setVisibility(View.GONE);
        btn12.setVisibility(View.GONE);
        btn13.setVisibility(View.GONE);
        btn14.setVisibility(View.GONE);

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
                checkAnswer(btn7);
                btn9.setVisibility(View.VISIBLE);
                btn10.setVisibility(View.VISIBLE);
                btn7.setEnabled(false);
                btn8.setEnabled(false);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btn8);
                btn9.setVisibility(View.VISIBLE);
                btn10.setVisibility(View.VISIBLE);
                btn7.setEnabled(false);
                btn8.setEnabled(false);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btn9);
                btn11.setVisibility(View.VISIBLE);
                btn12.setVisibility(View.VISIBLE);
                btn9.setEnabled(false);
                btn10.setEnabled(false);
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btn10);
                btn11.setVisibility(View.VISIBLE);
                btn12.setVisibility(View.VISIBLE);
                btn9.setEnabled(false);
                btn10.setEnabled(false);
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btn11);
                btn13.setVisibility(View.VISIBLE);
                btn14.setVisibility(View.VISIBLE);
                btn11.setEnabled(false);
                btn12.setEnabled(false);
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btn12);
                btn13.setVisibility(View.VISIBLE);
                btn14.setVisibility(View.VISIBLE);
                btn11.setEnabled(false);
                btn12.setEnabled(false);
            }
        });

        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.stop();
                time = chronometer.getText().toString();
                checkAnswer(btn13);
                Intent intent = new Intent(AverageDifficulty.this, Results.class);
                intent.putExtra("correctWords", correctWords);
                intent.putExtra("time", time);
                intent.putExtra("score", score);
                intent.putExtra("total", 7);
                startActivity(intent);
                finish();
            }
        });
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.stop();
                time = chronometer.getText().toString();
                checkAnswer(btn14);
                Intent intent = new Intent(AverageDifficulty.this, Results.class);
                intent.putExtra("correctWords", correctWords);
                intent.putExtra("time", time);
                intent.putExtra("score", score);
                intent.putExtra("total", 7);
                startActivity(intent);
                finish();
            }
        });

        chronometer.start();
        startGame();

    }

    private void startGame() {
        array = new String[][]{
                {"Laptop", "Loptop"},
                {"Bulldog", "Balldog"},
                {"Cabinet", "Cabbinet"},
                {"Electric", "Electrict"},
                {"Suicide", "Suicyde"},
                {"Vacuum", "Vaccum"},
                {"Genocide", "Genocyde"},
                {"Hanging", "Hangging"},
                {"Wining", "Winiing"},
                {"Elephant", "Elefant"},
                {"Fallopian Tube", "Faloppian Tube"},
                {"Pinnacle", "Pinaccle"},
                {"Swift", "Shwift"},
                {"Cinder", "Sinnder"},
                {"Cyanide", "Cianyde"},
        };
        setButtonRandomText();
    }

    private void checkAnswer(Button x) {
        String str = x.getText().toString();
        for(String[] i : array){
            if(i[0] == str){
                score++;
                tvScore.setText("Score: " + score);
            }
        }
    }

    private void setButtonRandomText() {
        boolean[] isDone = {false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        Button[] buttonArray = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14};
        int randomNumber;
        int randomI;
        int counter = 0;
        for(int i = 0; i < 7; i++){
            randomNumber = random.nextInt(2);
            randomI = random.nextInt(14);
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
