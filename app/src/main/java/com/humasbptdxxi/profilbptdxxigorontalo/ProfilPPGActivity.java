package com.humasbptdxxi.profilbptdxxigorontalo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfilPPGActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnKapal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_ppg);

        btnKapal = findViewById(R.id.detail_kapal_btn);

        btnKapal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent kapalPPGIntent;
        kapalPPGIntent = new Intent(ProfilPPGActivity.this,KapalPPGActivity.class);
        startActivity(kapalPPGIntent);
    }
}