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


public class Speed24Activity extends AppCompatActivity  {


    private EditText speed;
    private Button set, quit;
    private RadioButton radio2,radio3,radio4,radio5,radio6,radio7,radio8,radio9,radio10,radio11,radio12,radio13,radio14,radio15,radio16,radio17,radio18,radio19,radio20,radio21,radio22,radio23,radio24;
    private TextView textViewSpeed2,textViewSpeed3,textViewSpeed4,textViewSpeed5,textViewSpeed6,textViewSpeed7,textViewSpeed8,textViewSpeed9,textViewSpeed10,textViewSpeed11,textViewSpeed12,textViewSpeed13,textViewSpeed14,textViewSpeed15,textViewSpeed16,textViewSpeed17,textViewSpeed18,textViewSpeed19,textViewSpeed20,textViewSpeed21,textViewSpeed22,textViewSpeed23,textViewSpeed24;

    public TextView help_s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed24);
        speed = findViewById(R.id.Speed24);
        set = findViewById(R.id.buttonSet24);
        quit = findViewById(R.id.quitApp24);
        radio2 = findViewById(R.id.radio242);
        radio3 = findViewById(R.id.radio243);
        radio4 = findViewById(R.id.radio244);
        radio5 = findViewById(R.id.radio245);
        radio6 = findViewById(R.id.radio246);
        radio7 = findViewById(R.id.radio247);
        radio8 = findViewById(R.id.radio248);
        radio9 = findViewById(R.id.radio249);
        radio10 = findViewById(R.id.radio2410);
        radio11 = findViewById(R.id.radio2411);
        radio12 = findViewById(R.id.radio2412);
        radio13 = findViewById(R.id.radio2413);
        radio14 = findViewById(R.id.radio2414);
        radio15 = findViewById(R.id.radio2415);
        radio16 = findViewById(R.id.radio2416);
        radio17 = findViewById(R.id.radio2417);
        radio18 = findViewById(R.id.radio2418);
        radio19 = findViewById(R.id.radio2419);
        radio20 = findViewById(R.id.radio2420);
        radio21 = findViewById(R.id.radio2421);
        radio22 = findViewById(R.id.radio2422);
        radio23 = findViewById(R.id.radio2423);
        radio24 = findViewById(R.id.radio2424);

        textViewSpeed2 = findViewById(R.id.textViewSpeed242);
        textViewSpeed3 = findViewById(R.id.textViewSpeed243);
        textViewSpeed4 = findViewById(R.id.textViewSpeed244);
        textViewSpeed5 = findViewById(R.id.textViewSpeed245);
        textViewSpeed6 = findViewById(R.id.textViewSpeed246);
        textViewSpeed7 = findViewById(R.id.textViewSpeed247);
        textViewSpeed8 = findViewById(R.id.textViewSpeed248);
        textViewSpeed9 = findViewById(R.id.textViewSpeed249);
        textViewSpeed10 = findViewById(R.id.textViewSpeed2410);
        textViewSpeed11 = findViewById(R.id.textViewSpeed2411);
        textViewSpeed12 = findViewById(R.id.textViewSpeed2412);
        textViewSpeed13 = findViewById(R.id.textViewSpeed2413);
        textViewSpeed14 = findViewById(R.id.textViewSpeed2414);
        textViewSpeed15 = findViewById(R.id.textViewSpeed2415);
        textViewSpeed16 = findViewById(R.id.textViewSpeed2416);
        textViewSpeed17 = findViewById(R.id.textViewSpeed2417);
        textViewSpeed18 = findViewById(R.id.textViewSpeed2418);
        textViewSpeed19 = findViewById(R.id.textViewSpeed2419);
        textViewSpeed20 = findViewById(R.id.textViewSpeed2420);
        textViewSpeed21 = findViewById(R.id.textViewSpeed2421);
        textViewSpeed22 = findViewById(R.id.textViewSpeed2422);
        textViewSpeed23 = findViewById(R.id.textViewSpeed2423);
        textViewSpeed24 = findViewById(R.id.textViewSpeed2424);

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

        Thread lim24 = new Thread(() -> {

            Alerter.create(this,R.layout.alerter_custom_layout)
                    .setTitle(R.string.please_wait)
                    .setDuration(7000)
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

            Thread l11 = new Thread(() -> {
                try {

                    Thread.sleep(200);
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan211] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
                runOnUiThread(() -> {
                    textViewSpeed11.setText("");
                    textViewSpeed11.setText(result);
                });
            });

            Thread l12 = new Thread(() -> {
                try {

                    Thread.sleep(200);
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan212] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
                runOnUiThread(() -> {
                    textViewSpeed12.setText("");
                    textViewSpeed12.setText(result);
                });
            });

            Thread l13 = new Thread(() -> {
                try {

                    Thread.sleep(200);
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan213] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
                runOnUiThread(() -> {
                    textViewSpeed13.setText("");
                    textViewSpeed13.setText(result);
                });
            });

            Thread l14 = new Thread(() -> {
                try {

                    Thread.sleep(200);
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan214] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
                runOnUiThread(() -> {
                    textViewSpeed14.setText("");
                    textViewSpeed14.setText(result);
                });
            });

            Thread l15 = new Thread(() -> {
                try {

                    Thread.sleep(200);
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan215] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
                runOnUiThread(() -> {
                    textViewSpeed15.setText("");
                    textViewSpeed15.setText(result);
                });
            });

            Thread l16 = new Thread(() -> {
                try {

                    Thread.sleep(200);
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan216] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
                runOnUiThread(() -> {
                    textViewSpeed16.setText("");
                    textViewSpeed16.setText(result);
                });
            });

            Thread l17 = new Thread(() -> {
                try {

                    Thread.sleep(200);
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan217] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
                runOnUiThread(() -> {
                    textViewSpeed17.setText("");
                    textViewSpeed17.setText(result);
                });
            });

            Thread l18 = new Thread(() -> {
                try {

                    Thread.sleep(200);
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan218] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
                runOnUiThread(() -> {
                    textViewSpeed18.setText("");
                    textViewSpeed18.setText(result);
                });
            });

            Thread l19 = new Thread(() -> {
                try {

                    Thread.sleep(200);
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan219] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
                runOnUiThread(() -> {
                    textViewSpeed19.setText("");
                    textViewSpeed19.setText(result);
                });
            });

            Thread l20 = new Thread(() -> {
                try {

                    Thread.sleep(200);
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan220] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
                runOnUiThread(() -> {
                    textViewSpeed20.setText("");
                    textViewSpeed20.setText(result);
                });
            });

            Thread l21 = new Thread(() -> {
                try {

                    Thread.sleep(200);
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan221] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
                runOnUiThread(() -> {
                    textViewSpeed21.setText("");
                    textViewSpeed21.setText(result);
                });
            });

            Thread l22 = new Thread(() -> {
                try {

                    Thread.sleep(200);
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan222] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
                runOnUiThread(() -> {
                    textViewSpeed22.setText("");
                    textViewSpeed22.setText(result);
                });
            });

            Thread l23 = new Thread(() -> {
                try {

                    Thread.sleep(200);
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan223] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
                runOnUiThread(() -> {
                    textViewSpeed23.setText("");
                    textViewSpeed23.setText(result);
                });
            });

            Thread l24 = new Thread(() -> {
                try {

                    Thread.sleep(200);
                    ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan224] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
                runOnUiThread(() -> {
                    textViewSpeed24.setText("");
                    textViewSpeed24.setText(result);
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
                l11.start();
                l11.join();
                l12.start();
                l12.join();
                l13.start();
                l13.join();
                l14.start();
                l14.join();
                l15.start();
                l15.join();
                l16.start();
                l16.join();
                l17.start();
                l17.join();
                l18.start();
                l18.join();
                l19.start();
                l19.join();
                l20.start();
                l20.join();
                l21.start();
                l21.join();
                l22.start();
                l22.join();
                l23.start();
                l23.join();
                l24.start();
                l24.join();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        lim24.start();


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

                if (radio11.isChecked()) {
                    flg = 1;
                    Thread s11 = new Thread(() -> {
                        try {
                            if (b) {
                                ConnectionManager.runCommand("/queue simple remove [find where name=11]");

                            } else {
                                ConnectionManager.runCommand("/queue simple remove [find where name=11]");
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=11 target=bridge-vlan211");

                            }
                        } catch (JSchException | IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    s11.start();

                    Thread l11 = new Thread(() -> {
                        try {
                            Thread.sleep(700);
                            ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan211] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                        } catch (JSchException | IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        runOnUiThread(() -> {
                            radio11.setChecked(false);
                            speed.setText(null);
                            textViewSpeed11.setText("");
                            textViewSpeed11.setText(result);
                        });
                    });
                    l11.start();
                }

                if (radio12.isChecked()) {
                    flg = 1;
                    Thread s12 = new Thread(() -> {
                        try {
                            if (b) {
                                ConnectionManager.runCommand("/queue simple remove [find where name=12]");

                            } else {
                                ConnectionManager.runCommand("/queue simple remove [find where name=12]");
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=12 target=bridge-vlan212");

                            }
                        } catch (JSchException | IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    s12.start();

                    Thread l12 = new Thread(() -> {
                        try {
                            Thread.sleep(700);
                            ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan212] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                        } catch (JSchException | IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        runOnUiThread(() -> {
                            radio12.setChecked(false);
                            speed.setText(null);
                            textViewSpeed12.setText("");
                            textViewSpeed12.setText(result);
                        });
                    });
                    l12.start();
                }

                if (radio13.isChecked()) {
                    flg = 1;
                    Thread s13 = new Thread(() -> {
                        try {
                            if (b) {
                                ConnectionManager.runCommand("/queue simple remove [find where name=13]");

                            } else {
                                ConnectionManager.runCommand("/queue simple remove [find where name=13]");
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=13 target=bridge-vlan213");

                            }
                        } catch (JSchException | IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    s13.start();

                    Thread l13 = new Thread(() -> {
                        try {
                            Thread.sleep(700);
                            ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan213] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                        } catch (JSchException | IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        runOnUiThread(() -> {
                            radio13.setChecked(false);
                            speed.setText(null);
                            textViewSpeed13.setText("");
                            textViewSpeed13.setText(result);
                        });
                    });
                    l13.start();
                }

                if (radio14.isChecked()) {
                    flg = 1;
                    Thread s14 = new Thread(() -> {
                        try {
                            if (b) {
                                ConnectionManager.runCommand("/queue simple remove [find where name=14]");

                            } else {
                                ConnectionManager.runCommand("/queue simple remove [find where name=14]");
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=14 target=bridge-vlan214");

                            }
                        } catch (JSchException | IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    s14.start();

                    Thread l14 = new Thread(() -> {
                        try {
                            Thread.sleep(700);
                            ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan214] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                        } catch (JSchException | IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        runOnUiThread(() -> {
                            radio14.setChecked(false);
                            speed.setText(null);
                            textViewSpeed14.setText("");
                            textViewSpeed14.setText(result);
                        });
                    });
                    l14.start();
                }

                if (radio15.isChecked()) {
                    flg = 1;
                    Thread s15 = new Thread(() -> {
                        try {
                            if (b) {
                                ConnectionManager.runCommand("/queue simple remove [find where name=15]");

                            } else {
                                ConnectionManager.runCommand("/queue simple remove [find where name=15]");
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=15 target=bridge-vlan215");

                            }
                        } catch (JSchException | IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    s15.start();

                    Thread l15 = new Thread(() -> {
                        try {
                            Thread.sleep(700);
                            ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan215] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                        } catch (JSchException | IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        runOnUiThread(() -> {
                            radio15.setChecked(false);
                            speed.setText(null);
                            textViewSpeed15.setText("");
                            textViewSpeed15.setText(result);
                        });
                    });
                    l15.start();
                }

                if (radio16.isChecked()) {
                    flg = 1;
                    Thread s16 = new Thread(() -> {
                        try {
                            if (b) {
                                ConnectionManager.runCommand("/queue simple remove [find where name=16]");

                            } else {
                                ConnectionManager.runCommand("/queue simple remove [find where name=16]");
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=16 target=bridge-vlan216");

                            }
                        } catch (JSchException | IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    s16.start();

                    Thread l16 = new Thread(() -> {
                        try {
                            Thread.sleep(700);
                            ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan216] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                        } catch (JSchException | IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        runOnUiThread(() -> {
                            radio16.setChecked(false);
                            speed.setText(null);
                            textViewSpeed16.setText("");
                            textViewSpeed16.setText(result);
                        });
                    });
                    l16.start();
                }

                if (radio17.isChecked()) {
                    flg = 1;
                    Thread s17 = new Thread(() -> {
                        try {
                            if (b) {
                                ConnectionManager.runCommand("/queue simple remove [find where name=17]");

                            } else {
                                ConnectionManager.runCommand("/queue simple remove [find where name=17]");
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=17 target=bridge-vlan217");

                            }
                        } catch (JSchException | IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    s17.start();

                    Thread l17 = new Thread(() -> {
                        try {
                            Thread.sleep(700);
                            ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan217] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                        } catch (JSchException | IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        runOnUiThread(() -> {
                            radio17.setChecked(false);
                            speed.setText(null);
                            textViewSpeed17.setText("");
                            textViewSpeed17.setText(result);
                        });
                    });
                    l17.start();
                }

                if (radio18.isChecked()) {
                    flg = 1;
                    Thread s18 = new Thread(() -> {
                        try {
                            if (b) {
                                ConnectionManager.runCommand("/queue simple remove [find where name=18]");

                            } else {
                                ConnectionManager.runCommand("/queue simple remove [find where name=18]");
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=18 target=bridge-vlan218");

                            }
                        } catch (JSchException | IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    s18.start();

                    Thread l18 = new Thread(() -> {
                        try {
                            Thread.sleep(700);
                            ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan218] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                        } catch (JSchException | IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        runOnUiThread(() -> {
                            radio18.setChecked(false);
                            speed.setText(null);
                            textViewSpeed18.setText("");
                            textViewSpeed18.setText(result);
                        });
                    });
                    l18.start();
                }

                if (radio19.isChecked()) {
                    flg = 1;
                    Thread s19 = new Thread(() -> {
                        try {
                            if (b) {
                                ConnectionManager.runCommand("/queue simple remove [find where name=19]");

                            } else {
                                ConnectionManager.runCommand("/queue simple remove [find where name=19]");
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=19 target=bridge-vlan219");

                            }
                        } catch (JSchException | IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    s19.start();

                    Thread l19 = new Thread(() -> {
                        try {
                            Thread.sleep(700);
                            ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan219] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                        } catch (JSchException | IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        runOnUiThread(() -> {
                            radio19.setChecked(false);
                            speed.setText(null);
                            textViewSpeed19.setText("");
                            textViewSpeed19.setText(result);
                        });
                    });
                    l19.start();
                }

                if (radio20.isChecked()) {
                    flg = 1;
                    Thread s20 = new Thread(() -> {
                        try {
                            if (b) {
                                ConnectionManager.runCommand("/queue simple remove [find where name=20]");

                            } else {
                                ConnectionManager.runCommand("/queue simple remove [find where name=20]");
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=20 target=bridge-vlan220");

                            }
                        } catch (JSchException | IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    s20.start();

                    Thread l20 = new Thread(() -> {
                        try {
                            Thread.sleep(700);
                            ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan220] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                        } catch (JSchException | IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        runOnUiThread(() -> {
                            radio20.setChecked(false);
                            speed.setText(null);
                            textViewSpeed20.setText("");
                            textViewSpeed20.setText(result);
                        });
                    });
                    l20.start();
                }
                if (radio21.isChecked()) {
                    flg = 1;
                    Thread s21 = new Thread(() -> {
                        try {
                            if (b) {
                                ConnectionManager.runCommand("/queue simple remove [find where name=21]");

                            } else {
                                ConnectionManager.runCommand("/queue simple remove [find where name=21]");
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=21 target=bridge-vlan221");

                            }
                        } catch (JSchException | IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    s21.start();

                    Thread l21 = new Thread(() -> {
                        try {
                            Thread.sleep(700);
                            ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan221] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                        } catch (JSchException | IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        runOnUiThread(() -> {
                            radio21.setChecked(false);
                            speed.setText(null);
                            textViewSpeed21.setText("");
                            textViewSpeed21.setText(result);
                        });
                    });
                    l21.start();
                }

                if (radio22.isChecked()) {
                    flg = 1;
                    Thread s22 = new Thread(() -> {
                        try {
                            if (b) {
                                ConnectionManager.runCommand("/queue simple remove [find where name=22]");

                            } else {
                                ConnectionManager.runCommand("/queue simple remove [find where name=22]");
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=22 target=bridge-vlan222");

                            }
                        } catch (JSchException | IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    s22.start();

                    Thread l22 = new Thread(() -> {
                        try {
                            Thread.sleep(700);
                            ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan222] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                        } catch (JSchException | IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        runOnUiThread(() -> {
                            radio22.setChecked(false);
                            speed.setText(null);
                            textViewSpeed22.setText("");
                            textViewSpeed22.setText(result);
                        });
                    });
                    l22.start();
                }

                if (radio23.isChecked()) {
                    flg = 1;
                    Thread s23 = new Thread(() -> {
                        try {
                            if (b) {
                                ConnectionManager.runCommand("/queue simple remove [find where name=23]");

                            } else {
                                ConnectionManager.runCommand("/queue simple remove [find where name=23]");
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=23 target=bridge-vlan223");

                            }
                        } catch (JSchException | IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    s23.start();

                    Thread l23 = new Thread(() -> {
                        try {
                            Thread.sleep(700);
                            ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan223] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                        } catch (JSchException | IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        runOnUiThread(() -> {
                            radio23.setChecked(false);
                            speed.setText(null);
                            textViewSpeed23.setText("");
                            textViewSpeed23.setText(result);
                        });
                    });
                    l23.start();
                }

                if (radio24.isChecked()) {
                    flg = 1;
                    Thread s24 = new Thread(() -> {
                        try {
                            if (b) {
                                ConnectionManager.runCommand("/queue simple remove [find where name=24]");

                            } else {
                                ConnectionManager.runCommand("/queue simple remove [find where name=24]");
                                ConnectionManager.runCommand("/queue simple add max-limit=" + command + "M/" + command + "M name=24 target=bridge-vlan224");

                            }
                        } catch (JSchException | IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    s24.start();

                    Thread l24 = new Thread(() -> {
                        try {
                            Thread.sleep(700);
                            ConnectionManager.runCommand(":foreach i in=[/queue simple find where target=bridge-vlan224] do={:local qmax [/queue simple get $i max-limit]; :put \"$qmax\"}");

                        } catch (JSchException | IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        runOnUiThread(() -> {
                            radio24.setChecked(false);
                            speed.setText(null);
                            textViewSpeed24.setText("");
                            textViewSpeed24.setText(result);
                        });
                    });
                    l24.start();
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
