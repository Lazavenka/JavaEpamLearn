package by.roger.epamLearn.ModuleTwo;

/*
3. Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
 */

import java.util.Scanner;

public class TwoDimArrTaskThree {
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
        System.out.println("Введите столбец и строку которую надо вывести в консоль:");
        //экономия памяти под переменные m = k; n = p;
        do {
            System.out.println("Введите столбец p (от 1 до "+array[0].length+"): ");
            while (!in.hasNextInt()) {
                System.out.println("Не корректный ввод!");
                in.next();
            }
            n = in.nextInt();
        } while (n <= 0||n> array[0].length);
        do {
            System.out.println("Введите строку k (от 1 до "+array.length+"): ");
            while (!in.hasNextInt()) {
                System.out.println("Не корректный ввод!");
                in.next();
            }
            m = in.nextInt();
        } while (m <= 0||m> array.length);
        //Алгоритм рисования определенных столбцов и строк в виде таблицы в консоли. Можно просто в массив запомнить.
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == m - 1 || j == n - 1) {
                    System.out.print(array[i][j] + "\t");
                } else System.out.print("\t");
            }
            System.out.print("\n");
        }
    }
}
