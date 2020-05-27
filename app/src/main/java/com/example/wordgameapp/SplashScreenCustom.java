package com.example.wordgameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenCustom extends AppCompatActivity {
    TextView tvSplash;
    ImageView ivLogo;
    AnimationSet animationSet = new AnimationSet(true);
    Animation textIn = new AlphaAnimation(0.0f, 1.0f);
    Animation textOut = new AlphaAnimation(1.0f, 0.0f);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_custom);
        tvSplash = findViewById(R.id.tvSplashText);
        ivLogo = findViewById(R.id.ivLogo);
        ivLogo.setImageDrawable(null);

        textIn.setDuration(1000);
        textOut.setDuration(1500);
        textOut.setStartOffset(1700);
        textIn.setStartOffset(100);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                 tvSplash.startAnimation(textIn);
                 tvSplash.setText("A duo project for ICS 115");
                 ivLogo.startAnimation(textIn);
                 ivLogo.setImageResource(R.drawable.logo1);
                 tvSplash.startAnimation(textOut);
                 ivLogo.startAnimation(textOut);
            }
        }, 100);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    tvSplash.startAnimation(textIn);
                    tvSplash.setText("Hosted on UST IICS");
                    ivLogo.startAnimation(textIn);
                    ivLogo.setImageResource(R.drawable.logo2);
                    tvSplash.startAnimation(textOut);
                    ivLogo.startAnimation(textOut);
                }
            },3000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tvSplash.setText(null);
                ivLogo.setImageBitmap(null);
                Intent intent = new Intent(SplashScreenCustom.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        },5600);
    }
}
