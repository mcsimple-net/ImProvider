package com.itremedy.improvidermtfree;

import static com.itremedy.improvidermtfree.ConnectionManager.result;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.jcraft.jsch.JSchException;

import java.io.IOException;

public class Attention10Activity extends AppCompatActivity {

    private Button button;
    private TextView textViewWait, warning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attention10);
        button = findViewById(R.id.buttonIagree10);
        textViewWait = findViewById(R.id.textViewWait);
        textViewWait.setVisibility(View.GONE);
        warning = findViewById(R.id.textViewWarning);

        button.setOnClickListener(v -> {

            button.setVisibility(View.GONE);
            warning.setVisibility(View.GONE);
            textViewWait.setVisibility(View.VISIBLE);


            final Handler handler = new Handler();
            handler.postDelayed(() -> {
                Thread t = new Thread(() -> {
                    try {
                        ConnectionManager.runCommand("/system routerboard print");
                        Thread.sleep(200);
                        if (!result.contains("routerboard: yes")) {
                            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Please check the address of your MikroTik router ", 8000);
                            View snackbarView = snackbar.getView();
                            TextView tv = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
                            tv.setMaxLines(5);
                            snackbar.show();
                            Thread.sleep(8000);

                        }else {
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/system identity set name=ImProvider10");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/interface bridge set [find where bridge=bridge] vlan-filtering=yes");
                            Thread.sleep(10000);

                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan202 vlan-id=202");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan203 vlan-id=203");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan204 vlan-id=204");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan205 vlan-id=205");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan206 vlan-id=206");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan207 vlan-id=207");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan208 vlan-id=208");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan209 vlan-id=209");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan210 vlan-id=210");
                            Thread.sleep(200);

                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether2 and bridge=bridge] pvid=202");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether3 and bridge=bridge] pvid=203");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether4 and bridge=bridge] pvid=204");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether5 and bridge=bridge] pvid=205");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether6 and bridge=bridge] pvid=206");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether7 and bridge=bridge] pvid=207");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether8 and bridge=bridge] pvid=208");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether9 and bridge=bridge] pvid=209");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether10 and bridge=bridge] pvid=210");
                            Thread.sleep(200);

                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether2 vlan-ids=202");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether3 vlan-ids=203");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether4 vlan-ids=204");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether5 vlan-ids=205");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether6 vlan-ids=206");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether7 vlan-ids=207");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether8 vlan-ids=208");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether9 vlan-ids=209");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether10 vlan-ids=210");
                            Thread.sleep(200);

                            ConnectionManager.runCommand("/ip address add address=198.18.202.1/24 interface=bridge-vlan202 network=198.18.202.0");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip address add address=198.18.203.1/24 interface=bridge-vlan203 network=198.18.203.0");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip address add address=198.18.204.1/24 interface=bridge-vlan204 network=198.18.204.0");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip address add address=198.18.205.1/24 interface=bridge-vlan205 network=198.18.205.0");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip address add address=198.18.206.1/24 interface=bridge-vlan206 network=198.18.206.0");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip address add address=198.18.207.1/24 interface=bridge-vlan207 network=198.18.207.0");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip address add address=198.18.208.1/24 interface=bridge-vlan208 network=198.18.208.0");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip address add address=198.18.209.1/24 interface=bridge-vlan209 network=198.18.209.0");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip address add address=198.18.210.1/24 interface=bridge-vlan210 network=198.18.210.0");
                            Thread.sleep(200);

                            ConnectionManager.runCommand("/ip pool add name=pool-202 ranges=198.18.202.2-198.18.202.100");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip pool add name=pool-203 ranges=198.18.203.2-198.18.203.100");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip pool add name=pool-204 ranges=198.18.204.2-198.18.204.100");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip pool add name=pool-205 ranges=198.18.205.2-198.18.205.100");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip pool add name=pool-206 ranges=198.18.206.2-198.18.206.100");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip pool add name=pool-207 ranges=198.18.207.2-198.18.207.100");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip pool add name=pool-208 ranges=198.18.208.2-198.18.208.100");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip pool add name=pool-209 ranges=198.18.209.2-198.18.209.100");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip pool add name=pool-210 ranges=198.18.210.2-198.18.210.100");
                            Thread.sleep(200);

                            ConnectionManager.runCommand("/ip dhcp-server network set dns-server=1.1.1.1,8.8.8.8 0");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.202.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.202.1 netmask=24");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.203.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.203.1 netmask=24");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.204.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.204.1 netmask=24");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.205.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.205.1 netmask=24");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.206.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.206.1 netmask=24");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.207.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.207.1 netmask=24");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.208.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.208.1 netmask=24");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.209.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.209.1 netmask=24");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.210.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.210.1 netmask=24");
                            Thread.sleep(200);

                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-202 interface=bridge-vlan202 lease-time=1d name=dhcp-202 server-address=198.18.202.1");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-203 interface=bridge-vlan203 lease-time=1d name=dhcp-203 server-address=198.18.203.1");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-204 interface=bridge-vlan204 lease-time=1d name=dhcp-204 server-address=198.18.204.1");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-205 interface=bridge-vlan205 lease-time=1d name=dhcp-205 server-address=198.18.205.1");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-206 interface=bridge-vlan206 lease-time=1d name=dhcp-206 server-address=198.18.206.1");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-207 interface=bridge-vlan207 lease-time=1d name=dhcp-207 server-address=198.18.207.1");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-208 interface=bridge-vlan208 lease-time=1d name=dhcp-208 server-address=198.18.208.1");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-209 interface=bridge-vlan209 lease-time=1d name=dhcp-209 server-address=198.18.209.1");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-210 interface=bridge-vlan210 lease-time=1d name=dhcp-210 server-address=198.18.210.1");
                            Thread.sleep(200);


                            ConnectionManager.runCommand("/ip firewall filter add chain=forward action=accept in-interface-list=!WAN out-interface-list=WAN");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip firewall filter add chain=input src-address=192.168.88.0/24 dst-address=192.168.88.1 action=accept");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip firewall filter remove [find where comment=\"defconf: fasttrack\"]");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/ip firewall filter add action=drop chain=input comment=\"defconf: drop all\"");
                            Thread.sleep(200);


                            ConnectionManager.runCommand("/ipv6 settings set disable-ipv6=yes");
                            Thread.sleep(200);

                            ConnectionManager.runCommand("/user set admin password=mcsimple.net");
                            Thread.sleep(200);

                            ConnectionManager.runCommand("/interface wireless security-profiles add name=mcsimple authentication-types=wpa2-psk mode=dynamic-keys wpa2-pre-shared-key=mcsimple");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/interface wireless set [ find default-name=wlan2 ] security-profile=mcsimple");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/interface wireless set [ find default-name=wlan1 ] security-profile=mcsimple");
                            Thread.sleep(200);
                        }

                    } catch (JSchException | IOException e) {
                        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "An error occurred: " + e.getMessage(), 8000);
                        View snackbarView = snackbar.getView();
                        TextView tv = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
                        tv.setMaxLines(5);
                        snackbar.show();
                    } catch (RuntimeException runtimeException) {
                        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "The server is disconnected. An error occurred: " + runtimeException.getMessage(), 8000);
                        View snackbarView = snackbar.getView();
                        TextView tv = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
                        tv.setMaxLines(5);
                        snackbar.show();
                    } catch (Exception ignored) {
                    }

                });

                try {
                    t.start();
                    t.join();
                } catch (InterruptedException e) {
                    Snackbar.make(findViewById(android.R.id.content), "Sorry for all", Snackbar.LENGTH_SHORT).show();
                }
                ConnectionManager.close();

                finishAffinity();

                Log.d("Handler", "Running Handler");}, 1000);
        });

    }
}
