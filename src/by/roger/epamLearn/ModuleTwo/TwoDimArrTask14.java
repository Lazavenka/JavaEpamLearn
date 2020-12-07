package by.roger.epamLearn.ModuleTwo;

import java.util.Random;
import java.util.Scanner;

/*
14. Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце число
единиц равно номеру столбца.
Работает не очень хорошо.. лучше не придумалось(
 */
public class TwoDimArrTask14 {
    public static void main(String[] args) {
        int choose;
        Scanner in = new Scanner(System.in);
        System.out.println("Программа формирует случайную матрицу m x n, состоящую из нулей и единиц, причем " +
                "в каждом столбце число единиц равно номеру столбца.");
        int m;
        int n;
        do {
            System.out.println("Введите количество столбцов матрицы n: ");
            while (!in.hasNextInt()) {
                System.out.println("Не корректный ввод!");
                in.next();
            }
            n = in.nextInt();
        } while (n <= 0);
        do {
            System.out.println("Введите количество строк матрицы m: ");
            while (!in.hasNextInt()) {
                System.out.println("Не корректный ввод!");
                in.next();
            }
            m = in.nextInt();
        } while (m <= 0);
        Random rand = new Random();
        int[][] array = new int[m][n];
        int onesCount = 0;
        for (int j = 0; j < array[0].length; j++) {
            while (onesCount!=j+1&&onesCount!=m) {
                for (int i = 0; i < array.length; i++) {
                    int element = rand.nextInt(2);
                    if (element == 1&&onesCount<=j+1&&array[i][j]==0) {
                        onesCount++;
                        array[i][j] = element;
                    }
                    if (onesCount==j+1&&onesCount!=m) break;
                }
            }
            onesCount=0;
        }
        CustomArrays.printMatrix(array);
    }
}
