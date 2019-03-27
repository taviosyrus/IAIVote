package com.example.tavio_syrus_gblokpo.iai_vote;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.DAO.ProfesseurDAO;
import com.example.tavio_syrus_gblokpo.iai_vote.Traitement.CircleImageView;
import com.squareup.picasso.Picasso;

public class Info_professeur extends AppCompatActivity {
    private TextView nom_util, num_util, email_util;
    private ImageView Button_edit_numero_tel;
    private CircleImageView circleImageView;
    private TextView idEt,nom, nomprenom, tel,adresse,datenaiss;
    private String clef,photo;
    private ImageButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_professeur);
        nomprenom = findViewById(R.id.nomN);
        tel = findViewById(R.id.tel1);
        nom = findViewById(R.id.nom1);
        adresse = findViewById(R.id.adresse1);
        datenaiss = findViewById(R.id.datenaiss1);
        circleImageView = findViewById(R.id.photo_util_prof);

        clef = getIntent().getExtras().getString("toto");




        initData();


    }

    private void initData() {


        ProfesseurDAO professeurDAO = new ProfesseurDAO(getApplicationContext());
        Cursor result = professeurDAO.getPubDetail(clef);


        while (result.moveToNext()) {
            nomprenom.setText(result.getString(1)+" "+result.getString(2));
            nom.setText(result.getString(1)+" "+result.getString(2));
            tel.setText(result.getString(3));
            photo = result.getString(1);

            Picasso.with(getApplicationContext()).load("http://192.168.43.12/image/"+photo)
                    .placeholder(R.mipmap.ic_picasso_erreur_round)
                    .error(R.mipmap.ic_picasso_erreur_round)
                    .into(circleImageView);

        }

    }

    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        setTitle("Mr/Mlle");
        getMenuInflater().inflate(R.menu.menu__, menu);
        return true;
    }
}
