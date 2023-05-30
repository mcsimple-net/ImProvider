package com.itremedy.improvidermtfree;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import com.jcraft.jsch.JSchException;
import com.tapadoo.alerter.Alerter;

import java.io.IOException;

public class AdminPassword extends AppCompatActivity {

    private EditText new_password;
    private Button admin_ok;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_password);
        new_password = findViewById(R.id.editTextAdminPassword);
        admin_ok = findViewById(R.id.AdminPasswordOK);




        admin_ok.setOnClickListener(v -> {

            String adminPassword = new_password.getText().toString();

            if (adminPassword.isEmpty()){

                Alerter.create(this,R.layout.alerter_custom_layout)
                        .setTitle(R.string.flds_empty)
                        .setBackgroundColorRes(R.color.for_improvider)
                        .enableSwipeToDismiss()
                        .show();

            }else {
                final Handler handler = new Handler();
                handler.postDelayed(() -> {
                    Thread t10 = new Thread(() -> {
                        try {
                            ConnectionManager.runCommand("/user set admin password=" + adminPassword);
                            Thread.sleep(300);
                            runOnUiThread(() -> {

                                Alerter.create(this,R.layout.alerter_custom_layout)
                                        .setTitle(R.string.new_password_was_set)
                                        .setBackgroundColorRes(R.color.for_improvider)
                                        .enableSwipeToDismiss()
                                        .show();
                            });

                        } catch (JSchException | IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    t10.start();
                    try {
                        t10.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }, 1000);
            }

         });

    }
}