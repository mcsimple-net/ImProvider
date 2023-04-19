package com.itremedy.improvidermtfree;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SelectActionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_action);
        Button set_speed = findViewById(R.id.buttonConnectionSpeed);

        set_speed.setOnClickListener(v -> {

            Intent intent = new Intent(SelectActionActivity.this,SpeedActivity.class);
            startActivity(intent);

        });
    }
}