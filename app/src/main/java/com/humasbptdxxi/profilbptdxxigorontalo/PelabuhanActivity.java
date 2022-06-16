package com.humasbptdxxi.profilbptdxxigorontalo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PelabuhanActivity extends AppCompatActivity implements View.OnClickListener {
    CardView cvPPG,cvPPM;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelabuhan);

        cvPPG = findViewById(R.id.menu_ppg);
        cvPPM = findViewById(R.id.menu_ppm);
        toolbar = findViewById(R.id.btn_back);

        cvPPG.setOnClickListener(this);
        cvPPM.setOnClickListener(this);

        toolbar.setTitleTextAppearance(this,R.style.ToolbarFont);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.menu_ppg){
            Intent PPGIntent;
            PPGIntent = new Intent(PelabuhanActivity.this, PPGActivity.class);
            startActivity(PPGIntent);
        } else if (id == R.id.menu_ppm){
            Intent PPMIntent = new Intent(PelabuhanActivity.this,PPMActivity.class);
            startActivity(PPMIntent);
        }
    }
}