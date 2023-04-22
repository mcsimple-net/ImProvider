package com.itremedy.improvidermtfree;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
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
    TextView help;

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

        help = findViewById(R.id.help);

        help.setOnClickListener(v -> {



            Alerter.create(this, R.layout.alerter_custom_layout)
                    .setDuration(30000)
                    .setIcon(R.drawable.help)
                    .setBackgroundColorRes(R.color.for_improvider)
                    .setIconColorFilter(0)
                    .enableSwipeToDismiss()
                    .setTitleAppearance(R.style.AlertTextAppearance)
                    .setTitleTypeface(android.graphics.Typeface.createFromAsset(getAssets(),"fonts/abhaya_libre_semibold.ttf"))
                    .setTextAppearance(R.style.AlertTextAppearance)
                    .setTextTypeface(android.graphics.Typeface.createFromAsset(getAssets(),"fonts/Castrolo.ttf"))
                    .setTitle(R.string.help_main)
                    .show();

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
                        .setIconColorFilter(0)
                        .enableSwipeToDismiss()
                        .show();
                return;
            }

            ConnectionManager.setHostname(hostname_input);
            ConnectionManager.setUsername(username_input);
            ConnectionManager.setPassword(password_input);
            ConnectionManager.setFlag(-1);

            final Handler handler = new Handler();
                    handler.postDelayed(() -> {

                        Alerter.create(this,R.layout.alerter_custom_layout)
                                .setTitle("PLEASE WAIT")
                                .enableProgress(true)
                                .setBackgroundColorRes(R.color.for_improvider)
                                .setIconColorFilter(0)
                                .enableSwipeToDismiss()
                                .show();


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
            }, 100);
        });

        setup.setOnClickListener(v -> {

            Alerter.create(this,R.layout.alerter_custom_layout)
                    .setTitle("PLEASE WAIT")
                    .enableProgress(true)
                    .setBackgroundColorRes(R.color.for_improvider)
                    .setIconColorFilter(0)
                    .enableSwipeToDismiss()
                    .show();

            String hostname_input = hostname.getText().toString();
            String username_input = username.getText().toString();
            String password_input = password.getText().toString();
            String port_input = port.getText().toString();
            if (!port_input.isEmpty()) {
                ConnectionManager.setPort(Integer.parseInt(port_input));
            } else {
                ConnectionManager.setPort(22);
            }

            if (hostname_input.isEmpty() || username_input.isEmpty() || !password_input.isEmpty()) {

                Alerter.create(this,R.layout.alerter_custom_layout)
                        .setTitle(R.string.empty_or_pswrd_not)
                        .setBackgroundColorRes(R.color.for_improvider)
                        .show();
                return;
            }

            ConnectionManager.setHostname(hostname_input);
            ConnectionManager.setUsername(username_input);
            ConnectionManager.setPassword(password_input);
            ConnectionManager.setFlag(-1);

            final Handler handler = new Handler();
                    handler.postDelayed(() -> {

                        Alerter.create(this,R.layout.alerter_custom_layout)
                                .setTitle("PLEASE WAIT")
                                .enableProgress(true)
                                .setBackgroundColorRes(R.color.for_improvider)
                                .setIconColorFilter(0)
                                .enableSwipeToDismiss()
                                .show();

                        t.start();
                        try {
                            t.join();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        if (ConnectionManager.getFlag() == 0) {
                    password.getText().clear();
                    Intent intent = new Intent(this, PortsSelectActivity.class);
                    startActivity(intent);
                }
            }, 100);
        });
    }


   Thread t = new Thread(() -> {

        try {
            ConnectionManager.open();
        } catch (JSchException e) {
            Alerter.hide();
           /* Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Check your connection, input data or router settings. An error occurred: " + e.getMessage(), 8000);
            View snackbarView = snackbar.getView();
            TextView tv = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
            tv.setMaxLines(5);
            snackbar.show();*/

            Alerter.create(this,R.layout.alerter_custom_layout)
                    .setTitle(R.string.chk_connection)
                    .setText(Objects.requireNonNull(e.getMessage()))
                    .setDuration(10000)
                    .enableProgress(true)
                    .setBackgroundColorRes(R.color.for_improvider)
                    .setIconColorFilter(0)
                    .enableSwipeToDismiss()
                    .show();
        }
   });


}
