package com.projetJEE.Group;

import com.projetJEE.Student.Student;
import com.projetJEE.User.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Group {

    private int ID;
    private String name;
    private User owner;
    private Date creationDate;
    private List<Student> students;
    private List<Group> children;

    public Group(String name, User owner) {
        this.ID = -1;
        this.name = name;
        this.owner = owner;
        this.students = null;
        this.creationDate = null;
        this.students = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) { this.owner = owner; }

    public Date getCreationDate() { return creationDate; }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setStudents(List<Student> students) { this.students = students; }

    public List<Group> getChildren() { return children; }

    public void setChildren(List<Group> children) { this.children = children; }

    @Override
    public String toString() {
        return "Group{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", creationDate=" + creationDate +
                '}';
    }

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.addAll(this.students);
        for (Group g : children)
            students.addAll(g.getStudents());
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void addGroup(Group group) {
        // TODO : protection contre les cycles d'inclusion
        children.add(group);
    }

    public void removeGroup(Group group) {
        children.remove(group);
    }
}
