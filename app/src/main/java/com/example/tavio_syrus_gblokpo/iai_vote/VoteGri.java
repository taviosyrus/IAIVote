package com.example.tavio_syrus_gblokpo.iai_vote;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.tavio_syrus_gblokpo.iai_vote.Adapter.ExpendableAdapter;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.DAO.EtudiantDAO;
import com.example.tavio_syrus_gblokpo.iai_vote.Traitement.BackgroundTaskVote;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class VoteGri extends AppCompatActivity {
    private ExpandableListView expandableListView;
    private ExpendableAdapter expendableAdapter;
    private Context context;

    private EditText commentaire;
    private ArrayList<String> Groupecritere;
    private Map<String, ArrayList<String>> mapChild;
    private Button valider, annuler;


    //data send by webservice//
    private ArrayList<int[]> vote;
    private String comment;
    private int idVote;
    private  int idEt;
    private  int idAnneeSCO ;
    private  int idSemetre;
    private  int idFiliere ;
    private int idEC;

    //idCritere INT NOT NULL,
   // idDSatis INT NOT NULL,
    //



    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_gri);
        expandableListView = findViewById(R.id.expendListe);
        valider = findViewById(R.id.valider);
        annuler = findViewById(R.id.annuler);
        Groupecritere = new ArrayList<>();
        commentaire = findViewById(R.id.commentaire);
        mapChild = new HashMap<>();
        initData1();
        addData();





    }


    public void initData2() {
        ArrayList<String> List1 = new ArrayList<>();
        ArrayList<String> List2 = new ArrayList<>();
        Groupecritere.add("group1");
        Groupecritere.add("group2");
        List1.add("gb");
        List1.add("tg");
        List1.add("ik");
        List2.add("hd");
        mapChild.put(Groupecritere.get(0), List1);
        mapChild.put(Groupecritere.get(1), List2);
        expendableAdapter = new ExpendableAdapter(Groupecritere, mapChild, this);
        expandableListView.setAdapter(expendableAdapter);
    }


//  //  public void initData5() {
//        final GcServ gcServ = new GcServ(new GcServ.Response() {
//            @Override
//            public void success(List<Gc> gcL) {
//                idGc = new String[gcL.size()];
//                libGc = new String[gcL.size()];
//                for (int j = 0; j < gcL.size(); j++) {
//                    Toast.makeText(VoteGri.this, "", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }

    private void initData1() {
        EtudiantDAO etudiantDAO = new EtudiantDAO(VoteGri.this);
        Cursor result = etudiantDAO.getPub();
        int i = 0;
        int l = 0;
        ArrayList<ArrayList<String>> List1;
        List1 = new ArrayList<>();
        while (result.moveToNext()) {
            Groupecritere.add("" + result.getString(1));
            ArrayList<String> contenu = new ArrayList<>();
            EtudiantDAO etudiantDAO1 = new EtudiantDAO(VoteGri.this);
            Cursor result1 = etudiantDAO1.getPub();
            while (result1.moveToNext()) {
                contenu.add("" + result1.getString(1));
            }
            List1.add(contenu);
            i++;
        }
        for (l = 0; l < i; l++) {
            mapChild.put(Groupecritere.get(l), List1.get(l));
        }

        expendableAdapter = new ExpendableAdapter(Groupecritere, mapChild, this);

        expandableListView.setAdapter(expendableAdapter);


    }

    public void addData() {

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EtudiantDAO etudiantDAO = new EtudiantDAO(VoteGri.this);
                Cursor result = etudiantDAO.getPub();

                EtudiantDAO etudiantDAO1 = new EtudiantDAO(VoteGri.this);
                Cursor result1 = etudiantDAO1.getPub();
                vote = new ArrayList<>();
                while (result1.moveToNext()) {
                    vote.add(new int[]{1, result1.getInt(0), 0, 1});

                }
                comment = String.valueOf(commentaire.getText());
                Toast.makeText(VoteGri.this, "" + comment, Toast.LENGTH_SHORT).show();
                Toast.makeText(VoteGri.this, "" + vote.get(0)[2], Toast.LENGTH_SHORT).show();

                Service();


            }
        });

        annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
    }
    private boolean isConnected1() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return (networkInfo != null && networkInfo.isConnected());
    }


    public void message() {
        final AlertDialog.Builder mBuilder1 = new AlertDialog.Builder(context);
        final View view = getLayoutInflater().inflate(R.layout.patientez1, null);


        mBuilder1.setView(view);
        final AlertDialog alertDialog = mBuilder1.create();
        alertDialog.show();
        alertDialog.setCancelable(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isConnected1()){
                    EtudiantDAO etudiantDAO = new EtudiantDAO(getApplicationContext());
                    etudiantDAO.open();


                }else {
                    Toast.makeText(getApplicationContext(), "Pas de connexion", Toast.LENGTH_SHORT).show();
                    alertDialog.dismiss();
                    return;
                }
                EtudiantDAO etudiantDAO = new EtudiantDAO(getApplicationContext());
                Cursor etudiantCursor = etudiantDAO.getPub();
                if (etudiantCursor != null) {
                    if (etudiantCursor != null) {
                       // startActivity(new Intent(getApplicationContext(), VoteGri.class));
                        alertDialog.dismiss();
                    }
                } else
                {
                    Toast.makeText(getApplicationContext(), "Aucun vote n'est disponible pour vous", Toast.LENGTH_SHORT).show();
                    alertDialog.dismiss();
                }

            }
        }, 2000);
    }


    public void Service() {


        // Etudiant//
//        BackgroundTaskVote backgroundTaskVote = new BackgroundTaskVote(getApplicationContext(),
//        idVote,
//        idEt,
//        idAnneeSCO,
//        idSemetre,
//        idFiliere,
//         idEC,
//          vote,
//          comment);
//        backgroundTaskVote.execute();


        ///
    }
}
