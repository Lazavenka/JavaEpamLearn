package by.roger.epamLearn.ModuleTwo;

import java.util.Scanner;

/*
Сформировать квадратную матрицу порядка N по правилу:
A[I,J] = sin((I^2 - J^2)/N)
 */
public class TwoDimArrTaskSeven {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа строит числовую матрицу по правилу A[I,J] = sin((I^2 - J^2)/N)." +
                "\nИ подсчитывает количество положительных элементов в ней.");
        int n = CustomArrays.inputArraySize("Введите порядок матрицы N: ", in);
        double[][] array = new double[n][n];
        int countPos = 0;
        double d;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                d = Math.sin((Math.pow(i,2) - Math.pow(j,2)) / n);
                array[i][j] = d;
                if (d > 0) countPos++;
            }
        }
        CustomArrays.printMatrix(array);
        System.out.println("Количество положительных элементов: " + countPos);

    }
}
