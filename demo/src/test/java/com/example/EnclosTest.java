package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class EnclosTest {

    @Test
    public void testCreationEnclos() {
        List<String> especesPermises = Arrays.asList("Lion", "Tigre");
        Enclos enclos = new Enclos("1", "Enclos Grands Félins", "Grande", especesPermises);

        assertEquals("1", enclos.getIdEnclos(), "L'identifiant de l'enclos devrait être '1'.");
        assertEquals("Enclos Grands Félins", enclos.getNom(), "Le nom de l'enclos doit être 'Enclos Grands Félins'.");
        assertEquals("Grande", enclos.getTaille(), "La taille de l'enclos doit être 'Grande'.");
        assertEquals(especesPermises, enclos.getEspecesPermises(), "Les espèces permises devraient être 'Lion' et 'Tigre'.");
    }

    @Test
    public void testSetters() {
        List<String> especesPermises = Arrays.asList("Lion", "Tigre");
        Enclos enclos = new Enclos("1", "Enclos Grands Félins", "Grande", especesPermises);

        enclos.setIdEnclos("2");
        enclos.setNom("Enclos Petits Félins");
        enclos.setTaille("Petite");
        List<String> nouvellesEspecesPermises = Arrays.asList("Léopard", "Guépard");
        enclos.setEspecesPermises(nouvellesEspecesPermises);

        assertEquals("2", enclos.getIdEnclos(), "L'identifiant de l'enclos devrait être '2'.");
        assertEquals("Enclos Petits Félins", enclos.getNom(), "Le nom de l'enclos devrait être 'Enclos Petits Félins'.");
        assertEquals("Petite", enclos.getTaille(), "La taille de l'enclos devrait être 'Petite'.");
        assertEquals(nouvellesEspecesPermises, enclos.getEspecesPermises(), "Les nouvelles espèces permises devraient être 'Léopard' et 'Guépard'.");
    }

    @Test
    public void testToString() {
        List<String> especesPermises = Arrays.asList("Lion", "Tigre");
        Enclos enclos = new Enclos("1", "Enclos Grands Félins", "Grande", especesPermises);
        String expectedString = "Enclos Grands Félins - Taille: Grande, Espèces permises: [Lion, Tigre]";
        assertEquals(expectedString, enclos.toString(), "La méthode toString ne retourne pas la chaîne attendue.");
    }
}
