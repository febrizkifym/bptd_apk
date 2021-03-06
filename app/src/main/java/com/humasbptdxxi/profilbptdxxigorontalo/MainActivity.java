package com.humasbptdxxi.profilbptdxxigorontalo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CardView cvPelabuhan,cvTerminal,cvTentang,cvKeluar;
    ImageView link;
    public void keluar(){
        AlertDialog.Builder keluar = new AlertDialog.Builder(MainActivity.this);
        keluar.setMessage("Keluar Aplikasi?").setCancelable(false).setPositiveButton("Ya", (dialogInterface, i) -> {
            finish();
            System.exit(0);
        }).setNegativeButton("Tidak", (dialogInterface, i) -> dialogInterface.cancel());
        AlertDialog dialogKeluar = keluar.create();
        dialogKeluar.setTitle("Info");
        dialogKeluar.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cvTerminal = findViewById(R.id.menu_terminal);
        cvPelabuhan = findViewById(R.id.menu_pelabuhan);
        cvTentang = findViewById(R.id.menu_tentang);
        cvKeluar = findViewById(R.id.menu_keluar);
        link = findViewById(R.id.link);

        cvTerminal.setOnClickListener(this);
        cvPelabuhan.setOnClickListener(this);
        cvTentang.setOnClickListener(this);
        cvKeluar.setOnClickListener(this);
        link.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.menu_terminal) {
            Intent TerminalIntent;
            TerminalIntent = new Intent(MainActivity.this, TerminalActivity.class);
            startActivity(TerminalIntent);
        } else if (id == R.id.menu_pelabuhan) {
            Intent PelabuhanIntent;
            PelabuhanIntent = new Intent(MainActivity.this, PelabuhanActivity.class);
            startActivity(PelabuhanIntent);
        } else if (id == R.id.menu_tentang) {
            Intent tentangIntent;
            tentangIntent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(tentangIntent);
        } else if(id == R.id.link){
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("https://bptdxxigorontalo.com"));
            startActivity(intent);
        }else if (id == R.id.menu_keluar) {
            keluar();
        }
    }
    @Override
    public void onBackPressed(){
        keluar();
    }
}