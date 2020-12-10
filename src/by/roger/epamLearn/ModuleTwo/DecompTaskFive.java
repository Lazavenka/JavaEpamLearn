package by.roger.epamLearn.ModuleTwo;

import java.util.Arrays;
import java.util.Scanner;

/*
5. Составить программу, которая в массиве A[N] находит второе по величине число (вывести на печать число,
которое меньше максимального элемента массива, но больше всех других элементов).
 */
public class DecompTaskFive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа находит второе по величине число в массиве чисел A[N]." +
                " \nВыберите вариант выполнения программы: 1 - через случайный массив чисел, 2 - массив вводится" +
                " вручную из консоли.");
        int choose = CustomArrays.inputChoose("Выберите вариант выполнения программы: ",2,in);
        int size = CustomArrays.inputArraySize("Введите размерность массива: ", in);
        int[] array;
        switch (choose){
            case 1:
                array = CustomArrays.oneDimArrayRandomFillingNeg(size);
                break;
            case 2:
                array = CustomArrays.inputArray(size, in);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        System.out.println("Массив чисел до замены:");
        System.out.println(Arrays.toString(array));
        int secondMax = findSecondMax(array);
        if (secondMax!= -1){
            System.out.printf("Второе по величине число - %d", secondMax);
        }
    }
    public static int findSecondMax(int[] array) {
        if (array.length > 2) {
            int max = Math.max(array[0],array[1]);
            int secondMax = Math.min(array[0],array[1]);
            for (int i = 2; i < array.length; i++) {
                if (array[i] >= max) {
                    secondMax = max;
                    max = array[i];

                }else if (array[i] > secondMax && array[i]!=max) {
                    secondMax = array[i];
                }
            }
            return secondMax;
        } else if (array.length == 2) {
            return Math.min(array[0], array[1]);
        } else if (array.length == 1) {
            return array[0];
        } else {
            System.out.println("Массив пустой");
            return -1;
        }
    }
}
