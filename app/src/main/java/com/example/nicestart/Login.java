package com.example.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ImageView mGirl = findViewById(R.id.girl);

        Glide.with(this)
                .load(R.drawable.login)
                .centerCrop()
                .into(mGirl);
    }

    //metodo para login button
    public void openMain(View v){
        Intent intent = new Intent(Login.this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

        EditText nombre = findViewById(R.id.userName);

        intent.putExtra("user_name",nombre.getText().toString());
        startActivity(intent);
    }

    public void signUp(View v){
        Intent intent = new Intent(Login.this,SignUp.class);
        startActivity(intent);
    }
}