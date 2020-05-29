package com.example.wordgameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    private Button btnBack;
    private TextView tvAnswer1, tvAnswer2, tvAnswer3, tvAnswer4, tvAnswer5,  tvAnswer6, tvAnswer7, tvAnswer8, tvAnswer9, tvAnswer10, tvFinalScore, tvFinalTime;
    private int score;
    private int total;
    private String time;
    private String[] correctAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        tvAnswer1 = findViewById(R.id.tvAnswer1);
        tvAnswer2 = findViewById(R.id.tvAnswer2);
        tvAnswer3 = findViewById(R.id.tvAnswer3);
        tvAnswer4 = findViewById(R.id.tvAnswer4);
        tvAnswer5 = findViewById(R.id.tvAnswer5);
        tvAnswer6 = findViewById(R.id.tvAnswer6);
        tvAnswer7 = findViewById(R.id.tvAnswer7);
        tvAnswer8 = findViewById(R.id.tvAnswer8);
        tvAnswer9 = findViewById(R.id.tvAnswer9);
        tvAnswer10 = findViewById(R.id.tvAnswer10);
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
        score = intent.getIntExtra("score", 0);
        time = intent.getStringExtra("time");
        total = intent.getIntExtra("total", 0);
        correctAnswers = new String[total];
        correctAnswers = intent.getStringArrayExtra("correctWords");
        TextView[] tvArray = {tvAnswer1, tvAnswer2, tvAnswer3, tvAnswer4, tvAnswer5,  tvAnswer6, tvAnswer7, tvAnswer8, tvAnswer9, tvAnswer10};

        for(int i = 0; i < total; i++){
            tvArray[i].setText(correctAnswers[i]);
        }

        tvFinalScore.setText("Final Score: " + score + "/" + total);
        tvFinalTime.setText("Final Time: " + time);
    }
}
