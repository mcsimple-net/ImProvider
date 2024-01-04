package com.itremedy.improvidermtfree;

import static com.itremedy.improvidermtfree.ConnectionManager.result;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.jcraft.jsch.JSchException;
import com.tapadoo.alerter.Alerter;
import java.io.IOException;
import java.util.Base64;

public class FirstSetupActivity extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
    }
    EditText wifiName, wifiPass, adminPass;
    Button setup, hotspot, parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_setup);

        wifiName = findViewById(R.id.editTextWiFiName);
        wifiPass = findViewById(R.id.editTextWiFiPassword);
        adminPass = findViewById(R.id.editTextAdminPassword);
        setup = findViewById(R.id.buttonRouterSetup);
        hotspot = findViewById(R.id.mergePortsHotspot);
        parent = findViewById(R.id.mergePorts);
        TextView help = findViewById(R.id.help_wifi);

        help.setOnClickListener(v -> {

            runOnUiThread(() -> {
                Alerter.create(this, R.layout.alerter_custom_layout)
                        .setDuration(10000)
                        .setIcon(R.drawable.help)
                        .setBackgroundColorRes(R.color.for_improvider)
                        .enableSwipeToDismiss()
                        .setTitle(R.string.router_setup)
                        .show();
            });
        });


        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            Thread twname = new Thread(() -> {
                try {
                    ConnectionManager.runCommand(":put [/in wireless get wlan1 ssid]");
                    Thread.sleep(300);
                    runOnUiThread(() -> {
                        wifiName.setText(result.trim());
                    });

                } catch (JSchException | IOException | InterruptedException e) {
                      new RestartApp();
                }

            });
            twname.start();

            Log.d("Handler", "Running Handler");
        }, 200);

        setup.setOnClickListener(v -> {

                Thread test = new Thread(() -> {
                    try {
                        ConnectionManager.runCommand("/system routerboard print");

                        if (!result.contains("routerboard: yes")) {

                            runOnUiThread(() -> {
                                Alerter.create(this, R.layout.alerter_custom_layout)
                                                .setTitle(R.string.mikrotik_address)
                                                .setBackgroundColorRes(R.color.for_improvider)
                                                .setIcon(R.drawable.help)
                                                .enableSwipeToDismiss()
                                                .show();
                            });

                        } else {

                            String setName = wifiName.getText().toString().trim();
                            String setPass = wifiPass.getText().toString().trim();
                            String setAdmin = adminPass.getText().toString().trim();
                            String key43 = new String(Base64.getDecoder().decode(string43()));
                            String key44 = new String(Base64.getDecoder().decode(string44()));
                            String key45 = new String(Base64.getDecoder().decode(string45()));
                            String key46 = new String(Base64.getDecoder().decode(string46()));
                            String key47 = new String(Base64.getDecoder().decode(string47()));

                            if (setName.equals("") || setPass.equals("") || setAdmin.equals("")) {
                                runOnUiThread(() -> {
                                    Alerter.create(this, R.layout.alerter_custom_layout)
                                            .setTitle(R.string.flds_empty)
                                            .setDuration(5000)
                                            .setIcon(R.drawable.help)
                                            .setBackgroundColorRes(R.color.for_improvider)
                                            .enableSwipeToDismiss()
                                            .show();
                                });
                            } else {

                                Thread t = new Thread(() -> {
                                    try {
                                        ConnectionManager.runCommand(key43 + setName + key44 + setName + key45 + setPass + key46 + setAdmin + key47);
                                        ConnectionManager.runCommand("/system script run script9");
                                        
                                        new RestartApp();
                                    } catch (JSchException | IOException e) {
                                        
                                        new RestartApp();
                                    }
                                });
                                t.start();
                                try {
                                    t.join();
                                } catch (InterruptedException e) {
                                    
                                    new RestartApp();
                                }
                            }

                        }
                    } catch (JSchException | IOException e) {
                        throw new RuntimeException(e);
                    }

                });
                test.start();
                try {
                    test.join();
                } catch (InterruptedException e) {
                    
                    new RestartApp();
                }
        });

        parent.setOnClickListener(v -> {

            Thread count = new Thread(() -> {
                try {
                    ConnectionManager.runCommand(":put [/in vlan get bridge-vlan202 name]");
                    Thread.sleep(300);
                    if (!result.contains("bridge-vlan202")) {

                        runOnUiThread(() -> {
                            Alerter.create(this, R.layout.alerter_custom_layout)
                                    .setTitle(R.string.setup_networks)
                                    .setIcon(R.drawable.help)
                                    .setBackgroundColorRes(R.color.for_improvider)
                                    .enableSwipeToDismiss()
                                    .show();
                        });

                    } else {

                        Intent intent = new Intent(FirstSetupActivity.this, MergePorts.class);
                        startActivity(intent);
                    }

                } catch (JSchException | IOException | java.lang.InterruptedException InterruptedException ) {
                      new RestartApp();
                }
            });
            count.start();
            try {
                count.join();
            } catch (InterruptedException e) {
                  new RestartApp();
            }


        });

        hotspot.setOnClickListener(v -> {

            Thread testH = new Thread(() -> {
                try {
                    ConnectionManager.runCommand(":put [/in wireless get wlan3 name]");
                    Thread.sleep(300);

                if (result.contains("wlan3")) {

                    Intent intent = new Intent(FirstSetupActivity.this, MergePortsHotspot.class);
                    startActivity(intent);
                }
                else {

                    runOnUiThread(() -> {
                        Alerter.create(this, R.layout.alerter_custom_layout)
                                .setTitle(R.string.setup_hotspot)
                                .setBackgroundColorRes(R.color.for_improvider)
                                .setIcon(R.drawable.help)
                                .enableSwipeToDismiss()
                                .show();
                    });
                }
                } catch (JSchException | InterruptedException | IOException e) {
                          new RestartApp();
                    }
                });
                testH.start();
            try {
                testH.join();
            } catch (InterruptedException e) {
                  new RestartApp();
            }

        });
    }

    public native String string43();
    public native String string44();
    public native String string45();
    public native String string46();
    public native String string47();
}