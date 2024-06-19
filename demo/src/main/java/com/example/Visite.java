package com.example;

import java.time.LocalDateTime;
import java.util.List;

public class Visite {
    private String idVisite;
    private LocalDateTime heureDebut;
    private LocalDateTime heureFin;
    private List<String> enclosVisites;

    public String getIdVisite() {
        return idVisite;
    }

    public void setIdVisite(String idVisite) {
        this.idVisite = idVisite;
    }

    public LocalDateTime getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(LocalDateTime heureDebut) {
        this.heureDebut = heureDebut;
    }

    public LocalDateTime getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(LocalDateTime heureFin) {
        this.heureFin = heureFin;
    }

    public List<String> getEnclosVisites() {
        return enclosVisites;
    }

    public void setEnclosVisites(List<String> enclosVisites) {
        this.enclosVisites = enclosVisites;
    }

    public Visite(String idVisite, LocalDateTime heureDebut, LocalDateTime heureFin, List<String> enclosVisites) {
        this.idVisite = idVisite;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.enclosVisites = enclosVisites;
    }

    // Getters et setters

    @Override
    public String toString() {
        return "ID Visite: " + idVisite + ", Début: " + heureDebut + ", Fin: " + heureFin + ", Enclos: " + enclosVisites;
    }
}

