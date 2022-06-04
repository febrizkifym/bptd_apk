package com.humasbptdxxi.profilbptdxxigorontalo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class ProfilPPMActivity extends AppCompatActivity {
    TextView teksProfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_ppm);

        Toolbar toolbar = findViewById(R.id.btn_back);
        toolbar.setTitleTextAppearance(this,R.style.ToolbarFont);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        teksProfil = findViewById(R.id.teks_profil);
        String profil = "Satuan Pelayanan Pelabuhan Penyeberangan Marisa merupakan Unit Kerja dibawah naungan Balai Pengelola Transportasi Darat Wilayah XXI – Provinsi Gorontalo, Direktorat Jenderal Perhubungan Darat Kementerian Perhubungan.<br><br>Tugas Pokok dan Fungsi Satuan Pelayanan Pelabuhan Penyeberangan Marisa sesuai dengan Keputusan Menteri Perhubungan Nomor 60 Tahun 2002 adalah :<br><br>1).  Melaksanakan kegiatan pelayanan jasa Angkutan Penyeberangan di Pelabuhan Penyeberangan;<br><br>2). Melaksanakan kegiatan pelayanan jasa Kepelabuhanan di Pelabuhan Penyeberangan.<br><br>Visi Pelabuhan Penyeberangan Marisa adalah \"Terwujudnya Pelayanan Jasa Angkutan Penyeberangan yang  sesuai dengan prinsip pelayanan prima serta berkelanjutan sebagai Sarana Meningkatkan Kesejahteraan Masyarakat di wilayah Provinsi Gorontalo dan sekitarnya\"<br><br>Sedangkan Misi Pelabuhan Penyeberangan Marisa sebagai berikut:<br><br>-Sistem Pelayanan Angkutan Penyeberangan yang berkualitas, berdaya saing dan memberikan jaminan pelayanan prima terhadap pengguna jasa<br><br>-Prasarana Angkutan Penyeberangan yang layak dan memadai guna menunjang kualitas pelayanan jasa kepelabuhanan<br><br>-Tata Niaga Kepelabuhanan yang transparan dan akuntabel.<br><br>";
        teksProfil.setText(Html.fromHtml(profil));
        teksProfil.setMovementMethod(new ScrollingMovementMethod());
    }
}