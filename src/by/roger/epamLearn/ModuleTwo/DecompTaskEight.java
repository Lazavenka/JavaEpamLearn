package by.roger.epamLearn.ModuleTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
Задан массив D. Определить следующие суммы: D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
Пояснение. Составить метод(методы) для вычисления суммы трех последовательно
расположенных элементов массива с номерами от k до m.
 */
public class DecompTaskEight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа вычисляет суммы трех последовательно расположенных элементов массива." +
                " \nВыберите вариант выполнения программы: 1 - через случайный набор чисел, 2 - числа вводятся" +
                " вручную из консоли.");
        int choose = CustomArrays.inputChoose("Выберите вариант выполнения программы: ",2,in);
        int size = CustomArrays.inputArraySize("Введите размер массива:", in);
        int[] array;
        switch (choose){
            case 1:
                array = CustomArrays.oneDimArrayRandomFilling(size);
                break;
            case 2:
                array = CustomArrays.inputArray(size, in);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        System.out.println("Введен массив:\n------------------------------");
        System.out.println(Arrays.toString(array));
        ArrayList<Integer> summs = findSumms(array);
        System.out.println("Суммы трех последовательно расположенных элементов массива\n" +
                "------------------------------");
        System.out.println(Arrays.toString(summs.toArray()));
    }
    private static int summThree(int[] array, int i){
        return array[i]+array[i+1]+array[i+2];
    }
    private static ArrayList<Integer> findSumms(int[] array){
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < array.length-2; i++) {
            ans.add(summThree(array,i));
        }
        return ans;
    }
}
