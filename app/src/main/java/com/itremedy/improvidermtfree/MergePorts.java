package com.itremedy.improvidermtfree;

import static com.itremedy.improvidermtfree.ConnectionManager.result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.jcraft.jsch.JSchException;
import com.tapadoo.alerter.Alerter;

import java.io.IOException;

public class MergePorts extends AppCompatActivity {

    RadioButton m_radio5,m_radio2,m_radio3,m_radio4;
    Button buttonMerge;
    TextView help_merge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merge_ports);

        m_radio2 = findViewById(R.id.radio2);
        m_radio3 = findViewById(R.id.radio3);
        m_radio4 = findViewById(R.id.radio4);
        m_radio5 = findViewById(R.id.radio5);
        buttonMerge = findViewById(R.id.buttonMerge);
        help_merge = findViewById(R.id.help_merge);

        Thread merge = new Thread(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Thread m2 = new Thread(() -> {
                try {
                    ConnectionManager.runCommand("/interface bridge port print where pvid=202");
                    Thread.sleep(300);
                    if (!result.contains("bridge")){
                        runOnUiThread(() -> {
                            m_radio2.setChecked(true);
                        });
                    }else {
                        runOnUiThread(() -> {
                            m_radio2.setChecked(false);
                        });
                    }

                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }

            });


            Thread m3 = new Thread(() -> {
                try {
                    ConnectionManager.runCommand("/interface bridge port print where pvid=203");
                    Thread.sleep(300);

                    if (!result.contains("bridge")){
                        runOnUiThread(() -> {
                            m_radio3.setChecked(true);
                        });
                    }else {
                        runOnUiThread(() -> {
                            m_radio3.setChecked(false);
                        });
                    }

                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }

            });


            Thread m4 = new Thread(() -> {
                try {
                    ConnectionManager.runCommand("/interface bridge port print where pvid=204");
                    Thread.sleep(300);

                    if (!result.contains("bridge")){
                        runOnUiThread(() -> {
                            m_radio4.setChecked(true);
                        });
                    }else {
                        runOnUiThread(() -> {
                            m_radio4.setChecked(false);
                        });
                    }

                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }

            });


            Thread m5 = new Thread(() -> {
                try {
                    ConnectionManager.runCommand("/interface bridge port print where pvid=205");
                    Thread.sleep(300);

                    if (!result.contains("bridge")){
                        runOnUiThread(() -> {
                            m_radio5.setChecked(true);
                        });
                    }else {
                        runOnUiThread(() -> {
                            m_radio5.setChecked(false);
                        });
                    }

                } catch (JSchException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }

            });

            try {
                m2.start();
                m2.join();
                m3.start();
                m3.join();
                m4.start();
                m4.join();
                m5.start();
                m5.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        merge.start();

        help_merge.setOnClickListener(v -> {

            Alerter.create(this,R.layout.alerter_custom_layout)
                    .setTitle(R.string.help_merge)
                    .setBackgroundColorRes(R.color.for_improvider)
                    .enableSwipeToDismiss()
                    .setDuration(10000)
                    .show();

        });

        buttonMerge.setOnClickListener(v -> {

            if (m_radio2.isChecked()) {

                Thread y2 = new Thread(() -> {
                    try {
                        ConnectionManager.runCommand("/interface bridge port set [find where interface=ether2 and bridge=bridge] pvid=1");
                        Thread.sleep(300);
                    } catch (JSchException | IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                });
                y2.start();
            }else{
                    Thread n2 = new Thread(() -> {
                        try {
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether2 and bridge=bridge] pvid=202");
                            Thread.sleep(300);
                        } catch (JSchException | IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    });
                    n2.start();
            }


            if (m_radio3.isChecked()) {

                Thread y3 = new Thread(() -> {
                    try {
                        ConnectionManager.runCommand("/interface bridge port set [find where interface=ether3 and bridge=bridge] pvid=1");
                        Thread.sleep(300);
                    } catch (JSchException | IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                });
                y3.start();
            }else{
                Thread n3 = new Thread(() -> {
                    try {
                        ConnectionManager.runCommand("/interface bridge port set [find where interface=ether3 and bridge=bridge] pvid=203");
                        Thread.sleep(300);
                    } catch (JSchException | IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                });
                n3.start();
            }


            if (m_radio4.isChecked()) {

                Thread y4 = new Thread(() -> {
                    try {
                        ConnectionManager.runCommand("/interface bridge port set [find where interface=ether4 and bridge=bridge] pvid=1");
                        Thread.sleep(300);
                    } catch (JSchException | IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                });
                y4.start();
            }else{
                Thread n4 = new Thread(() -> {
                    try {
                        ConnectionManager.runCommand("/interface bridge port set [find where interface=ether4 and bridge=bridge] pvid=204");
                        Thread.sleep(300);
                    } catch (JSchException | IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                });
                n4.start();
            }


            if (m_radio5.isChecked()) {

                Thread y5 = new Thread(() -> {
                    try {
                        ConnectionManager.runCommand("/interface bridge port set [find where interface=ether5 and bridge=bridge] pvid=1");
                        Thread.sleep(300);
                    } catch (JSchException | IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                });
                y5.start();
            }else{
                Thread n5 = new Thread(() -> {
                    try {
                        ConnectionManager.runCommand("/interface bridge port set [find where interface=ether5 and bridge=bridge] pvid=205");
                        Thread.sleep(300);
                    } catch (JSchException | IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                });
                n5.start();
            }

            Alerter.create(this,R.layout.alerter_custom_layout)
                    .setTitle(R.string.done)
                    .setBackgroundColorRes(R.color.for_improvider)
                    .enableSwipeToDismiss()
                    .show();
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
}