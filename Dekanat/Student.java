/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dekanat;

/**
 *
 * @author ambrosiy
 */
public class Student {
   private String Family ;
    private String Name;
    private Integer Kurs;
    private String Group;

    /**
     * @return the Surname
     */
    public String getSurname() {
        return Family;
    }

    /**
     * @param Surname the Surname to set
     */
    public void setSurname(String Surname) {
        this.Family = Surname;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Kurs
     */
    public Integer getKurs() {
        return Kurs;
    }

    /**
     * @param Kurs the Kurs to set
     */
    public void setKurs(Integer Kurs) {
        this.Kurs = Kurs;
    }

    /**
     * @return the Group
     */
    public String getGroup() {
        return Group;
    }

    /**
     * @param Group the Group to set
     */
    public void setGroup(String Group) {
        this.Group = Group;
    }
    
    @Override 
    public String toString() {
    return this.Family+" "+this.Name;}
    
}
