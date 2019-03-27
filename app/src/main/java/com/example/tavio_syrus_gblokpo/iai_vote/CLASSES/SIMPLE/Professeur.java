package com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.SIMPLE;

/**
 * Created by TAVIO-SYRUS-GBLOKPO on 21/03/2018.
 */

public class Professeur {
    public  int idPr;
    public  String NomPr;
    public  String PrenomPr;
    public  String TelephonePr;




    public Professeur(int idPr,String NomPr,String PrenomPr,
                    String TelephonePr ) {
        this.idPr = idPr;
        this.NomPr = NomPr;
        this.PrenomPr = PrenomPr;
        this.TelephonePr = TelephonePr;



    }

    public int getIdPr() {
        return idPr;
    }

    public void setIdPr(int idPr) {
        this.idPr = idPr;
    }

    public String getNomPr() {
        return NomPr;
    }

    public void setNomPr(String nomPr) {
        NomPr = nomPr;
    }

    public String getPrenomPr() {
        return PrenomPr;
    }

    public void setPrenomPr(String prenomPr) {
        PrenomPr = prenomPr;
    }

    public String getTelephonePr() {
        return TelephonePr;
    }

    public void setTelephonePr(String telephonePr) {
        TelephonePr = telephonePr;
    }
}
