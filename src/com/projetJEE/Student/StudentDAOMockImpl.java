package com.projetJEE.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDAOMockImpl implements StudentDAO {

    @Override
    public void insert(Student student) { }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<Student>();
        students.add(
                new Student("id0", "gender", "firstname", "lastname", new Date(),
                        "bac", 2000, "grade",
                        "degree", 2000, "degreeCity", 2000,
                        "emailPro", "emailPer")
        );
        return students;
    }

    @Override
    public Student findByID(String ID) {
        return new Student(ID, "gender", "firstname", "lastname", new Date(),
                "bac", 2000, "grade",
                "degree", 2000, "degreeCity", 2000,
                "emailPro", "emailPer");
    }

    @Override
    public void update(Student student) { }

    @Override
    public void delete(Student student) { }
}
