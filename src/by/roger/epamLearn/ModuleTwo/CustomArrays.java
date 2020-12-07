package by.roger.epamLearn.ModuleTwo;

// Класс с методами создания различных числовых массивов.

import java.util.Scanner;

public class CustomArrays {
    // Возвращает одномерный массив случайных чисел размерностью size с диапазоном чисел 0 ... 100
    public static int[] oneDimArrayRandomFilling(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }
    // Возвращает одномерный массив случайных чисел размерностью size с диапазоном чисел 0 ... border
    public static int[] oneDimArrayRandomFilling(int size, int border) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * border);
        }
        return array;
    }
    // Возвращает одномерный массив случайных чисел размерностью size с диапазоном чисел -100 ... 100
    public static int[] oneDimArrayRandomFillingNeg(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) ((Math.random() -0.5) * 200);
        }
        return array;
    }
    // Возвращает одномерный массив случайных чисел размерностью size с диапазоном чисел -border ... border
    public static int[] oneDimArrayRandomFillingNeg(int size,int border) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) ((Math.random() -0.5) * 2*border);
        }
        return array;
    }

    public static double[] arrayFibonacci(int size) {
        double[] array = new double[size];
        array[0] = 1.0;
        array[1] = 1.0;
        for (int i = 2; i < size; i++) {
            array[i] = array[i - 2] + array[i - 1];
        }
        return array;
    }
    // Возвращает двумерный массив случайных чисел int размерностью n*n с диапазоном чисел 0 ... 99
    public static int[][] twoDimArrayRndFill(int n) {
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = (int) (Math.random() * 100);
            }
        }
        return array;
    }
    // Возвращает двумерный массив случайных чисел int размерностью m*n с диапазоном чисел 1 ... 15 включительно
    public static int[][] twoDimArrayRndFill(int m, int n) {
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = (int) (Math.random() * 15)+1;
            }
        }
        return array;
    }
    // Возвращает двумерный массив случайных чисел int размерностью m*n с диапазоном чисел 1 ... border включительно
    public static int[][] twoDimArrayRndFill(int m, int n, int border) {
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = (int) (Math.random() * border)+1;
            }
        }
        return array;
    }
    // Возвращает двумерный массив случайных чисел int размерностью m*n с диапазоном чисел -border ... border включительно
    public static int[][] twoDimArrayRndFillNeg(int m, int n, int border) {
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = (int) ((Math.random() - 0.5) * 2 * border);
            }
        }
        return array;
    }
    //Заполняет матрицу последовательно с 0 до n*n-1
    public static int[][] fillMatrix(int n){
        int[][] array = new int[n][n];
        int x = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j]=x;
                x++;
            }
        }
        return array;
    }


    //Вывод матрицы матрицей
    public static void printMatrix(int[][] array) {
        for (int[] ints : array) {
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j] + "\t");
                if (j == ints.length - 1) {
                    System.out.print("\n");
                }
            }
        }
    }
    //Вывод матрицы чисел с плавающей запятой с форматом
    public static void printMatrix(double[][] array) {
        for (double[] doubles : array) {
            for (int j = 0; j < doubles.length; j++) {
                System.out.format("%.3f", doubles[j]);
                System.out.print("\t");
                if (j == doubles.length - 1) {
                    System.out.print("\n");
                }
            }
        }
    }
    public static int[] inputArray(int size, Scanner in){
        //Scanner in = new Scanner(System.in);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Введите "+(i+1)+"й элемент массива: ");
            while (!in.hasNextInt()) {
                System.out.println("Не корректный ввод!");
                in.next();
            }
            array[i]  = in.nextInt();
        }
        return array;
    }
    public static int[][] inputTwoDimMatrix(int rows, int columns, Scanner in){
        int[][] array = new int[rows][columns];
        printMatrix(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print("Введите ["+(i)+"]["+j+"] элемент матрицы: ");
                while (!in.hasNextInt()) {
                    System.out.println("Не корректный ввод!");
                    in.next();
                }
                array[i][j]  = in.nextInt();
            }
        }
        return array;
    }
    public static int[][] inputTwoDimPositiveMatrix(int rows, int columns, Scanner in){
        int[][] array = new int[rows][columns];
        printMatrix(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                do {
                    System.out.print("Введите [" + (i) + "][" + j + "] элемент матрицы: ");
                    while (!in.hasNextInt()) {
                        System.out.println("Не корректный ввод!");
                        in.next();
                    }
                    array[i][j] = in.nextInt();
                }while (array[i][j]<0);
            }
        }
        return array;
    }
    public static int[][] inputSquareDimMatrix(int n, Scanner in){
        int[][] array = new int[n][n];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println("Введите ["+(i)+"]["+j+"] элемент матрицы: ");
                while (!in.hasNextInt()) {
                    System.out.println("Не корректный ввод!");
                    in.next();
                }
                array[i][j]  = in.nextInt();
            }
        }
        return array;
    }
}
