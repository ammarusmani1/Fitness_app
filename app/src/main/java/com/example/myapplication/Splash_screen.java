package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.example.myapplication.databinding.ActivitySplashScreenBinding;

public class Splash_screen extends AppCompatActivity {
    ActivitySplashScreenBinding binding;
    int translationDistance = 900;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Animate the LottieAnimationView from bottom to top
        ObjectAnimator animationTranslation = ObjectAnimator.ofFloat(binding.animation, "translationY", 0, translationDistance);
        animationTranslation.setDuration(2000);
        animationTranslation.start();

        // Animate the TextView from top to bottom
        ObjectAnimator textTranslation = ObjectAnimator.ofFloat(binding.textView2, "translationY", 0, -translationDistance);
        textTranslation.setDuration(2000);
        textTranslation.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash_screen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 4000);
    }
}
