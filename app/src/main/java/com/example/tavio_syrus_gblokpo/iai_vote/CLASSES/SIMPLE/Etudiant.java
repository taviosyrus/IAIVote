package com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.SIMPLE;

/**
 * Created by TAVIO-SYRUS-GBLOKPO on 21/03/2018.
 */

public class Etudiant {
    public  int idEt;
    public  String NomEt;
    public  String PrenomEt;
    public  String TelephoneEt;
    public  String AdresseEt;
    public  String MatriculeEt ;
    public  String DatedeNaissanceEt ;



    public Etudiant(int idEt,String NomEt,String PrenomEt,
                      String TelephoneEt,String AdresseEt,String MatriculeEt ,String DatedeNaissanceEt ) {
        this.idEt = idEt;
        this.NomEt = NomEt;
        this.PrenomEt = PrenomEt;
        this.TelephoneEt = TelephoneEt;
        this.AdresseEt = AdresseEt;
        this.MatriculeEt = MatriculeEt;
        this.DatedeNaissanceEt = DatedeNaissanceEt;


    }

    public int getIdEt() {
        return idEt;
    }

    public void setIdEt(int idEt) {
        this.idEt = idEt;
    }

    public String getNomEt() {
        return NomEt;
    }

    public void setNomEt(String nomEt) {
        NomEt = nomEt;
    }

    public String getPrenomEt() {
        return PrenomEt;
    }

    public void setPrenomEt(String prenomEt) {
        PrenomEt = prenomEt;
    }

    public String getTelephoneEt() {
        return TelephoneEt;
    }

    public void setTelephoneEt(String telephoneEt) {
        TelephoneEt = telephoneEt;
    }

    public String getAdresseEt() {
        return AdresseEt;
    }

    public void setAdresseEt(String adresseEt) {
        AdresseEt = adresseEt;
    }

    public String getMatriculeEt() {
        return MatriculeEt;
    }

    public void setMatriculeEt(String matriculeEt) {
        MatriculeEt = matriculeEt;
    }

    public String getDatedeNaissanceEt() {
        return DatedeNaissanceEt;
    }

    public void setDatedeNaissanceEt(String datedeNaissanceEt) {
        DatedeNaissanceEt = datedeNaissanceEt;
    }
}
