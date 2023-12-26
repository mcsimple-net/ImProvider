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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.jcraft.jsch.JSchException;
import com.tapadoo.alerter.Alerter;
import java.io.IOException;

public class MergePortsHotspot extends AppCompatActivity {


    RadioButton m_radio5H,m_radio2H,m_radio3H,m_radio4H;
    Button quit;
    TextView help_mergeH;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merge_ports_hotspot);

        m_radio2H = findViewById(R.id.radio2H);
        m_radio3H = findViewById(R.id.radio3H);
        m_radio4H = findViewById(R.id.radio4H);
        m_radio5H = findViewById(R.id.radio5H);
        help_mergeH = findViewById(R.id.help_mergeH);
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
        Thread mergeH = new Thread(() -> {
            try {
                //Thread.sleep(200);
                Thread m2 = new Thread(() -> {
                    try {
                        ConnectionManager.runCommand("/interface bridge port print where interface=ether2");
                        Thread.sleep(300);
                        if (!result.contains("Bridge-Guest")) {
                            runOnUiThread(() -> {
                                m_radio2H.setChecked(false);
                            });
                        } else {
                            runOnUiThread(() -> {
                                m_radio2H.setChecked(true);
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

                        if (!result.contains("Bridge-Guest")) {
                            runOnUiThread(() -> {
                                m_radio3H.setChecked(false);
                            });
                        } else {
                            runOnUiThread(() -> {
                                m_radio3H.setChecked(true);
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

                        if (!result.contains("Bridge-Guest")) {
                            runOnUiThread(() -> {
                                m_radio4H.setChecked(false);
                            });
                        } else {
                            runOnUiThread(() -> {
                                m_radio4H.setChecked(true);
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

                        if (!result.contains("Bridge-Guest")) {
                            runOnUiThread(() -> {
                                m_radio5H.setChecked(false);
                            });
                        } else {
                            runOnUiThread(() -> {
                                m_radio5H.setChecked(true);
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
                 new RestartApp();
            }
        });
        mergeH.start();
        try {
            mergeH.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        }, 200);


        help_mergeH.setOnClickListener(v1 -> {
            runOnUiThread(() -> {
                Alerter.create(this, R.layout.alerter_custom_layout)
                        .setTitle(R.string.help_mergeH)
                        .setBackgroundColorRes(R.color.for_improvider)
                        .enableSwipeToDismiss()
                        .setDuration(10000)
                        .show();
            });

        });

        m_radio2H.setOnCheckedChangeListener((buttonView, isChecked) -> {


            if (m_radio2H.isChecked()) {

                Thread y2 = new Thread(() -> {
                    try {
                        ConnectionManager.runCommand("/interface bridge port set [find interface=ether2] pvid=1");
                        ConnectionManager.runCommand("/interface bridge port { set [find interface=ether2] bridge=Bridge-Guest }");
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

                        ConnectionManager.runCommand("/interface bridge port { set [find interface=ether2] bridge=bridge }");

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

        m_radio3H.setOnCheckedChangeListener((buttonView, isChecked) -> {


            if (m_radio3H.isChecked()) {
                Thread y3 = new Thread(() -> {
                    try {
                        ConnectionManager.runCommand("/interface bridge port set [find interface=ether3] pvid=1");
                        ConnectionManager.runCommand("/interface bridge port { set [find interface=ether3] bridge=Bridge-Guest }");
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
                        ConnectionManager.runCommand("/interface bridge port { set [find interface=ether3] bridge=bridge }");

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

        m_radio4H.setOnCheckedChangeListener((buttonView, isChecked) -> {


            if (m_radio4H.isChecked()) {
                Thread y4 = new Thread(() -> {
                    try {
                        ConnectionManager.runCommand("/interface bridge port { set [find interface=ether4] bridge=Bridge-Guest }");
                        ConnectionManager.runCommand("/interface bridge port set [find interface=ether4] pvid=1");
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
                        ConnectionManager.runCommand("/interface bridge port { set [find interface=ether4] bridge=bridge }");

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

        m_radio5H.setOnCheckedChangeListener((buttonView, isChecked) -> {


            if (m_radio5H.isChecked()) {
                Thread y5 = new Thread(() -> {
                    try {
                        ConnectionManager.runCommand("/interface bridge port { set [find interface=ether5] bridge=Bridge-Guest }");
                        ConnectionManager.runCommand("/interface bridge port set [find interface=ether5] pvid=1");
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
                        ConnectionManager.runCommand("/interface bridge port { set [find interface=ether5] bridge=bridge }");

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