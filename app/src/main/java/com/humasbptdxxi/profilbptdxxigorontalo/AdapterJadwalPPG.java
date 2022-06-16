package com.humasbptdxxi.profilbptdxxigorontalo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterJadwalPPG extends RecyclerView.Adapter<AdapterJadwalPPG.ViewHolder> {
    public final List<String> namaKapal;
    public final List<String> keterangan;
    private final Context context;

    AdapterJadwalPPG(Context context1, List<String> vNamaKapal, List<String> vKeterangan) {
        namaKapal = vNamaKapal;
        keterangan = vKeterangan;
        context = context1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_jadwal_ppg,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvNamaKapal.setText(namaKapal.get(position));
        holder.tvKeterangan.setText(keterangan.get(position));
    }

    @Override
    public int getItemCount() {
        return namaKapal.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView tvNamaKapal;
        final TextView tvKeterangan;
        ViewHolder(View v){
            super(v);
            tvNamaKapal = v.findViewById(R.id.TvNamaKapal);
            tvKeterangan = v.findViewById(R.id.TvKeterangan);
        }

    }
}
