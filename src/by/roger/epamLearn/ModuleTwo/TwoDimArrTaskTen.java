package by.roger.epamLearn.ModuleTwo;

import java.util.Scanner;

/*
Найти положительные элементы главной диагонали квадратной матрицы.
 */
public class TwoDimArrTaskTen {
    public static void main(String[] args) {
        int choose;
        Scanner in = new Scanner(System.in);
        System.out.println("Программа подсвечивает положительные элементы на главной диагонали квадратной матрицы." +
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
                //По умолчанию рандомные числа в пределах -100...100. Можно добавить выбор предела чисел.
                array = CustomArrays.twoDimArrayRndFillNeg(n, n, 100);
                break;
            case 2:
                array = CustomArrays.inputSquareDimMatrix(n, in);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        CustomArrays.printMatrix(array);
        //Выводит только числа удовлетворяющие условию задачи. Остальные числа заменяются символом табуляции.
        System.out.println("Вывод положительных чисел главной диагонали матрицы:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j&&array[i][j]>0) {
                    System.out.print(array[i][j] + "\t");
                } else System.out.print("\t");
            }
            System.out.print("\n");
        }
    }
}
