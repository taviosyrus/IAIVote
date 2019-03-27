package com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.DAO;

import android.content.ContentValues;
import android.content.Context;

import com.example.tavio_syrus_gblokpo.iai_vote.BD_LOCAL.DAOBase;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.CONTENT.ConcernerContent;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.SIMPLE.Concerner;

/**
 * Created by TAVIO-SYRUS-GBLOKPO on 21/03/2018.
 */

public class ConcernerDAO extends DAOBase {
    public ConcernerDAO(Context context) {
        super(context);
    }

    public void add(Concerner concerner) {
        ContentValues values = new ContentValues();
        values.put(ConcernerContent.idEc, concerner.getIdEc());
        values.put(ConcernerContent.idCri, concerner.getIdCri());
        values.put(ConcernerContent.idDs, concerner.getIdDs());
        values.put(ConcernerContent.idEt, concerner.getIdEt());
        values.put(ConcernerContent.libAnneeSCO, concerner.getLibAnneeSCO());
        values.put(ConcernerContent.libSemetre, concerner.getLibSemetre());
        values.put(ConcernerContent.libFiliere, concerner.getLibSemetre());

        myDb.insert(ConcernerContent.NAME, null, values);

    }

    public void update(Concerner concerner) {
        ContentValues values = new ContentValues();
        values.put(ConcernerContent.idEc, concerner.getIdEc());
        values.put(ConcernerContent.idCri, concerner.getIdCri());
        values.put(ConcernerContent.idDs, concerner.getIdDs());
        values.put(ConcernerContent.idEt, concerner.getIdEt());
        values.put(ConcernerContent.libAnneeSCO, concerner.getLibAnneeSCO());
        values.put(ConcernerContent.libSemetre, concerner.getLibSemetre());
        values.put(ConcernerContent.libFiliere, concerner.getLibSemetre());


        myDb.update(ConcernerContent.NAME, values, ConcernerContent.idEc + " = ?", new String[]
                {String.valueOf(concerner.getIdEc())});
    }
}
