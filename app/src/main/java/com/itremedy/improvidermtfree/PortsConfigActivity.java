package com.itremedy.improvidermtfree;

import static com.itremedy.improvidermtfree.ConnectionManager.result;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import com.jcraft.jsch.JSchException;
import com.tapadoo.alerter.Alerter;

import java.io.IOException;

public class PortsConfigActivity extends AppCompatActivity {

    Button buttonMultiple, buttonHotspot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        buttonMultiple = findViewById(R.id.buttonBackToMain);
        buttonHotspot = findViewById(R.id.buttonHotspot);
        buttonMultiple.setOnClickListener(v -> {

            Thread count = new Thread(() -> {
                try {
                    ConnectionManager.runCommand("/ ip address print where comment=defconf");

                    if (!result.contains("198.18.200.0")) {

                        runOnUiThread(() -> {
                                    Alerter.create(this, R.layout.alerter_custom_layout)
                                            .setTitle(R.string.configure_mikrotik)
                                            .setIcon(R.drawable.help)
                                            .setBackgroundColorRes(R.color.for_improvider)
                                            .enableSwipeToDismiss()
                                            .show();
                                });
                        //Thread.sleep(8000);

                    } else {

                        ConnectionManager.runCommand("/interface ethernet print count-only");
                        Thread.sleep(300);

                        if (result.contains("25")) {

                            Intent intent = new Intent(this, Attention24Activity.class);
                            startActivity(intent);

                        } else if (result.contains("11")) {

                            Intent intent = new Intent(this, Attention10Activity.class);
                            startActivity(intent);


                        } else if (result.contains("9")) {

                            Intent intent = new Intent(this, Attention8Activity.class);
                            startActivity(intent);


                        } else if (result.contains("5") || result.contains("6")) {

                            Thread countLTE = new Thread(() -> {
                                try {

                                    ConnectionManager.runCommand("/interface ethernet print where slave");
                                    Thread.sleep(300);
                                    if (result.contains("ether1")) {

                                        Intent intent = new Intent(this, AttentionChateauActivity.class);
                                        startActivity(intent);

                                    } else {

                                        Intent intent = new Intent(this, AttentionActivity.class);
                                        startActivity(intent);

                                    }

                                } catch (JSchException | IOException | InterruptedException e) {
                                    ConnectionManager.close();
                                    new RestartApp();
                                }
                            });
                            countLTE.start();

                        } else if (result.contains("4")) {

                            Thread countLTE4 = new Thread(() -> {
                                try {

                                    ConnectionManager.runCommand("/interface ethernet print where slave");
                                    Thread.sleep(300);
                                    if (result.contains("ether1")) {

                                        Intent intent = new Intent(this, Attention4LteActivity.class);
                                        startActivity(intent);

                                    } else {

                                        Intent intent = new Intent(this, Attention4Activity.class);
                                        startActivity(intent);

                                    }
                                } catch (JSchException | IOException | InterruptedException e) {
                                    ConnectionManager.close();
                                    new RestartApp();
                                }
                            });
                            countLTE4.start();
                        } else {

                            Intent intent = new Intent(this, PortsSelectActivity.class);
                            startActivity(intent);

                        }
                    }

                    } catch(JSchException | InterruptedException ignored){
                    } catch(IOException e){
                         ConnectionManager.close(); new RestartApp();
                    }

            });
            count.start();

        });

        buttonHotspot.setOnClickListener(v -> {

            Intent main = new Intent(PortsConfigActivity.this,MainActivity.class);
            startActivity(main);

        });
    }
}