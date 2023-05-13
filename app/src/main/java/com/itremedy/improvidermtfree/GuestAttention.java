package com.itremedy.improvidermtfree;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;
import com.jcraft.jsch.JSchException;
import java.io.IOException;

public class GuestAttention extends AppCompatActivity {

    Button button;
    TextView textViewWait, warning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attention);
        button = findViewById(R.id.buttonIagree);
        textViewWait = findViewById(R.id.textViewWait);
        textViewWait.setVisibility(View.GONE);
        warning = findViewById(R.id.textViewWarning);

        Intent i = getIntent();
        String guestname = i.getStringExtra("guest_name");
        String guestpassword = i.getStringExtra("guest_password");
        String guestspeed = i.getStringExtra("guest_speed");

        button.setOnClickListener(v -> {

            button.setVisibility(View.GONE);
            warning.setVisibility(View.GONE);
            textViewWait.setVisibility(View.VISIBLE);




            final Handler handler = new Handler();
            handler.postDelayed(() -> {
                Thread t = new Thread(() -> {
                    try {

                        Thread.sleep(100);
                        ConnectionManager.runCommand("/system identity set name=GuestSetup");
                        Thread.sleep(200);
                        ConnectionManager.runCommand("/interface wireless security-profiles remove [find where name=Security-Profile-Guest]");
                        Thread.sleep(1000);
                        ConnectionManager.runCommand("/interface wireless security-profiles add authentication-types=wpa2-psk eap-methods=\"\" group-key-update=1h management-protection=allowed mode=dynamic-keys name=Security-Profile-Guest supplicant-identity=\"\" wpa2-pre-shared-key=" + guestpassword);
                        Thread.sleep(1000);
                        ConnectionManager.runCommand("/interface bridge add arp=reply-only name=Bridge-Guest");
                        Thread.sleep(500);
                        ConnectionManager.runCommand("/ip address add address=10.10.10.1/24 interface=Bridge-Guest network=10.10.10.0");
                        Thread.sleep(100);
                        ConnectionManager.runCommand("/ip dhcp-server network add address=10.10.10.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=10.10.10.1");
                        Thread.sleep(100);
                        ConnectionManager.runCommand("/ip pool add name=guest-pool ranges=10.10.10.2-10.10.10.254");
                        Thread.sleep(100);
                        ConnectionManager.runCommand("/ip dhcp-server add add-arp=yes address-pool=guest-pool disabled=no interface=Bridge-Guest lease-time=4h name=dhcp1");
                        Thread.sleep(100);
                        ConnectionManager.runCommand("/queue simple remove [find where name=Guest-WiFi]");
                        Thread.sleep(100);
                        ConnectionManager.runCommand("/queue simple add max-limit=" + guestspeed + "M/" + guestspeed + "M name=Guest-WiFi target=Bridge-Guest");
                        Thread.sleep(100);
                        ConnectionManager.runCommand("/interface wireless set security-profile=Security-Profile-Guest [find where name=wlan3]");
                        Thread.sleep(300);
                        ConnectionManager.runCommand("/interface wireless add default-forwarding=no disabled=no keepalive-frames=disabled  master-interface=wlan1 multicast-buffering=disabled name=wlan3 security-profile=Security-Profile-Guest ssid=" + guestname + " wds-cost-range=0 wds-default-cost=0 wps-mode=disabled");

                    } catch (JSchException | IOException e) {
                        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "An error occurred: " + e.getMessage(), 8000);
                        View snackbarView = snackbar.getView();
                        TextView tv = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
                        tv.setMaxLines(5);
                        snackbar.show();
                    } catch (RuntimeException runtimeException) {
                        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "The server is disconnected. An error occurred: " + runtimeException.getMessage(), 8000);
                        View snackbarView = snackbar.getView();
                        TextView tv = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
                        tv.setMaxLines(5);
                        snackbar.show();
                    } catch (Exception ignored) {
                    }

                });

                try {
                    t.start();
                    t.join();
                } catch (InterruptedException e) {
                    Snackbar.make(findViewById(android.R.id.content), "Sorry for all", Snackbar.LENGTH_SHORT).show();
                }
                ConnectionManager.close();

                finishAffinity();

                Log.d("Handler", "Running Handler");}, 1000);
        });

    }
}
