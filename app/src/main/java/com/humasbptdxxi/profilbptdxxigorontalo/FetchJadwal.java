package com.humasbptdxxi.profilbptdxxigorontalo;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchJadwal extends AsyncTask<Void, Void, Void> {
    public static String result;

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://www.bptdxxigorontalo.com/jadwal");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null){
                line = bufferedReader.readLine();
                result = result + line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String removeSuffix(final String s, final String suffix)
    {
        if (s != null && suffix != null && s.endsWith(suffix)) {
            return s.substring(0, s.length() - suffix.length());
        }
        return s;
    }
    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        String crappyPrefix = "null";
        if(result.startsWith(crappyPrefix)){
            result = result.substring(crappyPrefix.length());
        }
        if(result.endsWith(crappyPrefix)){
            result = removeSuffix(result,"null");
        }
        Log.d("JSON",result);
    }
}
