package com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.CONTENT;

import android.content.Context;

import com.example.tavio_syrus_gblokpo.iai_vote.BD_LOCAL.DAOBase;

/**
 * Created by TAVIO-SYRUS-GBLOKPO on 21/03/2018.
 */

public class CritereContent extends DAOBase {
    public static String NAME = "Crietre";
    public static String idCri = "idCri";
    public static String libCri = "libCri";
    public static String idGc   = "idGc";






    public static String CREATE = "CREATE TABLE "+NAME+" (" +
            idCri +" integer  PRIMARY KEY  ," +
            idGc +" integer ," +
            libCri+" text  " + ")";
    public static String DROP = " DROP TABLE IF EXISTS "+NAME+" ; ";

    public CritereContent(Context context) {
        super(context);
    }



}
