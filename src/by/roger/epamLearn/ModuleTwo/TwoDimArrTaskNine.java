package by.roger.epamLearn.ModuleTwo;

import java.util.Scanner;

/*
Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. Определить, какой
столбец содержит максимальную сумму.
 */
public class TwoDimArrTaskNine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа считает сумму элементов в каждом столбце и определяет, какой столбец " +
                "содержит максимальную сумму." +
                " \nВыберите вариант выполнения программы: 1 - через случайный массив чисел, 2 - массив вводится" +
                " вручную из консоли.");
        int choose = CustomArrays.inputChoose("Выберите вариант выполнения программы: ",2,in);
        int m = CustomArrays.inputArraySize("Введите количество столбцов матрицы m: ", in);
        int n = CustomArrays.inputArraySize("Введите количество строк матрицы n: ", in);
        int[][] array;
        switch (choose){
            case 1:
                //По умолчанию рандомные числа в пределах 0...99. Можно добавить выбор предела чисел.
                array = CustomArrays.twoDimArrayRndFill(n, m, 100);
                break;
            case 2:
                array = CustomArrays.inputTwoDimPositiveMatrix(n, m, in);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        CustomArrays.printMatrix(array);
        int[] summRows = new int[array[0].length];
        for (int[] ints : array) {
            for (int j = 0; j < ints.length; j++) {
                summRows[j] += ints[j];
            }
        }
        System.out.println("Сумма чисел по столбцам матрицы:");
        int max = 0;
        int row=0;
        for (int i = 0; i < summRows.length ; i++) {
            System.out.print(summRows[i]+"\t");
            if(summRows[i]>max){
                max=summRows[i];
                row = i;
            }
        }
        System.out.println("\nМаксимальная сумма по столбцам: "+max+" в столбце "+(row+1)+".");
    }
}
