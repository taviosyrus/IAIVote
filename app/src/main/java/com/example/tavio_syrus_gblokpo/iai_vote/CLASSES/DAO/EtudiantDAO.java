package com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.tavio_syrus_gblokpo.iai_vote.BD_LOCAL.DAOBase;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.CONTENT.EtudiantContent;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.CONTENT.Mon_CompteContent;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.SIMPLE.Etudiant;

/**
 * Created by TAVIO-SYRUS-GBLOKPO on 21/03/2018.
 */

public class EtudiantDAO extends DAOBase {

    public EtudiantDAO(Context context) {
        super(context);
    }

    public void add(Etudiant etudiant) {
        ContentValues values = new ContentValues();
        values.put(EtudiantContent.idEt, etudiant.getIdEt());
        values.put(EtudiantContent.NomEt, etudiant.getNomEt());
        values.put(EtudiantContent.PrenomEt, etudiant.getPrenomEt());
        values.put(EtudiantContent.TelephoneEt, etudiant.getTelephoneEt());
        values.put(EtudiantContent.AdresseEt, etudiant.getAdresseEt());
        values.put(EtudiantContent.MatriculeEt, etudiant.getMatriculeEt());
        values.put(EtudiantContent.DatedeNaissanceEt, etudiant.getDatedeNaissanceEt());


        myDb.insert(Mon_CompteContent.NAME, null, values);
    }

    public void update(Etudiant etudiant) {
        ContentValues values = new ContentValues();
        values.put(EtudiantContent.idEt, etudiant.getIdEt());
        values.put(EtudiantContent.NomEt, etudiant.getNomEt());
        values.put(EtudiantContent.PrenomEt, etudiant.getPrenomEt());
        values.put(EtudiantContent.TelephoneEt, etudiant.getTelephoneEt());
        values.put(EtudiantContent.AdresseEt, etudiant.getAdresseEt());
        values.put(EtudiantContent.MatriculeEt, etudiant.getMatriculeEt());
        values.put(EtudiantContent.DatedeNaissanceEt, etudiant.getDatedeNaissanceEt());

        myDb.update(EtudiantContent.NAME, values, EtudiantContent.idEt + " = ?", new String[]
                {String.valueOf(etudiant.getIdEt())});
    }


    public Cursor getPub(){
        open();
        return myDb.rawQuery("SELECT * FROM "+ EtudiantContent.NAME,null);
    }


    public Cursor getPubReq(String nom){
        open();


      String query = "select * from "+ EtudiantContent.NAME+" where nomEt like '%"+nom+"%' or prenomEt like'%"+nom+"%'";

         return  myDb.rawQuery(query,null);
    }

    public Cursor getPubDetail(String nom){
        open();


        String query = "select * from "+ EtudiantContent.NAME+" where idEt like '%"+nom+"%'";

        return  myDb.rawQuery(query,null);
    }

    public Cursor getPubSpinner(String nom){
        open();


        String query = "select * from "+ EtudiantContent.NAME+" where NomEt like '%"+nom+"%'";

        return  myDb.rawQuery(query,null);
    }
    public Cursor setProfil(Integer id,String nom){
        open();

        String query = "UPDATE"+ EtudiantContent.NAME+"SET nomEt='"+nom+"' "+" where idEt = '"+id+"'";

        return myDb.rawQuery(query,null);

    }



    public String maxId(){
        Cursor max =  myDb.rawQuery("SELECT * FROM "+ EtudiantContent.NAME,null);
        String resultHoraire = max.getCount()+"";
        if(max.getCount()>0)
            while (max.moveToNext())
                resultHoraire = max.getString(0);

        return resultHoraire;
    }
    public String count(){
        return String.valueOf(myDb.rawQuery("SELECT * FROM "+EtudiantContent.NAME,null).getCount());
    }
    public  Cursor select_Mon_Compte(){

        Cursor res = myDb.rawQuery("SELECT * FROM "+ EtudiantContent.NAME,null);
        return res;

    }

}
