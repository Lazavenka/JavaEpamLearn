package by.roger.epamLearn.ModuleTwo;

import java.util.Scanner;

/*
8. В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить
на соответствующие им позиции другого, а его элементы второго переместить в первый. Номера столбцов вводит
пользователь с клавиатуры.
 */
public class TwoDimArrTaskEight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа все элементы одного столбца ставит на соответствующие им позиции другого столбца." +
                " Пользователь вводит номера столбцов вручную в консоли." +
                " \nВыберите вариант выполнения программы: 1 - через случайный массив чисел, 2 - массив вводится" +
                " вручную из консоли.");
        int choose = CustomArrays.inputChoose("Выберите вариант выполнения программы: ",2,in);
        int m = CustomArrays.inputArraySize("Введите количество столбцов матрицы m: ", in);
        int n = CustomArrays.inputArraySize("Введите количество строк матрицы n: ", in);
        int[][] array;
        switch (choose){
            case 1:
                array = CustomArrays.twoDimArrayRndFill(n, m);
                break;
            case 2:
                array = CustomArrays.inputTwoDimMatrix(n, m, in);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        CustomArrays.printMatrix(array);
        System.out.println("Введите номера столбцов которые надо поменять местами:");
        //экономия памяти под переменные m = k; n = p;
        do {
            System.out.println("Введите столбец \"p\", который хотите поменять (от 1 до "+array[0].length+"): ");
            while (!in.hasNextInt()) {
                System.out.println("Не корректный ввод!");
                in.next();
            }
            n = in.nextInt();
        } while (n <= 0||n> array[0].length);
        do {
            System.out.println("Введите толбец \"k\", с которым хотите поменять столбец \"p\" (от 1 до "+array.length+"): ");
            while (!in.hasNextInt()) {
                System.out.println("Не корректный ввод!");
                in.next();
            }
            m = in.nextInt();
        } while (m <= 0||m> array[0].length);

        int temp;
        for (int i = 0; i < array.length; i++) {
            temp = array[i][n-1];
            array[i][n-1] = array[i][m-1];
            array[i][m-1]=temp;

        }
        CustomArrays.printMatrix(array);
    }
}
