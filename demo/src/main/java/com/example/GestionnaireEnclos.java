package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionnaireEnclos {
    private Map<String, Enclos> enclos;

    public GestionnaireEnclos() {
        enclos = new HashMap<>();
    }

    public void ajouterEnclos(Enclos enclos) {
        if (this.enclos.containsKey(enclos.getIdEnclos())) {
            throw new IllegalArgumentException("L'ID de l'enclos existe déjà");
        }
        this.enclos.put(enclos.getIdEnclos(), enclos);
    }

    @SuppressWarnings("unchecked")
    public void mettreAJourEnclos(String idEnclos, Map<String, Object> misesAJour) {
        Enclos enclos = this.enclos.get(idEnclos);
        if (enclos == null) {
            throw new IllegalArgumentException("Enclos non trouvé");
        }
        misesAJour.forEach((cle, valeur) -> {
            switch (cle) {
                case "nom":
                    enclos.setNom((String) valeur);
                    break;
                case "taille":
                    enclos.setTaille((String) valeur);
                    break;
                case "especesPermises":
                    enclos.setEspecesPermises((List<String>) valeur);
                    
                    break;
            }
        });
    }

    public void supprimerEnclos(String idEnclos) {
        if (!this.enclos.containsKey(idEnclos)) {
            throw new IllegalArgumentException("Enclos non trouvé");
        }
        if (enclosContientAnimaux(idEnclos)) {
            throw new IllegalArgumentException("L'enclos contient des animaux et ne peut pas être supprimé");
        }
        this.enclos.remove(idEnclos);
    }

    public Enclos obtenirEnclos(String idEnclos) {
        return this.enclos.get(idEnclos);
    }

    private boolean enclosContientAnimaux(String idEnclos) {
        // Logique pour vérifier si l'enclos contient des animaux
        return false;
    }

    // Autres méthodes comme obtenir tous les enclos, etc.
}

