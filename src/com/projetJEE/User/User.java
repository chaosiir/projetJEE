package com.projetJEE.User;

public class User {


    public enum Rights {
        USER,
        EDITOR,
        ADMIN
    }

    private int ID;
    private String login;
    private String pwdHash;
    private String question;
    private String answerHash;

    private Rights rights;

    public User(String login, String pwdHash, String question, String answerHash, Rights rights) {
        this.ID = -1;
        this.login = login;
        this.pwdHash = pwdHash;
        this.question = question;
        this.answerHash = answerHash;
        this.rights = rights;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwdHash() {
        return pwdHash;
    }

    public void setPwdHash(String pwdHash) {
        this.pwdHash = pwdHash;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerHash() {
        return answerHash;
    }

    public void setAnswerHash(String answerHash) {
        this.answerHash = answerHash;
    }

    public Rights getRights() {
        return rights;
    }
    public void   setRights(Rights rights) {
         this.rights=rights;
    }


    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", login='" + login + '\'' +
                ", pwdHash='" + pwdHash + '\'' +
                ", question='" + question + '\'' +
                ", answerHash='" + answerHash + '\'' +
                ", rights=" + rights +
                '}';
    }
}