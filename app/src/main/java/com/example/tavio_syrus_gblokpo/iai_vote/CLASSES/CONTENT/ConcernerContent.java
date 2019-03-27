package com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.CONTENT;

import android.content.Context;

import com.example.tavio_syrus_gblokpo.iai_vote.BD_LOCAL.DAOBase;

/**
 * Created by TAVIO-SYRUS-GBLOKPO on 21/03/2018.
 */

public class ConcernerContent extends DAOBase {
    public static String NAME = "Concerner";
    public static String idEc = "idEc";
    public static String idCri = "idCri";
    public static String idDs = "idDs";
    public static String idEt = "idEt";
    public static String libAnneeSCO = "libAnneeSCO";
    public static String libSemetre = "libSemetre";
    public static String libFiliere = "libFiliere";




    public static String CREATE = "CREATE TABLE "+NAME+" (" +
            idEc +" text  ," +
            idCri +" text ," +
            idDs +" text  ," +
            idEt +" text ," +
            libAnneeSCO +" text ," +
            libSemetre +" text ," +
            libFiliere+" text  ,"+
            "PRIMARY KEY (`idEc`,`idCri`,`idDs`,`idEt`,`libAnneeSCO`,`libSemetre`,`libFiliere`)" + ")";
    public static String DROP = "DROP TABLE IF EXISTS "+"Concerner"+" ; ";

    public ConcernerContent(Context context) {
        super(context);
    }



}
