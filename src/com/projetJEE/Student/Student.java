package com.projetJEE.Student;

import java.util.Date;

public class Student {

    private String ID;
    private String gender;

    private String firstname;
    private String lastname;
    private Date birthday;

    private String bac;
    private int bacYear;
    private String bacGrade;

    private String degree;
    private int degreeYear;
    private String degreeCity;
    private int registrationYear;

    private String emailPro;
    private String emailPer;

    public Student(
            String ID, String gender, String firstname, String lastname, Date birthday,
            String bac, int bacYear, String bacGrade,
            String degree, int degreeYear, String degreeCity, int registrationYear,
            String emailPro, String emailPer) {
        this.ID = ID;
        this.gender = gender;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.bac = bac;
        this.bacYear = bacYear;
        this.bacGrade = bacGrade;
        this.degree = degree;
        this.degreeYear = degreeYear;
        this.degreeCity = degreeCity;
        this.registrationYear = registrationYear;
        this.emailPro = emailPro;
        this.emailPer = emailPer;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID='" + ID + '\'' +
                ", gender='" + gender + '\'' +
                ", firstname='" +  + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthday=" + birthday +
                ", bac='" + bac + '\'' +
                ", bacYear=" + bacYear +
                ", bacGrade='" + bacGrade + '\'' +
                ", degree='" + degree + '\'' +
                ", degreeYear=" + degreeYear +
                ", degreeCity='" + degreeCity + '\'' +
                ", registrationYear='" + registrationYear + '\'' +
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

    public Date getBirthday() {
        return birthday;
    }

    public String getBac() {
        return bac;
    }

    public int getBacYear() {
        return bacYear;
    }

    public String getBacGrade() {
        return bacGrade;
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

    public int getRegistrationYear() {
        return registrationYear;
    }

    public String getEmailPro() {
        return emailPro;
    }

    public String getEmailPer() {
        return emailPer;
    }
}