package com.example;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionnaireVisites {
    private Map<String, Visite> visites;

    public GestionnaireVisites() {
        visites = new HashMap<>();
    }

    public void ajouterVisite(Visite visite) {
        if (visites.containsKey(visite.getIdVisite())) {
            throw new IllegalArgumentException("Identifiant de visite déjà existant");
        }
        if (visite.getEnclosVisites().size() > 5) {
            throw new IllegalArgumentException("Une visite ne peut inclure plus de 5 enclos");
        }
        visites.put(visite.getIdVisite(), visite);
    }

    @SuppressWarnings("unchecked")
    public void modifierVisite(String identifiantVisite, Map<String, Object> modifications) {
        Visite visite = visites.get(identifiantVisite);
        if (visite == null) {
            throw new IllegalArgumentException("Visite non trouvée");
        }
        modifications.forEach((cle, valeur) -> {
            switch (cle) {
                case "heureDebut":
                    visite.setHeureDebut((LocalDateTime) valeur);
                    break;
                case "heureFin":
                    visite.setHeureFin((LocalDateTime) valeur);
                    break;
                case "enclosVisites":
                    visite.setEnclosVisites((List<String>) valeur);
                    if (visite.getEnclosVisites().size() > 5) {
                        throw new IllegalArgumentException("Une visite ne peut inclure plus de 5 enclos");
                    }
                    break;
            }
        });
    }

    public void annulerVisite(String identifiantVisite) {
        if (!visites.containsKey(identifiantVisite)) {
            throw new IllegalArgumentException("Visite non trouvée");
        }
        visites.remove(identifiantVisite);
    }

    public Visite obtenirVisite(String identifiantVisite) {
        return visites.get(identifiantVisite);
    }

    // Autres méthodes comme obtenir toutes les visites, etc.
}


