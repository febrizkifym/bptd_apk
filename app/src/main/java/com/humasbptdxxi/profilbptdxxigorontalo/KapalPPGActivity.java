package com.humasbptdxxi.profilbptdxxigorontalo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class KapalPPGActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kapal_ppg);

        tabLayout = findViewById(R.id.tab_ppg);
        viewPager = findViewById(R.id.vp_ppg);

        tabLayout.setupWithViewPager(viewPager);

        PPGAdapter ppgAdapter = new PPGAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        ppgAdapter.addFragment(new FragmentMoinit(), "KMP. Moinit");
        ppgAdapter.addFragment(new FragmentTuna(), "KMP. Tuna Tomini");
        viewPager.setAdapter(ppgAdapter);
    }
}