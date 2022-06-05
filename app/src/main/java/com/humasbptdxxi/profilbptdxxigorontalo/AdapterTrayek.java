package com.humasbptdxxi.profilbptdxxigorontalo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterTrayek extends RecyclerView.Adapter<AdapterTrayek.ViewHolder> {
    public List<String> rute;
    public List<String> waktu;
    public List<String> tarif;
    private Context context;

    AdapterTrayek(Context context1, List<String> vRute, List<String> vWaktu, List<String> vTarif) {
        rute = vRute;
        waktu = vWaktu;
        tarif = vTarif;
        context = context1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_trayek,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvRute.setText(rute.get(position));
        holder.tvWaktu.setText(waktu.get(position));
        holder.tvTarif.setText(tarif.get(position));
    }

    @Override
    public int getItemCount() {
        return rute.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvRute, tvWaktu, tvTarif;
        ViewHolder(View v){
            super(v);
            tvRute = v.findViewById(R.id.TvRute);
            tvWaktu = v.findViewById(R.id.TvWaktu);
            tvTarif = v.findViewById(R.id.TvTarif);
        }

    }
}
