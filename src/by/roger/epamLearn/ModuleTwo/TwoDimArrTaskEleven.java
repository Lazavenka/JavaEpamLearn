package by.roger.epamLearn.ModuleTwo;

import java.util.Scanner;

/*
Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк, в
которых число 5 встречается три и более раз.
 */
public class TwoDimArrTaskEleven {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа заполняет матрицу 10x20 случайными числами от 0 до 15 и " +
                "выводит на экран саму матрицу и номера строк, в\n" +
                "которых число 5 встречается три и более раз");
        int[][] array = CustomArrays.twoDimArrayRndFill(10, 20);
        //Можно оформить ввод количества столбцов и строк вручную.
        CustomArrays.printMatrix(array);
        System.out.println("Результат работы программы: ");
        int fivesCount=0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
                if(array[i][j]==5) {
                    fivesCount++;
                }
            }
            if(fivesCount>=3){
                System.out.print((i+1)+" строка имеет "+ fivesCount +" пятерок.");
            }
            fivesCount=0;
            System.out.print("\n");
        }
    }
}
