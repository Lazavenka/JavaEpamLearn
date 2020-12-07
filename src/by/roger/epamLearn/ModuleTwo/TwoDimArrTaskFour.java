package by.roger.epamLearn.ModuleTwo;
/*
4. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
1, 2, 3, 4, ... n
n, n-1, n-2,... 1
1, 2, 3, 4, ... n
.
.
.
n, n-1, n-2,... 1
 */


import java.util.Scanner;

public class TwoDimArrTaskFour {
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
                if(i%2==0){
                    array[i][j]=j+1;
                }else {
                    array[i][j]=n-j;
                }
            }
        }
        CustomArrays.printMatrix(array);
    }
}
