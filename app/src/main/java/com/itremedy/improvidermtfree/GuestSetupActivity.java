package com.itremedy.improvidermtfree;


import static com.itremedy.improvidermtfree.ConnectionManager.result;

import androidx.appcompat.app.AppCompatActivity;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jcraft.jsch.JSchException;
import com.tapadoo.alerter.Alerter;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Base64;


public class GuestSetupActivity extends AppCompatActivity {


    EditText guest_name, guest_speed;
    Button quit, set;
    TextView help_guest;

    static {
        System.loadLibrary("native-lib");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_setup);
        guest_speed = findViewById(R.id.GuestSpeed);
        set = findViewById(R.id.buttonSet10);
        guest_name = findViewById(R.id.editTextWName);
        quit = findViewById(R.id.quitApp);
        help_guest = findViewById(R.id.help_wifi);


        guest_name.setText("Hotspot");
        guest_speed.setText("5");

        quit.setOnClickListener(v -> {

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });


        help_guest.setOnClickListener(v -> {
            runOnUiThread(() -> {
                Alerter.create(this, R.layout.alerter_custom_layout)
                        .setDuration(10000)
                        .setIcon(R.drawable.help)
                        .setBackgroundColorRes(R.color.for_improvider)
                        .enableSwipeToDismiss()
                        .setTitle(R.string.guest_help)
                        .show();
            });
        });

