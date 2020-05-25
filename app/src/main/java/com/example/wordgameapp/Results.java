package com.example.wordgameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    Button btnBack;
    TextView tvAnswer1, tvAnswer2, tvAnswer3, tvAnswer4, tvFinalScore, tvFinalTime;
    int score;
    String time;
    String[] correctAnswers = new String[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        tvAnswer1 = findViewById(R.id.tvAnswer1);
        tvAnswer2 = findViewById(R.id.tvAnswer2);
        tvAnswer3 = findViewById(R.id.tvAnswer3);
        tvAnswer4 = findViewById(R.id.tvAnswer4);
        tvFinalScore = findViewById(R.id.tvFinalScore);
        tvFinalTime = findViewById(R.id.tvFinalTime);
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        correctAnswers = intent.getStringArrayExtra("correctWords");
        score = intent.getIntExtra("score", score);
        time = intent.getStringExtra("time");



        tvAnswer1.setText(correctAnswers[0]);
        tvAnswer2.setText(correctAnswers[1]);
        tvAnswer3.setText(correctAnswers[2]);
        tvAnswer4.setText(correctAnswers[3]);


        tvFinalScore.setText("Final Score: " + score + "/4");
        tvFinalTime.setText("Final Time: " + time);


    }
}
