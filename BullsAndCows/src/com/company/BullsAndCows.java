package com.company;

import java.util.Random;
import java.util.Scanner;


public class BullsAndCows {
    public BullsAndCows() {
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] data = new int[4];
        int[] otvet = new int[4];
        Scanner scanner = new Scanner(System.in);

        int cows = 0, bulls = 0;
        int step = 0;
        String answer = "";
        shake(input);

        for (int i = 0; i < data.length; i++) {
            data[i] = input[i];
        }

        while (!answer.equals("y")) {
            step++;
            cows = 0;
            bulls = 0;
            int x = 0;
            for (int i = 0; i < otvet.length; i++) {
                do {
                    System.out.print("Enter " + (i + 1) + " number (0 - 9): ");
                    x = scanner.nextInt();
                } while (x > 9 || x < 1);

                otvet[i] = x;
            }

            for (int i = 0; i < otvet.length; i++) {
                for (int j = 0; j < data.length; j++) {
                    if (otvet[i] == data[j] && i == j) {
                        bulls++;
                        break;
                    }

                    if (otvet[i] == data[j] && i != j) {
                        cows++;
                        break;
                    }
                }

            }

            System.out.println("Try " + step);
            System.out.println("Bulls : " + bulls);
            if (cows > 0) {
                System.out.println("Cows : " + bulls);
            }

            if (bulls == 4) {
                System.out.println("Win");
                break;
            }

            System.out.print("Give up (y/n):");
            answer = scanner.next();
        }
    }

    public void shake(int[] a) {
        Random rand = new Random();
        int j, temp;
        for (int i = 1; i < a.length; i++) {
            j = rand.nextInt(i);
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
}
