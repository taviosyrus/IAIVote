package com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.SIMPLE;

/**
 * Created by TAVIO-SYRUS-GBLOKPO on 21/03/2018.
 */

public class Concerner {
    public int idCri;
    public int idDs;
    public int idEt;
    public int idEc;
    public String libAnneeSCO;
    public String libSemetre;
    public String libFiliere;



    public Concerner(int idCri,int idEc, int idDs, int idEt, String libAnneeSCO, String libSemetre, String libFiliere) {
        this.idCri = idCri;
        this.idDs = idDs;
        this.idEt = idEt;
        this.libAnneeSCO = libAnneeSCO;
        this.libSemetre = libSemetre;
        this.libFiliere = libFiliere;
        this.idEc = idEc;
    }

    public int getIdCri() {
        return idCri;
    }

    public void setIdCri(int idCri) {
        this.idCri = idCri;
    }

    public int getIdDs() {
        return idDs;
    }

    public void setIdDs(int idDs) {
        this.idDs = idDs;
    }

    public int getIdEc() {
        return idEc;
    }

    public void setIdEc(int idEc) {
        this.idEc = idEc;
    }

    public int getIdEt() {
        return idEt;
    }

    public void setIdEt(int idEt) {
        this.idEt = idEt;
    }

    public String getLibAnneeSCO() {
        return libAnneeSCO;
    }

    public void setLibAnneeSCO(String libAnneeSCO) {
        this.libAnneeSCO = libAnneeSCO;
    }

    public String getLibSemetre() {
        return libSemetre;
    }

    public void setLibSemetre(String libSemetre) {
        this.libSemetre = libSemetre;
    }

    public String getLibFiliere() {
        return libFiliere;
    }

    public void setLibFiliere(String libFiliere) {
        this.libFiliere = libFiliere;
    }
}