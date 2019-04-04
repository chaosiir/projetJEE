package com.projetJEE.Student;

import com.projetJEE.Group.Group;

import java.util.List;

public interface StudentDAO {
    boolean insert(Student student);
    List<Student> findAll();
    List<Student> findByGroup(Group group);
    List<Student> findByGender(String gender);
    List<Student> findByFirstname(String firstname);
    List<Student> findByLastname(String lastname);
    List<Student> findByBac(String bac);
    List<Student> findByBacYear(int bacYear);
    List<Student> findByBacGrade(String bacGrade);
    List<Student> findByDegree(String degree);
    List<Student> findByDegreeYear(int degreeYear);
    List<Student> findByDegreeCity(String degreeCity);
    List<Student> findByRegistrationYear(int registrationYear);
    Student findByID(String ID);
    boolean update(Student student);
    boolean delete(Student student);
}
