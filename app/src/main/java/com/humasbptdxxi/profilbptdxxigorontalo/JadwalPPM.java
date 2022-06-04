package com.humasbptdxxi.profilbptdxxigorontalo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class JadwalPPM extends AppCompatActivity {
    Toolbar toolbar;
    TextView TvEvent,TvStatus;
    Context context;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    List<String> namaKapal = new ArrayList<String>();
    List<String> keterangan = new ArrayList<String>();
    private static final String TAG = "MyActivity";
    public static String result;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_ppg);

        toolbar = findViewById(R.id.btn_back);
        toolbar.setTitleTextAppearance(this,R.style.ToolbarFont);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
        TvEvent = findViewById(R.id.event);
        TvEvent.setSingleLine(false);
        TvStatus = findViewById(R.id.status);



        final ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        final CompactCalendarView jadwalCalendar = findViewById(R.id.jadwal);
        Locale idLocale = new Locale("in","ID");
        Log.d(TAG,"checkpoint");
        String url = "https://www.bptdxxigorontalo.com/jadwal";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, response -> {
            progressBar.setVisibility(View.INVISIBLE);
            try {
                JSONObject objArray = new JSONObject(response);
                result = String.valueOf(objArray);
                Log.d(TAG, "result "+result);
                for (int i = 0; i < objArray.length(); i++) {
                    String id = Integer.toString(i+1);
                    JSONObject j = objArray.getJSONObject(id);
                    Log.d(TAG, String.valueOf(j));
                    String getTanggal = j.getString("tanggal");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                    long tanggal = 0;
                    try {
                        tanggal = sdf.parse(getTanggal).getTime();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    String keterangan = String.valueOf(j.get("keterangan"));
                    if (j.getString("id_kapal").equals("3")) {
                        Event titik = new Event(Color.GREEN, tanggal, keterangan);
                        jadwalCalendar.addEvent(titik);
                    }
                    Date c = Calendar.getInstance().getTime();
                    SimpleDateFormat td = new SimpleDateFormat("EEEE, dd MMM yyyy",idLocale);
                    TvStatus.setText(td.format(c));
                    TvEvent.setText("");
                }
            } catch (JSONException e) {
                e.printStackTrace();
                Log.d(TAG, String.valueOf(e));
            }
        },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Tidak dapat terhubung ke internet. Mohon coba lagi", Toast.LENGTH_SHORT).show();
                onBackPressed();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        jadwalCalendar.shouldScrollMonth(true);

        jadwalCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDayClick(Date dateClicked) {
                TvEvent.setText("");
                namaKapal.clear();
                keterangan.clear();
                if(!jadwalCalendar.getEvents(dateClicked).isEmpty()){
                    List<Event> events = jadwalCalendar.getEvents(dateClicked);
                    for(int i=0;i<jadwalCalendar.getEvents(dateClicked).size();i++){
                        String formatTanggal = getDate(events.get(i).getTimeInMillis(),"EEEE, dd MMM yyyy");
                        TvStatus.setText(formatTanggal);
                        Log.d("FETCHDATA", String.valueOf(events));
                        if(events.get(i).getColor() == Color.GREEN){
                            namaKapal.add("KMP. CENGKIH AFO");
                        }
                        keterangan.add(String.valueOf(events.get(i).getData()));
                        context = getApplicationContext();
                        recyclerView = findViewById(R.id.LvEvent);
                        recyclerViewLayoutManager = new LinearLayoutManager(context);
                        recyclerView.setLayoutManager(recyclerViewLayoutManager);
                        recyclerViewAdapter = new AdapterJadwalPPG(context,namaKapal,keterangan);
                        recyclerView.setAdapter(recyclerViewAdapter);
                    }
                }else{
                    SimpleDateFormat td = new SimpleDateFormat("EEEE, dd MMM yyyy",idLocale);
                    TvStatus.setText(td.format(dateClicked));
                    TvEvent.setText("Tidak ada jadwal pada tanggal ini.");
                    namaKapal.clear();
                    keterangan.clear();
                    context = getApplicationContext();
                    recyclerView = findViewById(R.id.LvEvent);
                    recyclerViewLayoutManager = new LinearLayoutManager(context);
                    recyclerView.setLayoutManager(recyclerViewLayoutManager);
                    recyclerViewAdapter = new AdapterJadwalPPG(context,namaKapal,keterangan);
                    recyclerView.setAdapter(recyclerViewAdapter);
                }
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {

            }
        });

    }
    public static String getDate(long milliSeconds, String dateFormat)
    {
        Locale id = new Locale("in","ID");
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat,id);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }
}