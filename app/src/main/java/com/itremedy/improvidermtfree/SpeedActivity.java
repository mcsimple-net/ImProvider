package com.itremedy.improvidermtfree;

import static com.itremedy.improvidermtfree.ConnectionManager.result;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import com.jcraft.jsch.JSchException;
import java.io.IOException;


public class SpeedActivity extends AppCompatActivity  {

    EditText speed;
    Button set, quit;
    RadioButton radio5,radio2,radio3,radio4;
   TextView textViewSpeed2;
    TextView textViewSpeed3;
    TextView textViewSpeed4;
    TextView textViewSpeed5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);
        speed = findViewById(R.id.EnterSpeed);
        set = findViewById(R.id.buttonSet);
        quit = findViewById(R.id.buttonQuit);
        radio2 = findViewById(R.id.radio2);
        radio3 = findViewById(R.id.radio3);
        radio4 = findViewById(R.id.radio4);
        radio5 = findViewById(R.id.radio5);
        textViewSpeed2  = (TextView)findViewById(R.id.textViewSpeed2);
        textViewSpeed3 = (TextView)findViewById(R.id.textViewSpeed3);
        textViewSpeed4 = (TextView)findViewById(R.id.textViewSpeed4);
        textViewSpeed5 = (TextView)findViewById(R.id.textViewSpeed5);

        quit.setOnClickListener(v -> {
            ConnectionManager.close();
            finishAffinity();
        });

        //threads for setting start limits

        final Handler handler = new Handler();
        handler.postDelayed(() -> {
        Thread limit = new Thread(() -> {
            Thread l2 = new Thread(() -> {
                try {
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan202] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");
                    Thread.sleep(100);

                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
                runOnUiThread(() -> {
                    textViewSpeed2.setText("");
                    textViewSpeed2.setText(result);
                });
            });

            Thread l3 = new Thread(() -> {
                try {
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan203] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");
                    Thread.sleep(100);
                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
                runOnUiThread(() -> {
                    textViewSpeed3.setText("");
                    textViewSpeed3.setText(result);
                });
            });

            Thread l4 = new Thread(() -> {
                try {
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan204] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");
                    Thread.sleep(100);
                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
                runOnUiThread(() -> {
                    textViewSpeed4.setText("");
                    textViewSpeed4.setText(result);
                });
            });

            Thread l5 = new Thread(() -> {
                try {
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan205] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");
                    Thread.sleep(100);
                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
                runOnUiThread(() -> {
                    textViewSpeed5.setText("");
                    textViewSpeed5.setText(result);
                });
            });
            try {
                l2.start();
                l2.join();
                l3.start();
                l3.join();
                l4.start();
                l4.join();
                l5.start();
                l5.join();
            } catch (InterruptedException e) {
                Snackbar.make(findViewById(android.R.id.content), "Sorry for all", Snackbar.LENGTH_SHORT).show();
            }
        });limit.start();
        }, 100);

        set.setOnClickListener(v -> {

            String command = speed.getText().toString();
            speed.getText().clear();

            Thread t = new Thread(() -> {
                try {
                    if (command.equals(""))
                    {
                        Snackbar.make(findViewById(android.R.id.content),"Please Enter Limit",Snackbar.LENGTH_LONG).show();
                    }
                    else {
                        boolean b = command.equals("999");
                        if (radio2.isChecked()){
                            if (b) {
                                ConnectionManager.runCommand("/queue simple remove [find where name=2]");
                                runOnUiThread(() -> textViewSpeed2.setText(""));
                            } else
                            {
                                ConnectionManager.runCommand("/queue simple remove [find where name=2]");
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=2 target=bridge-vlan202");

                                runOnUiThread(() -> {
                                    textViewSpeed2.setText("");
                                    textViewSpeed2.setText(command + "M/" + command + "M");
                                });
                            }
                        }
                        if (radio3.isChecked()){
                            if (b){
                                ConnectionManager.runCommand("/queue simple remove [find where name=3]" );
                                runOnUiThread(() -> textViewSpeed3.setText(""));
                            }
                            else
                            {
                                ConnectionManager.runCommand("/queue simple remove [find where name=3]");
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=3 target=bridge-vlan203");

                                runOnUiThread(() -> {
                                    textViewSpeed3.setText("");
                                    textViewSpeed3.setText(command +"M/" + command +"M");
                                });
                            }
                        }
                        if (radio4.isChecked()){
                            if (b){
                                ConnectionManager.runCommand("/queue simple remove [find where name=4]" );
                                runOnUiThread(() -> textViewSpeed4.setText(""));
                            }
                            else{
                                ConnectionManager.runCommand("/queue simple remove [find where name=4]");
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=4 target=bridge-vlan204");

                                runOnUiThread(() -> {
                                    textViewSpeed4.setText("");
                                    textViewSpeed4.setText(command +"M/" + command +"M");
                                });
                            }
                        }
                        if (radio5.isChecked()){
                            if (b){
                                ConnectionManager.runCommand("/queue simple remove [find where name=5]" );
                                runOnUiThread(() -> textViewSpeed5.setText(""));
                            }
                            else{
                                ConnectionManager.runCommand("/queue simple remove [find where name=5]");
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=5 target=bridge-vlan205");

                                runOnUiThread(() -> {
                                    textViewSpeed5.setText("");
                                    textViewSpeed5.setText(command +"M/" + command +"M");
                                });
                            }
                        }
                        else {
                            Snackbar.make(findViewById(android.R.id.content),"Please Select Port",Snackbar.LENGTH_LONG).show();
                        }
                        runOnUiThread(() -> {
                            radio2.setChecked(false);
                            radio3.setChecked(false);
                            radio4.setChecked(false);
                            radio5.setChecked(false);
                        });
                    }
                } catch (JSchException | IOException e) {
                    throw new RuntimeException(e);
                }
            });
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                Snackbar.make(findViewById(android.R.id.content), "Sorry, something went wrong. Try again later.", Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
