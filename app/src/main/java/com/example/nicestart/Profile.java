package com.example.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();

        ImageView icono = findViewById(R.id.logo);

        Glide.with(this)
                .load(R.drawable.signup)
                .circleCrop()
                .into(icono);

        TextView userName = findViewById(R.id.user_name);
        userName.setText(intent.getStringExtra("user_name"));
    }
}