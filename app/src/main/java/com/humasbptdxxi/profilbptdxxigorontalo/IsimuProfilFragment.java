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

public class IsimuProfilFragment extends Fragment {
    TextView teksProfil;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_isimu_profil, container, false);
        teksProfil = view.findViewById(R.id.teks_profil);
        String profil = "Keberhasilan pembangunan di Kabupaten Gorontalo tidak lepas dari pengembangan sektor Perhubungan yang terintegrasi dengan sektor lain dan dapat emberikan kontribusi yang signifikan terhadap pendapatan masyarakat khususnya.<br><br>Terminal Tipe A Isimu dibangun oleh Pemerintah Provinsi Gorontalo pada tahun 1996 dengan lahan seluas 31.390 m2. Terminal Tipe A Isimu bertempat di Desa Datahu, Kecamatan Tibawa, Kabupaten Gorontalo.<br><br>Terminal Tipe A Isimu merupakan Terminal singgah, dan tidak melayani keberangkatan penumpang, melainkan terminal singgah yang bertugas memastikan kenderaan yang menuju Provinsi Gorontalo maupun yang akan keluar Provinsi Gorontalo benar-benar telah diberangkatkan melalui Terminal Tipe A yang telah disediakan, dan dipastikan seluruh fungsi keselamatan pada kenderaan maupun sopir Bus telah melalui tahap pemeriksaan oleh Petugas Penguji Kenderaan Bermotor yang bertugas pada Terminal Tipe A, sehingga faktor keselamatan penumpang menjadi prioritas utama yang diperhatikan oleh petugas yang ada pada Satuan Layanan Terminal Tipe A Isimu.";
        teksProfil.setText(Html.fromHtml(profil));
        teksProfil.setMovementMethod(new ScrollingMovementMethod());

        return view;
    }
}