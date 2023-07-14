package com.itremedy.improvidermtfree;

import static com.itremedy.improvidermtfree.ConnectionManager.result;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.jcraft.jsch.JSchException;
import com.tapadoo.alerter.Alerter;

import java.io.IOException;


public class SpeedActivity extends AppCompatActivity  {


    private EditText speed;
    public Button quit;
    private RadioButton radio5,radio2,radio3,radio4;
    private TextView textViewSpeed2,textViewSpeed3,textViewSpeed4,textViewSpeed5;
    public TextView help_s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);
        speed = findViewById(R.id.Speed);
        Button set = findViewById(R.id.buttonSet);
        quit = findViewById(R.id.quitApp);
        radio2 = findViewById(R.id.radio2);
        radio3 = findViewById(R.id.radio3);
        radio4 = findViewById(R.id.radio4);
        radio5 = findViewById(R.id.radio5);
        textViewSpeed2 = findViewById(R.id.textViewSpeed2);
        textViewSpeed3 = findViewById(R.id.textViewSpeed3);
        textViewSpeed4 = findViewById(R.id.textViewSpeed4);
        textViewSpeed5 = findViewById(R.id.textViewSpeed5);
        help_s = findViewById(R.id.help_speed);

        help_s.setOnClickListener(v -> {

            Alerter.create(this, R.layout.alerter_custom_layout)
                    .setDuration(7000)
                    .setIcon(R.drawable.help)
                    .setBackgroundColorRes(R.color.for_improvider)
                    .enableSwipeToDismiss()
                    .setTitle(R.string.for_unlimited)
                    .show();
        });

        quit.setOnClickListener(v -> {
            ConnectionManager.close();
            finishAffinity();
        });


        //threads for setting start limits

        Thread lim = new Thread(() -> {

            Thread l2 = new Thread(() -> {
                try {

                    Thread.sleep(200);
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan202] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

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

                    Thread.sleep(200);
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan203] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

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

                    Thread.sleep(200);
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan204] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

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

                    Thread.sleep(200);
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan205] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

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
                throw new RuntimeException(e);
            }
        });
            lim.start();


        // on click SET Button

        set.setOnClickListener(v -> {

            String command = speed.getText().toString();

            if(command.equals(""))
            {
                Alerter.create(this,R.layout.alerter_custom_layout)
                        .setTitle(R.string.please_enter_limit)
                        .setBackgroundColorRes(R.color.for_improvider)
                        .enableSwipeToDismiss()
                        .show();
            }
            else {
                boolean b = command.equals("999");
                int flg = 0;
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
                            throw new RuntimeException(e);
                        }
                    });
                    s2.start();

                    Thread l2 = new Thread(() -> {
                        try {
                            Thread.sleep(700);
                            ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan202] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");
                        } catch (JSchException | IOException | InterruptedException e) {
                            throw new RuntimeException(e);
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
                            throw new RuntimeException(e);
                        }
                    });
                    s3.start();

                    Thread l3 = new Thread(() -> {
                        try {
                            Thread.sleep(700);
                            ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan203] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");
                        } catch (JSchException | IOException | InterruptedException e) {
                            throw new RuntimeException(e);
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
                            throw new RuntimeException(e);
                        }
                    });
                    s4.start();

                    Thread l4 = new Thread(() -> {
                        try {
                            Thread.sleep(700);
                            ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan204] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");
                        } catch (JSchException | IOException | InterruptedException e) {
                            throw new RuntimeException(e);
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
                            throw new RuntimeException(e);
                        }
                    });
                    s5.start();

                    Thread l5 = new Thread(() -> {
                        try {
                            Thread.sleep(700);
                            ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan205] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");
                        } catch (JSchException | IOException | InterruptedException e) {
                            throw new RuntimeException(e);
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
                    Alerter.create(this,R.layout.alerter_custom_layout)
                            .setTitle(R.string.please_select_port)
                            .setBackgroundColorRes(R.color.for_improvider)
                            .enableSwipeToDismiss()
                            .show();
                }
            }

        });
    }


    //on-off switching radio buttons

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
