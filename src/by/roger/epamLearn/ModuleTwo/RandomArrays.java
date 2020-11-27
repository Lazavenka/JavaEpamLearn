package by.roger.epamLearn.ModuleTwo;

// Класс с методами создания различных числовых массивов.

public class RandomArrays {
    // Возвращает одномерный массив случайных чисел размерностью size с диапазоном чисел 0 ... 100
    public static int[] oneDimArrayRandomFilling(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 100);
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
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
                if (j == array[i].length - 1) {
                    System.out.print("\n");
                }
            }
        }
    }
    //Вывод матрицы чисел с плавающей запятой с форматом
    public static void printMatrix(double[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.format("%.3f", array[i][j]);
                System.out.print("\t");
                if (j == array[i].length - 1) {
                    System.out.print("\n");
                }
            }
        }
    }

}