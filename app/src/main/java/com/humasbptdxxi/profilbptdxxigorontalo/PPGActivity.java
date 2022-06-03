package com.humasbptdxxi.profilbptdxxigorontalo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import java.util.Locale;

public class PPGActivity extends AppCompatActivity implements View.OnClickListener {
    CardView menu_jadwal,menu_lokasi,menu_profil,menu_tarif;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ppg);

        menu_profil = findViewById(R.id.menu_profil);
        menu_jadwal = findViewById(R.id.menu_jadwal);
        menu_tarif = findViewById(R.id.menu_tarif);
        menu_lokasi = findViewById(R.id.menu_lokasi);
        toolbar = findViewById(R.id.btn_back);

        menu_profil.setOnClickListener(this);
        menu_jadwal.setOnClickListener(this);
        menu_tarif.setOnClickListener(this);
        menu_lokasi.setOnClickListener(this);
        toolbar.setTitleTextAppearance(this,R.style.ToolbarFont);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if(id == R.id.menu_tarif) {
            Intent kapalPPGIntent;
            kapalPPGIntent = new Intent(PPGActivity.this, TarifPPGActivity.class);
            startActivity(kapalPPGIntent);
        }else if(id == R.id.menu_lokasi){
            String uri = String.format(Locale.ENGLISH,"geo:%f,%f?q=Pelabuhan+Ferry+Gorontalo",0.5030011,123.062513);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            startActivity(intent);
        }else if(id == R.id.menu_profil){
            Intent profilPPGIntent = new Intent(PPGActivity.this, ProfilPPGActivity.class);
            startActivity(profilPPGIntent);
        }else if(id == R.id.menu_jadwal){
            Intent jadwalPPGIntent = new Intent(PPGActivity.this, JadwalPPG.class);
            startActivity(jadwalPPGIntent);
        }
    }
}