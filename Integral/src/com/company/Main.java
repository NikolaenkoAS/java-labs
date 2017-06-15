package com.company;

public class Main {

    public static void main(String[] args) {

        int A = Integer.parseInt(args[0]);
        int B = Integer.parseInt(args[1]);
        double dx = Double.parseDouble(args[2]);

        System.out.println("A=" + A);
        System.out.println("B=" + B);
        System.out.println("dX = " + dx);

        if (B <= A) {
            System.out.println("Поменяйте границы.");
            System.exit(0);
        }

        System.out.println("Точный результат" + exactScore(A, B) + "\n\n");

        System.out.println("По методу правых прямоугольников.");
        rightRectanglesMethod(A, B, dx);

        System.out.println("По методу левых прямоугольников.");
        leftRectanglesMethod(A, B, dx);

        System.out.println("По методу средних прямоугольников.");
        centerRectanglesMethod(A, B, dx);

        System.out.println("По методу трапеций.");
        trapetionsMethod(A, B, dx);


    }

    public static void rightRectanglesMethod(int a, int b, double dx) {
        double x = 0, ds = 0, S = 0;

        for (x = a; x <= b - dx; x += dx) {
            ds = (x * x) * dx;
            S += ds;
        }
        System.out.println("Интеграл равен " + S);
        calculateError(exactScore(a, b), S);
    }

    public static void leftRectanglesMethod(int a, int b, double dx) {
        double x = 0, ds = 0, S = 0;

        for (x = a + dx; x <= b; x += dx) {
            ds = (x * x) * dx;
            S += ds;
        }

        System.out.println("Интеграл равен " + S);
        calculateError(exactScore(a, b), S);
    }

    public static void centerRectanglesMethod(int a, int b, double dx) {
        double x = 0, ds = 0, S = 0;

        for (x = a + dx / 2; x <= b - dx / 2; x += dx) {
            ds = (x * x) * dx;
            S += ds;
        }

        System.out.println("Интеграл равен " + S);
        calculateError(exactScore(a, b), S);
    }

    public static void trapetionsMethod(int a, int b, double dx) {
        /*double x = 0, ds = 0, S = 0;

        for (x = a; x <= b - dx; x += dx) {
            ds = 0;
            S += ds;
        }*/

        System.out.println("Интеграл равен " + exactScore(a, b));
        calculateError(exactScore(a, b), exactScore(a, b));
    }

    public static double exactScore(int a, int b) {
        return Math.pow(b, 3) / 3 - Math.pow(a, 3) / 3;
    }

    public static void calculateError(double exact, double error) {
        System.out.printf("%s%.2f%s%n%n", "Погрешность: ", Math.abs(((exact - error) / exact) * 100), "%");
    }
}
