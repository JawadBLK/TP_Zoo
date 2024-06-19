package com.example;
public class Animal {
    private String idAnimal;
    private String nom;
    private String espece;
    private int age;
    private String idEnclos;

    public void setIdAnimal(String idAnimal) {
        this.idAnimal = idAnimal;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIdEnclos(String idEnclos) {
        this.idEnclos = idEnclos;
    }

    public String getIdAnimal() {
        return idAnimal;
    }

    public String getNom() {
        return nom;
    }

    public String getEspece() {
        return espece;
    }

    public int getAge() {
        return age;
    }

    public String getIdEnclos() {
        return idEnclos;
    }

    public Animal(String idAnimal, String nom, String espece, int age, String idEnclos) {
        this.idAnimal = idAnimal;
        this.nom = nom;
        this.espece = espece;
        this.age = age;
        this.idEnclos = idEnclos;
    }

    // Getters et setters

    @Override
    public String toString() {
        return nom + " (" + espece + ") - Age: " + age + ", ID Enclos: " + idEnclos;
    }
}
