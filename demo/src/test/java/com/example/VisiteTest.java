package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VisiteTest {

    private GestionnaireVisitesImpl gestionnaireVisites;

    @BeforeEach
    public void setUp() {
        gestionnaireVisites = new GestionnaireVisitesImpl();
    }

    @Test
    public void testAjouterVisite() {
        Visite visite = new Visite("1", LocalDateTime.now(), LocalDateTime.now().plusHours(2), Arrays.asList("Enclos1", "Enclos2"));
        gestionnaireVisites.ajouterVisite(visite);
        assertEquals(visite, gestionnaireVisites.obtenirVisite("1"), "La visite devrait être ajoutée correctement.");
    }

    @Test
    public void testAjouterVisiteAvecIdDuplique() {
        Visite visite1 = new Visite("1", LocalDateTime.now(), LocalDateTime.now().plusHours(2), Arrays.asList("Enclos1", "Enclos2"));
        Visite visite2 = new Visite("1", LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(1).plusHours(2), Arrays.asList("Enclos3", "Enclos4"));
        gestionnaireVisites.ajouterVisite(visite1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            gestionnaireVisites.ajouterVisite(visite2);
        });
        assertEquals("Identifiant de visite déjà existant", exception.getMessage());
    }

    @Test
    public void testAjouterVisiteAvecTropEnclos() {
        List<String> enclos = Arrays.asList("Enclos1", "Enclos2", "Enclos3", "Enclos4", "Enclos5", "Enclos6");
        Visite visite = new Visite("1", LocalDateTime.now(), LocalDateTime.now().plusHours(2), enclos);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            gestionnaireVisites.ajouterVisite(visite);
        });
        assertEquals("Une visite ne peut inclure plus de 5 enclos", exception.getMessage());
    }

    @Test
    public void testModifierVisite() {
        Visite visite = new Visite("1", LocalDateTime.now(), LocalDateTime.now().plusHours(2), Arrays.asList("Enclos1", "Enclos2"));
        gestionnaireVisites.ajouterVisite(visite);

        LocalDateTime nouvelleHeureDebut = LocalDateTime.now().plusHours(1);
        LocalDateTime nouvelleHeureFin = LocalDateTime.now().plusHours(3);
        List<String> nouveauxEnclos = Arrays.asList("Enclos3", "Enclos4");

        Map<String, Object> modifications = new HashMap<>();
        modifications.put("heureDebut", nouvelleHeureDebut);
        modifications.put("heureFin", nouvelleHeureFin);
        modifications.put("enclosVisites", nouveauxEnclos);

        gestionnaireVisites.modifierVisite("1", modifications);

        Visite visiteModifiee = gestionnaireVisites.obtenirVisite("1");
        assertEquals(nouvelleHeureDebut, visiteModifiee.getHeureDebut(), "L'heure de début devrait être modifiée.");
        assertEquals(nouvelleHeureFin, visiteModifiee.getHeureFin(), "L'heure de fin devrait être modifiée.");
        assertEquals(nouveauxEnclos, visiteModifiee.getEnclosVisites(), "Les enclos visités devraient être modifiés.");
    }

    @Test
    public void testAnnulerVisite() {
        Visite visite = new Visite("1", LocalDateTime.now(), LocalDateTime.now().plusHours(2), Arrays.asList("Enclos1", "Enclos2"));
        gestionnaireVisites.ajouterVisite(visite);
        gestionnaireVisites.annulerVisite("1");
        assertNull(gestionnaireVisites.obtenirVisite("1"), "La visite devrait être annulée.");
    }

    @Test
    public void testObtenirVisite() {
        Visite visite = new Visite("1", LocalDateTime.now(), LocalDateTime.now().plusHours(2), Arrays.asList("Enclos1", "Enclos2"));
        gestionnaireVisites.ajouterVisite(visite);
        assertEquals(visite, gestionnaireVisites.obtenirVisite("1"), "La visite obtenue devrait correspondre à celle ajoutée.");
    }
}
