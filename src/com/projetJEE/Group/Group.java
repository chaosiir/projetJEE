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
    private List<Student> exclusions;

    public Group(String name, User owner) {
        this.ID = -1;
        this.name = name;
        this.owner = owner;
        this.students = null;
        this.creationDate = null;
        this.students = new ArrayList<>();
        this.children = new ArrayList<>();
        this.exclusions = new ArrayList<>();
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

    public List<Student> getExclusions() { return exclusions; }

    public void setExclusions(List<Student> exclusions) { this.exclusions = exclusions; }

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
            for (Student s : g.getStudents()) {
//                boolean is_excluded = false;
//                for (Student excluded : exclusions) {
//                    if (s.getID().equals(excluded.getID())) {
//                        is_excluded = true;
//                        break;
//                    }
//                }
//                if (!is_excluded) // !excluded.contains(s)
//                    students.add(s);
                if (!exclusions.contains(s))
                    students.add(s);
            }
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

    public void excludeStudent(Student student) { exclusions.add(student); }

    @Override
    public boolean equals(Object obj) {
        return ((Group)obj).getID() == this.getID();
    }
}
