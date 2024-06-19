package com.example;
import java.util.Map;

public interface GestionnaireEnclos {
    void ajouterEnclos(Enclos enclos);
    void modifierEnclos(String identifiantEnclos, Map<String, Object> modifications);
    void supprimerEnclos(String identifiantEnclos);
    Enclos obtenirEnclos(String identifiantEnclos);
}
