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

public class Attention24Activity extends AppCompatActivity {

    private Button button;
    private TextView textViewWait, warning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attention24);
        button = findViewById(R.id.buttonIagree24);
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
                        if (!result.contains("routerboard: yes")) {
                            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Please check the address of your MikroTik router ", 8000);
                            View snackbarView = snackbar.getView();
                            TextView tv = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
                            tv.setMaxLines(5);
                            snackbar.show();
                            Thread.sleep(8000);

                        }else {
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/system identity set name=ImProvider");
                            Thread.sleep(200);
                            ConnectionManager.runCommand("/interface bridge set [find where bridge=bridge] vlan-filtering=yes");
                            Thread.sleep(10000);

                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan202 vlan-id=202");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan203 vlan-id=203");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan204 vlan-id=204");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan205 vlan-id=205");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan206 vlan-id=206");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan207 vlan-id=207");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan208 vlan-id=208");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan209 vlan-id=209");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan210 vlan-id=210");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan211 vlan-id=211");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan212 vlan-id=212");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan213 vlan-id=213");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan214 vlan-id=214");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan215 vlan-id=215");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan216 vlan-id=216");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan217 vlan-id=217");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan218 vlan-id=218");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan219 vlan-id=219");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan220 vlan-id=220");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan221 vlan-id=221");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan222 vlan-id=222");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan223 vlan-id=223");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan224 vlan-id=224");
                            Thread.sleep(100);


                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether2 and bridge=bridge] pvid=202");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether3 and bridge=bridge] pvid=203");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether4 and bridge=bridge] pvid=204");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether5 and bridge=bridge] pvid=205");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether6 and bridge=bridge] pvid=206");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether7 and bridge=bridge] pvid=207");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether8 and bridge=bridge] pvid=208");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether9 and bridge=bridge] pvid=209");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether10 and bridge=bridge] pvid=210");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether11 and bridge=bridge] pvid=211");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether12 and bridge=bridge] pvid=212");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether13 and bridge=bridge] pvid=213");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether14 and bridge=bridge] pvid=214");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether15 and bridge=bridge] pvid=215");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether16 and bridge=bridge] pvid=216");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether17 and bridge=bridge] pvid=217");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether18 and bridge=bridge] pvid=218");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether19 and bridge=bridge] pvid=219");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether20 and bridge=bridge] pvid=220");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether21 and bridge=bridge] pvid=221");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether22 and bridge=bridge] pvid=222");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether23 and bridge=bridge] pvid=223");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge port set [find where interface=ether24 and bridge=bridge] pvid=224");
                            Thread.sleep(100);

                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether2 vlan-ids=202");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether3 vlan-ids=203");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether4 vlan-ids=204");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether5 vlan-ids=205");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether6 vlan-ids=206");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether7 vlan-ids=207");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether8 vlan-ids=208");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether9 vlan-ids=209");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether10 vlan-ids=210");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether11 vlan-ids=211");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether12 vlan-ids=212");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether13 vlan-ids=213");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether14 vlan-ids=214");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether15 vlan-ids=215");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether16 vlan-ids=216");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether17 vlan-ids=217");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether18 vlan-ids=218");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether19 vlan-ids=219");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether20 vlan-ids=220");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether21 vlan-ids=221");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether22 vlan-ids=222");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether23 vlan-ids=223");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether24 vlan-ids=224");
                            Thread.sleep(100);

                            ConnectionManager.runCommand("/ip address add address=198.18.202.1/24 interface=bridge-vlan202 network=198.18.202.0");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip address add address=198.18.203.1/24 interface=bridge-vlan203 network=198.18.203.0");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip address add address=198.18.204.1/24 interface=bridge-vlan204 network=198.18.204.0");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip address add address=198.18.205.1/24 interface=bridge-vlan205 network=198.18.205.0");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip address add address=198.18.206.1/24 interface=bridge-vlan206 network=198.18.206.0");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip address add address=198.18.207.1/24 interface=bridge-vlan207 network=198.18.207.0");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip address add address=198.18.208.1/24 interface=bridge-vlan208 network=198.18.208.0");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip address add address=198.18.209.1/24 interface=bridge-vlan209 network=198.18.209.0");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip address add address=198.18.210.1/24 interface=bridge-vlan210 network=198.18.210.0");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip address add address=198.18.211.1/24 interface=bridge-vlan211 network=198.18.211.0");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip address add address=198.18.212.1/24 interface=bridge-vlan212 network=198.18.212.0");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip address add address=198.18.213.1/24 interface=bridge-vlan213 network=198.18.213.0");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip address add address=198.18.214.1/24 interface=bridge-vlan214 network=198.18.214.0");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip address add address=198.18.215.1/24 interface=bridge-vlan215 network=198.18.215.0");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip address add address=198.18.216.1/24 interface=bridge-vlan216 network=198.18.216.0");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip address add address=198.18.217.1/24 interface=bridge-vlan217 network=198.18.217.0");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip address add address=198.18.218.1/24 interface=bridge-vlan218 network=198.18.218.0");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip address add address=198.18.219.1/24 interface=bridge-vlan219 network=198.18.219.0");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip address add address=198.18.220.1/24 interface=bridge-vlan220 network=198.18.220.0");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip address add address=198.18.221.1/24 interface=bridge-vlan221 network=198.18.221.0");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip address add address=198.18.222.1/24 interface=bridge-vlan222 network=198.18.222.0");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip address add address=198.18.223.1/24 interface=bridge-vlan223 network=198.18.223.0");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip address add address=198.18.224.1/24 interface=bridge-vlan224 network=198.18.224.0");
                            Thread.sleep(100);

                            ConnectionManager.runCommand("/ip pool add name=pool-202 ranges=198.18.202.2-198.18.202.100");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip pool add name=pool-203 ranges=198.18.203.2-198.18.203.100");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip pool add name=pool-204 ranges=198.18.204.2-198.18.204.100");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip pool add name=pool-205 ranges=198.18.205.2-198.18.205.100");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip pool add name=pool-206 ranges=198.18.206.2-198.18.206.100");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip pool add name=pool-207 ranges=198.18.207.2-198.18.207.100");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip pool add name=pool-208 ranges=198.18.208.2-198.18.208.100");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip pool add name=pool-209 ranges=198.18.209.2-198.18.209.100");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip pool add name=pool-210 ranges=198.18.210.2-198.18.210.100");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip pool add name=pool-211 ranges=198.18.211.2-198.18.211.100");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip pool add name=pool-212 ranges=198.18.212.2-198.18.212.100");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip pool add name=pool-213 ranges=198.18.213.2-198.18.213.100");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip pool add name=pool-214 ranges=198.18.214.2-198.18.214.100");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip pool add name=pool-215 ranges=198.18.215.2-198.18.215.100");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip pool add name=pool-216 ranges=198.18.216.2-198.18.216.100");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip pool add name=pool-217 ranges=198.18.217.2-198.18.217.100");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip pool add name=pool-218 ranges=198.18.218.2-198.18.218.100");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip pool add name=pool-219 ranges=198.18.219.2-198.18.219.100");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip pool add name=pool-220 ranges=198.18.220.2-198.18.220.100");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip pool add name=pool-221 ranges=198.18.221.2-198.18.221.100");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip pool add name=pool-222 ranges=198.18.222.2-198.18.222.100");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip pool add name=pool-223 ranges=198.18.223.2-198.18.223.100");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip pool add name=pool-224 ranges=198.18.224.2-198.18.224.100");
                            Thread.sleep(100);

                            ConnectionManager.runCommand("/ip dhcp-server network set dns-server=1.1.1.1,8.8.8.8 0");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.202.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.202.1 netmask=24");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.203.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.203.1 netmask=24");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.204.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.204.1 netmask=24");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.205.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.205.1 netmask=24");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.206.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.206.1 netmask=24");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.207.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.207.1 netmask=24");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.208.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.208.1 netmask=24");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.209.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.209.1 netmask=24");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.210.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.210.1 netmask=24");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.211.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.211.1 netmask=24");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.212.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.212.1 netmask=24");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.213.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.213.1 netmask=24");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.214.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.214.1 netmask=24");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.215.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.215.1 netmask=24");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.216.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.216.1 netmask=24");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.217.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.217.1 netmask=24");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.218.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.218.1 netmask=24");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.219.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.219.1 netmask=24");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.220.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.220.1 netmask=24");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.221.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.221.1 netmask=24");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.222.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.222.1 netmask=24");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.223.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.223.1 netmask=24");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.224.0/24 dns-server=1.1.1.1,8.8.8.8 gateway=198.18.224.1 netmask=24");
                            Thread.sleep(100);

                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-202 interface=bridge-vlan202 lease-time=1d name=dhcp-202 server-address=198.18.202.1");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-203 interface=bridge-vlan203 lease-time=1d name=dhcp-203 server-address=198.18.203.1");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-204 interface=bridge-vlan204 lease-time=1d name=dhcp-204 server-address=198.18.204.1");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-205 interface=bridge-vlan205 lease-time=1d name=dhcp-205 server-address=198.18.205.1");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-206 interface=bridge-vlan206 lease-time=1d name=dhcp-206 server-address=198.18.206.1");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-207 interface=bridge-vlan207 lease-time=1d name=dhcp-207 server-address=198.18.207.1");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-208 interface=bridge-vlan208 lease-time=1d name=dhcp-208 server-address=198.18.208.1");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-209 interface=bridge-vlan209 lease-time=1d name=dhcp-209 server-address=198.18.209.1");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-210 interface=bridge-vlan210 lease-time=1d name=dhcp-210 server-address=198.18.210.1");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-211 interface=bridge-vlan211 lease-time=1d name=dhcp-211 server-address=198.18.211.1");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-212 interface=bridge-vlan212 lease-time=1d name=dhcp-212 server-address=198.18.212.1");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-213 interface=bridge-vlan213 lease-time=1d name=dhcp-213 server-address=198.18.213.1");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-214 interface=bridge-vlan214 lease-time=1d name=dhcp-214 server-address=198.18.214.1");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-215 interface=bridge-vlan215 lease-time=1d name=dhcp-215 server-address=198.18.215.1");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-216 interface=bridge-vlan216 lease-time=1d name=dhcp-216 server-address=198.18.216.1");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-217 interface=bridge-vlan217 lease-time=1d name=dhcp-217 server-address=198.18.217.1");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-218 interface=bridge-vlan218 lease-time=1d name=dhcp-218 server-address=198.18.218.1");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-219 interface=bridge-vlan219 lease-time=1d name=dhcp-219 server-address=198.18.219.1");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-220 interface=bridge-vlan220 lease-time=1d name=dhcp-220 server-address=198.18.220.1");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-221 interface=bridge-vlan221 lease-time=1d name=dhcp-221 server-address=198.18.221.1");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-222 interface=bridge-vlan222 lease-time=1d name=dhcp-222 server-address=198.18.222.1");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-223 interface=bridge-vlan223 lease-time=1d name=dhcp-223 server-address=198.18.223.1");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-224 interface=bridge-vlan224 lease-time=1d name=dhcp-224 server-address=198.18.224.1");
                            Thread.sleep(100);


                            ConnectionManager.runCommand("/ip firewall filter add chain=forward action=accept in-interface-list=!WAN out-interface-list=WAN");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip firewall filter add chain=input src-address=192.168.88.0/24 dst-address=192.168.88.1/24 action=accept");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip firewall filter remove [find where comment=\"defconf: fasttrack\"]");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/ip firewall filter add action=drop chain=input comment=\"defconf: drop all\"");
                            Thread.sleep(100);


                            ConnectionManager.runCommand("/ipv6 settings set disable-ipv6=yes");
                            Thread.sleep(100);

                            ConnectionManager.runCommand("/user set admin password=mcsimple.net");
                            Thread.sleep(100);

                            ConnectionManager.runCommand("/interface wireless security-profiles add name=mcsimple authentication-types=wpa2-psk mode=dynamic-keys wpa2-pre-shared-key=mcsimple");
                            Thread.sleep(100);
                            ConnectionManager.runCommand("/interface wireless set [ find default-name=wlan2 ] security-profile=mcsimple");
                            ConnectionManager.runCommand("/interface wireless set [ find default-name=wlan1 ] security-profile=mcsimple");
                            Thread.sleep(100);

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
