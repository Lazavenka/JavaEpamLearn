package by.roger.epamLearn.ModuleTwo;
/*
2. Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.
 */
import java.util.Scanner;

public class TwoDimArrTaskTwo {
    public static void main(String[] args) {
        int choose;
        Scanner in = new Scanner(System.in);
        System.out.println("Программа выводит на экран элементы диагонали квадратной матрицы." +
                " \nВыберите вариант выполнения программы: 1 - через случайный массив чисел, 2 - массив вводится" +
                " вручную из консоли.");
        System.out.println("Выберите вариант выполнения программы: ");
        while (!in.hasNextInt()) {
            System.out.println("Не корректный ввод!");
            in.next();
        }
        choose = in.nextInt();

        int n;
        do {
            System.out.println("Введите порядок матрицы n: ");
            while (!in.hasNextInt()) {
                System.out.println("Не корректный ввод!");
                in.next();
            }
            n = in.nextInt();
        } while (n <= 0);
        int[][] array;
        switch (choose){
            case 1:
                array = CustomArrays.twoDimArrayRndFill(n);
                break;
            case 2:
                array = CustomArrays.inputTwoDimMatrix(n, n, in);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        CustomArrays.printMatrix(array);
        System.out.println("Вывод элементов диагонали матрицы (лево верх -> право низ)");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) {
                    System.out.print(array[i][j] + "\t");
                } else System.out.print("\t");
            }
            System.out.print("\n");
        }
    }

}
