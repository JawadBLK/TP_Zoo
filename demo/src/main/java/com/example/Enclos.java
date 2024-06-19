package com.example;

import java.util.List;

public class Enclos {
    private String idEnclos;
    private String nom;
    private String taille;
    private List<String> especesPermises;

    public String getIdEnclos() {
        return idEnclos;
    }

    public void setIdEnclos(String idEnclos) {
        this.idEnclos = idEnclos;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public List<String> getEspecesPermises() {
        return especesPermises;
    }

    public void setEspecesPermises(List<String> especesPermises) {
        this.especesPermises = especesPermises;
    }

    public Enclos(String idEnclos, String nom, String taille, List<String> especesPermises) {
        this.idEnclos = idEnclos;
        this.nom = nom;
        this.taille = taille;
        this.especesPermises = especesPermises;
    }

    // Getters et setters

    @Override
    public String toString() {
        return nom + " - Taille: " + taille + ", Espèces permises: " + especesPermises;
    }
}

