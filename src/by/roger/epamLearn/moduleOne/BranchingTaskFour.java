package by.roger.epamLearn.moduleOne;

import java.util.Scanner;

/*
Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича. Определить, пройдет ли кирпич через
отверстие.
 */
public class BranchingTaskFour {
    public static void main(String[] args) {
        System.out.println("Программа определяет, пройдет ли кирпич с размерами х, у, z через отверстие размеров А, В.");
        Scanner in = new Scanner(System.in);
        double x;
        System.out.println("Введите длину кирпича x:");
        while (!in.hasNextDouble()) {
            System.out.println("Неправильный ввод! Введите число формата ххх,ххх!");
            in.next();
        }
        x = in.nextDouble();
        double y;
        System.out.println("Введите ширину кирпича y:");
        while (!in.hasNextDouble()) {
            System.out.println("Неправильный ввод! Введите число формата ххх,ххх!");
            in.next();
        }
        y = in.nextDouble();
        double z;
        System.out.println("Введите высоту кирпича z:");
        while (!in.hasNextDouble()) {
            System.out.println("Неправильный ввод! Введите число формата ххх,ххх!");
            in.next();
        }
        z = in.nextDouble();
        double a;
        System.out.println("Введите ширину отверстия A:");
        while (!in.hasNextDouble()) {
            System.out.println("Неправильный ввод! Введите число формата ххх,ххх!");
            in.next();
        }
        a = in.nextDouble();
        double b;
        System.out.println("Введите высоту отверстия B:");
        while (!in.hasNextDouble()) {
            System.out.println("Неправильный ввод! Введите число формата ххх,ххх!");
            in.next();
        }
        b = in.nextDouble();
        boolean answer;
        if (a>=x) {
            if (b >= y || b >= z) {
                answer = true;
            } else answer = false;
        }else if (a>=y) {
            if (b >= x || b >= z) {
                answer = true;
            } else answer = false;
        } else if (a >= z) {
            if (b >= x || b >= y) {
                answer = true;
            } else answer = false;
        }else answer = false;
        if (answer){
            System.out.println("Кирпич прошел через отверстие!");
        } else{
            System.out.println("Кирпич не прошел через отверстие. :(");
        }

    }
}
