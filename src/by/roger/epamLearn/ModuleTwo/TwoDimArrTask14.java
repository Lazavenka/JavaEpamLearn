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
        Scanner in = new Scanner(System.in);
        System.out.println("Программа формирует случайную матрицу m x n, состоящую из нулей и единиц, причем " +
                "в каждом столбце число единиц равно номеру столбца.");
        int m = CustomArrays.inputArraySize("Введите количество столбцов матрицы m: ", in);
        int n = CustomArrays.inputArraySize("Введите количество строк матрицы n: ", in);
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
