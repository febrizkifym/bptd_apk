package com.humasbptdxxi.profilbptdxxigorontalo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CardView cvProfil,cvSatpel,cvTentang,cvKeluar;
    public void keluar(){
        AlertDialog.Builder keluar = new AlertDialog.Builder(MainActivity.this);
        keluar.setMessage("Keluar Aplikasi?").setCancelable(false).setPositiveButton("Ya", (dialogInterface, i) -> {
            finish();
            System.exit(0);
        }).setNegativeButton("Tidak", (dialogInterface, i) -> dialogInterface.cancel());
        AlertDialog dialogKeluar = keluar.create();
        dialogKeluar.setTitle("Info");
        dialogKeluar.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cvProfil = findViewById(R.id.menu_profil);
        cvSatpel = findViewById(R.id.menu_satpel);
        cvTentang = findViewById(R.id.menu_tentang);
        cvKeluar = findViewById(R.id.menu_keluar);

        cvProfil.setOnClickListener(this);
        cvSatpel.setOnClickListener(this);
        cvTentang.setOnClickListener(this);
        cvKeluar.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.menu_profil) {
            Intent profilBalaiIntent;
            profilBalaiIntent = new Intent(MainActivity.this, ProfilBalaiActivity.class);
            startActivity(profilBalaiIntent);
        } else if (id == R.id.menu_satpel) {
            Intent satpelIntent;
            satpelIntent = new Intent(MainActivity.this, SatpelActivity.class);
            startActivity(satpelIntent);
        } else if (id == R.id.menu_tentang) {
            Intent tentangIntent;
            tentangIntent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(tentangIntent);
        } else if (id == R.id.menu_keluar) {
            keluar();
        }
    }
    @Override
    public void onBackPressed(){
        keluar();
    }
}