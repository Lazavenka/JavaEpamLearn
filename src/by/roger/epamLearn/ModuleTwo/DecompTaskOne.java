package by.roger.epamLearn.ModuleTwo;

import java.util.Scanner;

/*
Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух
натуральных чисел:
 */
public class DecompTaskOne {
    public static void main(String[] args) {
        System.out.println("Программа определяет НОД и НОК двух натуральных чисел. Числа вводятся пользователем в консоль");
        Scanner in = new Scanner(System.in);
        int a = DecompositionUtils.inputNumber("Ввкдите первое число: ", in);
        int b = DecompositionUtils.inputNumber("Введите второе число: ", in);
        int gdc = gcdEvclidus(a, b);
        int lcm = lcm(a, b, gdc);
        System.out.printf("НОД чисел %d и %d равен %d", a, b, gdc);
        System.out.printf("\nНОК чисел %d и %d равен %d", a, b, lcm);
    }
    private static int gcdEvclidus(int a, int b){
        while (a - b != 0){
            if(a > b){
                a = a - b;
            }else{
                b = b - a;
            }
        }
        return a;
    }

    private static int lcm(int a, int b, int gcd){
        return a * b / gcd;
    }
}
