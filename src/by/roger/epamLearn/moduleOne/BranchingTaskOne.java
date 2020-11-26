package by.roger.epamLearn.moduleOne;

import java.util.Scanner;

/*
 Даны два угла треугольника (в градусах). Определить, существует ли такой треугольник, и если да, то будет ли
он прямоугольным.
 */
public class BranchingTaskOne {
    public static void main(String[] args) {
        System.out.println("Программа определяет, существует ли треугольник с углами α и β.");
        Scanner in = new Scanner(System.in);
        double alpha;
        do {
            System.out.println("Введите α:");
            while (!in.hasNextDouble()) {
                System.out.println("Неправильный ввод!");
                in.next();
            }
            alpha = in.nextDouble();
        } while (alpha <= 0);
        double beta;
        do {
            System.out.println("Введите β:");
            while (!in.hasNextDouble()) {
                System.out.println("Неправильный ввод!");
                in.next();
            }
            beta = in.nextDouble();
        } while (beta <= 0);
        if (alpha > 0 && beta > 0) {
            double thirdAngle = 180 - alpha - beta;
            if (thirdAngle > 0 && thirdAngle < 180) {
                System.out.println("Треугольник с углами " + alpha + " и " + beta
                        + " существует.");
                if (alpha == 90 || beta == 90 || thirdAngle == 90) {
                    System.out.println("И к тому же он прямоугольный!");
                }
            } else System.out.println("Заданный треугольник не существует :(");
        } else {
            System.out.println("Заданный треугольник не существует :(");
        }
    }
}
