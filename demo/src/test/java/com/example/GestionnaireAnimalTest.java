package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class GestionnaireAnimalTest {

    private GestionnaireAnimauxImpl gestionnaireAnimaux;

    @BeforeEach
    public void setUp() {
        gestionnaireAnimaux = new GestionnaireAnimauxImpl();
    }

    @Test
    public void testAjouterAnimal() {
        Animal animal = new Animal("1", "Lion", "Panthera leo", 5, "Enclos1");
        gestionnaireAnimaux.ajouterAnimal(animal);
        assertEquals(animal, gestionnaireAnimaux.obtenirAnimal("1"), "L'animal devrait être ajouté correctement.");
    }

    @Test
    public void testAjouterAnimalAvecIdDuplique() {
        Animal animal1 = new Animal("1", "Lion", "Panthera leo", 5, "Enclos1");
        Animal animal2 = new Animal("1", "Tigre", "Panthera tigris", 4, "Enclos2");
        gestionnaireAnimaux.ajouterAnimal(animal1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            gestionnaireAnimaux.ajouterAnimal(animal2);
        });
        assertEquals("Identifiant d'animal déjà existant", exception.getMessage());
    }

    @Test
    public void testModifierAnimal() {
        Animal animal = new Animal("1", "Lion", "Panthera leo", 5, "Enclos1");
        gestionnaireAnimaux.ajouterAnimal(animal);

        Map<String, Object> modifications = new HashMap<>();
        modifications.put("nom", "Tigre");
        modifications.put("espece", "Panthera tigris");
        modifications.put("age", 4);
        modifications.put("identifiantEnclos", "Enclos2");

        gestionnaireAnimaux.modifierAnimal("1", modifications);

        Animal animalModifie = gestionnaireAnimaux.obtenirAnimal("1");
        assertEquals("Tigre", animalModifie.getNom(), "Le nom devrait être modifié.");
        assertEquals("Panthera tigris", animalModifie.getEspece(), "L'espèce devrait être modifiée.");
        assertEquals(4, animalModifie.getAge(), "L'âge devrait être modifié.");
        assertEquals("Enclos2", animalModifie.getIdEnclos(), "L'identifiant de l'enclos devrait être modifié.");
    }

    @Test
    public void testSupprimerAnimal() {
        Animal animal = new Animal("1", "Lion", "Panthera leo", 5, "Enclos1");
        gestionnaireAnimaux.ajouterAnimal(animal);
        gestionnaireAnimaux.supprimerAnimal("1");
        assertNull(gestionnaireAnimaux.obtenirAnimal("1"), "L'animal devrait être supprimé.");
    }

    @Test
    public void testObtenirAnimal() {
        Animal animal = new Animal("1", "Lion", "Panthera leo", 5, "Enclos1");
        gestionnaireAnimaux.ajouterAnimal(animal);
        assertEquals(animal, gestionnaireAnimaux.obtenirAnimal("1"), "L'animal obtenu devrait correspondre à celui ajouté.");
    }
}
