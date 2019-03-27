package com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.CONTENT;

import android.content.Context;

import com.example.tavio_syrus_gblokpo.iai_vote.BD_LOCAL.DAOBase;


/**
 * Created by GBLOKPO.KOKU.ULRICH on 09/01/2018.
 */

public class Mon_CompteContent extends DAOBase {
    public static String NAME = "MonCompte";
    public static String idEt = "idEt";
    public static String NomEt = "NomEt";
    public static String PrenomEt = "PrenomEt";
    public static String TelephoneEt = "TelephoneEt";
    public static String AdresseEt = "AdresseEt";
    public static String MatriculeEt = "MatriculeEt";
    public static String DatedeNaissanceEt = "DatedeNaissanceEt";
    public static String libAnneeSCO = "libAnneeSCO";
    public static String libSemetre = "libSemetre";
    public static String libFiliere = "libFiliere";
    public static String idAnneeSCO = "idAnneSCO";
    public static String idFiliere = "idFiliere";




    public static String CREATE = "CREATE TABLE "+NAME+" (" +
            idEt +" integer  PRIMARY KEY  ," +
            NomEt +" text NOT NULL ," +
            PrenomEt+" text NOT NULL ," +
            TelephoneEt+" text  ," +
            AdresseEt +" text  ," +
            libAnneeSCO +" text NOT NULL ," +
            libSemetre +" text NOT NULL ," +
            libFiliere +" text NOT NULL ," +
            MatriculeEt +" text NOT NULL ," +
            idAnneeSCO +" text NOT NULL ," +
            idFiliere +" text NOT NULL ," +
            DatedeNaissanceEt +" text NOT NULL " + ")";
    public static String DROP = "DROP TABLE IF EXISTS "+"Mon_CompteContent"+" ; ";

    public Mon_CompteContent(Context context) {
        super(context);
    }



}
