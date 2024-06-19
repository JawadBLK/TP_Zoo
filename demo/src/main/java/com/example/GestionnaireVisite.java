package com.example;

import java.util.Map;

public interface GestionnaireVisite {
    void ajouterVisite(Visite visite);
    void modifierVisite(String identifiantVisite, Map<String, Object> modifications);
    void annulerVisite(String identifiantVisite);
    Visite obtenirVisite(String identifiantVisite);
}



