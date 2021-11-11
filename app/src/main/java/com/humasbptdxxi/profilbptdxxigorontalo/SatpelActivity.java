package com.humasbptdxxi.profilbptdxxigorontalo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SatpelActivity extends AppCompatActivity implements View.OnClickListener {
    CardView cvPPgtlo,cvPPmarisa,cvTTAdungingi,cvTTAisimu,cvUPPKBmolotabu,cvUPPKBmarisa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satpel);

        cvPPgtlo = findViewById(R.id.satpel_ppGtlo);
        cvPPmarisa = findViewById(R.id.satpel_ppMarisa);
        cvTTAdungingi = findViewById(R.id.satpel_ttaDungingi);
        cvTTAisimu = findViewById(R.id.satpel_ttaIsimu);
        cvUPPKBmarisa = findViewById(R.id.satpel_uppkbMarisa);
        cvUPPKBmolotabu = findViewById(R.id.satpel_uppkbMolotabu);

        cvPPgtlo.setOnClickListener(this);
        cvPPmarisa.setOnClickListener(this);
        cvTTAdungingi.setOnClickListener(this);
        cvTTAisimu.setOnClickListener(this);
        cvUPPKBmolotabu.setOnClickListener(this);
        cvUPPKBmarisa.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.satpel_ppGtlo) {
//            Toast.makeText(this, "PP Gorontalo", Toast.LENGTH_SHORT).show();
            Intent profilPPG;
            profilPPG = new Intent(SatpelActivity.this, ProfilPPGActivity.class);
            startActivity(profilPPG);
        } else if (id == R.id.satpel_ppMarisa) {
            Toast.makeText(this, "PP Marisa", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.satpel_ttaDungingi) {
            Toast.makeText(this, "TTA Dungingi", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.satpel_ttaIsimu) {
            Toast.makeText(this, "TTA Isimu", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.satpel_uppkbMarisa) {
            Toast.makeText(this, "UPPKB Marisa", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.satpel_uppkbMolotabu) {
            Toast.makeText(this, "UPPKB Molotabu", Toast.LENGTH_SHORT).show();
        }
    }
}