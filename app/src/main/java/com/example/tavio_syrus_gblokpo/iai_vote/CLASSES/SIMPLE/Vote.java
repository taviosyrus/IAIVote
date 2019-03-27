package com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.SIMPLE;

/**
 * Created by TAVIO-SYRUS-GBLOKPO on 21/03/2018.
 */

public class Vote {
    public  int idVote;
    public  String libVote ;
    public  String DateDebut;
    public  String DateFin ;
    public  String etatVote;
    public  String anonymat;


    public Vote(int idVote, String libVote, String dateDebut, String dateFin, String etatVote, String anonymat) {
        this.idVote = idVote;
        this.libVote = libVote;
        DateDebut = dateDebut;
        DateFin = dateFin;
        this.etatVote = etatVote;
        this.anonymat = anonymat;
    }

    public int getIdVote() {
        return idVote;
    }

    public void setIdVote(int idVote) {
        this.idVote = idVote;
    }

    public String getLibVote() {
        return libVote;
    }

    public void setLibVote(String libVote) {
        this.libVote = libVote;
    }

    public String getDateDebut() {
        return DateDebut;
    }

    public void setDateDebut(String dateDebut) {
        DateDebut = dateDebut;
    }

    public String getDateFin() {
        return DateFin;
    }

    public void setDateFin(String dateFin) {
        DateFin = dateFin;
    }

    public String getEtatVote() {
        return etatVote;
    }

    public void setEtatVote(String etatVote) {
        this.etatVote = etatVote;
    }

    public String getAnonymat() {
        return anonymat;
    }

    public void setAnonymat(String anonymat) {
        this.anonymat = anonymat;
    }
}
