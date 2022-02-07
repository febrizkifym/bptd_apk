package com.humasbptdxxi.profilbptdxxigorontalo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PelabuhanActivity extends AppCompatActivity implements View.OnClickListener {
    CardView cvPPG,cvPPM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelabuhan);

        cvPPG = findViewById(R.id.menu_ppg);
        cvPPM = findViewById(R.id.menu_ppm);

        cvPPG.setOnClickListener(this);
        cvPPM.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.menu_ppg){
            Intent PPGIntent;
            PPGIntent = new Intent(PelabuhanActivity.this,KapalPPGActivity.class);
            startActivity(PPGIntent);
        } else if (id == R.id.menu_ppm){
            Toast.makeText(this,"Pelabuhan Penyeberangan Marisa",Toast.LENGTH_SHORT).show();
        }
    }
}