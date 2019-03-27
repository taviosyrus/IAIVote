package com.example.tavio_syrus_gblokpo.iai_vote;

import android.app.Activity;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.tavio_syrus_gblokpo.iai_vote.Adapter.ClarteList;
import com.example.tavio_syrus_gblokpo.iai_vote.Adapter.ClassementomportementList;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.DAO.EtudiantDAO;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.DAO.ProfesseurDAO;
import com.example.tavio_syrus_gblokpo.iai_vote.Traitement.CircleImageView;

public class Classement_suivant_leur_clarte extends AppCompatActivity {

    private ListView listprof;
    private String[] NomEt;
    private String[] idEt;
    private String[] photo_util_p,score,rang;
    private SearchView rech;
    ClarteList clarteList;
    private CircleImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classement_suivant_leur_clarte);
        listprof = (ListView) findViewById(R.id.Profil_Liste_View);
        initData();
        clarteList = new ClarteList(this, idEt, NomEt, photo_util_p,score,rang);
        listprof.setAdapter(clarteList);

        rech = (SearchView) findViewById(R.id.rech);
        rech.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                EtudiantDAO etudiantDAO = new EtudiantDAO(getApplicationContext());
                Cursor result = etudiantDAO.getPubReq(newText);
                int i = 0;
                idEt = new String[result.getCount()];
                NomEt = new String[result.getCount()];
                while (result.moveToNext()) {
                    idEt[i] = result.getString(0);
                    NomEt[i] = (result.getString(1) + " " + result.getString(2));
                    photo_util_p[i] = result.getString(1);
                    i++;
                }
                clarteList = new ClarteList((Activity) getApplicationContext(), idEt, NomEt, photo_util_p,score,rang);
                listprof.setAdapter(clarteList);
                return true;
            }
        });
    }


    private void initData() {


        EtudiantDAO etudiantDAO = new EtudiantDAO(getApplicationContext());
        Cursor result = etudiantDAO.getPub();
        int i = 0;
        idEt = new String[result.getCount()];
        NomEt = new String[result.getCount()];
        photo_util_p = new String[result.getCount()];
        while (result.moveToNext()) {
            idEt[i] = result.getString(0);
            NomEt[i] = (result.getString(1) + " " + result.getString(2));
            photo_util_p[i] = result.getString(1);
            i++;
        }


    }
}
