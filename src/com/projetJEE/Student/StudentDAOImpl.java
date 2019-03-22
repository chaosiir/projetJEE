package com.projetJEE.Student;

import com.projetJEE.DBManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public List<Student> findAll() {
        return studentsFromQuery("select * from Student");
    }

    @Override
    public Student findByID(String ID) {
        List<Student> students = studentsFromQuery("select * from Student where ID_student=" + ID);
        return students.isEmpty() ? null : students.get(0);
    }

    @Override
    public void insert(Student student) {
        try {
            Connection con = DBManager.getInstance().getConnection();
            insert(student, con);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void insert(Student student, Connection con) throws SQLException {
        String query = " insert into Student values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
    }


/*
    private void delete(Student student)  {

        try {
            Connection con = DBManager.getInstance().getConnection();
            String query = " DELETE FROM Student where ID_student="+student.getID();
            Statement statement = con.createStatement();
            statement.executeQuery(query);

            System.out.println("Successfully deleted " + student);
            con.close();

        }catch (SQLException e){e.printStackTrace();}

    }*/

    @Override
    public void insertAll(Student[] students) {
        try {
            Connection con = DBManager.getInstance().getConnection();
            for(Student student : students)
                insert(student, con);
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

            students.add(new Student(
                    ID_student, gender, firstname, lastname, birthday,
                    bac, bacYear, bacGrade,
                    degree, degreeYear, degreeCity, registrationYear,
                    emailPro, emailPer)
            );
        }
        return students;
    }
}
