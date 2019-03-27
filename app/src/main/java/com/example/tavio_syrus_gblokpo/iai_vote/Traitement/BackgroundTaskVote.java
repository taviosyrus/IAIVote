package com.example.tavio_syrus_gblokpo.iai_vote.Traitement;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;


public class BackgroundTaskVote extends AsyncTask<String, Void, String> {


    Context ctx;

    private String idVote;
    private String idEt;
    private String idAnneeSCO;
    private String idSemetre;
    private String idFiliere;
    private String idEC;
    private ArrayList<int[]> vote;
    private String message;


    public BackgroundTaskVote(Context ctx
    ) {
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String ins_url = "http://192.168.137.1/android/rememberme/activity_inscription.php";

        idVote = params[0];
        idEt = params[1];
        idAnneeSCO = params[3];
        idSemetre = params[4];
        idFiliere = params[2];
        idEC = params[5];
        message = params[6];
        Log.d("idvote", "" + message);


        try {

            URL url = new URL(ins_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setConnectTimeout(20000);
            httpURLConnection.setReadTimeout(30000);
            OutputStream OS = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
            String donnee =
                    URLEncoder.encode("MESSAGE", "UTF-8") + "=" + URLEncoder.encode(idVote, "UTF-8") + "&" +
                            URLEncoder.encode("idEt", "UTF-8") + "=" + URLEncoder.encode(idEt, "UTF-8") + "&" +
                            URLEncoder.encode("idAnneeSCO", "UTF-8") + "=" + URLEncoder.encode(idAnneeSCO, "UTF-8") + "&" +
                            URLEncoder.encode("idSemetre", "UTF-8") + "=" + URLEncoder.encode(idSemetre, "UTF-8") + "&" +
                            URLEncoder.encode("idFiliere", "UTF-8") + "=" + URLEncoder.encode(idFiliere, "UTF-8") + "&" +
                            URLEncoder.encode("idEC", "UTF-8") + "=" + URLEncoder.encode(idEC, "UTF-8") + "&" +
                            URLEncoder.encode("MESSAGE", "UTF-8") + "=" + URLEncoder.encode(message, "UTF-8") + "&" +
                            URLEncoder.encode("vote", "UTF-8") + "=" + URLEncoder.encode(vote.toArray().toString(), "UTF-8");
            bufferedWriter.write(donnee);
            bufferedWriter.flush();
            bufferedWriter.close();
            OS.close();
            InputStream IS = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS, "UTF-8"));
            String result = "";
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                result += line;
            }
            bufferedReader.close();
            IS.close();
            httpURLConnection.disconnect();
            return result;

        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {

        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
    }
}
