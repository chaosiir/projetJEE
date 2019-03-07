package com.projetJEE;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class StudentWS {

    private static String ws_uri = "https://stormy-lowlands-39083.herokuapp.com/etudiants/";

    private static GsonBuilder gsonBuilder = null;
    private static Gson gson = null;

    private static void createGson() {
        gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Student.class, new StudentDeserializer());
        gson = gsonBuilder.create();
    }

    public static Student[] getAllStudents() {
        if (gson == null)
            createGson();
        String json = WebServiceGetter.jsonGetRequest(ws_uri);
        Student[] students = gson.fromJson(json, Student[].class);
        return students;
    }

    /**
     * DONT USE THAT FUNCTION (WS IS BROKEN)
     */
    public static Student getStudentById(int id) {
        if (gson == null)
            createGson();
        String json = WebServiceGetter.jsonGetRequest(ws_uri + id);
        Student student = gson.fromJson(json, Student.class);
        return student;
    }
}
