package com.humasbptdxxi.profilbptdxxigorontalo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.util.Locale;

public class PPMActivity extends AppCompatActivity implements View.OnClickListener {
    CardView menu_jadwal,menu_lokasi,menu_profil,menu_tarif;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ppm);
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
            Intent kapalPPMIntent;
            kapalPPMIntent = new Intent(PPMActivity.this, TarifPPMActivity.class);
            startActivity(kapalPPMIntent);
        }else if(id == R.id.menu_lokasi){
            String uri = "google.navigation:q=Pelabuhan+Penyeberangan+Marisa";
//            String uri = String.format(Locale.ENGLISH,"geo:%f,%f?q=Pelabuhan+Penyeberangan+Marisa",0.4857794,122.1069247);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            startActivity(intent);
        }else if(id == R.id.menu_profil){
            Intent profilPPMIntent = new Intent(PPMActivity.this, ProfilPPMActivity.class);
            startActivity(profilPPMIntent);
        }else if(id == R.id.menu_jadwal){
            Intent jadwalIntent = new Intent(PPMActivity.this,JadwalPPM.class);
            startActivity(jadwalIntent);
        }
    }
}