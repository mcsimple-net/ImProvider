package com.itremedy.improvidermtfree;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;


public class PortsSelectActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ports_select);
        LinearLayout linearLayout5ports = findViewById(R.id.linearLayout5ports);
        LinearLayout linearLayout10ports = findViewById(R.id.linearLayout10ports);
        LinearLayout linearLayout24ports = findViewById(R.id.linearLayout24ports);
        LinearLayout linearLayoutChateau = findViewById(R.id.linearLayoutChateau);
        LinearLayout linearLayout8ports = findViewById(R.id.linearLayout8ports);




        linearLayout5ports.setOnClickListener(v -> {

            Intent intent = new Intent(PortsSelectActivity.this,AttentionActivity.class);
            startActivity(intent);
        } );

        linearLayout8ports.setOnClickListener(v -> {

            Intent intent = new Intent(PortsSelectActivity.this,Attention8Activity.class);
            startActivity(intent);
        } );

        linearLayout10ports.setOnClickListener(v -> {



            Intent intent = new Intent(PortsSelectActivity.this,Attention10Activity.class);
            startActivity(intent);


            });



        linearLayout24ports.setOnClickListener(v -> {

            Intent intent = new Intent(PortsSelectActivity.this,Attention24Activity.class);
            startActivity(intent);
        } );

        linearLayoutChateau.setOnClickListener(v -> {

            Intent intent = new Intent(PortsSelectActivity.this,AttentionChateauActivity.class);
            startActivity(intent);
        } );
    }

}