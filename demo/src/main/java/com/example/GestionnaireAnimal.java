package com.example;
import java.util.Map;

public interface GestionnaireAnimal {
    void ajouterAnimal(Animal animal);
    void modifierAnimal(String identifiantAnimal, Map<String, Object> modifications);
    void supprimerAnimal(String identifiantAnimal);
    Animal obtenirAnimal(String identifiantAnimal);
}
