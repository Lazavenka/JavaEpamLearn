package by.roger.epamLearn.ModuleTwo;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
10. Дано натуральное число N. Написать метод(методы) для формирования массива, элементами которого являются цифры числа N.
 */
public class DecompTaskTen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа формирует массив, элементами которого являются цифры числа N. " +
                " \nВыберите вариант выполнения программы: 1 - N генерируется случайно, 2 - N вводится" +
                " вручную из консоли.");
        int choose = CustomArrays.inputChoose("Выберите вариант выполнения программы: ",2,in);
        long number;
        switch (choose){
            case 1:
                number = new Random().nextLong();
                System.out.println("Число: "+number);
                break;
            case 2:
                number =  DecompositionUtils.inputNumber("Введите число N:", in);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        int[] digits = splitOnDigits(number);
        System.out.println("Массив цифр:\n---------------------------");
        System.out.println(Arrays.toString(digits));
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
    private static int findDigits(long number){
        return(number == 0) ? 1 : (int) Math.ceil(Math.log10(Math.abs(number) + 0.5));
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
    public static int[] splitOnDigits(long number){
        int[] ans = new int[findDigits(number)];
        long temp = number;
        for (int i = 0; i < ans.length; i++) {
            ans[ans.length-1-i] = (int) (temp%10);
            temp/=10;
        }
        return ans;
    }
}
