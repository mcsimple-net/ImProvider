package com.itremedy.improvidermtfree;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jcraft.jsch.JSchException;
import com.tapadoo.alerter.Alerter;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    EditText hostname;
    EditText port;
    EditText username;
    EditText password;
    Button connect;
    Button setup;
    TextView help_m;

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
        help_m = findViewById(R.id.help_m);

        help_m.setOnClickListener(v ->
                Alerter.create(this, R.layout.alerter_custom_layout)
                .setDuration(10000)
                .setIcon(R.drawable.help)
                .setBackgroundColorRes(R.color.for_improvider)
                .enableSwipeToDismiss()
                .setTitle(R.string.help_main)
                .show());


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
                            Intent intent = new Intent(this, SelectActionActivity.class);
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

            if (hostname_input.isEmpty() || username_input.isEmpty() || !password_input.isEmpty())
            {
                Alerter.create(this,R.layout.alerter_custom_layout)
                        .setTitle(R.string.empty_or_pswrd_not)
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
                            Intent intent = new Intent(this, PortsSelectActivity.class);
                            startActivity(intent);
                        }
                        else t1.interrupt();
                    }, 1000);
            }
        });
    }
}
