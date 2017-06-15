package com.company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Dekanat {
    private Student st;
    private Vedomost ved;
    private HashSet setVed = new HashSet();

    Dekanat() {
        super();
        String answer = "";
        Scanner scanner = new Scanner(System.in);

        while (!answer.equals("n")) {
            ZapolnitVedomost();
            System.out.print("заполнить еще одну ведомость(y, n):");
            answer = scanner.next();
            System.out.println("\n");
        }

        Vedomost element;

        Iterator iterator = setVed.iterator();
        while (iterator.hasNext()){
            element = (Vedomost)iterator.next();
            System.out.println("Ведомость по предмету " + element.getDisciplina());
            element.listStudents();
            element.printStudsAverages();
            System.out.println("\n");
        }
    }

    public void ZapolnitVedomost() {
        String predmet = "";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите дисциплину");
        predmet = scanner.next();
        Vedomost ved = new Vedomost(predmet);

        System.out.println("Введите курс: ");
        ved.setCourse(scanner.nextInt());

        System.out.println("Введите количество студентов: ");
        int studCount = scanner.nextInt();

        for (int i = 1; i <= studCount; i++) {
            ved.InsertNewStudent();
        }

        setVed.add(ved);
    }
}
