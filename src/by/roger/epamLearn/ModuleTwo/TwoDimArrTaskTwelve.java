package by.roger.epamLearn.ModuleTwo;

import java.util.Arrays;
import java.util.Scanner;

/*
12. Отсортировать строки матрицы по возрастанию и убыванию значений элементов.
 */
public class TwoDimArrTaskTwelve {
    public static void main(String[] args) {
        int choose;
        Scanner in = new Scanner(System.in);
        System.out.println("Программа сортирует строки матрицы по возрастанию и убыванию значений элементов." +
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
                array = CustomArrays.twoDimArrayRndFill(n, m, 100);
                break;
            case 2:
                array = CustomArrays.inputTwoDimMatrix(n, m, in);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        CustomArrays.printMatrix(array);

        for (int[] ints : array) {
            Arrays.sort(ints);
        }
        System.out.println("Выполнена сортировка строк по возрастанию значений.");
        CustomArrays.printMatrix(array);
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length/2; j++) {
                temp = array[i][j];
                array[i][j] = array[i][array[i].length-1-j];
                array[i][array[i].length-1-j]=temp;
            }
        }
        System.out.println("Выполнена сортировка строк по убыванию значений.");
        CustomArrays.printMatrix(array);
    }
}
