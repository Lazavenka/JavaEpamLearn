package by.roger.epamLearn.moduleOne;

import java.util.Scanner;

/*
Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда, модуль которых больше или равен
заданному е. Общий член ряда имеет вид: An = 1/2^n + 1/3^n
 */
public class CuclesTaskFive {
    public static void main(String[] args) {
        System.out.println("Программа определяет сумму тех членов ряда, модуль которых больше или равен\n" +
                "заданному е. Общий член ряда имеет вид: An = 1/2^n + 1/3^n");
        Scanner in = new Scanner(System.in);
        double e;
        System.out.println("Введите число e: ");
        while (!in.hasNextDouble()) {
            System.out.println("Не корректный ввод!");
            in.next(); // this is important!
        }
        e = in.nextDouble();
        double ans = 0;
        int i = 1;
        if(e<0.9) { // ряд сходится в 0 при e>=0,9
            while ((1 / Math.pow(2, i) + 1 / Math.pow(3, i)) >= e) {
                ans += 1 / Math.pow(2, i) + 1 / Math.pow(3, i);
                i++;
            }
            System.out.println("Сумма ряда = "+ans);
        }else System.out.println("Сумма ряда = 0");
    }
}
