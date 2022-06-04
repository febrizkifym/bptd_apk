package com.humasbptdxxi.profilbptdxxigorontalo;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DungingiProfilFragment extends Fragment {
    TextView teksProfil;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dungingi_profil, container, false);
        teksProfil = view.findViewById(R.id.teks_profil);
        String profil = "Terminal Tipe A Dungingi dibangun oleh Pemerintah Kota Gorontalo pada tahun 2015 pada lahan seluas 39.147 m2, dilengkapi dengan sarana dan prasarana terminal<br><br>Pembangunan Terminal Tipe A Dungingi ini berdasarkan pemikiran Relokasi Terminal Tipe A 1942 Andalas, karena dinilai tidak memenuhi syarat dilihat dari daya tampung, sarana/prasarana maupun pembagian zona<br><br>Lokasi pembangunan terminal tipe A Dungingi sesuai dengan RUTR, serta memenuhi syarat dilihat dari:<br><br>-Tingkat kepadatan lalu lintas dan kapasitas jalan.<br><br>-Keterpaduan antar/intra moda transportasi<br><br>-Kondisi topografi.<br><br>-Kelestarian lingkungan.<br><br>Pembangunan Terminal Tipe A Dungingi didasari Keputusan Menteri Perhubungan No. SK.2102/AJ.101/DRJD/2012, tanggal 15 Juni 2012, tentang Penetapan Lokasi Terminal Penumpang Tipe A di Kota Gorontalo-Provinsi Gorontalo.";
        teksProfil.setText(Html.fromHtml(profil));
        teksProfil.setMovementMethod(new ScrollingMovementMethod());

        return view;
    }
}