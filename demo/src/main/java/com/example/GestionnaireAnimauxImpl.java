package com.example;
import java.util.HashMap;
import java.util.Map;

public class GestionnaireAnimauxImpl implements GestionnaireAnimal {
    private Map<String, Animal> animaux;

    public GestionnaireAnimauxImpl() {
        this.animaux = new HashMap<>();
    }

    @Override
    public void ajouterAnimal(Animal animal) {
        if (animaux.containsKey(animal.getIdAnimal())) {
            throw new IllegalArgumentException("Identifiant d'animal déjà existant");
        }
        animaux.put(animal.getIdAnimal(), animal);
    }

    @Override
    public void modifierAnimal(String identifiantAnimal, Map<String, Object> modifications) {
        Animal animal = animaux.get(identifiantAnimal);
        if (animal == null) {
            throw new IllegalArgumentException("Animal non trouvé");
        }
        modifications.forEach((cle, valeur) -> {
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
                case "identifiantEnclos":
                    animal.setIdEnclos((String) valeur);
                    break;
            }
        });
    }

    @Override
    public void supprimerAnimal(String identifiantAnimal) {
        if (!animaux.containsKey(identifiantAnimal)) {
            throw new IllegalArgumentException("Animal non trouvé");
        }
        animaux.remove(identifiantAnimal);
    }

    @Override
    public Animal obtenirAnimal(String identifiantAnimal) {
        return animaux.get(identifiantAnimal);
    }
}
