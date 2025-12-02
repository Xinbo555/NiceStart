package com.example.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        ImageView mSea = findViewById(R.id.backView);

        Animation anim = AnimationUtils.loadAnimation(this,R.anim.blink);

        ImageView crown = findViewById(R.id.crown);

        crown.startAnimation(anim);

        Glide.with(this)
                .load(R.drawable.girl)
                .centerCrop()
                .into(mSea);

        openApp();
    }

    private void openApp() {

        Handler handler = new Handler();

        handler.postDelayed(()->{
            Intent intent = new Intent(Splash.this, Login.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

            startActivity(intent);
        },5000);
    }
}