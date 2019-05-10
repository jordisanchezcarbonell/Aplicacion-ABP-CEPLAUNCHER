package com.example.ceplauncher.activities;

public class Equipo {
    private String nom;
    private int imgaen;
    public Equipo(String nom, int imgaen) {
        this.nom = nom;
        this.imgaen = imgaen;
    }
    public String getNom() {
        return nom;
    }
    public int getImgaen() {
        return imgaen;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setImgaen(int imgaen) {
        this.imgaen = imgaen;
    }
}