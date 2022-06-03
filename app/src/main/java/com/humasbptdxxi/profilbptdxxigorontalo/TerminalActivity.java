package com.humasbptdxxi.profilbptdxxigorontalo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class TerminalActivity extends AppCompatActivity implements View.OnClickListener {
    CardView cvDungingi,cvIsimu;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminal);

        cvDungingi = findViewById(R.id.menu_dungingi);
        cvIsimu = findViewById(R.id.menu_isimu);
        toolbar = findViewById(R.id.btn_back);

        cvDungingi.setOnClickListener(this);
        cvIsimu.setOnClickListener(this);

        toolbar.setTitleTextAppearance(this,R.style.ToolbarFont);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.menu_dungingi){
            Toast.makeText(this,"Terminal Tipe A Dungingi", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.menu_isimu){
            Toast.makeText(this,"Terminal Tipe A Isimu", Toast.LENGTH_SHORT).show();
        }
    }
}