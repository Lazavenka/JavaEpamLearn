package by.roger.epamLearn.ModuleTwo;

import java.util.Arrays;
import java.util.Scanner;

/*
Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего.
 */
public class TwoDimArrTaskOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа выводит на экран все нечетные столбцы, у которых первый элемент больше последнего." +
                " \nВыберите вариант выполнения программы: 1 - через случайный массив чисел, 2 - массив вводится" +
                " вручную из консоли.");
        int choose = CustomArrays.inputChoose("Выберите вариант выполнения программы: ",2,in);
        int m = CustomArrays.inputArraySize("Введите количество столбцов матрицы m: ", in);
        int n = CustomArrays.inputArraySize("Введите количество строк матрицы n: ", in);
        int[][] array;
        switch (choose){
            case 1:
                array = CustomArrays.twoDimArrayRndFill(n, m);
                break;
            case 2:
                array = CustomArrays.inputTwoDimMatrix(n, m, in);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        CustomArrays.printMatrix(array);
        boolean flag = false;
        for (int[] ints : array) {
            for (int j = 0; j < ints.length; j++) {
                if (j % 2 == 0 && array[0][j] > array[array.length - 1][j]) {
                    System.out.print(ints[j] + "\t");
                    flag = true;
                }
            }
            if (flag) System.out.print("\n");
        }
    }
}
