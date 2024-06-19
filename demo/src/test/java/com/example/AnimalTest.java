package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AnimalTest {

    @Test
    public void testCreationAnimal() {
        Animal animal = new Animal("1", "Simba", "Lion", 5, "Enclos1");
        assertEquals("1", animal.getIdAnimal(), "L'identifiant de l'animal doit être '1'.");
        assertEquals("Simba", animal.getNom(), "Le nom de l'animal doit être 'Simba'.");
        assertEquals("Lion", animal.getEspece(), "L'espèce de l'animal doit être 'Lion'.");
        assertEquals(5, animal.getAge(), "L'âge de l'animal doit être 5.");
        assertEquals("Enclos1", animal.getIdEnclos(), "L'identifiant de l'enclos de l'animal devrait être 'Enclos1'.");
    }

    @Test
    public void testSetters() {
        Animal animal = new Animal("1", "Simba", "Lion", 5, "Enclos1");
        animal.setIdAnimal("2");
        animal.setNom("Nala");
        animal.setEspece("Tigresse");
        animal.setAge(3);
        animal.setIdEnclos("Enclos2");

        assertEquals("2", animal.getIdAnimal(), "L'identifiant de l'animal devrait être '2'.");
        assertEquals("Nala", animal.getNom(), "Le nom de l'animal devrait être 'Nala'.");
        assertEquals("Tigresse", animal.getEspece(), "L'espèce de l'animal devrait être 'Tigresse'.");
        assertEquals(3, animal.getAge(), "L'âge de l'animal devrait être 3.");
        assertEquals("Enclos2", animal.getIdEnclos(), "L'identifiant de l'enclos de l'animal devrait être 'Enclos2'.");
    }

    @Test
    public void testToString() {
        Animal animal = new Animal("1", "Simba", "Lion", 5, "Enclos1");
        String expectedString = "Simba (Lion) - Age: 5, ID Enclos: Enclos1";
        assertEquals(expectedString, animal.toString(), "La méthode toString ne retourne pas la chaîne attendue.");
    }
}