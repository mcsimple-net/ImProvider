package com.itremedy.improvidermtfree;

import static com.itremedy.improvidermtfree.ConnectionManager.result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.jcraft.jsch.JSchException;
import com.tapadoo.alerter.Alerter;

import java.io.IOException;

public class HotspotSetupActivity extends AppCompatActivity {

    Button setupHotspot, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotspot_setup);
        setupHotspot = findViewById(R.id.buttonHotspot);
        back = findViewById(R.id.buttonBackToMain);

        setupHotspot.setOnClickListener(v -> {

            Thread check = new Thread(() -> {
                try {
                    ConnectionManager.runCommand("/ ip address print where comment=defconf");

                    if (!result.contains("198.18.200.0")) {
                        /*
                        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Please configure your MikroTik router first", 8000);
                        View snackbarView = snackbar.getView();
                        TextView tv = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
                        tv.setMaxLines(5);
                        snackbar.show();

                         */
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

                        Intent setup = new Intent(HotspotSetupActivity.this, GuestSetupActivity.class);
                        startActivity(setup);
                    }
        } catch (JSchException | IOException e) {
                     ConnectionManager.close(); restartApp();}
                });
            check.start();
        });

        back.setOnClickListener(v1 -> {

            Intent main = new Intent(HotspotSetupActivity.this,MainActivity.class);
            startActivity(main);

        });

    }
    public void restartApp() {
        Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage( getBaseContext().getPackageName() );
        startActivity(Intent.makeRestartActivityTask(i.getComponent()));
        Runtime.getRuntime().exit(0);
    }

}