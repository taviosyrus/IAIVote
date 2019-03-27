package com.example.tavio_syrus_gblokpo.iai_vote;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tavio_syrus_gblokpo.iai_vote.Adapter.GroupeItem;
import com.example.tavio_syrus_gblokpo.iai_vote.Adapter.QuestionItem;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.DAO.CritereDAO;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.DAO.EtudiantDAO;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.DAO.GcDAO;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.DAO.Mon_CompteDAO;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.DAO.ProfesseurDAO;
import com.example.tavio_syrus_gblokpo.iai_vote.Traitement.BackgroundTaskVote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VoteVrai extends AppCompatActivity {
    private Context context;

    private EditText commentaire;
    private ArrayList<String> Groupecritere;
    private Map<String, ArrayList<String>> mapChild;
    private Button valider, annuler;
    private TextView UE, Semestre, NomEn;
    private String toto = "";


    //data send by webservice//
    private ArrayList<int[]> vote;
    private String comment;
    private String idVote;
    private String idEt;
    private String idAnneeSCO;
    private String idSemetre;
    private String idFiliere;
    private String idEC;

    //idCritere INT NOT NULL,
    // idDSatis INT NOT NULL,
    //

    private Spinner liste = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_vrai);

        //*findview*//
        valider = findViewById(R.id.valider);
        annuler = findViewById(R.id.annuler);
        liste = (Spinner) findViewById(R.id.spiEC);
        commentaire = findViewById(R.id.commentaire);
        UE = (TextView) findViewById(R.id.ed);
        Semestre = (TextView) findViewById(R.id.Semestre);
        NomEn = (TextView) findViewById(R.id.NomEn);

        //*findview*//

        Groupecritere = new ArrayList<>();

        mapChild = new HashMap<>();
        iniData();
        addData();
        spinner();


    }

    public class function implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long id) {
            toto = parent.getItemAtPosition(pos).toString();
            //Toast.makeText(getApplicationContext(),toto ,Toast.LENGTH_LONG).show();
            EtudiantDAO etudiantDAO = new EtudiantDAO(getApplicationContext());
            Cursor cursor = etudiantDAO.getPubSpinner(toto);

            String Ue, sem, nom;
            sem = "";
            nom = "";
            Ue = "";


            while (cursor.moveToNext()) {
                Ue = cursor.getString(1);
                sem = cursor.getString(3);
                nom = cursor.getString(2);
            }
            UE.setText(Ue);
            Semestre.setText(sem);
            NomEn.setText(nom);

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }


    }


    public void spinner() {
        ProfesseurDAO professeurDAO = new ProfesseurDAO(VoteVrai.this);
        Cursor result1 = professeurDAO.getPub();
        List<String> spinner1 = new ArrayList<String>();

        while (result1.moveToNext()) {
            spinner1.add(result1.getString(1));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinner1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        liste.setAdapter(adapter);
        liste.setOnItemSelectedListener(new VoteVrai.function());

    }

    private boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(getApplicationContext().CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return (networkInfo != null && networkInfo.isConnected());
    }

    public void addData() {

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(VoteVrai.this);
                final View view = getLayoutInflater().inflate(R.layout.vote_validation, null);
                mBuilder.setView(view);
                final AlertDialog alertDialog = mBuilder.create();
                Button btn1 = view.findViewById(R.id.Ok);
                Button btn6 = view.findViewById(R.id.cancel);
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                        final AlertDialog.Builder mBuilder1 = new AlertDialog.Builder(VoteVrai.this);
                        final View view = getLayoutInflater().inflate(R.layout.patientez1, null);
                        mBuilder1.setView(view);
                        final AlertDialog alertDialog1 = mBuilder1.create();
                        alertDialog1.show();
                        alertDialog1.setCancelable(false);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (isConnected()) {


                                    EtudiantDAO etudiantDAO1 = new EtudiantDAO(VoteVrai.this);
                                    Cursor result1 = etudiantDAO1.getPub();
                                    vote = new ArrayList<>();
                                    while (result1.moveToNext()) {
                                        vote.add(new int[]{1, result1.getInt(0), 0, 1});
                                    }

                                   //recuper le text saisi pour un commentair//
                                    comment = String.valueOf(commentaire.getText());

                                    //ajout des identifiants pour permetre l'evaluation//
                                    idVote = "1";
                                    idSemetre = "1";
                                    idEC = "1";
                                    Mon_CompteDAO mon_compteDAO = new Mon_CompteDAO(getApplicationContext());
                                    Cursor cursor1 = mon_compteDAO.getPub();
                                    while (cursor1.moveToNext()) {
                                        idEt = cursor1.getString(0);
                                        idAnneeSCO = cursor1.getString(9);
                                        idFiliere = cursor1.getString(10);
                                    }
                                    //fin//

                                    BackgroundTaskVote backgroundTaskVote = new BackgroundTaskVote(context);
                                    backgroundTaskVote.execute(idVote, idEt, idFiliere, idAnneeSCO, idSemetre, idEC, comment);
                                } else {
                                    Toast.makeText(getApplicationContext(), "Pas de connexion", Toast.LENGTH_SHORT).show();
                                    alertDialog1.dismiss();
                                    return;
                                }


                                if (commentaire.length() == 0) {
                                    Toast.makeText(getApplicationContext(), "Veuillez saisir un commentaire", Toast.LENGTH_SHORT).show();
                                    alertDialog1.dismiss();
                                    commentaire.requestFocus();

                                } else {

                                    EtudiantDAO etudiantDAO1 = new EtudiantDAO(VoteVrai.this);
                                    Cursor result1 = etudiantDAO1.getPub();
                                    vote = new ArrayList<>();
                                    while (result1.moveToNext()) {
                                        vote.add(new int[]{1, result1.getInt(0), 0, 1});
                                    }

                                    comment = String.valueOf(commentaire.getText());
                                    //  Toast.makeText(VoteVrai.this, "" + comment, Toast.LENGTH_SHORT).show();
                                    //Toast.makeText(VoteVrai.this, "" + vote.get(0)[3], Toast.LENGTH_SHORT).show();

                                    if (comment.length() != 0) {

                                        alertDialog1.dismiss();
                                        Intent intent = getIntent();
                                        finish();
                                        startActivity(intent);
                                        Toast.makeText(getApplicationContext(), "Evaluation effectuee avec succees!", Toast.LENGTH_SHORT).show();

                                    } else {
                                        Mon_CompteDAO mon_compteDAO = new Mon_CompteDAO(getApplicationContext());
                                        Cursor cursor1 = mon_compteDAO.getPub();
                                        while (cursor1.moveToNext()) {
                                            idVote = result1.getString(0);
                                        }
                                        Toast.makeText(VoteVrai.this, "" + idVote, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }, 2000);


                    }
                });

                btn6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();
                alertDialog.setCancelable(false);


            }
        });

        annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = getIntent();
                finish();
                startActivity(intent);

            }
        });
    }


    public void iniData() {

        List<GroupeItem> LIST_GROUP = new ArrayList<>();
        GcDAO gcDAO = new GcDAO(VoteVrai.this);
        Cursor result = gcDAO.getPub();
        while (result.moveToNext()) {
            GroupeItem groupItem = new GroupeItem();
            groupItem.setGroup_name("" + result.getString(1));

            List<QuestionItem> LIST_QUESTION = new ArrayList<>();
            CritereDAO critereDAO = new CritereDAO(VoteVrai.this);
            Cursor result1 = critereDAO.getPubDetail(result.getString(0));
            while (result1.moveToNext()) {
                QuestionItem questionItem = new QuestionItem();
                questionItem.setQuestionName("" + result1.getString(2));
                LIST_QUESTION.add(questionItem);
            }

            groupItem.setLIST_QUESTION(LIST_QUESTION);
            LIST_GROUP.add(groupItem);
        }
        ListView listView = (ListView) findViewById(R.id.listview);
        QuestionAdapter adapter = new QuestionAdapter(VoteVrai.this, LIST_GROUP);
        listView.setAdapter(adapter);


    }


    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.menu__, menu);
        setTitle("Grille d'evaluation des enseignants");

        return true;
    }
}

