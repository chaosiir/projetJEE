package com.projetJEE;

public class Student {

    private String numetudiant;
    private String S;

    private String nom;
    private String prenom;
    private String ddn;

    private String bac;
    private String anBac;
    private String menBac;

    private String diplome;
    private String anDiplome;
    private String villeDiplome;
    private String inscription;

    private String emailPro;
    private String emailPerso;

    @Override
    public String toString() {
        String str = "";
        str += numetudiant + " " + nom + " " + prenom;
        return str;
    }
}