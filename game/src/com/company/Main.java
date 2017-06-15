package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String answer = new String();
        byte playerChoice = 0;
        byte compChoice = 0;
        int playerWons = 0;
        int compWons = 0;

        do {
            System.out.println("Начать игру (y, n): ");
            answer = scanner.next();
            if (answer.equals("n")) {
                break;
            }
            do {
                System.out.println("Введите выбор (1 - камень, 2 - ножницы, 3 - бумага): ");
                playerChoice = scanner.nextByte();
            } while (playerChoice > 3 || playerChoice < 0);

            compChoice = (byte) (1 + (Math.random() * 3));
            System.out.println("выбор компьютера: " + compChoice);

            boolean wonStatus = false;

            if (playerChoice == compChoice) {
                System.out.println("Ничья ");
                playerWons++;
                compWons++;
                continue;
            }

            switch (compChoice) {
                case 1:
                    wonStatus = playerChoice == 3;
                    break;
                case 2:
                    wonStatus = playerChoice == 1;
                    break;
                case 3:
                    wonStatus = playerChoice == 2;
                    break;
            }

            if (wonStatus) {
                System.out.println("Вы победили !");
                playerWons++;
            } else {
                System.out.println("Вы проиграли !");
                compWons++;
            }
            System.out.println("Вы " + playerWons + " : компьютер " + compWons);

        } while (!answer.equals("n"));
    }
}
