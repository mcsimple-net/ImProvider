package com.itremedy.improvidermtfree;


import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.jcraft.jsch.JSchException;

import java.io.IOException;

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

            Thread t = new Thread(() -> {

                try {
                    ConnectionManager.runCommand("/system identity set name=ImProvider5");
                } catch (JSchException | IOException e) {
                    throw new RuntimeException(e);
                }
            });
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Intent intent = new Intent(SelectSpeedActivity.this,SpeedActivity.class);
            startActivity(intent);
        } );

        linearLayout10portsSpeed.setOnClickListener(v -> {

            Thread t = new Thread(() -> {

                try {
                    ConnectionManager.runCommand("/system identity set name=ImProvider10");
                } catch (JSchException | IOException e) {
                    throw new RuntimeException(e);
                }
            });
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Intent intent = new Intent(SelectSpeedActivity.this,Speed10Activity.class);
            startActivity(intent);
        } );

        linearLayout24portsSpeed.setOnClickListener(v -> {

            Thread t = new Thread(() -> {

                try {
                    ConnectionManager.runCommand("/system identity set name=ImProvider24");
                } catch (JSchException | IOException e) {
                    throw new RuntimeException(e);
                }
            });
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Intent intent = new Intent(SelectSpeedActivity.this,Speed24Activity.class);
            startActivity(intent);
        } );

        linearLayoutChateauSpeed.setOnClickListener(v -> {

            Thread t = new Thread(() -> {

                try {
                    ConnectionManager.runCommand("/system identity set name=ImProviderLTE");
                } catch (JSchException | IOException e) {
                    throw new RuntimeException(e);
                }
            });
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Intent intent = new Intent(SelectSpeedActivity.this,SpeedChateauActivity.class);
            startActivity(intent);
        } );
    }
}