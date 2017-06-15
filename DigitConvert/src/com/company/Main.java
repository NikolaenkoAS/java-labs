package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите число");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println("В римской записи ему соответсвует число - " + convert(x));
    }


    public static String convert(int x) {
        StringBuffer convert = new StringBuffer();
        int thousands = 0;
        boolean f = false;
        if (x < 1) {
            System.out.println("Число не может быть отрицательным.");
            System.exit(0);
        }
        if (x >= 4000) {
            f = x % 1000 == 0;
            thousands = (x - (x % 1000)) / 1000;

            convert.append(convert(thousands).concat(" "));
            if (f) convert.append("M");

            x -= thousands * 1000;
        }
        while (x >= 1000) {
            convert.append("M");
            x = x - 1000;
        }
        if (x >= 900) {
            convert.append("CM");
            x = x - 900;
        }
        if (x >= 500) {
            convert.append("D");
            x = x - 500;
        }
        if (x >= 400) {
            convert.append("CD");
            x = x - 400;
        }
        while (x >= 100) {
            convert.append("C");
            x = x - 100;
        }
        if (x >= 90) {
            convert.append("XC");
            x = x - 90;
        }
        if (x >= 50) {
            convert.append("L");
            x = x - 50;
        }
        if (x >= 40) {
            convert.append("XL");
            x = x - 40;
        }
        while (x >= 10) {
            convert.append("X");
            x = x - 10;
        }
        if (x == 9) {
            convert.append("IX");
            x = x - 9;
        }
        if (x >= 5) {
            convert.append("V");
            x = x - 5;
        }
        if (x == 4) {
            convert.append("IV");
            x = x - 4;
        }
        while (x >= 1) {
            convert.append("I");
            x = x - 1;
        }

        return convert.toString();
    }
}
