package com.itremedy.improvidermtfree;

import static com.itremedy.improvidermtfree.ConnectionManager.result;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.DhcpInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.jcraft.jsch.JSchException;
import com.tapadoo.alerter.Alerter;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    //private BillingClient billingClient;
    boolean isPremium= true;

    static {
        System.loadLibrary("native-lib");
    }

    private EditText password;
    CheckBox checkBox;
    String router;
    ConstraintLayout mainLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLayout = findViewById(R.id.mainLayout);
        password = findViewById(R.id.password);
        Button connect = findViewById(R.id.connect);
        Button setup = findViewById(R.id.new_router_setup);
        TextView help_m = findViewById(R.id.help_wifi);
        Button start_page = findViewById(R.id.start_page);
        checkBox = findViewById(R.id.checkBox);
        Button quit = findViewById(R.id.quitApp10);

        /*

        billingClient = BillingClient.newBuilder(this)
                .setListener(purchasesUpdatedListener)
                .enablePendingPurchases().build();
        query_purchase();

         */

        //getUIDs();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean previouslyStarted = prefs.getBoolean(getString(R.string.pref_previously_started), false);
        if (!previouslyStarted) {

            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String password_shared = sharedPreferences.getString("password", "mcsimple.net");
        password.setText(password_shared);

        quit.setOnClickListener(v -> {

            finishAffinity();
        });

        help_m.setOnClickListener(v -> {

            ShowPopupMain();
        });

        start_page.setOnClickListener(v -> {

            WifiManager manager = (WifiManager) getSystemService(WIFI_SERVICE);
            DhcpInfo info = manager.getDhcpInfo();
            final int ip = info.gateway;
            router = formatIP(ip);

            connectionFeatures();

            final Handler handler = new Handler();
            handler.postDelayed(() -> {
                Thread t = new Thread(() -> {
                    try {
                        ConnectionManager.open();

                    } catch (JSchException e) {
                        runOnUiThread(() -> {
                            Alerter.create(this, R.layout.alerter_custom_layout)
                                    .setTitle(R.string.chk_connection)
                                    .setText(Objects.requireNonNull(e.getMessage()))
                                    .setDuration(10000)
                                    .setBackgroundColorRes(R.color.for_improvider)
                                    .enableSwipeToDismiss()
                                    .show();
                        });
                    }
                });
                t.start();
                try {
                    t.join();
                } catch (InterruptedException e) {

                    new RestartApp();
                }

                if (ConnectionManager.getFlag() == 0) {

                    Intent first = new Intent(this, FirstSetupActivity.class);
                    startActivity(first);
                } else t.interrupt();
            }, 500);

        });

        setup.setOnClickListener(v -> {

            if (isPremium) {

            WifiManager manager = (WifiManager) getSystemService(WIFI_SERVICE);
            DhcpInfo info = manager.getDhcpInfo();
            final int ip = info.gateway;
            router = formatIP(ip);

            connectionFeatures();


                final Handler handler = new Handler();
                handler.postDelayed(() -> {
                    Thread t1 = new Thread(() -> {
                        try {
                            ConnectionManager.open();
                            if (ConnectionManager.getFlag() == 0) {

                                ConnectionManager.runCommand(":put [/in wireless get wlan3 name]");
                                Thread.sleep(300);
                                if (result.contains("wlan3")) {

                                    Intent intent = new Intent(this, CreateUserActivity.class);
                                    startActivity(intent);

                                } else {
                                    Intent intent = new Intent(this, HotspotSetupActivity.class);
                                    startActivity(intent);
                                }

                            }
                        } catch (JSchException e) {

                            runOnUiThread(() -> {
                                Alerter.create(this, R.layout.alerter_custom_layout)
                                        .setTitle(R.string.chk_connection)
                                        .setText(Objects.requireNonNull(e.getMessage()))
                                        .setDuration(10000)
                                        .setBackgroundColorRes(R.color.for_improvider)
                                        .enableSwipeToDismiss()
                                        .show();
                            });
                        } catch (IOException | InterruptedException e) {

                            new RestartApp();
                        }

                    });
                    t1.start();

                    try {
                        t1.join();
                    } catch (InterruptedException e) {

                        new RestartApp();
                    }

                }, 500);
            }else
                {
                    Intent intent = new Intent(this, Subs.class);
                    startActivity(intent);
                }

        });


        connect.setOnClickListener(v -> {

            if (isPremium) {

            WifiManager manager = (WifiManager) getSystemService(WIFI_SERVICE);
            DhcpInfo info = manager.getDhcpInfo();
            final int ip = info.gateway;
            router = formatIP(ip);

            connectionFeatures();

            final Handler handler = new Handler();
            handler.postDelayed(() -> {
                Thread t = new Thread(() -> {
                    try {
                        ConnectionManager.open();
                        if (ConnectionManager.getFlag() == 0) {
                            ConnectionManager.runCommand("/system identity print");
                            Thread.sleep(300);
                            if (result.contains("ImProvider24")) {

                                Intent intent = new Intent(this, Speed24Activity.class);
                                startActivity(intent);

                            } else if (result.contains("ImProvider10")) {

                                Intent intent = new Intent(this, Speed10Activity.class);
                                startActivity(intent);

                            } else if (result.contains("ImProvider8")) {

                                Intent intent = new Intent(this, Speed8Activity.class);
                                startActivity(intent);

                            } else if (result.contains("ImProvider5")) {

                                Intent intent = new Intent(this, SpeedActivity.class);
                                startActivity(intent);

                            } else if (result.contains("ImProviderLTE")) {

                                Intent intent = new Intent(this, SpeedChateauActivity.class);
                                startActivity(intent);

                            } else if (result.contains("ImProvider4")) {

                                Intent intent = new Intent(this, Speed4Activity.class);
                                startActivity(intent);

                            } else if (result.contains("ImProvider4LTE")) {

                                Intent intent = new Intent(this, Speed4LteActivity.class);
                                startActivity(intent);

                            } else {

                                Intent intent = new Intent(this, PortsConfigActivity.class);
                                startActivity(intent);

                            }
                        }
                    } catch (JSchException e) {

                        runOnUiThread(() -> {
                            Alerter.create(this, R.layout.alerter_custom_layout)
                                    .setTitle(R.string.chk_connection)
                                    .setText(Objects.requireNonNull(e.getMessage()))
                                    .setDuration(10000)
                                    .setBackgroundColorRes(R.color.for_improvider)
                                    .enableSwipeToDismiss()
                                    .show();
                        });
                    } catch (IOException | java.lang.InterruptedException InterruptedException) {

                        new RestartApp();
                    }
                });
                t.start();
                try {
                    t.join();
                } catch (InterruptedException e) {

                    new RestartApp();
                }

            }, 500);
            }else
            {
                Intent intent = new Intent(this, Subs.class);
                startActivity(intent);
            }

        });

    }

    public void itemClicked(View v) {
        //code to check if this checkbox is checked!
        CheckBox checkBox = (CheckBox) v;
        if (checkBox.isChecked()) {

            MasterKey masterKey = null;
            try {
                masterKey = new MasterKey.Builder(this)
                        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                        .build();
            } catch (GeneralSecurityException | IOException e) {

                new RestartApp();
            }

            SharedPreferences sharedPreferences;
            try {
                assert masterKey != null;
                sharedPreferences = EncryptedSharedPreferences.create(
                        this,
                        "secret_shared_prefs",
                        masterKey,
                        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
                );
            } catch (GeneralSecurityException | IOException e) {

                new RestartApp();
            }
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("password", password.getText().toString());
            editor.apply();
        }
    }

   /*
    void getUIDs()
    {
        AsyncTask.execute(() -> {
            try {
                AdvertisingIdClient.Info adInfo = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
                    adInfo = AdvertisingIdClient.getAdvertisingIdInfo(this);
                }
                String myId = adInfo != null ? adInfo.getId() : null;

                Log.i("UIDMY", myId);
            } catch (Exception e) {
               Toast toast = Toast.makeText(getApplicationContext(), "error occurred ", Toast.LENGTH_SHORT);
               toast.show();
            }
        });
    }
    */


    private void connectionFeatures() {

        String password_input = password.getText().toString().trim();

        if (password_input.isEmpty()) {
            runOnUiThread(() -> {
                Alerter.create(this, R.layout.alerter_custom_layout)
                        .setTitle(R.string.flds_empty)
                        .setBackgroundColorRes(R.color.for_improvider)
                        .enableSwipeToDismiss()
                        .show();
            });

        } else {
            ConnectionManager.setHostname(router);
            ConnectionManager.setUsername("admin");
            ConnectionManager.setPort(22);
            ConnectionManager.setPassword(password_input);
            ConnectionManager.setFlag(-1);
            runOnUiThread(() -> {
                Alerter.create(this, R.layout.alerter_custom_layout)
                        .setTitle(R.string.please_wait)
                        .enableProgress(true)
                        .setBackgroundColorRes(R.color.for_improvider)
                        .enableSwipeToDismiss()
                        .show();
            });


        }
    }

    @SuppressLint("DefaultLocale")
    String formatIP(int ip) {
        return String.format(
                "%d.%d.%d.%d",
                (ip & 0xff),
                (ip >> 8 & 0xff),
                (ip >> 16 & 0xff),
                (ip >> 24 & 0xff)
        );
    }


    @SuppressLint("ClickableViewAccessibility")
    private void ShowPopupMain() {
        LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        View popUpView = layoutInflater.inflate(R.layout.main_popup, null);

        TextView tvManual = popUpView.findViewById(R.id.textViewManual);
        //TextView tvWhatsapp = popUpView.findViewById(R.id.textViewWhatsapp);
        TextView tvEmail =popUpView.findViewById(R.id.textViewEmail);

        int width = ViewGroup.LayoutParams.WRAP_CONTENT;
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        boolean focusable = true;
        PopupWindow popupWindow = new PopupWindow(popUpView, width, height, focusable);
        mainLayout.post(() -> popupWindow.showAtLocation(mainLayout, Gravity.TOP, 0, 0));

        tvManual.setOnClickListener(v -> {

            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://mcsimple.net/improvider")));

        });

        /*
        tvWhatsapp.setOnClickListener(v -> {

                boolean installed = appInstalledOrNot();
                if (installed){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=+19897850101"));
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "Whats app not installed on your device", Toast.LENGTH_SHORT).show();
                }
        });

         */

        tvEmail.setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_VIEW);
            Uri data = Uri.parse("mailto:customercare@mcsimple.net");
            intent.setData(data);
            startActivity(intent);

        });

        popUpView.setOnTouchListener((v, event) -> {
            popupWindow.dismiss();
            return true;
        });
    }

