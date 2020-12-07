package by.roger.epamLearn.ModuleTwo;

import java.util.Arrays;
import java.util.Scanner;

/*
Магическим квадратом порядка n называется квадратная матрица размера nxn, составленная из чисел 1, 2, 3, ..., n^2
так, что суммы по каждому столбцу, каждой строке и каждой из двух больших диагоналей равны между
собой. Построить такой квадрат. Пример магического квадрата порядка 3:
6, 1, 8
7, 5, 3
2, 9, 4
 */
public class TwoDimArrTask16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа строит магический квадрат порядка n. alpha версия программы " +
                "умеет правильно строить квадрат для n - нечетного." +
                "\nПрограмма проверяет магический ли квадрат выводя сумму всех строк, столбцов и главных диагоналей.");
        int n;
        do {
            System.out.println("Введите порядок магического квадрата N: ");
            while (!in.hasNextInt()) {
                System.out.println("Не корректный ввод!");
                in.next();
            }
            n = in.nextInt();
        } while (n <= 0);

        int summ = n*(n*n+1)/2;
        System.out.println("Магическая константа квадрата порядка "+n+": "+summ);
        int[][] array = new int[n][n];
        int num = 1;
        int nn = n * 3 / 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[(i - j + nn) % n][(j * 2 - i + n) % n] = num++;
            }
        }
        CustomArrays.printMatrix(array);
        System.out.println("Проверка на магичность :)");
        int[] summs = new int[2*array.length+2];
        int k = 0;
        for (int[] ints : array) {
            for (int anInt : ints) {
                summs[k] += anInt;
            }
            k++;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                summs[k]+= array[j][i];
            }
            k++;
        }
        for (int i = 0; i < array.length; i++) {
            summs[k]+=array[i][i];
        }
        k++;
        for (int i = 0; i < array.length; i++) {
            summs[k]+=array[i][array.length-1-i];
        }
        System.out.println(Arrays.toString(summs));

    }
}
