package com.itremedy.improvidermtfree;

import static com.itremedy.improvidermtfree.ConnectionManager.result;

import androidx.appcompat.app.AppCompatActivity;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.jcraft.jsch.JSchException;
import com.tapadoo.alerter.Alerter;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class WiFiSetup extends AppCompatActivity {

    private EditText wname,wpassword;
    private Button wifipass, wifiname;
    private TextView help_wifi;
    private SharedPreferences sharedPreferencesW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wi_fi_setup);

        wname = findViewById(R.id.editTextWName);
        wpassword = findViewById(R.id.editTextWPassword);
        wifipass = findViewById(R.id.WiFiPasswordOK);
        wifiname = findViewById(R.id.WiFiNameOK);
        help_wifi = findViewById(R.id.help_wifi);



        //thread for setting name

            Thread twname = new Thread(() -> {
                try {
                    ConnectionManager.runCommand(":put [/in wireless get wlan1 ssid]");
                    Thread.sleep(200);

                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
                runOnUiThread(() -> {
                    wname.setText("");
                    wname.setText(result);
                });
            });
            twname.start();
            try {
                twname.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }



        help_wifi.setOnClickListener(v -> {

            Alerter.create(this, R.layout.alerter_custom_layout)
                    .setDuration(10000)
                    .setIcon(R.drawable.help)
                    .setBackgroundColorRes(R.color.for_improvider)
                    .enableSwipeToDismiss()
                    .setTitle(R.string.wifi_help)
                    .show();
        });


            //for setting password

        sharedPreferencesW = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String password_w = sharedPreferencesW.getString("password_w", "mcsimple");
        wpassword.setText(password_w);

        wifiname.setOnClickListener(v -> {

            String wifiname = wname.getText().toString();
            if (wifiname.isEmpty()){

                Alerter.create(this,R.layout.alerter_custom_layout)
                        .setTitle(R.string.flds_empty)
                        .setBackgroundColorRes(R.color.for_improvider)
                        .enableSwipeToDismiss()
                        .show();

            }else {
                final Handler handler = new Handler();
                handler.postDelayed(() -> {
                    Thread t3 = new Thread(() -> {
                        try {
                            ConnectionManager.runCommand("/interface wireless disable wlan2");
                            Thread.sleep(300);
                            ConnectionManager.runCommand("/interface wireless set ssid=" + wifiname + " [find where name=wlan2]");
                            Thread.sleep(300);
                            ConnectionManager.runCommand("/interface wireless enable wlan2");
                            Thread.sleep(300);
                            ConnectionManager.runCommand("/interface wireless set ssid=" + wifiname + " [find where name=wlan1]");
                            Thread.sleep(2000);
                            runOnUiThread(() -> {
                                ConnectionManager.close();
                                finishAffinity();
                            });
                        } catch (JSchException | IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    t3.start();
                    try {
                        t3.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }, 1000);
            }

        });

        wifipass.setOnClickListener(v3 -> {

            MasterKey masterKey = null;
            try {
                masterKey = new MasterKey.Builder(this)
                        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                        .build();
            } catch (GeneralSecurityException | IOException e) {
                throw new RuntimeException(e);
            }

            SharedPreferences sharedPreferencesW;
            try {
                sharedPreferencesW = EncryptedSharedPreferences.create(
                        this,
                        "secret_shared_prefs",
                        masterKey,
                        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
                );
            } catch (GeneralSecurityException | IOException e) {
                throw new RuntimeException(e);
            }

        sharedPreferencesW = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor_wifi = sharedPreferencesW.edit();
        editor_wifi.putString("password_w", wpassword.getText().toString());
        editor_wifi.apply();

        String wpass = wpassword.getText().toString();

        if (wpass.isEmpty()){
            final Handler handler = new Handler();
            handler.postDelayed(() -> {
                Thread t1 = new Thread(() -> {
                    try {

                        ConnectionManager.runCommand("/interface wireless security-profiles remove [find where name=Security-Profile-Guest]");
                        Thread.sleep(2000);

                        runOnUiThread(() -> {
                            ConnectionManager.close();
                            finishAffinity();
                        });
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
                    t1.start();
                    t1.join();
                } catch (InterruptedException e) {
                    Snackbar.make(findViewById(android.R.id.content), "Sorry for all", Snackbar.LENGTH_SHORT).show();
                }


                Log.d("Handler", "Running Handler");}, 1000);

        }else {
            final Handler handler = new Handler();
            handler.postDelayed(() -> {
                Thread t = new Thread(() -> {
                    try {

                        ConnectionManager.runCommand("/interface wireless security-profiles set wpa2-pre-shared-key=" + wpass + " [find where name=mcsimple]");
                        Thread.sleep(300);

                        runOnUiThread(() -> {
                            ConnectionManager.close();
                            finishAffinity();
                        });
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
                Log.d("Handler", "Running Handler");
            }, 1000);
        }
        });
    }
}