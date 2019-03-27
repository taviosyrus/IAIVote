package com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.CONTENT;

import android.content.Context;

import com.example.tavio_syrus_gblokpo.iai_vote.BD_LOCAL.DAOBase;

/**
 * Created by TAVIO-SYRUS-GBLOKPO on 21/03/2018.
 */

public class EtudiantContent extends DAOBase {
    public static String NAME = "Etudiant";
    public static String idEt = "idEt";
    public static String NomEt = "NomEt";
    public static String PrenomEt = "PrenomEt";
    public static String TelephoneEt = "TelephoneEt";
    public static String AdresseEt = "AdresseEt";
    public static String MatriculeEt = "MatriculeEt";
    public static String DatedeNaissanceEt = "DatedeNaissanceEt";




    public static String CREATE = "CREATE TABLE "+NAME+" (" +
            idEt +" integer  PRIMARY KEY  ," +
            NomEt +" text NOT NULL ," +
            PrenomEt+" text NOT NULL ," +
            TelephoneEt+" text  ," +
            AdresseEt +" text  ," +
            MatriculeEt +" text NOT NULL ," +
            DatedeNaissanceEt +" text NOT NULL " + ")";
    public static String DROP = " DROP TABLE IF EXISTS "+NAME+" ; ";

    public EtudiantContent(Context context) {
        super(context);
    }



}
