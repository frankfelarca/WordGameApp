package com.example.wordgameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {

    private Button btnBack;
    private TextView tvNameAronBelmonte, tvNameFrankFelarca;

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        tvNameAronBelmonte = findViewById(R.id.tvNameAronBelmonte);
        tvNameFrankFelarca = findViewById(R.id.tvNameFrankFelarca);
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        tvNameFrankFelarca.setText("Frank Joseph M. Felarca");
        tvNameAronBelmonte.setText("John Aron Belmonte");
    }
}
