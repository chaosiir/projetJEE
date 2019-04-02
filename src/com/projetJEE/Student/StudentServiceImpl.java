package com.projetJEE.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private static StudentServiceImpl instance;

    /**
     * Returns the StudentServiceImpl singleton
     * @return StudentServiceImpl instance
     */
    public static StudentServiceImpl getInstance() {
        if (instance == null) {
            synchronized (StudentServiceImpl.class) {
                instance = new StudentServiceImpl();
            }
        }
        return instance;
    }

    private StudentDAO studentDAO = new StudentDAOImpl();

    /**
     * Inserts a student
     * @param student Student to insert
     * @pre The student should have a valid ID
     */
    @Override
    public void insertStudent(Student student) {
        studentDAO.insert(student);
    }

    /**
     * Returns all students
     * @return A list of students
     */
    @Override
    public List<Student> getAllStudents() { return studentDAO.findAll(); }

    /**
     * Returns a student by ID
     * @param ID Student's ID
     * @return The student with that ID or null if nonexistent
     */
    @Override
    public Student getStudentByID(String ID) {
        return studentDAO.findByID(ID);
    }

    /**
     * Updates a student
     * @param student The student to update
     */
    @Override
    public void updateStudent(Student student) { studentDAO.update(student); }

    /**
     * Deletes a student
     * @param student The student to delete
     */
    @Override
    public void deleteStudent(Student student) { studentDAO.delete(student); }
}
