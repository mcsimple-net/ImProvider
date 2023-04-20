package com.itremedy.improvidermtfree;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import com.jcraft.jsch.JSchException;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText hostname;
    EditText port;
    EditText username;
    EditText password;
    Button connect;
    Button setup;
    TextView wait;

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
        wait = findViewById(R.id.Wait);


        connect.setOnClickListener(v -> {

            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (getCurrentFocus() != null) {
                imm.hideSoftInputFromWindow(getCurrentFocus().getApplicationWindowToken(), 0);
            }
            String hostname_input = hostname.getText().toString();
            String username_input = username.getText().toString();
            String password_input = password.getText().toString();

            if (hostname_input.isEmpty() || username_input.isEmpty() || password_input.isEmpty()) {
                Snackbar.make(findViewById(android.R.id.content), "Some fields are empty", Snackbar.LENGTH_SHORT).show();
                return;
            }
            String port_input = port.getText().toString();
            if (!port_input.isEmpty()) {
                ConnectionManager.setPort(Integer.parseInt(port_input));
            } else {
                ConnectionManager.setPort(22);
            }
            ConnectionManager.setHostname(hostname_input);
            ConnectionManager.setUsername(username_input);
            ConnectionManager.setPassword(password_input);
            ConnectionManager.setFlag(-1);

            connect.setVisibility(View.INVISIBLE);
            setup.setVisibility(View.INVISIBLE);
            wait.setVisibility(View.VISIBLE);

            final Handler handler = new Handler();
                    handler.postDelayed(() -> {
            try {
                t.start();
                t.join();
            } catch (InterruptedException e) {
                Snackbar.make(findViewById(android.R.id.content), "Sorry, something went wrong. Try again later.", Snackbar.LENGTH_SHORT).show();
            }
            if (ConnectionManager.getFlag() == 0) {
                password.getText().clear();
                Intent intent = new Intent(this, SelectActionActivity.class);
                startActivity(intent);
                finish();
            }
            }, 1000);
        });

        setup.setOnClickListener(v -> {

            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (getCurrentFocus() != null) {
                imm.hideSoftInputFromWindow(getCurrentFocus().getApplicationWindowToken(), 0);
            }
            String hostname_input = hostname.getText().toString();
            String username_input = username.getText().toString();
            String password_input = password.getText().toString();
            if (hostname_input.isEmpty() || username_input.isEmpty() || !password_input.isEmpty()) {
                Snackbar.make(findViewById(android.R.id.content), "Some fields are empty or password is not empty.", Snackbar.LENGTH_SHORT).show();
                return;
            }
            String port_input = port.getText().toString();
            if (!port_input.isEmpty()) {
                ConnectionManager.setPort(Integer.parseInt(port_input));
            } else {
                ConnectionManager.setPort(22);
            }
            ConnectionManager.setHostname(hostname_input);
            ConnectionManager.setUsername(username_input);
            ConnectionManager.setPassword(password_input);
            ConnectionManager.setFlag(-1);



            final Handler handler = new Handler();
                    handler.postDelayed(() -> {
            try {
                t.start();
                t.join();

                runOnUiThread(() -> {
                    connect.setVisibility(View.INVISIBLE);
                    setup.setVisibility(View.INVISIBLE);
                    wait.setVisibility(View.VISIBLE);
                });

            } catch (InterruptedException e) {
                Snackbar.make(findViewById(android.R.id.content), "Sorry, something went wrong. Try again later.", Snackbar.LENGTH_SHORT).show();
            }
            if (ConnectionManager.getFlag() == 0) {
                password.getText().clear();
                Intent intent = new Intent(this, PortsSelectActivity.class);
                startActivity(intent);
                finish();
            }
            }, 1000);
        });
    }

   Thread t = new Thread(() -> {
        try {
            ConnectionManager.open();
        } catch (JSchException e) {
            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Check your connection, input data or router settings. An error occurred: " + e.getMessage(), 8000);
            View snackbarView = snackbar.getView();
            TextView tv = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
            tv.setMaxLines(5);
            snackbar.show();
        }
    });
}
