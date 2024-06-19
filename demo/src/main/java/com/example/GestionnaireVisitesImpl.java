package com.example;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionnaireVisitesImpl implements GestionnaireVisite {
    private Map<String, Visite> visites;

    public GestionnaireVisitesImpl() {
        this.visites = new HashMap<>();
    }

    @Override
    public void ajouterVisite(Visite visite) {
        if (visites.containsKey(visite.getIdVisite())) {
            throw new IllegalArgumentException("Identifiant de visite déjà existant");
        }
        if (visite.getEnclosVisites().size() > 5) {
            throw new IllegalArgumentException("Une visite ne peut inclure plus de 5 enclos");
        }
        visites.put(visite.getIdVisite(), visite);
    }

    @Override
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

    @Override
    public void annulerVisite(String identifiantVisite) {
        if (!visites.containsKey(identifiantVisite)) {
            throw new IllegalArgumentException("Visite non trouvée");
        }
        visites.remove(identifiantVisite);
    }

    @Override
    public Visite obtenirVisite(String identifiantVisite) {
        return visites.get(identifiantVisite);
    }
}
