package by.roger.epamLearn.ModuleTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
15. Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую последовательность
(например, 1234, 5789). Для решения задачи использовать декомпозицию.
 */
public class DecompTask15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа выполняет поиск всех натуральных n-значных чисел, цифры в которых образуют строго " +
                "возрастающую последовательность (например, 1234, 5789). \nВыберите вариант выполнения программы: " +
                "1 - n генерируется случайно, 2 - n вводится вручную из консоли.");
        int choose = CustomArrays.inputChoose("Выберите вариант выполнения программы: ",2,in);
        int n;
        switch (choose){
            case 1:
                n = new Random().nextInt(10);
                System.out.printf("Программа выполнит поиск %d-значных чисел\n", n);
                break;
            case 2:
                n =  DecompositionUtils.inputPositiveNumberBound("Введите число n:", 9, in);
                System.out.printf("Программа выполнит поиск %d-значных чисел\n", n);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        System.out.println("Сформирован массив чисел:");
        System.out.println(Arrays.toString(formRisingArray(n).toArray()));
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
    private static boolean isRisingDigits (int number){
        boolean ans = true;
        int[] array = splitOnDigits(number);
        for (int i = 0; i < array.length-1; i++) {
            if (array[i]>array[i+1]||array[i]==array[i+1]){
                return false;
            }
        }
        return ans;
    }
    public static ArrayList<Integer> formRisingArray (int n){
        ArrayList<Integer> arrayList = new ArrayList<>();
        int start = (int) Math.pow(10,n-1);
        int end = (int) Math.pow(10, n);
        for (int i = start; i < end; i++) {
            if(isRisingDigits(i)){
                arrayList.add(i);
            }
        }
        return arrayList;
    }
}
