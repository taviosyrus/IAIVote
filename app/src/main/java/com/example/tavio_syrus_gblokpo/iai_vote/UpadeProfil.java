package com.example.tavio_syrus_gblokpo.iai_vote;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.tavio_syrus_gblokpo.iai_vote.BD_LOCAL.DataBaseHandler;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.CONTENT.EtudiantContent;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.DAO.EtudiantDAO;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.SIMPLE.Etudiant;

import java.util.PriorityQueue;

public class UpadeProfil extends AppCompatActivity {
    EtudiantDAO myDb;
    EditText id,nom, prenom,tel,adress,email,datenaiss;
    String nomS,prenomS,telS,adressS,emailS,datenaissS;
    private Button valider;
    boolean cancel = false;
    View focusView = null;
    private ImageButton button,button1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upade_profil);
        myDb = new EtudiantDAO(this);



        nom = findViewById(R.id.nom1);
        prenom = findViewById(R.id.prenom1);
        tel = findViewById(R.id.tel1);
        adress = findViewById(R.id.adresse1);
                email = findViewById(R.id.email1);
                datenaiss = findViewById(R.id.datenaiss1);



        initData();





        valider = findViewById(R.id.modifPro);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nomS = nom.getText().toString();
                prenomS = prenom.getText().toString();
                telS = tel.getText().toString();
                if(nomS.length()==0){
                    nom.setError(getString(R.string.erreurNom));
                    focusView = nom;
                    cancel = true;
                }
                else

                if(prenomS.length()==0){
                    prenom.setError(getString(R.string.erreurPrenom));
                    focusView = prenom;
                    cancel = true;     }
                else
                    updateProfil();


                }




        });


    }



    private void initData() {
        //affichage des Publication

        EtudiantDAO etudiantDAO = new EtudiantDAO(getApplicationContext());
        Cursor result = etudiantDAO.getPubDetail("1");

        //  Toast.makeText(this, "" +clef, Toast.LENGTH_SHORT).show();

        while (result.moveToNext()) {
            nom.setText(result.getString(1));
            prenom.setText(result.getString(2));
            tel.setText(result.getString(3));
            adress.setText(result.getString(4));
            email.setText(result.getString(5));
            datenaiss.setText(result.getString(3));

        }

    }

    public void updateProfil(){

        nomS = nom.getText().toString();
        prenomS = prenom.getText().toString();
        adressS = adress.getText().toString();
        emailS = email.getText().toString();
        datenaissS = datenaiss.getText().toString();
        telS = tel.getText().toString();

        EtudiantContent etudiantContent = new EtudiantContent(getApplicationContext());



        EtudiantDAO etudiantDAO = new EtudiantDAO(getApplicationContext());
        etudiantDAO.open();
        etudiantContent.open();

        Etudiant etudiant = new Etudiant(
                1,
                 nomS,
                 prenomS,
                  telS,
                 adressS,
                 "5050",
                 datenaissS


        );


        etudiantDAO.update(etudiant);
        Intent intent = new Intent(getApplicationContext(), Profil.class);
        startActivity(intent);
      Toast.makeText(getApplicationContext(),"Modification effectuee avec succes!!",Toast.LENGTH_LONG).show();

    }


    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {

        setTitle("Modifier mon profil");
        return true;
    }



}
