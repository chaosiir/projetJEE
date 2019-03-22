package com.projetJEE.Group;

public class Group {

    private int ID_group;
    private String name;

    public Group(int ID_group, String name) {
        this.ID_group = ID_group;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Group{" +
                "ID_group=" + ID_group +
                ", name='" + name + '\'' +
                '}';
    }

    public int getID_group() {
        return ID_group;
    }

    public String getName() {
        return name;
    }
}
