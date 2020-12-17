package by.roger.epamLearn.ModuleTwo;

import java.util.Random;
import java.util.Scanner;

/*
11. Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.
 */
public class DecompTaskEleven {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа определяет, в каком из данных двух чисел больше цифр. " +
                " \nВыберите вариант выполнения программы: 1 - Числа генерируются случайно, 2 - Числа вводятся" +
                " вручную из консоли.");
        int choose = CustomArrays.inputChoose("Выберите вариант выполнения программы: ",2,in);
        long number1;
        long number2;
        switch (choose){
            case 1:
                number1 = new Random().nextLong();
                System.out.println("Случайное число 1: "+number1);
                number2 = new Random().nextLong();
                System.out.println("Случайное число 2: "+number2);
                break;
            case 2:
                number1 =  DecompositionUtils.inputNumber("Введите первое число: ", in);
                number2 =  DecompositionUtils.inputNumber("Введите второе число: ", in);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        System.out.println("Число с большим количеством цифр - "+ maxNumberLength(number1, number2));

    }
    private static int findDigitsCount(long number){
        return(number == 0) ? 1 : (int) Math.ceil(Math.log10(Math.abs(number) + 0.5));
    }
    private static int[] splitOnDigits(long number){
        int[] ans = new int[findDigitsCount(number)];
        long temp = number;
        for (int i = 0; i < ans.length; i++) {
            ans[ans.length-1-i] = (int)temp%10;
            temp/=10;
        }
        return ans;
    }
    private static long maxNumberLength (long a, long b){
        int[] arrA = splitOnDigits(a);
        int[] arrB = splitOnDigits(b);
        if(arrA.length != arrB.length){
            return splitOnDigits(a).length> splitOnDigits(b).length ? a : b;
        }else {
            return Math.max(a, b);
        }
    }
}
