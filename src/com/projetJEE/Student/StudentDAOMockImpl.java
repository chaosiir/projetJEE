package com.projetJEE.Student;

import com.projetJEE.Group.Group;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDAOMockImpl implements StudentDAO {

    @Override
    public boolean insert(Student student) { return false; }

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
    public List<Student> findByGroup(Group group) { return null; }

    @Override
    public Student findByID(String ID) {
        return new Student(ID, "gender", "firstname", "lastname", new Date(),
                "bac", 2000, "grade",
                "degree", 2000, "degreeCity", 2000,
                "emailPro", "emailPer");
    }

    @Override
    public boolean update(Student student) { return false; }

    @Override
    public boolean delete(Student student) { return false; }
}
