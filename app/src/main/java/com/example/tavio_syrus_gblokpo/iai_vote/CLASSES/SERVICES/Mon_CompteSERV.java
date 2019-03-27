package com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.SERVICES;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.CONTENT.Mon_CompteContent;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.DAO.Mon_CompteDAO;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.SIMPLE.Mon_Compte;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

/**
 * Created by GBLOKPO-KOKU-ULRICH on 12/01/2018.
 */

public class Mon_CompteSERV extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    public Mon_CompteSERV(Context ctx) {
        context = ctx;
    }
    private String type;
    private String resulta;
    private String ip = "http://192.168.2.198";
    String login_url;
    private String filiere,nom,prenom,email,tel,mdp,datenais;
    @Override
    protected String doInBackground(String... params) {
        this.resulta = "oui";
        String resultat = "";
        type = params[0];
        if(type.equals("professeur")) {
            login_url = ip+"/Maruti-Admin/HTML/webservice/ListedesProfesseurs.php";
            try {
                nom = params[1];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("iduser","UTF-8")+"="+ URLEncoder.encode(nom,"UTF-8")+"&"
                        + URLEncoder.encode("type","UTF-8")+"="+ URLEncoder.encode(type,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return resultat;
    }

    public  boolean reponse;
    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Webby");
        alertDialog.setMessage("hhhh");
        //   alertDialog.show();
    }


    @Override
    protected void onPostExecute(String result) {
        int nombre = 0;
        boolean rep = false;
        try
        {

            JSONArray ja=new JSONArray(result);
            JSONObject jo=null;
            nombre = ja.length();


            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                Mon_CompteContent mon_compteContent = new Mon_CompteContent(context);



                Mon_CompteDAO mon_CompteDAO = new Mon_CompteDAO(context);
                mon_CompteDAO.open();

            //    Mon_Compte mon_compte = new Mon_Compte(
//                        Integer.parseInt(jo.getString("idEt")),
//                        jo.getString("NomEt"),
//                        jo.getString("PrenomEt"),
//                        jo.getString("TelephoneEt"),
//                        jo.getString("AdresseEt"),
//                        jo.getString("MatriculeEt"),
//                        jo.getString("DatedeNaissanceEt"),
//                        jo.getString("libAnneeSCO"),
//                        jo.getString("libSemetre"),
//                        jo.getString("libFiliere")
//
//

               // );

             //   mon_CompteDAO.add(mon_compte);



            }

          //  Toast.makeText(context,result,Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
