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

public class PortsSelectActivity extends AppCompatActivity {

    private LinearLayout linearLayout5ports,linearLayout10ports,linearLayout24ports,linearLayoutChateau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ports_select);
        linearLayout5ports = findViewById(R.id.linearLayout5ports);
        linearLayout10ports = findViewById(R.id.linearLayout10ports);
        linearLayout24ports = findViewById(R.id.linearLayout24ports);
        linearLayoutChateau = findViewById(R.id.linearLayoutChateau);


        linearLayout5ports.setOnClickListener(v -> {

            Intent intent = new Intent(PortsSelectActivity.this,AttentionActivity.class);
            startActivity(intent);
        } );

        linearLayout10ports.setOnClickListener(v -> {

            Intent intent = new Intent(PortsSelectActivity.this,Attention10Activity.class);
            startActivity(intent);
        } );

        linearLayout24ports.setOnClickListener(v -> {

            Intent intent = new Intent(PortsSelectActivity.this,Attention24Activity.class);
            startActivity(intent);
        } );
    }
}