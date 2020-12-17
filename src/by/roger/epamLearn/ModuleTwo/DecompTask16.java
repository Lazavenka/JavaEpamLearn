package by.roger.epamLearn.ModuleTwo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
16. Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры. Определить также,
сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию.
 */
public class DecompTask16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа выполняет поиск всех натуральных n-значных чисел, в которых все цифры нечетные, " +
                "затем вычисляет сумму этих чисел. Далее определяет сколько четных цифр в найденной сумме." +
                "\nВыберите вариант выполнения программы: 1 - n генерируется случайно, 2 - n вводится вручную из консоли.");
        int choose = CustomArrays.inputChoose("Выберите вариант выполнения программы: ",2,in);
        int n;
        switch (choose){
            case 1:
                n = new Random().nextInt(8);
                System.out.printf("Программа выполнит расчет для %d-значных чисел\n", n);
                break;
            case 2:
                n =  DecompositionUtils.inputPositiveNumberBound("Введите число n:", 8, in);
                System.out.printf("Программа выполнит расчет для %d-значных чисел\n", n);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        ArrayList<Integer> arrayList = findOddDigitsNumbers(n);
        //System.out.println("Получен массив чисел с нечетными цифрами");
        //System.out.println(Arrays.toString(arrayList.toArray()));
        int summ = findSummOddDigitsNumbers(arrayList);
        System.out.printf("Сумма %d-значных чисел с нечетными цифрами - %d\n", n, summ);
        System.out.println("Количество четных цифр в полученной сумме - "+findCountEvenDigits(summ));
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
    private static boolean isEven(int n){
        return n % 2 == 0;
    }
    private static boolean isOddDigits (int n){
        int[] array = splitOnDigits(n);
        for (int j : array) {
            if (isEven(j))
                return false;
        }
        return true;
    }
    private static ArrayList<Integer> findOddDigitsNumbers(int n){
        ArrayList<Integer> arrayList= new ArrayList<>();
        int start = (int) Math.pow(10,n-1);
        int end = (int) Math.pow(10, n);
        for (int i = start; i < end; i++) {
            if (isOddDigits(i)){
                arrayList.add(i);
            }
        }
        return arrayList;
    }
    private static int findSummOddDigitsNumbers(ArrayList<Integer> arrayList){
        int ans = 0;
        for (Integer integer : arrayList) {
            ans += integer;
        }
        return ans;
    }
    private static int findCountEvenDigits(int n){
        int count = 0;
        int[] array = splitOnDigits(n);
        for (int j : array) {
            if (isEven(j)) {
                count++;
            }
        }
        return count;
    }
}
