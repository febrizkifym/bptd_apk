package com.humasbptdxxi.profilbptdxxigorontalo;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;

public class IsimuJadwalFragment extends Fragment {
    Context context;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    final String[] rute = {"Rute Gorontalo-Manado","Rute Gorontalo-Bitung","Rute Gorontalo-Kotamobagu","Rute Gorontalo-Palu",
            "Rute Gorontalo-Makassar","Rute Gorontalo-Buol","Rute Gorontalo-Pinolosian"};
    final String[] waktu = {"Pukul 06:00 WITA","Pukul 05:00 WITA","Pukul 06:00 WITA","Pukul 09:00 WITA","Pukul 05:30 WITA","Pukul 07:30 WITA","Pukul 08:00 WITA"};
    final String[] tarif = {"Rp. 100.000","Rp. 120.000","Rp. 100.000","Rp. 150.000","Rp. 400.000","Rp. 80.000","Rp. 80.000"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_isimu_jadwal, container, false);
        context = view.getContext();
        recyclerView = view.findViewById(R.id.LvTrayek);
        recyclerViewLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        recyclerViewAdapter = new AdapterTrayek(context, Arrays.asList(rute), Arrays.asList(waktu), Arrays.asList(tarif));
        recyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }
}