package by.roger.epamLearn.ModuleTwo;

import java.util.Scanner;

/*
13. Отсотрировать стобцы матрицы по возрастанию и убыванию значений эементов
 */
public class TwoDimArrTask13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа сортирует столбцы матрицы по возрастанию и убыванию значений элементов." +
                " \nВыберите вариант выполнения программы: 1 - через случайный массив чисел, 2 - массив вводится" +
                " вручную из консоли.");
        int choose = CustomArrays.inputChoose("Выберите вариант выполнения программы: ",2,in);
        int m = CustomArrays.inputArraySize("Введите количество столбцов матрицы m: ", in);
        int n = CustomArrays.inputArraySize("Введите количество строк матрицы n: ", in);
        int[][] array;
        switch (choose){
            case 1:
                array = CustomArrays.twoDimArrayRndFill(n, m, 100);
                break;
            case 2:
                array = CustomArrays.inputTwoDimMatrix(n, m, in);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        CustomArrays.printMatrix(array);
        int temp;
        boolean flag = true;
        // Сортировка столбцов по возрастанию значений. Пузырьки...
        for (int j = 0; j < array[0].length; j++) {
            while(flag){
                flag=false;
                for (int i = 0; i < array.length - 1; i++) {
                    if (array[i][j]>array[i+1][j]){
                        temp = array[i][j];
                        array[i][j] = array[i+1][j];
                        array[i+1][j] = temp;
                        flag = true;
                    }
                }
            }
            flag = true;
        }
        System.out.println("Выполнена сортировка столбцов по возрастанию значений.");
        CustomArrays.printMatrix(array);
        // Сортировка столбцов по убыванию значений. Пузырьки...
        for (int j = 0; j < array[0].length; j++) {
            while(flag){
                flag=false;
                for (int i = 0; i < array.length - 1; i++) {
                    if (array[i][j]<array[i+1][j]){
                        temp = array[i][j];
                        array[i][j] = array[i+1][j];
                        array[i+1][j] = temp;
                        flag = true;
                    }
                }
            }
            flag = true;
        }
        System.out.println("Выполнена сортировка столбцов по убыванию значений.");
        CustomArrays.printMatrix(array);
    }
}
