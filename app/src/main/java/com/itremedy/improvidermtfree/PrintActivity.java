package com.itremedy.improvidermtfree;

import static com.itremedy.improvidermtfree.ConnectionManager.result;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.print.PrintHelper;
import com.jcraft.jsch.JSchException;
import net.glxn.qrgen.android.QRCode;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PrintActivity extends AppCompatActivity {

    View viewTicket;
    private TextView net;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);

        viewTicket = findViewById(R.id.frameLayoutTicket);
        Button print = findViewById(R.id.buttonTicketPrint);
        Button back = findViewById(R.id.buttonTicketBack);
        TextView time = findViewById(R.id.textViewTime);
        TextView user = findViewById(R.id.textViewHotspotUserView);
        TextView password = findViewById(R.id.textViewHotspotPassView);
        TextView devices = findViewById(R.id.textViewHotspotDevices);
        TextView hours = findViewById(R.id.textViewHours);
        net = findViewById(R.id.textViewHotspotWiFi);
        Button quit = findViewById(R.id.quitApp);



        final Handler handler = new Handler();
        handler.postDelayed(() -> {
        Thread l2 = new Thread(() -> {
            try {
                ConnectionManager.runCommand(":foreach i in=[/interface wireless find where name=wlan3] do={:local net [/interface wireless get $i ssid]; :put \"$net\"}");
                Thread.sleep(300);
            } catch (JSchException | IOException | InterruptedException e) {
                new RestartApp();
            }
            runOnUiThread(() -> {
                net.setText(result);
            });
        });
        l2.start();
            Log.d("Handler", "Running Handler");}, 200);


        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
        String currentDateandTime = currentTime + " " + currentDate;

        time.setText(currentDateandTime);

        String hotspotUser_print;
        Bundle extrasU = getIntent().getExtras();
        if(extrasU == null) {
            hotspotUser_print= null;
        } else {
            hotspotUser_print= extrasU.getString(Intent.EXTRA_SUBJECT);
        }
        user.setText(hotspotUser_print);

        String hotspotPass_print;
        Bundle extrasP = getIntent().getExtras();
        if(extrasP == null) {
            hotspotPass_print= null;
        } else {
            hotspotPass_print= extrasP.getString(Intent.EXTRA_CC);
        }
        password.setText(hotspotPass_print);

        String hotspotDevices_print;
        Bundle extrasD = getIntent().getExtras();
        if(extrasD == null) {
            hotspotDevices_print= null;
        } else {
            hotspotDevices_print= extrasD.getString(Intent.EXTRA_TEXT);
        }
        devices.setText(hotspotDevices_print);

        String hotspotLimit_print;
        Bundle extrasL = getIntent().getExtras();
        if(extrasL == null) {
            hotspotLimit_print= null;
        } else {
            hotspotLimit_print= extrasL.getString(Intent.EXTRA_BCC);
        }
        hours.setText(hotspotLimit_print);

        Bitmap myBitmap = QRCode.from("http://10.10.10.1/login?username=" + hotspotUser_print + "&password=" + hotspotPass_print).bitmap();
        ImageView myImage = findViewById(R.id.imageView);
        myImage.setImageBitmap(myBitmap);


        back.setOnClickListener(v -> {

            Intent intent = new Intent(PrintActivity.this,CreateUserActivity.class);
            startActivity(intent);

        });

        print.setOnClickListener(v -> {

            PrintHelper photoPrinter = new PrintHelper(this);
            photoPrinter.setScaleMode(PrintHelper.SCALE_MODE_FIT);
            photoPrinter.printBitmap("hotspot-ticket", getBitmapFromView(viewTicket));

        });

        quit.setOnClickListener(v -> {

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
    private Bitmap getBitmapFromView(View viewTicket) {
        viewTicket.setDrawingCacheEnabled(true);
        return viewTicket.getDrawingCache();
    }

    protected void onRestoreInstanceState (@NonNull Bundle savedInstanceState){
        onRestart();
    }
}