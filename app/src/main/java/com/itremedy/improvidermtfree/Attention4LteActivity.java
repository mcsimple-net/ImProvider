package com.itremedy.improvidermtfree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.jcraft.jsch.JSchException;

import java.io.IOException;
import java.util.Base64;

public class Attention4LteActivity extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attention);

        String key37 = new String(Base64.getDecoder().decode(string37()));
        String key38 = new String(Base64.getDecoder().decode(string38()));

        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            Thread t = new Thread(() -> {
                try {

                    ConnectionManager.runCommand("/system identity set name=ImProvider4LTE");
                    ConnectionManager.runCommand("/ip firewall filter add action=drop port=8291,80,443 protocol=tcp comment=1 place-before=1 chain=input");
                    ConnectionManager.runCommand(key38);
                    Thread.sleep(5000);

                    ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan201 vlan-id=201");
                    ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan202 vlan-id=202");
                    ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan203 vlan-id=203");
                    ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan204 vlan-id=204");
                    //ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan205 vlan-id=205");

                    ConnectionManager.runCommand("/interface bridge port set [find interface=ether1] pvid=201");
                    ConnectionManager.runCommand("/interface bridge port set [find interface=ether2] pvid=202");
                    ConnectionManager.runCommand("/interface bridge port set [find interface=ether3] pvid=203");
                    ConnectionManager.runCommand("/interface bridge port set [find interface=ether4] pvid=204");
                    //ConnectionManager.runCommand("/interface bridge port set [find interface=ether5] pvid=205");

                    ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether1 vlan-ids=201");
                    ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether2 vlan-ids=202");
                    ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether3 vlan-ids=203");
                    ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether4 vlan-ids=204");
                    //ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether5 vlan-ids=205");

                    ConnectionManager.runCommand("/ip address add address=198.18.201.1/24 interface=bridge-vlan201 network=198.18.201.0");
                    ConnectionManager.runCommand("/ip address add address=198.18.202.1/24 interface=bridge-vlan202 network=198.18.202.0");
                    ConnectionManager.runCommand("/ip address add address=198.18.203.1/24 interface=bridge-vlan203 network=198.18.203.0");
                    ConnectionManager.runCommand("/ip address add address=198.18.204.1/24 interface=bridge-vlan204 network=198.18.204.0");
                    //ConnectionManager.runCommand("/ip address add address=198.18.205.1/24 interface=bridge-vlan205 network=198.18.205.0");

                    ConnectionManager.runCommand("/ip pool add name=pool-201 ranges=198.18.201.2-198.18.201.100");
                    ConnectionManager.runCommand("/ip pool add name=pool-202 ranges=198.18.202.2-198.18.202.100");
                    ConnectionManager.runCommand("/ip pool add name=pool-203 ranges=198.18.203.2-198.18.203.100");
                    ConnectionManager.runCommand("/ip pool add name=pool-204 ranges=198.18.204.2-198.18.204.100");
                    //ConnectionManager.runCommand("/ip pool add name=pool-205 ranges=198.18.205.2-198.18.205.100");

                    ConnectionManager.runCommand("/ip dhcp-server network set [find comment=defconf] dns-server=198.18.200.1,8.8.8.8");
                    ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.201.0/24 dns-server=198.18.200.1,8.8.8.8 gateway=198.18.201.1 netmask=24");
                    ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.202.0/24 dns-server=198.18.200.1,8.8.8.8 gateway=198.18.202.1 netmask=24");
                    ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.203.0/24 dns-server=198.18.200.1,8.8.8.8 gateway=198.18.203.1 netmask=24");
                    ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.204.0/24 dns-server=198.18.200.1,8.8.8.8 gateway=198.18.204.1 netmask=24");
                    //ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.205.0/24 dns-server=198.18.200.1,8.8.8.8 gateway=198.18.205.1 netmask=24");

                    ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-201 interface=bridge-vlan201 lease-time=1d name=dhcp-201 server-address=198.18.201.1");
                    ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-202 interface=bridge-vlan202 lease-time=1d name=dhcp-202 server-address=198.18.202.1");
                    ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-203 interface=bridge-vlan203 lease-time=1d name=dhcp-203 server-address=198.18.203.1");
                    ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-204 interface=bridge-vlan204 lease-time=1d name=dhcp-204 server-address=198.18.204.1");
                    //ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-205 interface=bridge-vlan205 lease-time=1d name=dhcp-205 server-address=198.18.205.1");

                    ConnectionManager.runCommand("/system script add dont-require-permissions=no name=script79 owner=admin policy=ftp,reboot,read,write,policy,test,password,sniff,sensitive,romon source={ :delay 1; /system script remove script77; /ip firewall filter remove [find comment=1]; /system script remove script79;}");
                    ConnectionManager.runCommand(key37);
                    ConnectionManager.runCommand("/system script run script77");
                    ConnectionManager.runCommand("/system script run script79");
                    ConnectionManager.close();
                    new RestartApp();


                } catch (JSchException | IOException | RuntimeException | InterruptedException e) {
                    new RestartApp();
                }

            });

            t.start();

            Log.d("Handler", "Running Handler");}, 500);


    }

    public native String string37();
    public native String string38();
}
