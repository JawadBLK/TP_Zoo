package com.example;
import java.util.HashMap;
import java.util.Map;


public class GestionnaireAnimal {
    private Map<String, Animal> animaux;

    public GestionnaireAnimal() {
        animaux = new HashMap<>();
    }

    public void ajouterAnimal(Animal animal) {
        if (animaux.containsKey(animal.getIdAnimal())) {
            throw new IllegalArgumentException("L'ID de l'animal existe déjà");
        }
        animaux.put(animal.getIdAnimal(), animal);
    }

    public void mettreAJourAnimal(String idAnimal, Map<String, Object> misesAJour) {
        Animal animal = animaux.get(idAnimal);
        if (animal == null) {
            throw new IllegalArgumentException("Animal non trouvé");
        }
        misesAJour.forEach((cle, valeur) -> {
            switch (cle) {
                case "nom":
                    animal.setNom((String) valeur);
                    break;
                case "espece":
                    animal.setEspece((String) valeur);
                    break;
                case "age":
                    animal.setAge((int) valeur);
                    break;
                case "idEnclos":
                    animal.setIdEnclos((String) valeur);
                    break;
            }
        });
    }

    public void supprimerAnimal(String idAnimal) {
        if (!animaux.containsKey(idAnimal)) {
            throw new IllegalArgumentException("Animal non trouvé");
        }
        animaux.remove(idAnimal);
    }

    public Animal obtenirAnimal(String idAnimal) {
        return animaux.get(idAnimal);
    }

    // Autres méthodes comme obtenir tous les animaux, etc.
}