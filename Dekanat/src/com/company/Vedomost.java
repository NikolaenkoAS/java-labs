package com.company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Vedomost {

    private String disciplina;
    private HashSet setStud = new HashSet();
    private Integer course;

    public Vedomost(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public int getCourse(){
        return course;
    }

    public void setCourse(int value){
        this.course = value;
    }

    public void InsertNewStudent() {
        Student student = new Student();
        student = new Student();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите фамилию");
        student.setSurname(scanner.next());

        System.out.println("Введите Имя");
        student.setName(scanner.next());

        System.out.println("Введите группу");
        student.setGroup(scanner.nextInt());

        System.out.println("Введите оценку");
        student.setOcenka(scanner.nextInt());

        setStud.add(student);
    }

    public void listStudents(){
        Student element;
        Iterator iterator = setStud.iterator();

        while(iterator.hasNext()){
            element = (Student)iterator.next();
            System.out.println(element.toString());
        }
    }

    public void printStudsAverages(){
        Student student;
        Iterator iterator = setStud.iterator();
        int[] groups = new int[5];

        while (iterator.hasNext()){
            student = (Student)iterator.next();

            if(student.getOcenka() < 74){
                groups[student.getGroup()]++;
            }
        }

        for (int i = 1; i < groups.length; i++){
            if(groups[i] != 0)
            System.out.println("В группе " + i + " " + groups[i] + " двоешников.");
        }
    }

}
