package by.roger.epamLearn.moduleOne;

import java.util.Scanner;

/*
Напишите программу, где пользователь вводит любое целое положительное число. А программа суммирует
все числа от 1 до введенного пользователем числа.
 */
public class CuclesTaskOne {
    public static void main(String[] args) {
        System.out.println("Программа рограмма суммирует все числа от 1 до введенного пользователем числа.");
        Scanner in = new Scanner(System.in);
        int number;
        do {
            System.out.println("Введите положительное целое число: ");
            while (!in.hasNextInt()) {
                System.out.println("Не корректный ввод!");
                in.next(); // this is important!
            }
            number = in.nextInt();
        } while (number <= 0);
        int ans = 0;
        for (int i = 0; i <= number; i++) {
            ans += i;
        }
        System.out.println("Сумма чисел от 1 до "+number+" составила: "+ans);
    }
}
