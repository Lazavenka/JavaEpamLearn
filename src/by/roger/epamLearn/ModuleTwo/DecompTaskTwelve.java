package by.roger.epamLearn.ModuleTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
12. Даны натуральные числа К и N. Написать метод(методы) формирования массива А,
элементами которого являются числа, сумма цифр которых равна К и которые не большее N.
 */
public class DecompTaskTwelve {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа формирует массив, в каком элементами являются числа, сумма цифр которых равна К " +
                "и которые не большее N.\nВыберите вариант выполнения программы: 1 - N и K генерируются случайно, 2 - N и K вводятся" +
                " вручную из консоли.");
        int choose = CustomArrays.inputChoose("Выберите вариант выполнения программы: ",2,in);
        int n;
        int k;
        switch (choose){
            case 1:
                n = new Random().nextInt(100);
                System.out.println("Случайное число N: "+n);
                k = new Random().nextInt(100);
                System.out.println("Случайное число K: "+k);
                break;
            case 2:
                n =  DecompositionUtils.inputNumber("Введите число N: ", in);
                k =  DecompositionUtils.inputNumber("Введите число K: ", in);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        ArrayList<Integer> array = formArray(k,n);
        System.out.println("Получен массив: ");
        System.out.println(Arrays.toString(array.toArray()));
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
    public static ArrayList<Integer> formArray(int k, int n){
        ArrayList<Integer> arrayList = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (summDigits(i)==k){
                arrayList.add(i);
            }

        }
        return arrayList;
    }
}
