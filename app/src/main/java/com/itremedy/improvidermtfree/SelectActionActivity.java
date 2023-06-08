package com.itremedy.improvidermtfree;

import static com.itremedy.improvidermtfree.ConnectionManager.result;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.jcraft.jsch.JSchException;
import com.tapadoo.alerter.Alerter;

import java.io.IOException;

public class SelectActionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_action);
        Button set_speed = findViewById(R.id.buttonConnectionSpeed);
        Button guest = findViewById(R.id.GuestWifiSetup);
        Button wifisetup = findViewById(R.id.wifisetup);
        Button cap = findViewById(R.id.changeAdminPass);
        Button merge = findViewById(R.id.mergePorts);

        set_speed.setOnClickListener(v -> {

            Thread t = new Thread(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    ConnectionManager.runCommand("/system identity print");
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
            if (!result.contains("ImProvider")) {
                Alerter.create(this, R.layout.alerter_custom_layout)
                        .setTitle(R.string.setup_first)
                        .setDuration(10000)
                        .setBackgroundColorRes(R.color.for_improvider)
                        .enableSwipeToDismiss()
                        .show();}


            else {Intent intent = new Intent(SelectActionActivity.this,SelectSpeedActivity.class);
            startActivity(intent);}

        });
        guest.setOnClickListener(v1 -> {

            Intent i = new Intent(SelectActionActivity.this,GuestSetupActivity.class);
            startActivity(i);
        });
        wifisetup.setOnClickListener(v2 -> {

            Intent u = new Intent(SelectActionActivity.this,WiFiSetup.class);
            startActivity(u);
        });

        cap.setOnClickListener(v3 -> {

            Intent f = new Intent(SelectActionActivity.this,AdminPassword.class);
            startActivity(f);

        });

        merge.setOnClickListener(v4 -> {
            Thread t = new Thread(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    ConnectionManager.runCommand("/system identity print");
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
            if (!result.contains("ImProvider")) {
                Alerter.create(this, R.layout.alerter_custom_layout)
                        .setTitle(R.string.setup_first)
                        .setDuration(10000)
                        .setBackgroundColorRes(R.color.for_improvider)
                        .enableSwipeToDismiss()
                        .show();}

            else {
                Intent f = new Intent(SelectActionActivity.this,MergePorts.class);
            startActivity(f);
            }

        });
    }

}