        set.setOnClickListener(v3 -> {

            String guestname = guest_name.getText().toString().trim();
            String guestspeed = guest_speed.getText().toString();

            if (guestname.isEmpty() || guestspeed.isEmpty()) {
                runOnUiThread(() -> {
                    Alerter.create(this, R.layout.alerter_custom_layout)
                            .setTitle(R.string.flds_empty)
                            .setDuration(5000)
                            .setBackgroundColorRes(R.color.for_improvider)
                            .enableSwipeToDismiss()
                            .show();
                });

            }
            else  {
                runOnUiThread(() -> {
                            Alerter.create(this, R.layout.alerter_custom_layout)
                                    .setTitle(R.string.please_wait)
                                    .enableProgress(true)
                                    .setBackgroundColorRes(R.color.for_improvider)
                                    .enableSwipeToDismiss()
                                    .show();
                        });

                String key34 = new String(Base64.getDecoder().decode(string34()));
                String key35 = new String(Base64.getDecoder().decode(string35()));
                String key36 = new String(Base64.getDecoder().decode(string36()));
                String key37 = new String(Base64.getDecoder().decode(string37()));
                String key38 = new String(Base64.getDecoder().decode(string38()));

                final Handler handler = new Handler();
                handler.postDelayed(() -> {
                Thread t = new Thread(() -> {
                    try {

                        ConnectionManager.runCommand(":put [/in bridge get Bridge-Guest name]");
                        Thread.sleep(300);
                        if (result.contains("Bridge-Guest")){

                            ConnectionManager.runCommand("/system script add dont-require-permissions=no name=script2 owner=admin policy=ftp,reboot,read,write,policy,test,password,sniff,sensitive,romon source={/ip hotspot user profile set [find add-mac-cookie=yes] rate-limit=" + guestspeed + "M/" + guestspeed + "M; /interface wireless set ssid=" + guestname + " [find name=wlan4] ; /interface wireless set ssid=" + guestname + " [find name=wlan3] ; :delay 5; /system script remove script2;}");
                            ConnectionManager.runCommand("/system script run script2");
                            new RestartApp();
                        }

                        else {
                            ConnectionManager.runCommand("/ip firewall filter add action=drop port=8291,80,443 protocol=tcp comment=1 place-before=1 chain=input");
                            ConnectionManager.runCommand("/ip firewall filter remove [find where comment=\"defconf: fasttrack\"]");
                            ConnectionManager.runCommand("/interface bridge add arp=proxy-arp name=Bridge-Guest");

                            ConnectionManager.runCommand("/ip address add address=10.10.10.1/24 interface=Bridge-Guest network=10.10.10.0");
                            ConnectionManager.runCommand("/ip dhcp-server network add address=10.10.10.0/24 gateway=10.10.10.1");
                            ConnectionManager.runCommand("/ip pool add name=guest-pool ranges=10.10.10.2-10.10.10.254");
                            ConnectionManager.runCommand("/ip dhcp-server add add-arp=yes address-pool=guest-pool disabled=no interface=Bridge-Guest lease-time=1h name=dhcp-Guest");
                            ConnectionManager.runCommand("/ip hotspot profile add hotspot-address=10.10.10.1 html-directory=flash/hotspot login-by=http-chap,http-pap,mac-cookie name=hsprof-improvider");

                            ConnectionManager.runCommand("/ip hotspot user profile add name=improvider1 shared-users=1 rate-limit=" + guestspeed + "M/" + guestspeed + "M mac-cookie-timeout=7d keepalive-timeout=10m open-status-page=http-login");
                            ConnectionManager.runCommand("/ip hotspot user profile add name=improvider2 shared-users=2 rate-limit=" + guestspeed + "M/" + guestspeed + "M mac-cookie-timeout=7d keepalive-timeout=10m open-status-page=http-login");
                            ConnectionManager.runCommand("/ip hotspot user profile add name=improvider3 shared-users=3 rate-limit=" + guestspeed + "M/" + guestspeed + "M mac-cookie-timeout=7d keepalive-timeout=10m open-status-page=http-login");
                            ConnectionManager.runCommand("/ip hotspot user profile add name=improvider4 shared-users=4 rate-limit=" + guestspeed + "M/" + guestspeed + "M mac-cookie-timeout=7d keepalive-timeout=10m open-status-page=http-login");
                            ConnectionManager.runCommand("/ip hotspot user profile add name=improvider5 shared-users=5 rate-limit=" + guestspeed + "M/" + guestspeed + "M mac-cookie-timeout=7d keepalive-timeout=10m open-status-page=http-login");
                            ConnectionManager.runCommand("/ip hotspot user profile add name=improvider6 shared-users=6 rate-limit=" + guestspeed + "M/" + guestspeed + "M mac-cookie-timeout=7d keepalive-timeout=10m open-status-page=http-login");
                            ConnectionManager.runCommand("/ip hotspot user profile add name=improvider7 shared-users=7 rate-limit=" + guestspeed + "M/" + guestspeed + "M mac-cookie-timeout=7d keepalive-timeout=10m open-status-page=http-login");
                            ConnectionManager.runCommand("/ip hotspot user profile add name=improvider8 shared-users=8 rate-limit=" + guestspeed + "M/" + guestspeed + "M mac-cookie-timeout=7d keepalive-timeout=10m open-status-page=http-login");
                            ConnectionManager.runCommand("/ip hotspot user profile add name=improvider9 shared-users=9 rate-limit=" + guestspeed + "M/" + guestspeed + "M mac-cookie-timeout=7d keepalive-timeout=10m open-status-page=http-login");
                            ConnectionManager.runCommand("/ip hotspot user profile add name=improvider10 shared-users=10 rate-limit=" + guestspeed + "M/" + guestspeed + "M mac-cookie-timeout=7d keepalive-timeout=10m open-status-page=http-login");

                            ConnectionManager.runCommand("/ip hotspot add address-pool=guest-pool disabled=no interface=Bridge-Guest name=hotspot-improvider profile=hsprof-improvider");

                            ConnectionManager.runCommand(key34);
                            ConnectionManager.runCommand(key35);

                            ConnectionManager.runCommand("/system scheduler" +
                                    " add interval=5m name=del-user on-event=" +
                                    "\"/system script run user-del\" policy=" +
                                    "ftp,reboot,read,write,policy,test,password,sniff,sensitive,romon " +
                                    "start-time=startup");

                            ConnectionManager.runCommand(key36 + guestname + key37 + guestname + key38);
                            ConnectionManager.runCommand("/system script add dont-require-permissions=no name=script1 owner=admin policy=ftp,reboot,read,write,policy,test,password,sniff,sensitive,romon source={:delay 15; /system script remove script3; /ip firewall filter remove [find comment=1]; /system script remove script1;}");
                            ConnectionManager.runCommand("/system script run script1");
                            ConnectionManager.runCommand("/system script run script3");
                            new RestartApp();
                        }
                    } catch (JSchException | IOException | InterruptedException e) {
                        new RestartApp();
                    }

                });

                    t.start();
                try {
                    t.join();
                } catch (InterruptedException e) {
                    new RestartApp();
                }
                }, 500);
            }

        });

    }

    public native String string34();
    public native String string35();
    public native String string36();
    public native String string37();
    public native String string38();
}

