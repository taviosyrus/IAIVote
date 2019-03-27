package com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.tavio_syrus_gblokpo.iai_vote.BD_LOCAL.DAOBase;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.CONTENT.ConcernerContent;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.CONTENT.CritereContent;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.CONTENT.EtudiantContent;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.CONTENT.GcContent;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.SIMPLE.Concerner;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.SIMPLE.Critere;

/**
 * Created by TAVIO-SYRUS-GBLOKPO on 21/03/2018.
 */

public class CritereDAO extends DAOBase {

    public CritereDAO(Context context) {
        super(context);
    }

    public void add(Critere critere) {
        ContentValues values = new ContentValues();
        values.put(CritereContent.idCri, critere.getIdCri());
        values.put(CritereContent.libCri, critere.getLibCri());
        values.put(CritereContent.idGc, critere.getIdGc());


        myDb.insert(ConcernerContent.NAME, null, values);

    }

    public void update(Critere critere) {
        ContentValues values = new ContentValues();
        values.put(CritereContent.idCri, critere.getIdCri());
        values.put(CritereContent.libCri, critere.getIdCri());
        values.put(CritereContent.idGc, critere.getIdGc());



        myDb.update(CritereContent.NAME, values, CritereContent.idCri + " = ?", new String[]
                {String.valueOf(critere.getIdCri())});
    }

    public Cursor getPubDetail(String nom){
        open();


        String query = "select * from "+ CritereContent.NAME+" where idGc like '%"+nom+"%'";

        return  myDb.rawQuery(query,null);
    }
}
