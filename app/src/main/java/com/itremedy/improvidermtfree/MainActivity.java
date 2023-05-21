package com.itremedy.improvidermtfree;


import androidx.appcompat.app.AppCompatActivity;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.jcraft.jsch.JSchException;
import com.tapadoo.alerter.Alerter;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    private EditText hostname;
    private EditText port;
    private EditText username;
    private EditText password;
    private Button connect;
    private Button setup, start_page;
    private TextView help_m;
    private SharedPreferences prefs;
    CheckBox checkBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hostname = findViewById(R.id.hostname);
        port = findViewById(R.id.port);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        connect = findViewById(R.id.connect);
        setup = findViewById(R.id.new_router_setup);
        help_m = findViewById(R.id.help_wifi);
        start_page = findViewById(R.id.start_page);
        checkBox = findViewById(R.id.checkBox);


       prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean previouslyStarted = prefs.getBoolean(getString(R.string.pref_previously_started), false);
        if(!previouslyStarted) {

            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String hostname_shared = sharedPreferences.getString("host", "192.168.88.1"); // Second parameter is the default value.
        String port_shared = sharedPreferences.getString("port", "22");
        String username_shared = sharedPreferences.getString("login", "admin");
        String password_shared = sharedPreferences.getString("password", "");

        hostname.setText(hostname_shared);
        port.setText(port_shared);
        username.setText(username_shared);
        password.setText(password_shared);

        help_m.setOnClickListener(v ->
                Alerter.create(this, R.layout.alerter_custom_layout)
                .setDuration(10000)
                .setIcon(R.drawable.help)
                .setBackgroundColorRes(R.color.for_improvider)
                .enableSwipeToDismiss()
                .setTitle(R.string.help_main)
                .show());

        start_page.setOnClickListener(v -> {

            Intent instruction = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(instruction);

        });

        connect.setOnClickListener(v -> {

            String hostname_input = hostname.getText().toString();
            String username_input = username.getText().toString();
            String password_input = password.getText().toString();
            String port_input = port.getText().toString();
            if (!port_input.isEmpty()) {
                ConnectionManager.setPort(Integer.parseInt(port_input));
            } else {
                ConnectionManager.setPort(22);
            }

            if (hostname_input.isEmpty() || username_input.isEmpty() || password_input.isEmpty()) {

                Alerter.create(this,R.layout.alerter_custom_layout)
                        .setTitle(R.string.flds_empty)
                        .setBackgroundColorRes(R.color.for_improvider)
                        .enableSwipeToDismiss()
                        .show();

            }
            else
            {
                ConnectionManager.setHostname(hostname_input);
                ConnectionManager.setUsername(username_input);
                ConnectionManager.setPassword(password_input);
                ConnectionManager.setFlag(-1);

                Alerter.create(this,R.layout.alerter_custom_layout)
                        .setTitle(R.string.please_wait)
                        .enableProgress(true)
                        .setBackgroundColorRes(R.color.for_improvider)
                        .enableSwipeToDismiss()
                        .show();


                final Handler handler = new Handler();
                    handler.postDelayed(() -> {
                        Thread t = new Thread(() -> {
                            try {
                                ConnectionManager.open();

                            } catch (JSchException e)
                            {

                                Alerter.create(this,R.layout.alerter_custom_layout)
                                        .setTitle(R.string.chk_connection)
                                        .setText(Objects.requireNonNull(e.getMessage()))
                                        .setDuration(10000)
                                        .setBackgroundColorRes(R.color.for_improvider)
                                        .enableSwipeToDismiss()
                                        .show();
                            }
                        });
                        t.start();
                        try {
                            t.join();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        if (ConnectionManager.getFlag() == 0) {
                            password.getText().clear();
                            Intent intent = new Intent(MainActivity.this, SelectActionActivity.class);
                            startActivity(intent);
                        }
                        else t.interrupt();
                    }, 1000);

            }
        });

        setup.setOnClickListener(v -> {

            Alerter.create(this,R.layout.alerter_custom_layout)
                    .setTitle(R.string.please_wait)
                    .enableProgress(true)
                    .setBackgroundColorRes(R.color.for_improvider)
                    .enableSwipeToDismiss()
                    .show();

            String hostname_input = hostname.getText().toString();
            String username_input = username.getText().toString();
            String password_input = password.getText().toString();
            String port_input = port.getText().toString();
            if (!port_input.isEmpty())
            {
                ConnectionManager.setPort(Integer.parseInt(port_input));
            }else
            {
                ConnectionManager.setPort(22);
            }

            if (hostname_input.isEmpty() || username_input.isEmpty())
            {
                Alerter.create(this,R.layout.alerter_custom_layout)
                        .setTitle(R.string.flds_empty)
                        .setBackgroundColorRes(R.color.for_improvider)
                        .enableSwipeToDismiss()
                        .show();
            }else
            {
            ConnectionManager.setHostname(hostname_input);
            ConnectionManager.setUsername(username_input);
            ConnectionManager.setPassword(password_input);
            ConnectionManager.setFlag(-1);

                Alerter.create(this,R.layout.alerter_custom_layout)
                        .setTitle(R.string.please_wait)
                        .enableProgress(true)
                        .setBackgroundColorRes(R.color.for_improvider)
                        .enableSwipeToDismiss()
                        .show();

                final Handler handler = new Handler();
                    handler.postDelayed(() -> {
                        @SuppressLint("ResourceAsColor") Thread t1 = new Thread(() -> {
                            try {
                                ConnectionManager.open();
                            } catch (JSchException e)
                            {
                                Alerter.hide();
                                Alerter.create(this,R.layout.alerter_custom_layout)
                                        .setTitle(R.string.chk_connection)
                                        .setText(Objects.requireNonNull(e.getMessage()))
                                        .setDuration(10000)
                                        .setBackgroundColorRes(R.color.for_improvider)
                                        .enableSwipeToDismiss()
                                        .show();
                            }
                        });
                        t1.start();

                        try {
                            t1.join();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        if (ConnectionManager.getFlag() == 0)
                        {
                            password.getText().clear();
                            Intent intent = new Intent(MainActivity.this, PortsSelectActivity.class);
                            startActivity(intent);
                        }
                        else t1.interrupt();
                    }, 1000);
            }
        });
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finishAffinity();
            return;
        }
    }
    public void itemClicked(View v) {
        //code to check if this checkbox is checked!
        CheckBox checkBox = (CheckBox)v;
        if(checkBox.isChecked()) {

            MasterKey masterKey = null;
            try {
                masterKey = new MasterKey.Builder(this)
                        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                        .build();
            } catch (GeneralSecurityException | IOException e) {
                throw new RuntimeException(e);
            }

            SharedPreferences sharedPreferences;
            try {
                sharedPreferences = EncryptedSharedPreferences.create(
                        this,
                        "secret_shared_prefs",
                        masterKey,
                        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
                );
            } catch (GeneralSecurityException | IOException e) {
                throw new RuntimeException(e);
            }
           sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("host", hostname.getText().toString());
            editor.putString("port", port.getText().toString());
            editor.putString("login", username.getText().toString());
            editor.putString("password", password.getText().toString());
            editor.apply();
        }
    }
}
