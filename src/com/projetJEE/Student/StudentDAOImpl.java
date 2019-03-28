package com.projetJEE.Student;

import com.projetJEE.DAOImpl;

import java.sql.*;
import java.util.Date;
import java.util.List;

public class StudentDAOImpl extends DAOImpl<Student> implements StudentDAO {

    @Override
    public List<Student> findAll() {
        String query = "select * from Student";
        return getEntriesFromQuery(query, preparedStatement -> {});
    }

    @Override
    public Student findByID(String ID) {
        String query = "select * from Student where ID_student=?";
        return getUniqueEntryFromQuery(query, preparedStatement -> {
           preparedStatement.setString(1, ID);
        });
    }

    @Override
    public void insert(Student student) {
        String query = " insert into Student values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        executeUpdateQuery(query,
                preparedStatement -> {
                    preparedStatement.setString(1, student.getID());
                    buildStudentStatement(student, preparedStatement, 1);
                },
                generatedKeys -> {
                    System.out.println("Successfully inserted " + student);
                });
    }

    @Override
    public void update(Student student) {
        String query = "update Student set " +
                "gender=?," +
                "firstname=?," +
                "lastname=?," +
                "birthday=?," +
                "bac=?," +
                "bacYear=?," +
                "bacGrade=?," +
                "degree=?," +
                "degreeYear=?," +
                "degreeCity=?," +
                "registrationYear=?," +
                "emailPro=?," +
                "emailPer=? " +
                "where ID_student=?";
        executeUpdateQuery(query, preparedStatement -> {
            buildStudentStatement(student, preparedStatement, 0);
            preparedStatement.setString(14, student.getID());
        });
    }

    @Override
    public void delete(Student student)  {
        String query = "delete from Student where ID_student=?";
        executeUpdateQuery(query, preparedStatement -> {
            preparedStatement.setString(1, student.getID());
        });
    }

    @Override
    public Student entryFromResultSet(ResultSet resultSet) throws SQLException {
        String ID_student = resultSet.getString("ID_student");
        String gender = resultSet.getString("gender");
        String firstname = resultSet.getString("firstname");
        String lastname = resultSet.getString("lastname");
        Date birthday = resultSet.getDate("birthday");
        String bac = resultSet.getString("bac");
        int bacYear = resultSet.getInt("bacYear");
        String bacGrade = resultSet.getString("bacGrade");
        String degree = resultSet.getString("degree");
        int degreeYear = resultSet.getInt("degreeYear");
        String degreeCity = resultSet.getString("degreeCity");
        int registrationYear = resultSet.getInt("registrationYear");
        String emailPro = resultSet.getString("emailPro");
        String emailPer = resultSet.getString("emailPer");

        return new Student(
                ID_student, gender, firstname, lastname, birthday,
                bac, bacYear, bacGrade,
                degree, degreeYear, degreeCity, registrationYear,
                emailPro, emailPer);
    }

    private void buildStudentStatement(Student student, PreparedStatement preparedStatement, int offset) throws SQLException{
        preparedStatement.setString(offset + 1, student.getGender());
        preparedStatement.setString(offset + 2, student.getFirstname());
        preparedStatement.setString(offset + 3, student.getLastname());
        preparedStatement.setDate(offset + 4, new java.sql.Date(student.getBirthday().getTime()));
        preparedStatement.setString(offset + 5, student.getBac());
        preparedStatement.setInt(offset + 6, student.getBacYear());
        preparedStatement.setString(offset + 7, student.getBacGrade());
        preparedStatement.setString(offset + 8, student.getDegree());
        preparedStatement.setInt(offset + 9, student.getDegreeYear());
        preparedStatement.setString(offset + 10, student.getDegreeCity());
        preparedStatement.setInt(offset + 11, student.getRegistrationYear());
        preparedStatement.setString(offset + 12, student.getEmailPro());
        preparedStatement.setString(offset + 13, student.getEmailPer());
    }
}
