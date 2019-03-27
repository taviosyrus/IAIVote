package com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.tavio_syrus_gblokpo.iai_vote.BD_LOCAL.DAOBase;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.CONTENT.ConcernerContent;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.CONTENT.EtudiantContent;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.CONTENT.GcContent;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.SIMPLE.Concerner;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.SIMPLE.Gc;

/**
 * Created by TAVIO-SYRUS-GBLOKPO on 21/03/2018.
 */

public class GcDAO extends DAOBase {
    public GcDAO(Context context) {
        super(context);
    }

    public void add(Gc gc) {
        ContentValues values = new ContentValues();
        values.put(GcContent.idGc, gc.getIdDc());
        values.put(GcContent.libGc, gc.getLibGc());


        myDb.insert(ConcernerContent.NAME, null, values);

    }

    public void update(Gc gc) {
        ContentValues values = new ContentValues();
        values.put(GcContent.idGc, gc.getIdDc());
        values.put(GcContent.libGc, gc.getLibGc());



        myDb.update(GcContent.NAME, values, GcContent.idGc + " = ?", new String[]
                {String.valueOf(gc.getIdDc())});
    }

    public Cursor getPub(){
        open();
        return myDb.rawQuery("SELECT * FROM "+ GcContent.NAME,null);
    }
}
