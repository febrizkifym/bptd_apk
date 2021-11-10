package com.humasbptdxxi.profilbptdxxigorontalo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SatpelActivity extends AppCompatActivity implements View.OnClickListener {
    CardView cvPPgtlo,cvPPmarisa,cvTTAdungingi,cvTTAisimu,cvUPPKBmolotabu,cvUPPKBmarisa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satpel);

        cvPPgtlo = (CardView) findViewById(R.id.satpel_ppGtlo);
        cvPPmarisa = (CardView) findViewById(R.id.satpel_ppMarisa);
        cvTTAdungingi = (CardView) findViewById(R.id.satpel_ttaDungingi);
        cvTTAisimu = (CardView) findViewById(R.id.satpel_ttaIsimu);
        cvUPPKBmarisa = (CardView) findViewById(R.id.satpel_uppkbMarisa);
        cvUPPKBmolotabu = (CardView) findViewById(R.id.satpel_uppkbMolotabu);

        cvPPgtlo.setOnClickListener(this);
        cvPPmarisa.setOnClickListener(this);
        cvTTAdungingi.setOnClickListener(this);
        cvTTAisimu.setOnClickListener(this);
        cvUPPKBmolotabu.setOnClickListener(this);
        cvUPPKBmarisa.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.satpel_ppGtlo:
                Toast.makeText(this,"PP Gorontalo",Toast.LENGTH_SHORT).show();
                break;
            case R.id.satpel_ppMarisa:
                Toast.makeText(this,"PP Marisa",Toast.LENGTH_SHORT).show();
                break;
            case R.id.satpel_ttaDungingi:
                Toast.makeText(this,"TTA Dungingi",Toast.LENGTH_SHORT).show();
                break;
            case R.id.satpel_ttaIsimu:
                Toast.makeText(this,"TTA Isimu",Toast.LENGTH_SHORT).show();
                break;
            case R.id.satpel_uppkbMarisa:
                Toast.makeText(this,"UPPKB Marisa",Toast.LENGTH_SHORT).show();
                break;
            case R.id.satpel_uppkbMolotabu:
                Toast.makeText(this,"UPPKB Molotabu",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}