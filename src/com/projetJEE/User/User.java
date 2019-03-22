package com.projetJEE.User;

public class User {
    private int ID_user;
    private String login;
    private String pwdHash;
    private String question;
    private String answerHash;

    public User(int ID_user, String login, String pwdHash, String question, String answerHash) {
        this.ID_user = ID_user;
        this.login = login;
        this.pwdHash = pwdHash;
        this.question = question;
        this.answerHash = answerHash;
    }

    public int getID_user() {
        return ID_user;
    }

    public void setID_user(int ID_user) {
        this.ID_user = ID_user;
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

    @Override
    public String toString() {
        return "User{" +
                "ID_user=" + ID_user +
                ", login='" + login + '\'' +
                ", pwdHash='" + pwdHash + '\'' +
                ", question='" + question + '\'' +
                ", answerHash='" + answerHash + '\'' +
                '}';
    }
}