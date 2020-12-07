package by.roger.epamLearn.ModuleTwo;

import java.util.Scanner;

/*
6. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
1, 1, 1, ... 1, 1, 1
0, 1, 1, ... 1, 1, 0
0, 0, 1, ... 1, 0, 0
.  .  .  .   .  .  .
.  .  .   .  .  .  .
.  .  .    . .  .  .
0, 0, 1, ... 1, 0, 0
0, 1, 1, ... 1, 1, 0
1, 1, 1, ... 1, 1, 1
 */
public class TwoDimArrTaskSix {
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
                if((array.length-i>j&&j+1>i)||(i+1>j&&array.length-2-j<i)){
                    //if(array.length-2-j<i){
                    //if(i+1>j){
                    //if(j+1>i){
                    //if(array.length-i>j){
                    array[i][j]=1;
                }else {
                    array[i][j]=0;
                }
            }
        }
        CustomArrays.printMatrix(array);
    }
}
