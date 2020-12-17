package by.roger.epamLearn.ModuleTwo;

import java.util.Random;
import java.util.Scanner;

/*
17. Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д. Сколько таких действий
надо произвести, чтобы получился нуль? Для решения задачи использовать декомпозицию.
 */
public class DecompTask17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Из заданного числа N вычли сумму его цифр. Из результата вновь вычли сумму цифр результата." +
                "Программа определяет, сколько раз нужно выполнить это действие, чтобы получился нуль."+
                "\nВыберите вариант выполнения программы: 1 - N генерируется случайно, 2 - N вводится вручную из консоли.");
        int choose = CustomArrays.inputChoose("Выберите вариант выполнения программы: ",2,in);
        int n;
        switch (choose){
            case 1:
                n = new Random().nextInt(1_000_000);
                System.out.printf("Программа выполнит расчет для %d\n", n);
                break;
            case 2:
                n =  DecompositionUtils.inputNumber("Введите число N:",  in);
                System.out.printf("Программа выполнит расчет для %d\n", n);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        System.out.println("Количество операций вычитания - "+findCountSubtractions(n));
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
    private static int[] splitOnDigits(int number){
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
    private static int findCountSubtractions (int number){
        int count = 0;
        int remainder = -1;
        while (remainder!=0){
            remainder = number - summDigits(number);
            number = remainder;
            count++;
        }
        return count;
    }
}
