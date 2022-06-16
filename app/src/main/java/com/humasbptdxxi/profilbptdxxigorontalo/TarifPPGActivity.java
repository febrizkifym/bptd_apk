package com.humasbptdxxi.profilbptdxxigorontalo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

public class TarifPPGActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarif_ppg);

        TabLayout tabLayout = findViewById(R.id.tab_ppg);
        ViewPager viewPager = findViewById(R.id.vp_ppg);
        Toolbar toolbar = findViewById(R.id.btn_back);

        toolbar.setTitleTextAppearance(this,R.style.ToolbarFont);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        tabLayout.setupWithViewPager(viewPager);

        PPGAdapter ppgAdapter = new PPGAdapter(getSupportFragmentManager());
        ppgAdapter.addFragment(new FragmentMoinit(), "KMP. Moinit");
        ppgAdapter.addFragment(new FragmentTuna(), "KMP. Tuna Tomini");
        viewPager.setAdapter(ppgAdapter);

    }
}