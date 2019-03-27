package com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.CONTENT;

import android.content.Context;

import com.example.tavio_syrus_gblokpo.iai_vote.BD_LOCAL.DAOBase;

/**
 * Created by TAVIO-SYRUS-GBLOKPO on 21/03/2018.
 */

public class VoteContent extends DAOBase {
    public static String NAME = "Vote";
    public static String idVote = "idVote";
    public static String libVote = "libVote";
    public static String DateDebut = "DateDebut";
    public static String DateFin = "DateFin";
    public static String etatVote = "etatVote";
    public static String anonymat = "anonymat";





    public static String CREATE = "CREATE TABLE "+NAME+" (" +
            idVote +" integer  PRIMARY KEY  ," +
            libVote +" text ," +
            DateDebut +" date  ," +
            DateFin +" date ," +
            etatVote +" text ," +
            anonymat+" text  " + ")";
    public static String DROP = "DROP TABLE IF EXISTS "+"Vote"+" ; ";

    public VoteContent(Context context) {
        super(context);
    }



}
