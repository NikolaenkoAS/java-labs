package com.company;

public class Student {
    private String surname;
    private String name;
    private Integer group;
    private Integer ocenka;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String Surname) {
        this.surname = Surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer Group) {
        this.group = Group;
    }

    public Integer getOcenka() {
        return ocenka;
    }

    public void setOcenka(Integer ocenka) {
        this.ocenka = ocenka;
    }

    @Override
    public String toString() {
        return this.surname + " " + this.name + " " + this.ocenka;
    }

}
