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


public class Speed10Activity extends AppCompatActivity  {


    private EditText speed;
    private Button set, quit;
    private RadioButton radio2,radio3,radio4,radio5,radio6,radio7,radio8,radio9,radio10;
    private TextView textViewSpeed2,textViewSpeed3,textViewSpeed4,textViewSpeed5,textViewSpeed6,textViewSpeed7,textViewSpeed8,textViewSpeed9,textViewSpeed10;

    public TextView help_s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed10);
        speed = findViewById(R.id.Speed10);
        set = findViewById(R.id.buttonSet10);
        quit = findViewById(R.id.quitApp10);
        radio2 = findViewById(R.id.radio210);
        radio3 = findViewById(R.id.radio310);
        radio4 = findViewById(R.id.radio410);
        radio5 = findViewById(R.id.radio510);
        radio6 = findViewById(R.id.radio610);
        radio7 = findViewById(R.id.radio710);
        radio8 = findViewById(R.id.radio810);
        radio9 = findViewById(R.id.radio910);
        radio10 = findViewById(R.id.radio1010);
        textViewSpeed2 = findViewById(R.id.textViewSpeed210);
        textViewSpeed3 = findViewById(R.id.textViewSpeed310);
        textViewSpeed4 = findViewById(R.id.textViewSpeed410);
        textViewSpeed5 = findViewById(R.id.textViewSpeed510);
        textViewSpeed6 = findViewById(R.id.textViewSpeed610);
        textViewSpeed7 = findViewById(R.id.textViewSpeed710);
        textViewSpeed8 = findViewById(R.id.textViewSpeed810);
        textViewSpeed9 = findViewById(R.id.textViewSpeed910);
        textViewSpeed10 = findViewById(R.id.textViewSpeed1010);
        help_s = findViewById(R.id.help_wifi);

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

        Thread lim10 = new Thread(() -> {

            Alerter.create(this,R.layout.alerter_custom_layout)
                    .setTitle(R.string.please_wait)
                    .setDuration(3000)
                    .enableProgress(true)
                    .setBackgroundColorRes(R.color.for_improvider)
                    .enableSwipeToDismiss()
                    .show();

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
            Thread l6 = new Thread(() -> {
                try {

                    Thread.sleep(200);
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan206] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
                runOnUiThread(() -> {
                    textViewSpeed6.setText("");
                    textViewSpeed6.setText(result);
                });
            });
            Thread l7 = new Thread(() -> {
                try {

                    Thread.sleep(200);
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan207] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
                runOnUiThread(() -> {
                    textViewSpeed7.setText("");
                    textViewSpeed7.setText(result);
                });
            });
            Thread l8 = new Thread(() -> {
                try {

                    Thread.sleep(200);
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan208] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
                runOnUiThread(() -> {
                    textViewSpeed8.setText("");
                    textViewSpeed8.setText(result);
                });
            });
            Thread l9 = new Thread(() -> {
                try {

                    Thread.sleep(200);
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan209] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
                runOnUiThread(() -> {
                    textViewSpeed9.setText("");
                    textViewSpeed9.setText(result);
                });
            });
            Thread l10 = new Thread(() -> {
                try {

                    Thread.sleep(200);
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan210] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
                runOnUiThread(() -> {
                    textViewSpeed10.setText("");
                    textViewSpeed10.setText(result);
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
                l6.start();
                l6.join();
                l7.start();
                l7.join();
                l8.start();
                l8.join();
                l9.start();
                l9.join();
                l10.start();
                l10.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        lim10.start();


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
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=2 target=bridge-vlan202");
                            }
                        } catch (JSchException | IOException e) {
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
                            speed.setText(null);
                            textViewSpeed2.setText("");
                            textViewSpeed2.setText(result);
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
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=3 target=bridge-vlan203");


                            }
                        } catch (JSchException | IOException e) {
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
                            speed.setText(null);
                            textViewSpeed3.setText("");
                            textViewSpeed3.setText(result);
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
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=4 target=bridge-vlan204");
                            }
                        } catch (JSchException | IOException e) {
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
                            speed.setText(null);
                            textViewSpeed4.setText("");
                            textViewSpeed4.setText(result);
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
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=5 target=bridge-vlan205");
                            }
                        } catch (JSchException | IOException e) {
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
                            speed.setText(null);
                            textViewSpeed5.setText("");
                            textViewSpeed5.setText(result);
                        });
                    });
                    l5.start();
                }

                if (radio6.isChecked()) {
                    flg = 1;
                    Thread s6 = new Thread(() -> {
                        try {
                            if (b) {
                                ConnectionManager.runCommand("/queue simple remove [find where name=6]");

                            } else {
                                ConnectionManager.runCommand("/queue simple remove [find where name=6]");
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=6 target=bridge-vlan206");

                            }
                        } catch (JSchException | IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    s6.start();

                    Thread l6 = new Thread(() -> {
                        try {
                            Thread.sleep(700);
                            ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan206] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                        } catch (JSchException | IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        runOnUiThread(() -> {
                            radio6.setChecked(false);
                            speed.setText(null);
                            textViewSpeed6.setText("");
                            textViewSpeed6.setText(result);
                        });
                    });
                    l6.start();
                }


                if (radio7.isChecked()) {
                    flg = 1;
                    Thread s7 = new Thread(() -> {
                        try {
                            if (b) {
                                ConnectionManager.runCommand("/queue simple remove [find where name=7]");

                            } else {
                                ConnectionManager.runCommand("/queue simple remove [find where name=7]");
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=7 target=bridge-vlan207");

                            }
                        } catch (JSchException | IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    s7.start();

                    Thread l7 = new Thread(() -> {
                        try {
                            Thread.sleep(700);
                            ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan207] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                        } catch (JSchException | IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        runOnUiThread(() -> {
                            radio7.setChecked(false);
                            speed.setText(null);
                            textViewSpeed7.setText("");
                            textViewSpeed7.setText(result);
                        });
                    });
                    l7.start();

                }

                if (radio8.isChecked()) {
                    flg = 1;
                    Thread s8 = new Thread(() -> {
                        try {
                            if (b) {
                                ConnectionManager.runCommand("/queue simple remove [find where name=8]");

                            } else {
                                ConnectionManager.runCommand("/queue simple remove [find where name=8]");
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=8 target=bridge-vlan208");

                            }
                        } catch (JSchException | IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    s8.start();

                    Thread l8 = new Thread(() -> {
                        try {
                            Thread.sleep(700);
                            ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan208] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                        } catch (JSchException | IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        runOnUiThread(() -> {
                            radio8.setChecked(false);
                            speed.setText(null);
                            textViewSpeed8.setText("");
                            textViewSpeed8.setText(result);
                        });
                    });
                    l8.start();

                }

                if (radio9.isChecked()) {
                    flg = 1;
                    Thread s9 = new Thread(() -> {
                        try {
                            if (b) {
                                ConnectionManager.runCommand("/queue simple remove [find where name=9]");

                            } else {
                                ConnectionManager.runCommand("/queue simple remove [find where name=9]");
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=9 target=bridge-vlan209");

                            }
                        } catch (JSchException | IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    s9.start();

                    Thread l9 = new Thread(() -> {
                        try {
                            Thread.sleep(700);
                            ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan209] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                        } catch (JSchException | IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        runOnUiThread(() -> {
                            radio9.setChecked(false);
                            speed.setText(null);
                            textViewSpeed9.setText("");
                            textViewSpeed9.setText(result);
                        });
                    });
                    l9.start();

                }

                if (radio10.isChecked()) {
                    flg = 1;
                    Thread s10 = new Thread(() -> {
                        try {
                            if (b) {
                                ConnectionManager.runCommand("/queue simple remove [find where name=10]");

                            } else {
                                ConnectionManager.runCommand("/queue simple remove [find where name=10]");
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=10 target=bridge-vlan210");

                            }
                        } catch (JSchException | IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    s10.start();

                    Thread l10 = new Thread(() -> {
                        try {
                            Thread.sleep(700);
                            ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan210] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                        } catch (JSchException | IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        runOnUiThread(() -> {
                            radio10.setChecked(false);
                            speed.setText(null);
                            textViewSpeed10.setText("");
                            textViewSpeed10.setText(result);
                        });
                    });
                    l10.start();
                }

//___________end of threads_____________________________

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
