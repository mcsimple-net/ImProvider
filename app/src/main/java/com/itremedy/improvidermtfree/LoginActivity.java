package com.itremedy.improvidermtfree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.agree_login);

        login.setOnClickListener(v -> {

            Intent i = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(i);

        });
    }
}