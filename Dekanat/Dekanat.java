/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dekanat;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author ambrosiy
 */
public class Dekanat {
   Student st;
   Vedomost ved;
    HashSet setStud = new HashSet();
    HashSet setVed = new HashSet();

    Dekanat() {
        super();
     
        for (int i=1; i<3;i++) {
            ZapolnitVedomost("Java", st);
            InsertNewStudent();
            
        }
        
        Iterator iterator = setVed.iterator();
        while ( iterator.hasNext()) {
            Vedomost element = (Vedomost) iterator.next();
            System.out.println(element.getStudent()+"  "+element.getOcenka());
        }
        
        
    }

    public static void main(String[] args) {
        Dekanat dk = new Dekanat();

    }

    public void InsertNewStudent() {
         st = new Student();
        System.out.println("Введите фамилию");
        Scanner scanner = new Scanner(System.in);
        String fam = scanner.next();
        st.setSurname(fam);

        System.out.println("Введите Имя");

        String name = scanner.next();
        st.setName(name);

        System.out.println("Введите курс");

        String kurs = scanner.next();
        st.setGroup(kurs);

        System.out.println("Введите группу");

        String group = scanner.next();
        st.setGroup(group);
        
        System.out.println("Введите оценку");
        ved.setOcenka(scanner.nextInt());
        setStud.add(st);
        setVed.add(ved);
    }

    public void ZapolnitVedomost (String predmet,Student stud) {
        Vedomost ved = new Vedomost();
        
        Scanner scanner= new Scanner(System.in);
        System.out.println("Введите дисциплину");
        ved.setDisciplina(predmet);
        ved.setStudent(stud);
        
        setVed.add(ved);
        
    }
}
