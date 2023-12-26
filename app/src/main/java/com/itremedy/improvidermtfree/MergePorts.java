package com.itremedy.improvidermtfree;

import static com.itremedy.improvidermtfree.ConnectionManager.result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.jcraft.jsch.JSchException;
import com.tapadoo.alerter.Alerter;

import java.io.IOException;

public class MergePorts extends AppCompatActivity {

    RadioButton m_radio5,m_radio2,m_radio3,m_radio4;
    Button  quit;
    TextView help_merge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merge_ports);

        m_radio2 = findViewById(R.id.radio2);
        m_radio3 = findViewById(R.id.radio3);
        m_radio4 = findViewById(R.id.radio4);
        m_radio5 = findViewById(R.id.radio5);
        help_merge = findViewById(R.id.help_merge);
        quit = findViewById(R.id.quitApp);

        quit.setOnClickListener(v -> {

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

/*
        Alerter.create(this,R.layout.alerter_custom_layout)
                .setTitle(R.string.please_wait)
                .setDuration(2000)
                .enableProgress(true)
                .setBackgroundColorRes(R.color.for_improvider)
                .enableSwipeToDismiss()
                .show();

 */


        final Handler handler = new Handler();
        handler.postDelayed(() -> {
        Thread mergeP = new Thread(() -> {

            try {
                //Thread.sleep(200);
                Thread m2 = new Thread(() -> {
                    try {

                        ConnectionManager.runCommand("/interface bridge port print where interface=ether2");
                        Thread.sleep(300);
                        if (!result.contains("202") && !result.contains("Bridge-Guest")) {
                            runOnUiThread(() -> {
                                m_radio2.setChecked(true);
                            });
                        } else {
                            runOnUiThread(() -> {
                                m_radio2.setChecked(false);
                            });
                        }

                    } catch (JSchException | IOException | InterruptedException e) {
                        
                        new RestartApp();
                    }

                });


                Thread m3 = new Thread(() -> {
                    try {
                        ConnectionManager.runCommand("/interface bridge port print where interface=ether3");
                        Thread.sleep(300);

                        if (!result.contains("203") && !result.contains("Bridge-Guest")) {
                            runOnUiThread(() -> {
                                m_radio3.setChecked(true);
                            });
                        } else {
                            runOnUiThread(() -> {
                                m_radio3.setChecked(false);
                            });
                        }

                    } catch (JSchException | IOException | InterruptedException e) {
                        
                        new RestartApp();
                    }

                });


                Thread m4 = new Thread(() -> {
                    try {
                        ConnectionManager.runCommand("/interface bridge port print where interface=ether4");
                        Thread.sleep(300);

                        if (!result.contains("204") && !result.contains("Bridge-Guest")) {
                            runOnUiThread(() -> {
                                m_radio4.setChecked(true);
                            });
                        } else {
                            runOnUiThread(() -> {
                                m_radio4.setChecked(false);
                            });
                        }

                    } catch (JSchException | IOException | InterruptedException e) {
                        
                        new RestartApp();
                    }

                });


                Thread m5 = new Thread(() -> {
                    try {
                        ConnectionManager.runCommand("/interface bridge port print where interface=ether5");
                        Thread.sleep(300);

                        if (!result.contains("205") && !result.contains("Bridge-Guest")) {
                            runOnUiThread(() -> {
                                m_radio5.setChecked(true);
                            });
                        } else {
                            runOnUiThread(() -> {
                                m_radio5.setChecked(false);
                            });
                        }

                    } catch (JSchException | IOException | InterruptedException e) {
                        
                        new RestartApp();
                    }

                });

                m2.start();
                m2.join();
                m3.start();
                m3.join();
                m4.start();
                m4.join();
                m5.start();
                m5.join();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        mergeP.start();
        try {
            mergeP.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }, 200);

        //End of test---------------------------------------------------




        help_merge.setOnClickListener(v -> {
            runOnUiThread(() -> {
                Alerter.create(this, R.layout.alerter_custom_layout)
                        .setTitle(R.string.help_merge)
                        .setBackgroundColorRes(R.color.for_improvider)
                        .enableSwipeToDismiss()
                        .setDuration(10000)
                        .show();
            });

        });


        m_radio2.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (m_radio2.isChecked()) {
                Thread y2 = new Thread(() -> {
                    try {

                        ConnectionManager.runCommand("/interface bridge port { set [find interface=ether2] bridge=bridge }");
                        ConnectionManager.runCommand("/interface bridge port set [find where interface=ether2] pvid=1");
                    } catch (JSchException | IOException e) {
                          new RestartApp();
                    }

                });
                y2.start();
                try {
                    y2.join();
                } catch (InterruptedException e) {
                      new RestartApp();
                }
            } else {
                Thread n2 = new Thread(() -> {
                    try {

                        ConnectionManager.runCommand("/interface bridge port set [find where interface=ether2] pvid=202");
                    } catch (JSchException | IOException e) {
                          new RestartApp();
                    }

                });
                n2.start();
                try {
                    n2.join();
                } catch (InterruptedException e) {
                      new RestartApp();
                }
            }
        });

        m_radio3.setOnCheckedChangeListener((buttonView, isChecked) -> {


            if (m_radio3.isChecked()) {
                Thread y3 = new Thread(() -> {
                    try {

                        ConnectionManager.runCommand("/interface bridge port { set [find interface=ether3] bridge=bridge }");
                        ConnectionManager.runCommand("/interface bridge port set [find where interface=ether3] pvid=1");
                    } catch (JSchException | IOException e) {
                          new RestartApp();
                    }

                });
                y3.start();
                try {
                    y3.join();
                } catch (InterruptedException e) {
                      new RestartApp();
                }
            } else {
                Thread n3 = new Thread(() -> {
                    try {

                        ConnectionManager.runCommand("/interface bridge port set [find where interface=ether3] pvid=203");
                    } catch (JSchException | IOException e) {
                          new RestartApp();
                    }

                });
                n3.start();
                try {
                    n3.join();
                } catch (InterruptedException e) {
                      new RestartApp();
                }
            }
        });

        m_radio4.setOnCheckedChangeListener((buttonView, isChecked) -> {


            if (m_radio4.isChecked()) {
                Thread y4 = new Thread(() -> {
                    try {

                        ConnectionManager.runCommand("/interface bridge port { set [find interface=ether4] bridge=bridge }");
                        ConnectionManager.runCommand("/interface bridge port set [find where interface=ether4] pvid=1");
                    } catch (JSchException | IOException e) {
                          new RestartApp();
                    }

                });
                y4.start();
                try {
                    y4.join();
                } catch (InterruptedException e) {
                      new RestartApp();
                }
            } else {
                Thread n4 = new Thread(() -> {
                    try {

                        ConnectionManager.runCommand("/interface bridge port set [find where interface=ether4] pvid=204");
                    } catch (JSchException | IOException e) {
                          new RestartApp();
                    }

                });
                n4.start();
                try {
                    n4.join();
                } catch (InterruptedException e) {
                      new RestartApp();
                }
            }
        });

        m_radio5.setOnCheckedChangeListener((buttonView, isChecked) -> {


            if (m_radio5.isChecked()) {
                Thread y5 = new Thread(() -> {
                    try {

                        ConnectionManager.runCommand("/interface bridge port { set [find interface=ether5] bridge=bridge }");
                        ConnectionManager.runCommand("/interface bridge port set [find where interface=ether5] pvid=1");
                    } catch (JSchException | IOException e) {
                          new RestartApp();
                    }

                });
                y5.start();
                try {
                    y5.join();
                } catch (InterruptedException e) {
                      new RestartApp();
                }
            } else {
                Thread n5 = new Thread(() -> {
                    try {

                        ConnectionManager.runCommand("/interface bridge port set [find where interface=ether5] pvid=205");
                    } catch (JSchException | IOException e) {
                          new RestartApp();
                    }

                });
                n5.start();
                try {
                    n5.join();
                } catch (InterruptedException e) {
                      new RestartApp();
                }
            }
        });

    }
}