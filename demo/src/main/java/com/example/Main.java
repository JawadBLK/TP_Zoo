package com.example;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        GestionnaireAnimal gestionnaireAnimaux = new GestionnaireAnimauxImpl();
        GestionnaireEnclos gestionnaireEnclos = new GestionnaireEnclosImpl();
        GestionnaireVisite gestionnaireVisites = new GestionnaireVisitesImpl();

        Animal lion = new Animal("A1", "Simba", "Lion", 5, "E1");
        Enclos enclosLion = new Enclos("E1", "Enclos Lions", "grand", Arrays.asList("Lion"));
        Visite visite = new Visite("V1", LocalDateTime.now(), LocalDateTime.now().plusHours(2), Arrays.asList("E1"));

        gestionnaireEnclos.ajouterEnclos(enclosLion);
        gestionnaireAnimaux.ajouterAnimal(lion);
        gestionnaireVisites.ajouterVisite(visite);

        // Affichage des informations
        System.out.println(gestionnaireAnimaux.obtenirAnimal("A1"));
        System.out.println(gestionnaireEnclos.obtenirEnclos("E1"));
        System.out.println(gestionnaireVisites.obtenirVisite("V1"));
    }
}
