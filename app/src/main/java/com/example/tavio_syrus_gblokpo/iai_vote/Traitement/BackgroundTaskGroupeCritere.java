package com.example.tavio_syrus_gblokpo.iai_vote.Traitement;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.example.tavio_syrus_gblokpo.iai_vote.Login;
import com.example.tavio_syrus_gblokpo.iai_vote.Menu;

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

public class BackgroundTaskGroupeCritere extends AsyncTask<String,Void,Boolean> {
    protected AlertDialog alertDialog;
    Context context;
    public final static String id="au";
    public static java.lang.String reponse = "";
    public String rep = null;
    String user_name;
    String pass_word;

    public BackgroundTaskGroupeCritere(Context context){
        this.context=context;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
    }

    @Override
    protected Boolean doInBackground(String... params) {

        boolean retourne = false;
        String con_url = "http://192.168.43.54:8081/webService_Dizewe/login.php";
        String method = params[0];
        if(method.equals("connection")) {

            user_name = params[1];
            pass_word = params[2];
            InputStream IS = null;
            try {
                URL url = new URL(con_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setConnectTimeout(50000);
                httpURLConnection.setReadTimeout(50000);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String donnee = URLEncoder.encode("NOM_UTILISATEUR", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&" +
                        URLEncoder.encode("PASSWORD_UTILISATEUR", "UTF-8") + "=" + URLEncoder.encode(pass_word, "UTF-8");
                bufferedWriter.write(donnee);
                bufferedWriter.flush();
                if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                    IS = httpURLConnection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(IS,"UTF-8"));
                    String ligne;
                    while((ligne = reader.readLine()) != null) {
                        reponse += ligne;
                        rep=ligne;
                    }

                    if (rep.equals("0")){
                        retourne =false;

                    }else{
                        retourne = true;
                        SharedPreferences preferences;
                        preferences = PreferenceManager.getDefaultSharedPreferences(context);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString(id, rep);
                        editor.apply();
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return retourne;
    }
    @Override
    protected void onProgressUpdate(Void... values) {

        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(final Boolean success) {
        super.onPostExecute(success);
        Login activity = (Login) context;

        if (success) {
            activity.startActivity(new Intent(context, Menu.class));
            Toast.makeText(context,"Bienvenue "+user_name,Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(context,"Les informations entrées sont incorrectes",Toast.LENGTH_SHORT).show();
        }
    }
}
