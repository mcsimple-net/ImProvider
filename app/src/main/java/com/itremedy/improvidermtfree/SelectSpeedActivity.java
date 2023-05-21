package com.itremedy.improvidermtfree;

import static com.itremedy.improvidermtfree.ConnectionManager.result;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.jcraft.jsch.JSchException;
import com.tapadoo.alerter.Alerter;

import java.io.IOException;
import java.util.Objects;

public class SelectSpeedActivity extends AppCompatActivity {

    private LinearLayout linearLayout5portsSpeed,linearLayout10portsSpeed,linearLayout24portsSpeed,linearLayoutChateauSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_speed);
        linearLayout5portsSpeed = findViewById(R.id.linearLayout5portsSpeed);
        linearLayout10portsSpeed = findViewById(R.id.linearLayout10portsSpeed);
        linearLayout24portsSpeed = findViewById(R.id.linearLayout24portsSpeed);
        linearLayoutChateauSpeed = findViewById(R.id.linearLayoutChateauSpeed);


        linearLayout5portsSpeed.setOnClickListener(v -> {

            Intent intent = new Intent(SelectSpeedActivity.this,SpeedActivity.class);
            startActivity(intent);
        } );

        linearLayout10portsSpeed.setOnClickListener(v -> {

            Intent intent = new Intent(SelectSpeedActivity.this,Speed10Activity.class);
            startActivity(intent);
        } );

        linearLayout24portsSpeed.setOnClickListener(v -> {

            Intent intent = new Intent(SelectSpeedActivity.this,Speed24Activity.class);
            startActivity(intent);
        } );
    }
}