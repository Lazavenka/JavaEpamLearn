package by.roger.epamLearn.ModuleTwo;

import java.util.Arrays;
import java.util.Scanner;

/*
Дана последовательность целых чисел  a1, a2, ... an. Образовать новую последовательность, выбросив из
исходной те члены, которые равны min(a1, a2, ... , an)
 */
public class OneDimArrTaskEight {
    public static void main(String[] args) {
        int choose;
        Scanner in = new Scanner(System.in);
        System.out.println("Программа образует новую последовательность, выбрасывая из исходной последовательности" +
                " те члены которые равны min(a1, a2, ... , an)." +
                " \nВыберите вариант выполнения программы: 1 - через случайный массив чисел, 2 - массив вводится" +
                " вручную из консоли.");
        choose = CustomArrays.inputChoose("Выберите вариант выполнения программы: ",2,in);
        int size = CustomArrays.inputArraySize("Введите размерность массива: ", in);
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
        System.out.println(Arrays.toString(array));
        int min = array[0];
        int count = 0;
        for (int k : array) {
            if (k < min) {
                min = k;
            }
        }
        System.out.println("\nМинимум - "+min);
        for (int j : array) {
            if (j == min) {
                count++;
            }
        }
        System.out.println("Число вхождений минимума - "+count);
        int[] ans = new int[array.length-count];
        for (int idxAns = 0, idxArray = 0; idxAns < ans.length; idxAns++, idxArray++) {
            if(array[idxArray]!=min){
                ans[idxAns]=array[idxArray];
            }else{
                idxArray++;
                ans[idxAns]=array[idxArray];
            }
        }
        System.out.println(Arrays.toString(ans));
    }
}
