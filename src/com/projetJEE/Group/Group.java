package com.projetJEE.Group;

import com.projetJEE.User.User;

import java.util.Date;

public class Group {

    private int ID;
    private String name;
    private User owner;

    private Date creationDate;

    public Group(String name, User owner) {
        this.ID = -1;
        this.name = name;
        this.owner = owner;
        this.creationDate = null;
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

    public User getOwner() {
        return owner;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Group{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", creationDate=" + creationDate +
                '}';
    }
}
