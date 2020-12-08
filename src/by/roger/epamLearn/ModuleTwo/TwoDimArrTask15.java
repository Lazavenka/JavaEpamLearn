package by.roger.epamLearn.ModuleTwo;

import java.util.Scanner;

/*
15. Найдите наибольший элемент матрицы и заменить все нечетные элементы на него.
 */
public class TwoDimArrTask15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа находит наибольший элемент матрицы и заменяет все нечетные элементы на него." +
                " \nВыберите вариант выполнения программы: 1 - через случайный массив чисел, 2 - массив вводится" +
                " вручную из консоли.");
        System.out.println("Выберите вариант выполнения программы: ");
        while (!in.hasNextInt()) {
            System.out.println("Не корректный ввод!");
            in.next();
        }
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

        int max = array[0][0];
        for (int[] ints : array) {
            for (int anInt : ints) {
                if (anInt > max) {
                    max = anInt;
                }
            }
        }
        boolean flag = false;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j]%2!=0){
                    flag = true;
                    array[i][j] = max;
                    count++;
                }
            }
        }
        if (flag) {
            System.out.println("Программа выполнила " + count + " замен. Результат работы программы:");
            CustomArrays.printMatrix(array);
        }else {
            System.out.println("Подходящих элементов матрицы для замены не нашлось. Видимо все элементы четные.");
        }
    }
}
