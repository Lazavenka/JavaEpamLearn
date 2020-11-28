package by.roger.epamLearn.ModuleTwo;

import java.util.Scanner;

/*
 Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для которых аi > i.

 */
public class OneDimArrTaskFive {
    public static void main(String[] args) {
        int choose;
        Scanner in = new Scanner(System.in);
        System.out.println("Программа выводит на печать те элементы, значение которых больше его порядкового номера." +
                " \nВыберите вариант выполнения программы: 1 - через случайный массив чисел, 2 - массив вводится" +
                " вручную из консоли.");
        System.out.println("Выберите вариант выполнения программы: ");
        while (!in.hasNextInt()) {
            System.out.println("Не корректный ввод!");
            in.next();
        }
        choose = in.nextInt();

        int size;
        do {
            System.out.println("Введите размерность массива: ");
            while (!in.hasNextInt()) {
                System.out.println("Не корректный ввод!");
                in.next();
            }
            size = in.nextInt();
        } while (size <= 0);
        int[] array;
        switch (choose){
            case 1:
                array = CustomArrays.oneDimArrayRandomFillingNeg(size);
                break;
            case 2:
                array = CustomArrays.inputArray(size, in);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i]>i+1){
                System.out.print(array[i]+"\t");
            }
        }
    }
}
