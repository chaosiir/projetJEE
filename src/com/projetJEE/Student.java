package com.projetJEE;

import java.util.Date;

public class Student {

    private String ID;
    private String gender;

    private String firstname;
    private String lastname;
    private Date birthDate;

    private String bac;
    private int bacYear;
    private String grade;

    private String degree;
    private int degreeYear;
    private String degreeCity;
    private String registration;

    private String emailPro;
    private String emailPer;

    public Student(
            String ID, String gender, String firstname, String lastname, Date birthDate,
            String bac, int bacYear, String grade,
            String degree, int degreeYear, String degreeCity, String registration,
            String emailPro, String emailPer) {
        this.ID = ID;
        this.gender = gender;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDate = birthDate;
        this.bac = bac;
        this.bacYear = bacYear;
        this.grade = grade;
        this.degree = degree;
        this.degreeYear = degreeYear;
        this.degreeCity = degreeCity;
        this.registration = registration;
        this.emailPro = emailPro;
        this.emailPer = emailPer;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID='" + ID + '\'' +
                ", gender='" + gender + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthDate=" + birthDate +
                ", bac='" + bac + '\'' +
                ", bacYear=" + bacYear +
                ", grade='" + grade + '\'' +
                ", degree='" + degree + '\'' +
                ", degreeYear=" + degreeYear +
                ", degreeCity='" + degreeCity + '\'' +
                ", registration='" + registration + '\'' +
                ", emailPro='" + emailPro + '\'' +
                ", emailPer='" + emailPer + '\'' +
                '}';
    }

    public String getID() {
        return ID;
    }

    public String getGender() {
        return gender;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getBac() {
        return bac;
    }

    public int getBacYear() {
        return bacYear;
    }

    public String getGrade() {
        return grade;
    }

    public String getDegree() {
        return degree;
    }

    public int getDegreeYear() {
        return degreeYear;
    }

    public String getDegreeCity() {
        return degreeCity;
    }

    public String getRegistration() {
        return registration;
    }

    public String getEmailPro() {
        return emailPro;
    }

    public String getEmailPer() {
        return emailPer;
    }
}