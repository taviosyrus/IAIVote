package com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.tavio_syrus_gblokpo.iai_vote.BD_LOCAL.DAOBase;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.CONTENT.Mon_CompteContent;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.CONTENT.ProfesseurContent;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.SIMPLE.Professeur;

/**
 * Created by TAVIO-SYRUS-GBLOKPO on 21/03/2018.
 */

public class ProfesseurDAO extends DAOBase {
    public ProfesseurDAO(Context context) {
        super(context);
    }

    public void add(Professeur professeur) {
        ContentValues values = new ContentValues();
        values.put(ProfesseurContent.idPr, professeur.getIdPr());
        values.put(ProfesseurContent.NomPr, professeur.getNomPr());
        values.put(ProfesseurContent.PrenomPr, professeur.getPrenomPr());
        values.put(ProfesseurContent.TelephonePr, professeur.getTelephonePr());
        myDb.insert(Mon_CompteContent.NAME, null, values);
    }

    public void update(Professeur professeur) {
        ContentValues values = new ContentValues();
        values.put(ProfesseurContent.idPr, professeur.getIdPr());
        values.put(ProfesseurContent.NomPr, professeur.getNomPr());
        values.put(ProfesseurContent.PrenomPr, professeur.getPrenomPr());
        values.put(ProfesseurContent.TelephonePr, professeur.getTelephonePr());
        myDb.update(ProfesseurContent.NAME, values, ProfesseurContent.idPr + " = ?", new String[]
                {String.valueOf(professeur.getIdPr())});
    }

    public Cursor getPub(){
        open();
        return myDb.rawQuery("SELECT * FROM "+ ProfesseurContent.NAME,null);
    }


    public Cursor getPubReq(String nom){
        open();


        String query = "select * from "+ ProfesseurContent.NAME+" where nomPr like '%"+nom+"%' or prenomPr like'%"+nom+"%'";

        return  myDb.rawQuery(query,null);
    }
    public Cursor getPubDetail(String nom){
        open();


        String query = "select * from "+ ProfesseurContent.NAME+" where idPr like '%"+nom+"%'";

        return  myDb.rawQuery(query,null);
    }
}