package com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.SIMPLE;

public class Critere {
    public int idCri;
    public String libCri;
    public int idGc;

    public Critere(int idCri, String libCri,int idGc) {
        this.idCri = idCri;
        this.libCri = libCri;
        this.idCri = idCri;
    }

    public int getIdCri() {
        return idCri;
    }

    public void setIdCri(int idCri) {
        this.idCri = idCri;
    }

    public String getLibCri() {
        return libCri;
    }

    public void setLibCri(String libCri) {
        this.libCri = libCri;
    }

    public int getIdGc() {
        return idGc;
    }

    public void setIdGc(int idGc) {
        this.idGc = idGc;
    }
}
