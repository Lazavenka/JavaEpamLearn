package by.roger.epamLearn.moduleOne;

import java.util.Scanner;

/*
Вычислить значение функции.
 */
public class BranchingTaskFive {
    public static void main(String[] args) {
        System.out.println("Программа вычисляет уравнение при условии что Х принимает определенные значения.");
        Scanner in = new Scanner(System.in);
        double x;
        System.out.println("Введите значение Х:");
        while (!in.hasNextDouble()) {
            System.out.println("Неправильный ввод! Введите число формата ххх,ххх!");
            in.next();
        }
        x = in.nextDouble();
        double answer;
        if(x<=3) {
            answer = (Math.pow(x, 2) - 3 * x + 9);
            System.out.println("Решено уравнение вида x^2 - 3x + 9. Ответ: " + answer);
        }else {
            answer = 1 / (Math.pow(x, 3) + 6);
            System.out.println("Решено уравнение вида 1/(x^3 + 6). Ответ: " + answer);
        }

    }
}
