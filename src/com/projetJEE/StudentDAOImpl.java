package com.projetJEE;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public List<Student> findAll() {
        return studentsFromQuery("select * from Students");
    }

    @Override
    public List<Student> findByID(String ID) {
        return studentsFromQuery("select * from Students where ID=" + ID);
    }

    @Override
    public void insert(Student student) {
        try {
            Connection con = DBManager.getInstance().getConnection();
            String query = " insert into Students values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, student.getID());
            preparedStatement.setString(2, student.getGender());
            preparedStatement.setString(3, student.getFirstname());
            preparedStatement.setString(4, student.getLastname());
            preparedStatement.setDate(5, new java.sql.Date(student.getBirthday().getTime()));
            preparedStatement.setString(6, student.getBac());
            preparedStatement.setInt(7, student.getBacYear());
            preparedStatement.setString(8, student.getBacGrade());
            preparedStatement.setString(9, student.getDegree());
            preparedStatement.setInt(10, student.getDegreeYear());
            preparedStatement.setString(11, student.getDegreeCity());
            preparedStatement.setInt(12, student.getRegistrationYear());
            preparedStatement.setString(13, student.getEmailPro());
            preparedStatement.setString(14, student.getEmailPer());

            preparedStatement.execute();
            System.out.println("Successfully inserted " + student);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<Student> studentsFromQuery(String query) {
        List<Student> students = new ArrayList<Student>();
        try {
            Connection con = DBManager.getInstance().getConnection();
            Statement sta = con.createStatement();
            ResultSet rs = sta.executeQuery(query);
            students = studentsFromResultSet(rs);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    private List<Student> studentsFromResultSet(ResultSet resultSet) throws SQLException {
        ArrayList<Student> students = new ArrayList<>();

        while(resultSet.next()) {
            String ID = resultSet.getString("ID");
            String gender = resultSet.getString("Gender");
            String firstname = resultSet.getString("FirstName");
            String lastname = resultSet.getString("LastName");
            Date birthday = resultSet.getDate("Birthday");
            String bac = resultSet.getString("Bac");
            int bacYear = resultSet.getInt("BacYear");
            String bacGrade = resultSet.getString("BacGrade");
            String degree = resultSet.getString("Degree");
            int degreeYear = resultSet.getInt("DegreeYear");
            String degreeCity = resultSet.getString("DegreeCity");
            int registrationYear = resultSet.getInt("RegistrationYear");
            String emailPro = resultSet.getString("EmailPro");
            String emailPer = resultSet.getString("EmailPer");

            students.add(new Student(
                    ID, gender, firstname, lastname, birthday,
                    bac, bacYear, bacGrade,
                    degree, degreeYear, degreeCity, registrationYear,
                    emailPro, emailPer)
            );
        }
        return students;
    }
}
