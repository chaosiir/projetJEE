package com.projetJEE.Student;

import com.projetJEE.DAOImpl;
import com.projetJEE.Group.Group;

import java.sql.*;
import java.util.Date;
import java.util.List;

public class StudentDAOImpl extends DAOImpl<Student> implements StudentDAO {

    @Override
    public boolean insert(Student student) {
        String query = " insert into Student values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return executeUniqueUpdateQuery(query,
                preparedStatement -> {
                    preparedStatement.setString(1, student.getID());
                    buildStudentStatement(student, preparedStatement, 1);
                },
                generatedKeys -> {
                    System.out.println("Successfully inserted " + student);
                });
    }

    @Override
    public List<Student> findAll() {
        String query = "select * from Student";
        return getEntriesFromQuery(query, preparedStatement -> {});
    }

    @Override
    public List<Student> findByGroup(Group group) {
        String query = "select * from IncludedStudent natural join Student where ID_group=?";
        return getEntriesFromQuery(query, preparedStatement -> {
            preparedStatement.setInt(1, group.getID());
        });
    }

    @Override
    public List<Student> findByGender(String gender) {
        String query = "select * from Student where gender=?";
        return getEntriesFromQuery(query, preparedStatement -> {
            preparedStatement.setString(1, gender);
        });
    }

    @Override
    public List<Student> findByFirstname(String firstname) {
        String query = "select * from Student where firstname=?";
        return getEntriesFromQuery(query, preparedStatement -> {
            preparedStatement.setString(1, firstname);
        });
    }

    @Override
    public List<Student> findByLastname(String lastname) {
        String query = "select * from Student where lastname=?";
        return getEntriesFromQuery(query, preparedStatement -> {
            preparedStatement.setString(1, lastname);
        });
    }

    @Override
    public List<Student> findByBac(String bac) {
        String query = "select * from Student where bac=?";
        return getEntriesFromQuery(query, preparedStatement -> {
            preparedStatement.setString(1, bac);
        });
    }

    @Override
    public List<Student> findByBacYear(int bacYear) {
        String query = "select * from Student where bacYear=?";
        return getEntriesFromQuery(query, preparedStatement -> {
            preparedStatement.setInt(1, bacYear);
        });
    }

    @Override
    public List<Student> findByBacGrade(String bacGrade) {
        String query = "select * from Student where bacGrade=?";
        return getEntriesFromQuery(query, preparedStatement -> {
            preparedStatement.setString(1, bacGrade);
        });
    }

    @Override
    public List<Student> findByDegree(String degree) {
        String query = "select * from Student where degree=?";
        return getEntriesFromQuery(query, preparedStatement -> {
            preparedStatement.setString(1, degree);
        });
    }

    @Override
    public List<Student> findByDegreeYear(int degreeYear) {
        String query = "select * from Student where degreeYear=?";
        return getEntriesFromQuery(query, preparedStatement -> {
            preparedStatement.setInt(1, degreeYear);
        });
    }

    @Override
    public List<Student> findByDegreeCity(String degreeCity) {
        String query = "select * from Student where degreeCity=?";
        return getEntriesFromQuery(query, preparedStatement -> {
            preparedStatement.setString(1, degreeCity);
        });
    }

    @Override
    public List<Student> findByRegistrationYear(int registrationYear) {
        String query = "select * from Student where registrationYear=?";
        return getEntriesFromQuery(query, preparedStatement -> {
            preparedStatement.setInt(1, registrationYear);
        });
    }

    @Override
    public List<Student> findByEmailPro(String emailPro) {
        String query = "select * from Student where emailPro=?";
        return getEntriesFromQuery(query, preparedStatement -> {
            preparedStatement.setString(1, emailPro);
        });
    }

    @Override
    public List<Student> findByEmailPer(String emailPer) {
        String query = "select * from Student where emailPro=?";
        return getEntriesFromQuery(query, preparedStatement -> {
            preparedStatement.setString(1, emailPer);
        });
    }

    public List<Student> findByExclusion(Group group) {
        String query = "select * from ExcludedStudent natural join Student where ID_group=?";
        return getEntriesFromQuery(query, preparedStatement -> {
            preparedStatement.setInt(1, group.getID());
        });
    }

    @Override
    public Student findByID(String ID) {
        String query = "select * from Student where ID_student=?";
        return getUniqueEntryFromQuery(query, preparedStatement -> {
           preparedStatement.setString(1, ID);
        });
    }

    @Override
    public boolean update(Student student) {
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
        boolean updated = executeUniqueUpdateQuery(query, preparedStatement -> {
            buildStudentStatement(student, preparedStatement, 0);
            preparedStatement.setString(14, student.getID());
        });
        if (updated) {
            System.out.println("Successfully updated " + student);
        }
        return updated;
    }

    @Override
    public boolean delete(Student student)  {
        String query = "delete from Student where ID_student=?";
        boolean deleted = executeUniqueUpdateQuery(query, preparedStatement -> {
            preparedStatement.setString(1, student.getID());
        });
        if (deleted) {
            System.out.println("Successfully deleted " + student);
        }
        return deleted;
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
