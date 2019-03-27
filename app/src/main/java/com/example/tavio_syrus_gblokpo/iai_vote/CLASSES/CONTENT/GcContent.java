package com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.CONTENT;

import android.content.Context;

import com.example.tavio_syrus_gblokpo.iai_vote.BD_LOCAL.DAOBase;

/**
 * Created by TAVIO-SYRUS-GBLOKPO on 21/03/2018.
 */

public class GcContent extends DAOBase {
    public static String NAME = "Gc";
    public static String idGc = "idGc";
    public static String libGc = "libGc";






    public static String CREATE = "CREATE TABLE "+NAME+" (" +
            idGc +" integer  PRIMARY KEY  ," +
            libGc+" text  " + ")";
    public static String DROP = " DROP TABLE IF EXISTS "+NAME+" ; ";

    public GcContent(Context context) {
        super(context);
    }



}
