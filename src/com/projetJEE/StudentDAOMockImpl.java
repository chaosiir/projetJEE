package com.projetJEE;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDAOMockImpl implements StudentDAO {
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
    public List<Student> findByID(String ID) {
        return new ArrayList<Student>();
    }

    @Override
    public void insert(Student student) { }

    @Override
    public void insertAll(Student[] students) { }
}
