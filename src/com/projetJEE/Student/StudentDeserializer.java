package com.projetJEE.Student;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentDeserializer implements JsonDeserializer<Student> {

    private static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public Student deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jobject = jsonElement.getAsJsonObject();

        String ID = jobject.get("numetudiant").getAsString();
        String gender = jobject.get("S").getAsString();
        String firstname = jobject.get("nom").getAsString();
        String lastname = jobject.get("prenom").getAsString();
        Date birthday = null;
        try {
            birthday = dateFormat.parse(jobject.get("ddn").getAsString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String bac = jobject.get("bac").getAsString();
        int bacYear = jobject.get("anBac").getAsInt();
        String grade = jobject.get("menBac").getAsString();
        String degree = jobject.get("diplome").getAsString();
        int degreeYear = jobject.get("anDiplome").getAsInt();
        String degreeCity = jobject.get("villeDiplome").getAsString();
        int registrationYear = jobject.get("inscription").getAsInt();
        String emailPro = jobject.get("emailPro").getAsString();
        String emailPer = jobject.get("emailPerso").getAsString();

        return new Student(
                ID, gender, firstname, lastname, birthday,
                bac, bacYear, grade,
                degree, degreeYear, degreeCity, registrationYear,
                emailPro, emailPer);
    }
}