/*
    private PurchasesUpdatedListener purchasesUpdatedListener = new PurchasesUpdatedListener() {
        @Override
        public void onPurchasesUpdated(@NonNull BillingResult billingResult, @Nullable List<Purchase> Purchase) {
        }
    };

    private void  query_purchase(){
        billingClient.startConnection(new BillingClientStateListener() {
            @Override
            public void onBillingServiceDisconnected() {

            }

            @Override
            public void onBillingSetupFinished(@NonNull BillingResult billingResult) {

                if(billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK){
                    ExecutorService executorService= Executors.newSingleThreadExecutor();
                    executorService.execute(() -> {
                        try {
                            billingClient.queryPurchasesAsync(
                                    QueryPurchasesParams.newBuilder()
                                            .setProductType(BillingClient.ProductType.SUBS)
                                            .build(),
                                    (billingResult1, purchaseList) -> {
                                        // check billingResult
                                        for(Purchase purchase : purchaseList){
                                            if(purchase!=null && purchase.isAcknowledged()){
                                                isPremium = true;
                                            }

                                        }

                                    }
                            );

                        }catch (Exception ex){
                            isPremium=false;
                        }

                        runOnUiThread(() -> {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            if(isPremium){

                                ConnectionClass.premium= true;
                                ConnectionClass.locked= false;

                            }else{

                                ConnectionClass.premium= false;
                                //ConnectionClass.locked= true;
                                //Intent intent=new Intent(MainActivity.this,Subs.class);
                                //startActivity(intent);
                            }

                        });
                    });


                }
            }
        });

    }

 */
}
