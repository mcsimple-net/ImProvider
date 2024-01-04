package com.itremedy.improvidermtfree;

import static com.itremedy.improvidermtfree.ConnectionManager.result;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import com.jcraft.jsch.JSchException;
import com.tapadoo.alerter.Alerter;
import java.io.IOException;


public class SpeedChateauActivity extends AppCompatActivity  {


    private EditText speed;
    private RadioButton radio5,radio2,radio3,radio4,radio1;
    private TextView textViewSpeed2,textViewSpeed3,textViewSpeed4,textViewSpeed5,textViewSpeed1;
    public TextView help_s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed_chateau);
        speed = findViewById(R.id.SpeedC);
        Button set = findViewById(R.id.buttonSetC);
        Button quit = findViewById(R.id.quitAppC);
        radio1 = findViewById(R.id.radio1C);
        radio2 = findViewById(R.id.radio2C);
        radio3 = findViewById(R.id.radio3C);
        radio4 = findViewById(R.id.radio4C);
        radio5 = findViewById(R.id.radio5C);
        textViewSpeed1 = findViewById(R.id.textViewSpeed1C);
        textViewSpeed2 = findViewById(R.id.textViewSpeed2C);
        textViewSpeed3 = findViewById(R.id.textViewSpeed3C);
        textViewSpeed4 = findViewById(R.id.textViewSpeed4C);
        textViewSpeed5 = findViewById(R.id.textViewSpeed5C);
        help_s = findViewById(R.id.help_speed);

        help_s.setOnClickListener(v -> {
                    runOnUiThread(() -> {
                        Alerter.create(this, R.layout.alerter_custom_layout)
                                .setDuration(7000)
                                .setIcon(R.drawable.help)
                                .setBackgroundColorRes(R.color.for_improvider)
                                .enableSwipeToDismiss()
                                .setTitle(R.string.for_unlimited)
                                .show();
                    });
        });

        quit.setOnClickListener(v -> {

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });


        //threads for setting start limits

        Thread limC = new Thread(() -> {
            //Thread.sleep(200);

            Thread l1 = new Thread(() -> {
                try {

                    Thread.sleep(200);
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan201] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                } catch (JSchException | IOException | InterruptedException e) {
                      new RestartApp();
                }
                runOnUiThread(() -> {
                    textViewSpeed1.setText("");
                    textViewSpeed1.setText(result);
                });
            });

            Thread l2 = new Thread(() -> {
                try {

                    Thread.sleep(200);
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan202] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                } catch (JSchException | IOException | InterruptedException e) {
                      new RestartApp();
                }
                runOnUiThread(() -> {
                    textViewSpeed2.setText("");
                    textViewSpeed2.setText(result);
                });
            });


            Thread l3 = new Thread(() -> {
                try {

                    Thread.sleep(200);
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan203] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                } catch (JSchException | IOException | InterruptedException e) {
                      new RestartApp();
                }
                runOnUiThread(() -> {
                    textViewSpeed3.setText("");
                    textViewSpeed3.setText(result);
                });
            });


            Thread l4 = new Thread(() -> {
                try {

                    Thread.sleep(200);
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan204] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                } catch (JSchException | IOException | InterruptedException e) {
                      new RestartApp();
                }
                runOnUiThread(() -> {
                    textViewSpeed4.setText("");
                    textViewSpeed4.setText(result);
                });
            });


            Thread l5 = new Thread(() -> {
                try {

                    Thread.sleep(200);
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan205] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                } catch (JSchException | IOException | InterruptedException e) {
                      new RestartApp();
                }
                runOnUiThread(() -> {
                    textViewSpeed5.setText("");
                    textViewSpeed5.setText(result);
                });
            });

            try {
                l1.start();
                l1.join();
                l2.start();
                l2.join();
                l3.start();
                l3.join();
                l4.start();
                l4.join();
                l5.start();
                l5.join();
            } catch (InterruptedException e) {
                  new RestartApp();
            }
        });
        limC.start();


        // on click SET Button

        set.setOnClickListener(v -> {

            String command = speed.getText().toString();

            if(command.equals(""))
            {
                runOnUiThread(() -> {
                    Alerter.create(this, R.layout.alerter_custom_layout)
                            .setTitle(R.string.please_enter_limit)
                            .setBackgroundColorRes(R.color.for_improvider)
                            .enableSwipeToDismiss()
                            .show();
                });
            }
            else {
                boolean b = command.equals("999");
                int flg = 0;

                if (radio1.isChecked()) {
                    flg = 1;
                    Thread s1 = new Thread(() -> {
                        try {
                            if (b) {
                                ConnectionManager.runCommand("/queue simple remove [find where name=1]");

                            } else {
                                ConnectionManager.runCommand("/queue simple remove [find where name=1]");
                                Thread.sleep(200);
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=1 target=bridge-vlan201");

                            }
                        } catch (JSchException | IOException | InterruptedException e) {
                              new RestartApp();
                        }
                    });
                    s1.start();

                    Thread l1 = new Thread(() -> {
                        try {

                            Thread.sleep(700);
                            ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan201] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                        } catch (JSchException | IOException | InterruptedException e) {
                              new RestartApp();
                        }
                        runOnUiThread(() -> {
                            radio1.setChecked(false);
                            speed.setText(null);
                            textViewSpeed1.setText("");
                            textViewSpeed1.setText(result);
                        });
                    });
                    l1.start();
                }

                if (radio2.isChecked()) {
                    flg = 1;
                    Thread s2 = new Thread(() -> {
                        try {
                            if (b) {
                                ConnectionManager.runCommand("/queue simple remove [find where name=2]");
                            } else {
                                ConnectionManager.runCommand("/queue simple remove [find where name=2]");
                                Thread.sleep(200);
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=2 target=bridge-vlan202");
                            }
                        } catch (JSchException | IOException | InterruptedException e) {
                              new RestartApp();
                        }
                    });
                    s2.start();

                    Thread l2 = new Thread(() -> {
                        try {
                            Thread.sleep(700);
                            ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan202] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");
                        } catch (JSchException | IOException | InterruptedException e) {
                              new RestartApp();
                        }
                        runOnUiThread(() -> {
                            radio2.setChecked(false);
                            textViewSpeed2.setText("");
                            textViewSpeed2.setText(result);
                            speed.setText(null);
                        });
                    });
                    l2.start();

                }
                if (radio3.isChecked()) {
                    flg = 1;
                    Thread s3 = new Thread(() -> {
                        try {
                            if (b) {
                                ConnectionManager.runCommand("/queue simple remove [find where name=3]");
                            } else {
                                ConnectionManager.runCommand("/queue simple remove [find where name=3]");
                                Thread.sleep(200);
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=3 target=bridge-vlan203");
                            }
                        } catch (JSchException | IOException | InterruptedException e) {
                              new RestartApp();
                        }
                    });
                    s3.start();

                    Thread l3 = new Thread(() -> {
                        try {
                            Thread.sleep(700);
                            ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan203] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");
                        } catch (JSchException | IOException | InterruptedException e) {
                              new RestartApp();
                        }
                        runOnUiThread(() -> {
                            radio3.setChecked(false);
                            textViewSpeed3.setText("");
                            textViewSpeed3.setText(result);
                            speed.setText(null);
                        });
                    });
                    l3.start();
                }

                if (radio4.isChecked()) {
                    flg = 1;
                    Thread s4 = new Thread(() -> {
                        try {
                            if (b) {
                                ConnectionManager.runCommand("/queue simple remove [find where name=4]");
                            } else {
                                ConnectionManager.runCommand("/queue simple remove [find where name=4]");
                                Thread.sleep(200);
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=4 target=bridge-vlan204");
                            }
                        } catch (JSchException | IOException | InterruptedException e) {
                              new RestartApp();
                        }
                    });
                    s4.start();

                    Thread l4 = new Thread(() -> {
                        try {
                            Thread.sleep(700);
                            ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan204] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");
                        } catch (JSchException | IOException | InterruptedException e) {
                              new RestartApp();
                        }
                        runOnUiThread(() -> {
                            radio4.setChecked(false);
                            textViewSpeed4.setText("");
                            textViewSpeed4.setText(result);
                            speed.setText(null);
                        });
                    });
                    l4.start();
                }

                if (radio5.isChecked()) {
                    flg = 1;
                    Thread s5 = new Thread(() -> {
                        try {
                            if (b) {
                                ConnectionManager.runCommand("/queue simple remove [find where name=5]");
                            } else {
                                ConnectionManager.runCommand("/queue simple remove [find where name=5]");
                                Thread.sleep(200);
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=5 target=bridge-vlan205");
                            }
                        } catch (JSchException | IOException | InterruptedException e) {
                              new RestartApp();
                        }
                    });
                    s5.start();

                    Thread l5 = new Thread(() -> {
                        try {
                            Thread.sleep(700);
                            ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan205] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");
                        } catch (JSchException | IOException | InterruptedException e) {
                              new RestartApp();
                        }
                        runOnUiThread(() -> {
                            radio5.setChecked(false);
                            textViewSpeed5.setText("");
                            textViewSpeed5.setText(result);
                            speed.setText(null);
                        });
                    });
                    l5.start();
                }

                if(flg == 0)
                {
                    runOnUiThread(() -> {
                        Alerter.create(this, R.layout.alerter_custom_layout)
                                .setTitle(R.string.please_select_port)
                                .setBackgroundColorRes(R.color.for_improvider)
                                .enableSwipeToDismiss()
                                .show();
                    });
                }
            }

        });
    }


    //on-off switching radio buttons

   /* public static class ToggleableRadioButton extends androidx.appcompat.widget.AppCompatRadioButton { public ToggleableRadioButton(Context context) {
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
    }*/

    //refresh activity if opened second time

    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {
            this.finish();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

}
