package com.itremedy.improvidermtfree;

import static com.itremedy.improvidermtfree.ConnectionManager.result;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import com.jcraft.jsch.JSchException;
import com.tapadoo.alerter.Alerter;
import java.io.IOException;
import java.util.Base64;
import java.util.Random;

public class CreateUserActivity extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
    }
    EditText hotspotUsername, hotspotPassword, hotspotLimit;
    Button createUser, onoff;
    ConstraintLayout layout;
    int min = 100;
    int max = 9999;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        hotspotUsername = findViewById(R.id.editTextHotspotUsername);
        hotspotPassword = findViewById(R.id.editTextHotspotPassword);
        hotspotLimit = findViewById(R.id.editTextHotspotLimit);
        createUser = findViewById(R.id.buttonCreateUser);
        final HorizontalNumberPicker np_channel_nr = findViewById(R.id.np_channel_nr);
        onoff = findViewById(R.id.buttonEnableDisable);
        layout = findViewById(R.id.constr);
        Button quitCH = findViewById(R.id.buttonQuitCH);




        hotspotUsername.setText(str1);
        hotspotPassword.setText(str2);

        Thread t1 = new Thread(() -> {

            try {
                ConnectionManager.runCommand("/system script run timestamp");
                Thread.sleep(100);

            } catch (JSchException | IOException | InterruptedException e) {
                new RestartApp();
            }
        });
        t1.start();

        quitCH.setOnClickListener(v -> {

            Thread t11 = new Thread(() -> {
                try {
                    ConnectionManager.runCommand(":put [/in wireless get wlan3 disabled]");
                    Thread.sleep(300);
                    if (result.contains("true")) {
                        runOnUiThread(() -> {
                            Alerter.create(this, R.layout.alerter_custom_layout)
                                    .setTitle(R.string.enable_hotspot)
                                    .setBackgroundColorRes(R.color.for_improvider)
                                    .enableSwipeToDismiss()
                                    .show();
                        });

                    }else {
                        Intent setup = new Intent(CreateUserActivity.this, GuestSetupActivity.class);
                        startActivity(setup);
                    }

                } catch (JSchException | InterruptedException | IOException e) {
                      new RestartApp();
                }
            });
            t11.start();
            try {
                t11.join();
            } catch (InterruptedException e) {
                  new RestartApp();
            }
        });



        createUser.setOnClickListener(v -> {

                String hotspotUsername_input = hotspotUsername.getText().toString();
                String hotspotPassword_input = hotspotPassword.getText().toString();
                String hotspotLimit_input = hotspotLimit.getText().toString();
            final int nr = np_channel_nr.getValue();
            String devices = String.valueOf(nr);

                boolean b = hotspotUsername_input.isEmpty() || hotspotPassword_input.isEmpty() || hotspotLimit_input.isEmpty() || hotspotLimit_input.equals("0");
                if (b) {
                    runOnUiThread(() -> {
                        Alerter.create(this, R.layout.alerter_custom_layout)
                                .setTitle(R.string.flds_empty)
                                .setBackgroundColorRes(R.color.for_improvider)
                                .enableSwipeToDismiss()
                                .show();
                    });

                } else {

                    Thread t2 = new Thread(() -> {

                        try {

                                ConnectionManager.runCommand(":put [$datetime2epoch]");
                                int epoch = Integer.parseInt(result.trim());
                                int tleft = Integer.parseInt(hotspotLimit_input) * 3600 + epoch;

                                ConnectionManager.runCommand("/ip hotspot user add name=" + hotspotUsername_input + " password=" + hotspotPassword_input + " limit-uptime=" + hotspotLimit_input + "h" + " profile=improvider" + devices + " comment=" + tleft);

                            } catch (JSchException | IOException e) {
                            new RestartApp();
                        }

                    });

                    t2.start();

                }
            Intent intent = new Intent(CreateUserActivity.this,PrintActivity.class);
            intent.putExtra(Intent.EXTRA_SUBJECT,hotspotUsername_input);
            intent.putExtra(Intent.EXTRA_CC,hotspotPassword_input);
            intent.putExtra(Intent.EXTRA_BCC,hotspotLimit_input);
            intent.putExtra(Intent.EXTRA_TEXT,devices);
            startActivity(intent);

        });

        onoff.setOnClickListener(v -> ShowPopup());

    }
    Random r = new Random();
    int int1 = r.nextInt(max - min + 1) + min;
    int int2 = r.nextInt(max - min + 1) + min;
    String str1 = String.valueOf(int1);
    String str2 = String.valueOf(int2);




    @SuppressLint("ClickableViewAccessibility")
    private void ShowPopup() {
        LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        View popUpView = layoutInflater.inflate(R.layout.reallypopup, null);


        int width = ViewGroup.LayoutParams.WRAP_CONTENT;
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        boolean focusable = true;
        PopupWindow popupWindow = new PopupWindow(popUpView, width, height, focusable);
        layout.post(() -> popupWindow.showAtLocation(layout, Gravity.BOTTOM, 0, 0));
        Button buttonYes, buttonNo;
        buttonYes = popUpView.findViewById(R.id.buttonYes);
        buttonNo = popUpView.findViewById(R.id.buttonNo);


        popUpView.setOnTouchListener((v, event) -> {
            popupWindow.dismiss();
            return true;});

        buttonYes.setOnClickListener(v -> {

            String key8 = new String(Base64.getDecoder().decode(string8()));

            Thread t11 = new Thread(() -> {
                try {
                    ConnectionManager.runCommand(":put [/in wireless get wlan3 disabled]");
                    Thread.sleep(300);
                    if (result.contains("true")) {
                        ConnectionManager.runCommand(key8);
                        ConnectionManager.runCommand("/system script run script8");
                        new RestartApp();
                    }else {


                        runOnUiThread(() -> {
                            Alerter.create(this, R.layout.alerter_custom_layout)
                                    .setTitle(R.string.already_enabled)
                                    .setBackgroundColorRes(R.color.for_improvider)
                                    .enableSwipeToDismiss()
                                    .show();

                        });
                    }

                        } catch (JSchException | InterruptedException | IOException e) {
                              new RestartApp();
                        }
                    });
                    t11.start();
                    try {
                        t11.join();
                    } catch (InterruptedException e) {
                          new RestartApp();
                    }
        });

        buttonNo.setOnClickListener(v -> {

            String key7 = new String(Base64.getDecoder().decode(string7()));

                Thread t10 = new Thread(() -> {
                    try {
                        ConnectionManager.runCommand(":put [/in wireless get wlan3 disabled]");
                        Thread.sleep(300);
                        if (!result.contains("true")) {

                            ConnectionManager.runCommand(key7);
                            ConnectionManager.runCommand("/system script run script7");
                            new RestartApp();

                        } else {
                            runOnUiThread(() -> {

                                Alerter.create(this, R.layout.alerter_custom_layout)
                                        .setTitle(R.string.already_disabled)
                                        .setBackgroundColorRes(R.color.for_improvider)
                                        .enableSwipeToDismiss()
                                        .show();
                            });
                        }
                    } catch (JSchException | IOException | InterruptedException e) {
                          new RestartApp();
                    }
                });
                t10.start();
                try {
                    t10.join();
                } catch (InterruptedException e) {
                      new RestartApp();
                }
        });
    }
    public native String string8();
    public native String string7();

}