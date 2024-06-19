package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionnaireEnclosImpl implements GestionnaireEnclos {
    private Map<String, Enclos> enclos;

    public GestionnaireEnclosImpl() {
        this.enclos = new HashMap<>();
    }

    @Override
    public void ajouterEnclos(Enclos enclos) {
        if (this.enclos.containsKey(enclos.getIdEnclos())) {
            throw new IllegalArgumentException("Identifiant d'enclos déjà existant");
        }
        this.enclos.put(enclos.getIdEnclos(), enclos);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void modifierEnclos(String identifiantEnclos, Map<String, Object> modifications) {
        Enclos enclos = this.enclos.get(identifiantEnclos);
        if (enclos == null) {
            throw new IllegalArgumentException("Enclos non trouvé");
        }
        modifications.forEach((cle, valeur) -> {
            switch (cle) {
                case "nom":
                    enclos.setNom((String) valeur);
                    break;
                case "taille":
                    enclos.setTaille((String) valeur);
                    break;
                case "especesAutorisees":
                    enclos.setEspecesPermises((List<String>) valeur);
                    break;
            }
        });
    }

    @Override
    public void supprimerEnclos(String identifiantEnclos) {
        if (!enclos.containsKey(identifiantEnclos)) {
            throw new IllegalArgumentException("Enclos non trouvé");
        }
        enclos.remove(identifiantEnclos);
    }

    @Override
    public Enclos obtenirEnclos(String identifiantEnclos) {
        return enclos.get(identifiantEnclos);
    }
}

