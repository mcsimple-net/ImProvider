package com.itremedy.improvidermtfree;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class PortsSelectActivity extends AppCompatActivity {

    LinearLayout linearLayout5ports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ports_select);
        linearLayout5ports = findViewById(R.id.linearLayout5ports);

        linearLayout5ports.setOnClickListener(v -> {

            Intent intent = new Intent(PortsSelectActivity.this,AttentionActivity.class);
            startActivity(intent);
        } );
    }
}