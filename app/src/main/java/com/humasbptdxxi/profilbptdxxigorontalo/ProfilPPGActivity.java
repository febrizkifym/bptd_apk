package com.humasbptdxxi.profilbptdxxigorontalo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class ProfilPPGActivity extends AppCompatActivity {
    TextView teksProfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_ppg);

        Toolbar toolbar = findViewById(R.id.btn_back);
        toolbar.setTitleTextAppearance(this,R.style.ToolbarFont);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        teksProfil = findViewById(R.id.teks_profil);
        String profil = "Pelabuhan Penyeberangan Gorontalo merupakan Pelabuhan Penyeberangan yang melayani 2 (dua) lintasan yaitu Gorontalo – Pagimana serta Gorontalo – Wakai – Ampana.<br><br>Dilayani oleh 2 (dua) armada Kapal Penyeberangan yaitu KMP. Moinit (untuk lintasan Gorontalo – Pagimana) serta KMP.Tuna Tomini (untuk lintasan Gorontalo – Wakai – Ampana).<br><br>Pelabuhan Penyeberangan Gorontalo dibangun pada Tahun 1992 s/d Tahun 1997. Diresmikan oleh Gubernur Provinsi Sulawesi Utara yaitu Bapak Mayjen TNI. EE. Mangindaan (Menteri Perhubungan Th. 2011 - 2014  ) pada tanggal 17 September 1997.<br><br>Visi dari Pelabuhan Penyeberangan Gorontalo adalah \"Terwujudnya Pelayanan Jasa Angkutan Penyeberangan yang  sesuai dengan prinsip pelayanan prima serta berkelanjutan sebagai Sarana Meningkatkan Kesejahteraan Masyarakat di wilayah Provinsi Gorontalo dan sekitarnya\".<br><br>Sedangkan Misi dari Pelabuhan Penyeberangan Gorontalo adalah sebagai berikut:<br>-Sistem Pelayanan Angkutan Penyeberangan yang berkualitas, berdaya saing dan memberikan jaminan pelayanan prima terhadap pengguna jasa<br><br>-Prasarana Angkutan Penyeberangan yang layak dan memadai guna menunjang kualitas pelayanan jasa kepelabuhanan<br><br>-Tata Niaga Kepelabuhanan yang transparan dan akuntabel.<br><br>";
        teksProfil.setText(Html.fromHtml(profil));
        teksProfil.setMovementMethod(new ScrollingMovementMethod());

    }
}