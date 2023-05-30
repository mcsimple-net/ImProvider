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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jcraft.jsch.JSchException;
import com.tapadoo.alerter.Alerter;

import java.io.IOException;
import java.security.GeneralSecurityException;


public class GuestSetupActivity extends AppCompatActivity  {


    private EditText guest_name, guest_password, guest_speed;
    private Button set,remove;
    private TextView help_guest;
   SharedPreferences sharedPreferencesGuest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_setup);
        guest_speed = findViewById(R.id.GuestSpeed);
        set = findViewById(R.id.buttonSet10);
        guest_name = findViewById(R.id.editTextWName);
        guest_password = findViewById(R.id.editTextWPassword);
        remove = findViewById(R.id.RemoveGuestWiFi);

        help_guest = findViewById(R.id.help_wifi);

        help_guest.setOnClickListener(v -> {

            Alerter.create(this, R.layout.alerter_custom_layout)
                    .setDuration(10000)
                    .setIcon(R.drawable.help)
                    .setBackgroundColorRes(R.color.for_improvider)
                    .enableSwipeToDismiss()
                    .setTitle(R.string.guest_help)
                    .show();
        });



        remove.setOnClickListener(v2 -> {

            Thread remove = new Thread(() -> {

                try {
                    ConnectionManager.runCommand("/interface wireless remove [find where name=wlan3]");
                    Thread.sleep(500);

                    Alerter.create(this, R.layout.alerter_custom_layout)
                            .setDuration(5000)
                            .setIcon(R.drawable.help)
                            .setBackgroundColorRes(R.color.for_improvider)
                            .enableSwipeToDismiss()
                            .setTitle(R.string.done)
                            .show();
                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            remove.start();
            try {
                remove.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

     sharedPreferencesGuest = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        String guestname_shared = sharedPreferencesGuest.getString("guest_name", "Guest-WiFI");
        String guestpassword_shared = sharedPreferencesGuest.getString("guest_password", "12345678");
        String guestspeed_shared = sharedPreferencesGuest.getString("guest_speed", "5");

        guest_name.setText(guestname_shared);
        guest_password.setText(guestpassword_shared);
        guest_speed.setText(guestspeed_shared);

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
        if (result.contains("GuestSetup")) {

            Alerter.create(this,R.layout.alerter_custom_layout)
                    .setTitle(R.string.please_wait)
                    .enableProgress(true)
                    .setBackgroundColorRes(R.color.for_improvider)
                    .enableSwipeToDismiss()
                    .show();

            final Handler handler = new Handler();
            handler.postDelayed(() -> {
            Thread guest_setup_finish = new Thread(() -> {
                try {
                    ConnectionManager.runCommand("/interface bridge port add bridge=Bridge-Guest interface=wlan3");
                    Thread.sleep(200);
                    ConnectionManager.runCommand("/system identity set name=ImProvider");
                    Thread.sleep(200);

                   ConnectionManager.runCommand("/interface wireless set ssid=" + guestname_shared + " [find where name=wlan3]");
                   Thread.sleep(300);
                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            guest_setup_finish.start();
            try {
                guest_setup_finish.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            }, 1000);


            Alerter.create(this, R.layout.alerter_custom_layout)
                    .setTitle(R.string.guest_ready)
                    .setDuration(5000)
                    .setBackgroundColorRes(R.color.for_improvider)
                    .enableSwipeToDismiss()
                    .show();

            final Handler handler1 = new Handler();
            handler1.postDelayed(() -> {
                Thread finish = new Thread(this::finishAffinity);
                finish.start();
                try {
                    finish.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, 5000);
        }
        set.setOnClickListener(v3 -> {

            MasterKey masterKey = null;
            try {
                masterKey = new MasterKey.Builder(this)
                        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                        .build();
            } catch (GeneralSecurityException | IOException e) {
                throw new RuntimeException(e);
            }

            SharedPreferences sharedPreferencesGuest;
            try {
                sharedPreferencesGuest = EncryptedSharedPreferences.create(
                        this,
                        "secret_shared_prefs",
                        masterKey,
                        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
                );
            } catch (GeneralSecurityException | IOException e) {
                throw new RuntimeException(e);
            }
            sharedPreferencesGuest = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor editor_guest = sharedPreferencesGuest.edit();

            editor_guest.putString("guest_name", guest_name.getText().toString());
            editor_guest.putString("guest_password", guest_password.getText().toString());
            editor_guest.putString("guest_speed", guest_speed.getText().toString());
            editor_guest.apply();

            Intent intent = new Intent(GuestSetupActivity.this,GuestAttention.class);
            intent.putExtra ("guest_name", guest_name.getText().toString());
            intent.putExtra("guest_password", guest_password.getText().toString());
            intent.putExtra("guest_speed", guest_speed.getText().toString());
            startActivity(intent);
        });
    }

}
