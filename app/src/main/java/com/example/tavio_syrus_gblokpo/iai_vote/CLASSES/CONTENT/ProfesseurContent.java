package com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.CONTENT;

import android.content.Context;

import com.example.tavio_syrus_gblokpo.iai_vote.BD_LOCAL.DAOBase;

/**
 * Created by TAVIO-SYRUS-GBLOKPO on 21/03/2018.
 */

public class ProfesseurContent extends DAOBase {
    public static String NAME = "Professeur";
    public static String idPr = "idPr";
    public static String NomPr = "NomPr";
    public static String PrenomPr = "PrenomPr";
    public static String TelephonePr = "TelephonePr";





    public static String CREATE = "CREATE TABLE "+NAME+" (" +
            idPr +" integer  PRIMARY KEY  ," +
            NomPr +" text NOT NULL ," +
            PrenomPr+" text NOT NULL ," +
            TelephonePr+" text  " + ")";
    public static String DROP = " DROP TABLE IF EXISTS "+"Professeur"+" ; ";

    public ProfesseurContent(Context context) {
        super(context);
    }



}
