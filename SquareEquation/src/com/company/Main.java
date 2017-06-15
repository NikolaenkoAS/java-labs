package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a, b, c, d, x1, x2;

        System.out.println("Ведите числа a, b, c");
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        c = scanner.nextDouble();


        d = b * b - 4 * a * c;

        if (d < 0) {
            System.out.println("Корней нет.");
        } else if (d == 0) {
            x1 = b / 2 * a;
            System.out.println("Уравнение имеет один корень - " + x1);
        } else {
            d = Math.sqrt(d);

            x1 = ((-b - d) / 2 * a);
            x2 = ((-b + d) / 2 * a);

            System.out.println("x1=" + x1);
            System.out.println("x2=" + x2);
        }
    }
}
