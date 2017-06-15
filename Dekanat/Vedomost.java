/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dekanat;

import java.util.Date;

/**
 *
 * @author ambrosiy
 */
public class Vedomost {
     
    private Date date;    
    private String disciplina;   
    private Student student;     
    private Integer ocenka;

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the disciplina
     */
    public String getDisciplina() {
        return disciplina;
    }

    /**
     * @param disciplina the disciplina to set
     */
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * @return the ocenka
     */
    public Integer getOcenka() {
        return ocenka;
    }

    /**
     * @param ocenka the ocenka to set
     */
    public void setOcenka(Integer ocenka) {
        this.ocenka = ocenka;
    }
    } 

