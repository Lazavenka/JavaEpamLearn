package by.roger.epamLearn.ModuleTwo;

import java.util.Arrays;
import java.util.Scanner;

/*
1. Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в
один массив, включив второй массив между k-м и (k+1) - м элементами первого, при этом не используя
дополнительный массив.
 */
public class SortTaskOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа объединяет два одномерных массива в один, включая второй массив между k-м и " +
                "(k+1) - м элементами первого." +
                " \nВыберите вариант выполнения программы: 1 - через случайные массивы чисел, 2 - массивы вводятся" +
                " вручную из консоли.");
        int choose = CustomArrays.inputChoose("Выберите вариант выполнения программы: ",2,in);
        int sizeFirst = CustomArrays.inputArraySize("Введите размерность первого массива: ", in);
        int sizeSecond = CustomArrays.inputArraySize("Введите размерность второго массива: ", in);
        int[] arrayOne;
        int[] arrayTwo;
        switch (choose){
            case 1:
                arrayOne = CustomArrays.oneDimArrayRandomFillingNeg(sizeFirst);
                arrayTwo = CustomArrays.oneDimArrayRandomFillingNeg(sizeSecond);
                break;
            case 2:
                arrayOne = CustomArrays.inputArray(sizeFirst, in);
                arrayTwo = CustomArrays.inputArray(sizeSecond, in);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        System.out.println(Arrays.toString(arrayOne));
        System.out.println(Arrays.toString(arrayTwo));
        //k получаем при помощи ввода из консоли, методом который позволяет получить числа 1...num ->
        //индекс массива надо использовать 0 ... arrayOne.length - 1;
        int k = CustomArrays.inputPositiveNum("Введите k: ", arrayOne.length, in);
        int[] arrayAns = mergeArrays(arrayOne, arrayTwo, k);

        System.out.println(Arrays.toString(arrayAns));
    }
    private static int[] mergeArrays(int[] a, int[] b, int k){
        int[] arrayAns = new int[a.length + b.length];
        for (int i = 0; i < arrayAns.length; i++) {
            if(i<k){
                arrayAns[i] = a[i];
            }else if(i==k){
                for (int j = i, idxTwo = 0; j < b.length+i; j++, idxTwo++) {
                    arrayAns[j] = b[idxTwo];
                }
                i = i + b.length-1;
            } else {
                arrayAns[i] = a[i - b.length];
            }
        }
        return arrayAns;
    }
}
