package com.humasbptdxxi.profilbptdxxigorontalo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Locale;

public class DungingiActivity extends AppCompatActivity {

    Toolbar toolbar;

    BottomNavigationView bottomNavigationView;
    DungingiJadwalFragment dungingiJadwalFragment = new DungingiJadwalFragment();
    DungingiProfilFragment dungingiProfilFragment = new DungingiProfilFragment();
    DungingiTarifFragment dungingiTarifFragment = new DungingiTarifFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dungingi);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        toolbar = findViewById(R.id.btn_back);

        toolbar.setTitleTextAppearance(this,R.style.ToolbarFont);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        getSupportFragmentManager().beginTransaction().replace(R.id.container,dungingiProfilFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch(item.getItemId()){
                    case R.id.profil_nav:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,dungingiProfilFragment).commit();
                        return true;
                    case R.id.jadwal_nav:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,dungingiJadwalFragment).commit();
                        return true;
                    case R.id.tarif_nav:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,dungingiTarifFragment).commit();
                        return true;
                    case R.id.lokasi_nav:
                        bottomNavigationView.setSelectedItemId(R.id.profil_nav);
                        String uri = String.format(Locale.ENGLISH,"geo:%f,%f?q=Terminal+Dungingi",0.5705868,123.0704386);
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                        startActivity(intent);
                        return true;
                }

                return false;
            }
        });
    }
}