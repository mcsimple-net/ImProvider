package com.itremedy.improvidermtfree;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.jcraft.jsch.JSchException;
import java.io.IOException;
import java.util.Base64;

public class Attention10Activity extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attention);

        String key97 = new String(Base64.getDecoder().decode(string97()));
        String key98 = new String(Base64.getDecoder().decode(string98()));

            final Handler handler = new Handler();
            handler.postDelayed(() -> {
                Thread t = new Thread(() -> {
                    try {

                            
                            ConnectionManager.runCommand("/system identity set name=ImProvider10");
                        ConnectionManager.runCommand("/ip firewall filter add action=drop port=8291,80,443 protocol=tcp comment=1 place-before=1 chain=input");
                        ConnectionManager.runCommand(key98);
                        Thread.sleep(5000);

                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan202 vlan-id=202");
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan203 vlan-id=203");
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan204 vlan-id=204");
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan205 vlan-id=205");
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan206 vlan-id=206");
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan207 vlan-id=207");
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan208 vlan-id=208");
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan209 vlan-id=209");
                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan210 vlan-id=210");
                            
                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether2] pvid=202");
                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether3] pvid=203");
                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether4] pvid=204");
                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether5] pvid=205");
                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether6] pvid=206");
                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether7] pvid=207");
                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether8] pvid=208");
                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether9] pvid=209");
                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether10] pvid=210");
                            
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether2 vlan-ids=202");
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether3 vlan-ids=203");
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether4 vlan-ids=204");
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether5 vlan-ids=205");
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether6 vlan-ids=206");
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether7 vlan-ids=207");
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether8 vlan-ids=208");
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether9 vlan-ids=209");
                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether10 vlan-ids=210");

                            ConnectionManager.runCommand("/ip address add address=198.18.202.1/24 interface=bridge-vlan202 network=198.18.202.0");
                            ConnectionManager.runCommand("/ip address add address=198.18.203.1/24 interface=bridge-vlan203 network=198.18.203.0");
                            ConnectionManager.runCommand("/ip address add address=198.18.204.1/24 interface=bridge-vlan204 network=198.18.204.0");
                            ConnectionManager.runCommand("/ip address add address=198.18.205.1/24 interface=bridge-vlan205 network=198.18.205.0");
                            ConnectionManager.runCommand("/ip address add address=198.18.206.1/24 interface=bridge-vlan206 network=198.18.206.0");
                            ConnectionManager.runCommand("/ip address add address=198.18.207.1/24 interface=bridge-vlan207 network=198.18.207.0");
                            ConnectionManager.runCommand("/ip address add address=198.18.208.1/24 interface=bridge-vlan208 network=198.18.208.0");
                            ConnectionManager.runCommand("/ip address add address=198.18.209.1/24 interface=bridge-vlan209 network=198.18.209.0");
                            ConnectionManager.runCommand("/ip address add address=198.18.210.1/24 interface=bridge-vlan210 network=198.18.210.0");

                            ConnectionManager.runCommand("/ip pool add name=pool-202 ranges=198.18.202.2-198.18.202.100");
                            ConnectionManager.runCommand("/ip pool add name=pool-203 ranges=198.18.203.2-198.18.203.100");
                            ConnectionManager.runCommand("/ip pool add name=pool-204 ranges=198.18.204.2-198.18.204.100");
                            ConnectionManager.runCommand("/ip pool add name=pool-205 ranges=198.18.205.2-198.18.205.100");
                            ConnectionManager.runCommand("/ip pool add name=pool-206 ranges=198.18.206.2-198.18.206.100");
                            ConnectionManager.runCommand("/ip pool add name=pool-207 ranges=198.18.207.2-198.18.207.100");
                            ConnectionManager.runCommand("/ip pool add name=pool-208 ranges=198.18.208.2-198.18.208.100");
                            ConnectionManager.runCommand("/ip pool add name=pool-209 ranges=198.18.209.2-198.18.209.100");
                            ConnectionManager.runCommand("/ip pool add name=pool-210 ranges=198.18.210.2-198.18.210.100");

                            ConnectionManager.runCommand("/ip dhcp-server network set [find comment=defconf] dns-server=198.18.200.1,8.8.8.8");
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.202.0/24 dns-server=198.18.200.1,8.8.8.8 gateway=198.18.202.1 netmask=24");
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.203.0/24 dns-server=198.18.200.1,8.8.8.8 gateway=198.18.203.1 netmask=24");
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.204.0/24 dns-server=198.18.200.1,8.8.8.8 gateway=198.18.204.1 netmask=24");
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.205.0/24 dns-server=198.18.200.1,8.8.8.8 gateway=198.18.205.1 netmask=24");
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.206.0/24 dns-server=198.18.200.1,8.8.8.8 gateway=198.18.206.1 netmask=24");
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.207.0/24 dns-server=198.18.200.1,8.8.8.8 gateway=198.18.207.1 netmask=24");
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.208.0/24 dns-server=198.18.200.1,8.8.8.8 gateway=198.18.208.1 netmask=24");
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.209.0/24 dns-server=198.18.200.1,8.8.8.8 gateway=198.18.209.1 netmask=24");
                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.210.0/24 dns-server=198.18.200.1,8.8.8.8 gateway=198.18.210.1 netmask=24");
                            
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-202 interface=bridge-vlan202 lease-time=1d name=dhcp-202 server-address=198.18.202.1");
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-203 interface=bridge-vlan203 lease-time=1d name=dhcp-203 server-address=198.18.203.1");
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-204 interface=bridge-vlan204 lease-time=1d name=dhcp-204 server-address=198.18.204.1");
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-205 interface=bridge-vlan205 lease-time=1d name=dhcp-205 server-address=198.18.205.1");
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-206 interface=bridge-vlan206 lease-time=1d name=dhcp-206 server-address=198.18.206.1");
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-207 interface=bridge-vlan207 lease-time=1d name=dhcp-207 server-address=198.18.207.1");
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-208 interface=bridge-vlan208 lease-time=1d name=dhcp-208 server-address=198.18.208.1");
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-209 interface=bridge-vlan209 lease-time=1d name=dhcp-209 server-address=198.18.209.1");
                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-210 interface=bridge-vlan210 lease-time=1d name=dhcp-210 server-address=198.18.210.1");

                        ConnectionManager.runCommand("/system script add dont-require-permissions=no name=script79 owner=admin policy=ftp,reboot,read,write,policy,test,password,sniff,sensitive,romon source={ :delay 1; /system script remove script77; /ip firewall filter remove [find comment=1]; /system script remove script79;}");
                        ConnectionManager.runCommand(key97);
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

    public native String string97();
    public native String string98();
}
