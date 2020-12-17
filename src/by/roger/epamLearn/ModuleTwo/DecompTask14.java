package by.roger.epamLearn.ModuleTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
14. Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр, возведенная
в степень n, равна самому числу. Найти все числа Армстронга от 1 до k. Для решения задачи использовать декомпозицию.
 */
public class DecompTask14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа выполняет поиск чисел Армстронга на отрезке [1, k], то есть таких " +
                "чисел, в которых сумма его цифр, возведеннаяна в степень n (количество цифр в записи числа), " +
                "равна самому числу. \nВыберите вариант выполнения программы: " +
                "1 - K генерируется случайно, 2 - K вводится вручную из консоли.");
        int choose = CustomArrays.inputChoose("Выберите вариант выполнения программы: ",2,in);
        int k;
        switch (choose){
            case 1:
                k = new Random().nextInt(5000);
                System.out.printf("Сгенерирован отрезок чисел [1, %d]\n", k);
                break;
            case 2:
                k =  DecompositionUtils.inputNumber("Введите число n:", in);
                System.out.printf("Сгенерирован отрезок чисел [1, %d]\n", k);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        System.out.println("Сформирован массив чисел Армстронга:");
        System.out.println(Arrays.toString(formArmstrongArray(k).toArray()));
    }
    private static int findDigits(int number){
        if (number < 100000) {
            if (number < 100) {
                if (number < 10) {
                    return 1;
                } else {
                    return 2;
                }
            } else {
                if (number < 1000) {
                    return 3;
                } else {
                    if (number < 10000) {
                        return 4;
                    } else {
                        return 5;
                    }
                }
            }
        } else {
            if (number < 10000000) {
                if (number < 1000000) {
                    return 6;
                } else {
                    return 7;
                }
            } else {
                if (number < 100000000) {
                    return 8;
                } else {
                    if (number < 1000000000) {
                        return 9;
                    } else {
                        return 10;
                    }
                }
            }
        }
    }
    public static int[] splitOnDigits(int number){
        int[] ans = new int[findDigits(number)];
        int temp = number;
        for (int i = 0; i < ans.length; i++) {
            ans[ans.length-1-i] = temp%10;
            temp/=10;
        }
        return ans;
    }
    private static int summDigits(int number){
        int[] digits = splitOnDigits(number);
        int summ = 0;
        for (int digit : digits) {
            summ += digit;
        }
        return summ;
    }
    private static boolean isArmstrongNumber(int n){
        return Math.pow(summDigits(n), splitOnDigits(n).length) == n;
    }

    public static ArrayList<Integer> formArmstrongArray (int k){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            if (isArmstrongNumber(i)){
                arrayList.add(i);
            }
        }
        return arrayList;
    }
}
