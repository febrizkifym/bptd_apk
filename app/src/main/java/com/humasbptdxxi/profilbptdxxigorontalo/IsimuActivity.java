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

public class IsimuActivity extends AppCompatActivity {

    Toolbar toolbar;

    BottomNavigationView bottomNavigationView;
    IsimuJadwalFragment isimuJadwalFragment = new IsimuJadwalFragment();
    IsimuProfilFragment isimuProfilFragment = new IsimuProfilFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isimu);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        toolbar = findViewById(R.id.btn_back);

        toolbar.setTitleTextAppearance(this,R.style.ToolbarFont);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        getSupportFragmentManager().beginTransaction().replace(R.id.container,isimuProfilFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch(item.getItemId()){
                    case R.id.profil_nav:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,isimuProfilFragment).commit();
                        return true;
                    case R.id.jadwal_nav:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,isimuJadwalFragment).commit();
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