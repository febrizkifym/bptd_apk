package com.humasbptdxxi.profilbptdxxigorontalo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Locale;

public class ProfilPPGActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnKapal;
    ImageView ppg_map;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_ppg);

        btnKapal = findViewById(R.id.detail_kapal_btn);
        ppg_map = findViewById(R.id.ppg_map);
        toolbar = findViewById(R.id.btn_back);

        btnKapal.setOnClickListener(this);
        ppg_map.setOnClickListener(this);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if(id == R.id.detail_kapal_btn) {
            Intent kapalPPGIntent;
            kapalPPGIntent = new Intent(ProfilPPGActivity.this, KapalPPGActivity.class);
            startActivity(kapalPPGIntent);
        }else if(id == R.id.ppg_map){
            String uri = String.format(Locale.ENGLISH,"geo:%f,%f?q=Pelabuhan+Ferry+Gorontalo",0.5030011,123.062513);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            startActivity(intent);
        }
    }
}