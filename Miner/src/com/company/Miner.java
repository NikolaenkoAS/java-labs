package com.company;

import java.util.Scanner;

public class Miner {
    private int count;
    private int num_mines;
    private final int n = 10, m = 10;

    String[][] field = new String[n + 2][m + 2];
    String[][] field1 = new String[n + 1][m + 1];

    public Miner() {
        boolean finish = false;
        Scanner scanner = new Scanner(System.in);
        boolean retry = true;


        while (retry) {
            System.out.println("Enter number of mines: ");
            num_mines = scanner.nextInt();
            int numMines = num_mines;
            count = 0;
            prepare();

            while (!finish) {
                System.out.println("Enter row n and column m number");
                int N = scanner.nextInt();
                int M = scanner.nextInt();
                int rez = readCell(N, M);
                if (rez == 1) {
                    System.out.println("You lose.");
                    printFull();
                    break;
                }

                if (count == numMines) {
                    finish = true;
                    System.out.println("You Win.");
                }
                printField();
                count++;
            }
            System.out.println("Play again(y, n): ");

            retry = scanner.next().equals("y");
        }
    }

    public void prepare() {
        int nMine, mMine;

        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < m + 2; j++) {
                field[i][j] = "0";
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                field1[i][j] = "?";
            }
        }

        while (num_mines > 0) {
            nMine = 1 + (int) (Math.random() * 10);
            mMine = 1 + (int) (Math.random() * 10);

            if (field[nMine][mMine].equals("M")) {
                continue;
            } else {
                field[nMine][mMine] = "M";
                num_mines--;
            }
        }

    }


    public void printField() {
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++)
                System.out.print(field1[i][j] + " ");
            System.out.println();
        }
    }

    public void printFull() {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }

    }

    public int readCell(int N, int M) {

        if (field[N][M].equals("M")) {
            field1[N][M] = "M";
            return 1;
        } else {
            int mine_counter = 0;
            if (field[N][M - 1].equals("M")) {
                mine_counter++;
            }
            if (field[N][M + 1].equals("M")) {
                mine_counter++;
            }
            if (field[N - 1][M].equals("M")) {
                mine_counter++;
            }
            if (field[N + 1][M].equals("M")) {
                mine_counter++;
            }
            if (field[N - 1][M - 1].equals("M")) {
                mine_counter++;
            }
            if (field[N - 1][M + 1].equals("M")) {
                mine_counter++;
            }
            if (field[N + 1][M - 1].equals("M")) {
                mine_counter++;
            }
            if (field[N + 1][M + 1].equals("M")) {
                mine_counter++;
            }
            field1[N][M] = Integer.toString(mine_counter);
            return 0;
        }

    }

}
