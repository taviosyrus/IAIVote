package com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.tavio_syrus_gblokpo.iai_vote.BD_LOCAL.DAOBase;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.CONTENT.EtudiantContent;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.CONTENT.Mon_CompteContent;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.SIMPLE.Mon_Compte;


/**
 * Created by GBLOKPO on 09/01/2018.
 */

public class Mon_CompteDAO extends DAOBase {
    public Mon_CompteDAO(Context context) {
        super(context);
    }
    public void add(Mon_Compte mon_compte) {
        ContentValues values = new ContentValues();
        values.put(Mon_CompteContent.idEt, mon_compte.getIdEt());
        values.put(Mon_CompteContent.NomEt, mon_compte.getNomEt());
        values.put(Mon_CompteContent.PrenomEt, mon_compte.getPrenomEt());
        values.put(Mon_CompteContent.TelephoneEt, mon_compte.getTelephoneEt());
        values.put(Mon_CompteContent.AdresseEt, mon_compte.getAdresseEt());
        values.put(Mon_CompteContent.MatriculeEt, mon_compte.getMatriculeEt());
        values.put(Mon_CompteContent.DatedeNaissanceEt, mon_compte.getDatedeNaissanceEt());
        values.put(Mon_CompteContent.libAnneeSCO, mon_compte.getLibAnneeSCO());
        values.put(Mon_CompteContent.libFiliere, mon_compte.getIdFiliere());
        values.put(Mon_CompteContent.idAnneeSCO, mon_compte.getIdAnneeSCO());
        values.put(Mon_CompteContent.idFiliere, mon_compte.getIdFiliere());

        myDb.insert(Mon_CompteContent.NAME, null, values);
    }

    public void update(Mon_Compte mon_compte) {
        ContentValues values = new ContentValues();
        values.put(Mon_CompteContent.idEt, mon_compte.getIdEt());
        values.put(Mon_CompteContent.NomEt, mon_compte.getNomEt());
        values.put(Mon_CompteContent.PrenomEt, mon_compte.getPrenomEt());
        values.put(Mon_CompteContent.TelephoneEt, mon_compte.getTelephoneEt());
        values.put(Mon_CompteContent.AdresseEt, mon_compte.getAdresseEt());
        values.put(Mon_CompteContent.MatriculeEt, mon_compte.getMatriculeEt());
        values.put(Mon_CompteContent.DatedeNaissanceEt, mon_compte.getDatedeNaissanceEt());
        values.put(Mon_CompteContent.libAnneeSCO, mon_compte.getLibAnneeSCO());
        values.put(Mon_CompteContent.libFiliere, mon_compte.getLibFiliere());
        values.put(Mon_CompteContent.idAnneeSCO, mon_compte.getIdAnneeSCO());
        values.put(Mon_CompteContent.idFiliere, mon_compte.getIdFiliere());

        myDb.update(EtudiantContent.NAME, values, EtudiantContent.idEt + " = ?", new String[]
                {String.valueOf(mon_compte.getIdEt())});
    }
    public Cursor getPub(){
        open();
        return myDb.rawQuery("SELECT * FROM "+ Mon_CompteContent.NAME,null);
    }
}