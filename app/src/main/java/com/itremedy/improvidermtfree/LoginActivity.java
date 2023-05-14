package com.itremedy.improvidermtfree;

import static java.lang.Boolean.TRUE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    Button login;
    SharedPreferences set_prefs;
    TextView textViewLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textViewLogin = findViewById(R.id.textViewLogin);
        login = findViewById(R.id.agree_login);
        set_prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        Linkify.addLinks(textViewLogin,Linkify.EMAIL_ADDRESSES | Linkify.WEB_URLS);
        //textViewLogin.setMovementMethod(LinkMovementMethod.getInstance());

        login.setOnClickListener(v -> {
            SharedPreferences.Editor edit = set_prefs.edit();
            edit.putBoolean(getString(R.string.pref_previously_started),TRUE);
            edit.apply();
            Intent i = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(i);

        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("EXIT", true);
            startActivity(intent);

        }
        return super.onKeyDown(keyCode, event);
    }
}