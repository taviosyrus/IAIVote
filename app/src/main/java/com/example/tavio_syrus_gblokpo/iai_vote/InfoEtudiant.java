package com.example.tavio_syrus_gblokpo.iai_vote;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.DAO.EtudiantDAO;
import com.example.tavio_syrus_gblokpo.iai_vote.Traitement.CircleImageView;
import com.squareup.picasso.Picasso;

public class InfoEtudiant extends AppCompatActivity {
    private TextView nom_util, num_util, email_util;
    private ImageView Button_edit_numero_tel;
    private CircleImageView circleImageView;
    private TextView idEt,nom, nomprenom, tel,adresse,datenaiss,email,nom2;
    private String clef,photo;
    private ImageButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_etudiant);
        nomprenom = findViewById(R.id.nomN);
        tel = findViewById(R.id.tel1);
        nom = findViewById(R.id.nom1);
        adresse = findViewById(R.id.adresse1);
        datenaiss = findViewById(R.id.datenaiss1);
        email = findViewById(R.id.email1);
        circleImageView = findViewById(R.id.photo_util_etu);



        clef = getIntent().getExtras().getString("toto");





        initData();


    }

    private void initData() {


        EtudiantDAO etudiantDAO = new EtudiantDAO(getApplicationContext());
        Cursor result = etudiantDAO.getPubDetail(clef);


        while (result.moveToNext()) {
            nomprenom.setText(result.getString(1)+" "+result.getString(2));
            nom.setText(result.getString(1)+" "+result.getString(2));
            tel.setText(result.getString(3));
            adresse.setText(result.getString(4));
            email.setText(result.getString(5));
            datenaiss.setText(result.getString(6));
            photo = result.getString(1);

            Picasso.with(getApplicationContext()).load("http://192.168.43.12/image/"+photo)
                    .placeholder(R.mipmap.ic_picasso_erreur_round)
                    .error(R.mipmap.ic_picasso_erreur_round)
                    .into(circleImageView);



        }

    }
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        setTitle("Profil");
        getMenuInflater().inflate(R.menu.menu__, menu);

        return true;
    }

}
