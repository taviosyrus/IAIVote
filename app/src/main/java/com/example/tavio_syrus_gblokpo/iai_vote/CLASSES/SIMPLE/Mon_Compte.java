package com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.SIMPLE;

/**
 * Created by TAVIO-SYRUS-GBLOKPO on 09/01/2018.
 */

public class Mon_Compte {
    public  int idEt;
    public  String NomEt;
    public  String PrenomEt;
    public  String TelephoneEt;
    public  String AdresseEt;
    public  String MatriculeEt ;
    public  String DatedeNaissanceEt ;
    public  String libAnneeSCO ;
    public  String libFiliere ;
    private  int idAnneeSCO ;
    private  int idFiliere ;


    public Mon_Compte(int idEt, String nomEt, String prenomEt, String telephoneEt, String adresseEt, String matriculeEt, String datedeNaissanceEt, String libAnneeSCO, String libFiliere, int idAnneeSCO, int idFiliere) {
        this.idEt = idEt;
        NomEt = nomEt;
        PrenomEt = prenomEt;
        TelephoneEt = telephoneEt;
        AdresseEt = adresseEt;
        MatriculeEt = matriculeEt;
        DatedeNaissanceEt = datedeNaissanceEt;
        this.libAnneeSCO = libAnneeSCO;
        this.libFiliere = libFiliere;
        this.idAnneeSCO = idAnneeSCO;
        this.idFiliere = idFiliere;
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

    public String getLibAnneeSCO() {
        return libAnneeSCO;
    }

    public void setLibAnneeSCO(String libAnneeSCO) {
        this.libAnneeSCO = libAnneeSCO;
    }

    public String getLibFiliere() {
        return libFiliere;
    }

    public void setLibFiliere(String libFiliere) {
        this.libFiliere = libFiliere;
    }

    public int getIdAnneeSCO() {
        return idAnneeSCO;
    }

    public void setIdAnneeSCO(int idAnneeSCO) {
        this.idAnneeSCO = idAnneeSCO;
    }

    public int getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(int idFiliere) {
        this.idFiliere = idFiliere;
    }
}




