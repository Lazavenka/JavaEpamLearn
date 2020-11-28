package by.roger.epamLearn.ModuleTwo;

import java.util.Arrays;
import java.util.Scanner;

/*
Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего.
 */
public class TwoDimArrTaskOne {
    public static void main(String[] args) {
        int choose;
        Scanner in = new Scanner(System.in);
        System.out.println("Программа выводит на экран все нечетные столбцы, у которых первый элемент больше последнего." +
                " \nВыберите вариант выполнения программы: 1 - через случайный массив чисел, 2 - массив вводится" +
                " вручную из консоли.");
        System.out.println("Выберите вариант выполнения программы: ");
        while (!in.hasNextInt()) {
            System.out.println("Не корректный ввод!");
            in.next();
        }
        choose = in.nextInt();

        int m;
        int n;
        do {
            System.out.println("Введите количество столбцов матрицы m: ");
            while (!in.hasNextInt()) {
                System.out.println("Не корректный ввод!");
                in.next();
            }
            m = in.nextInt();
        } while (m <= 0);
        do {
            System.out.println("Введите количество строк матрицы n: ");
            while (!in.hasNextInt()) {
                System.out.println("Не корректный ввод!");
                in.next();
            }
            n = in.nextInt();
        } while (n <= 0);
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
