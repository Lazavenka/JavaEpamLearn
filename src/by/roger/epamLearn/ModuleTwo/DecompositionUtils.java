package by.roger.epamLearn.ModuleTwo;

import java.util.Scanner;

public class DecompositionUtils {
    public static int inputNumber(String comment, Scanner in){
        int number;
        do {
            System.out.println(comment);
            while (!in.hasNextInt()) {
                System.out.println("Не корректный ввод!");
                in.next();
            }
            number = in.nextInt();
        }while(number<=0);
        return number;
    }
    public static int inputPositiveNumberBound(String comment, int bound, Scanner in){
        int number;
        do {
            System.out.println(comment);
            while (!in.hasNextInt()) {
                System.out.println("Не корректный ввод!");
                in.next();
            }
            number = in.nextInt();
        }while(number<=0&&number>=bound);
        return number;
    }
    public static double inputNumberDouble(String comment, Scanner in){
        double number;
        do {
            System.out.println(comment);
            while (!in.hasNextDouble()) {
                System.out.println("Не корректный ввод!");
                in.next();
            }
            number = in.nextDouble();
        }while(number<=0);
        return number;
    }
    public static int inputNumberNeg(String comment, Scanner in){
        int number;
        System.out.println(comment);
        while (!in.hasNextInt()) {
            System.out.println("Не корректный ввод!");
            in.next();
        }
        number = in.nextInt();
        return number;
    }
}
