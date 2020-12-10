package by.roger.epamLearn.ModuleTwo;

import java.util.Arrays;
import java.util.Scanner;

/*
Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел.
 */
public class DecompTaskTwo {
    public static void main(String[] args) {
        System.out.println("Программа определяет НОД n натуральных чисел. Числа вводятся пользователем в консоль");
        Scanner in = new Scanner(System.in);
        int count = CustomArrays.inputArraySize("Введите количетсво чисел НОД которых хотите определить:", in);
        int[] numbers = CustomArrays.inputArray(count, in);
        System.out.println("Введены следующие числа:");
        System.out.println(Arrays.toString(numbers));
        int gcd = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            gcd = gcdEvclidus(gcd, numbers[i]);
        }
        System.out.printf("НОД чисел введенных пользователем равен %d", gcd);
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
}
