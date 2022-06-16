package com.humasbptdxxi.profilbptdxxigorontalo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class IsimuActivity extends AppCompatActivity {

    Toolbar toolbar;

    BottomNavigationView bottomNavigationView;
    final IsimuJadwalFragment isimuJadwalFragment = new IsimuJadwalFragment();
    final IsimuProfilFragment isimuProfilFragment = new IsimuProfilFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isimu);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        toolbar = findViewById(R.id.btn_back);

        toolbar.setTitleTextAppearance(this,R.style.ToolbarFont);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        getSupportFragmentManager().beginTransaction().replace(R.id.container,isimuProfilFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch(item.getItemId()){
                case R.id.profil_nav:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,isimuProfilFragment).commit();
                    return true;
                case R.id.jadwal_nav:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,isimuJadwalFragment).commit();
                    return true;
                case R.id.lokasi_nav:
                    bottomNavigationView.setSelectedItemId(R.id.profil_nav);
                    Uri uri = Uri.parse("google.navigation:q=Terminal+Tipe+A+Isimu");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    intent.setPackage("com.google.android.apps.maps");
                    startActivity(intent);
                    return true;
            }

            return false;
        });
    }
}