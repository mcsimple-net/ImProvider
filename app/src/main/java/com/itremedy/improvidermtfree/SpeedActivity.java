package com.itremedy.improvidermtfree;

import static com.itremedy.improvidermtfree.ConnectionManager.result;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
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
    TextView textViewSpeed2,textViewSpeed3,textViewSpeed4,textViewSpeed5;


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
        textViewSpeed2 = findViewById(R.id.textViewSpeed2);
        textViewSpeed3 = findViewById(R.id.textViewSpeed3);
        textViewSpeed4 = findViewById(R.id.textViewSpeed4);
        textViewSpeed5 = findViewById(R.id.textViewSpeed5);



        quit.setOnClickListener(v -> {
            ConnectionManager.close();
            finishAffinity();
        });


        //threads for setting start limits


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
            });l2.start();

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
            });l3.start();

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
            });l4.start();

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
            });l5.start();




  // on click SET Button

        set.setOnClickListener(v -> {

            String command = speed.getText().toString();
            speed.getText().clear();

            if (command.equals(""))
            {
                Snackbar.make(findViewById(android.R.id.content),"Please Enter Limit",Snackbar.LENGTH_LONG).show();
            }
            else {
                boolean b = command.equals("999");
                if (radio2.isChecked()) {

                    Thread s2 = new Thread(() -> {
                        try {
                            if (b) {
                                ConnectionManager.runCommand("/queue simple remove [find where name=2]");
                                runOnUiThread(() -> {
                                    textViewSpeed2.setText("");
                                    radio2.setChecked(false);
                                });
                            } else {
                                ConnectionManager.runCommand("/queue simple remove [find where name=2]");
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=2 target=bridge-vlan202");

                                runOnUiThread(() -> {
                                    textViewSpeed2.setText("");
                                    textViewSpeed2.setText(command + "M/" + command + "M");
                                    radio2.setChecked(false);
                                });
                            }
                        } catch (JSchException | IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    s2.start();
                }
                if (radio3.isChecked()) {
                    Thread s3 = new Thread(() -> {
                        try {
                            if (b) {
                                ConnectionManager.runCommand("/queue simple remove [find where name=3]");

                                runOnUiThread(() -> textViewSpeed3.setText(""));
                            } else {
                                ConnectionManager.runCommand("/queue simple remove [find where name=3]");
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=3 target=bridge-vlan203");

                                runOnUiThread(() -> {
                                    textViewSpeed3.setText("");
                                    textViewSpeed3.setText(command + "M/" + command + "M");
                                    radio3.setChecked(false);
                                });
                            }
                        } catch (JSchException | IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    s3.start();
                }
                if (radio4.isChecked()) {
                    Thread s4 = new Thread(() -> {
                        try {
                            if (b) {
                                ConnectionManager.runCommand("/queue simple remove [find where name=4]");
                                runOnUiThread(() -> textViewSpeed4.setText(""));
                            } else {
                                ConnectionManager.runCommand("/queue simple remove [find where name=4]");
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=4 target=bridge-vlan204");

                                runOnUiThread(() -> {
                                    textViewSpeed4.setText("");
                                    textViewSpeed4.setText(command + "M/" + command + "M");
                                    radio4.setChecked(false);
                                });
                            }
                        } catch (JSchException | IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    s4.start();
                }
                if (radio5.isChecked()) {
                    Thread s5 = new Thread(() -> {
                        try {
                            if (b) {
                                ConnectionManager.runCommand("/queue simple remove [find where name=5]");
                                runOnUiThread(() -> textViewSpeed5.setText(""));
                            } else {
                                ConnectionManager.runCommand("/queue simple remove [find where name=5]");
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=5 target=bridge-vlan205");

                                runOnUiThread(() -> {
                                    textViewSpeed5.setText("");
                                    textViewSpeed5.setText(command + "M/" + command + "M");
                                    radio5.setChecked(false);
                                });
                            }
                        } catch (JSchException | IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    s5.start();
                }
            }
        });
    }
    public static class ToggleableRadioButton extends androidx.appcompat.widget.AppCompatRadioButton { public ToggleableRadioButton(Context context) {
            super(context);
        }
        public ToggleableRadioButton(Context context, AttributeSet attrs) {
            super(context, attrs);
        }
        public ToggleableRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }
        @Override
        public void toggle() {
            if(isChecked()) {
                setChecked(false);

            } else {
                setChecked(true);
            }
        }
    }
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {
            this.finish();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

}
