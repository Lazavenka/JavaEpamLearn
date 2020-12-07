package by.roger.epamLearn.ModuleTwo;

import java.util.Scanner;

/*
5. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
1, 1, 1, ... 1, 1, 1
2, 2, 2, ... 2, 2, 0
3, 3, 3, ... 3, 0, 0
.  .  .  .   .  .  .
.  .  .   .  .  .  .
.  .  .    . .  .  .
n-1, n-1, 0, ...0, 0, 0
n, 0, 0, ... 0, 0, 0
 */
public class TwoDimArrTaskFive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа строит числовую матрицу по заданному алгоритму.");
        int n;
        do {
            System.out.println("Введите порядок матрицы n (n - четное!): ");
            while (!in.hasNextInt()) {
                System.out.println("Не корректный ввод!");
                in.next();
            }
            n = in.nextInt();
        } while (n <= 0||n%2==1);
        int[][] array = new int[n][n];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array.length-i>j){
                    array[i][j]=i+1;
                }else {
                    array[i][j]=0;
                }
            }
        }
        CustomArrays.printMatrix(array);
    }
}
