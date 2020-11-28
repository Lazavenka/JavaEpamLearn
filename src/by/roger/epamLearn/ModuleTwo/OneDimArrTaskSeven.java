package by.roger.epamLearn.ModuleTwo;

import java.util.Arrays;
import java.util.Scanner;

/*
Даны действительные числа a1, a2, ... an. Найти max( a1 + a2n, a2 + a2n−1 , ... , an + an+1).
 */

public class OneDimArrTaskSeven {
    public static void main(String[] args) {
        int choose;
        Scanner in = new Scanner(System.in);
        System.out.println("Программа находит максимальное значение из сумм пар крайних чисел " +
                "max(a1 + a2n, a2 + a2n−1 , ... , an + an+1)." +
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
                array = RandomArrays.oneDimArrayRandomFilling(size);
                break;
            case 2:
                array = new int[size];
                for (int i = 0; i < size; i++) {
                    System.out.println("Введите "+(i+1)+"е число массива: ");
                    while (!in.hasNextInt()) {
                        System.out.println("Не корректный ввод!");
                        in.next();
                    }
                    array[i]  = in.nextInt();
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        System.out.println(Arrays.toString(array));
        int max = 0;
        for (int i = 0; i < array.length / 2; i++) {
            if((array[i]+array[array.length-1-i])>max){
                max=(array[i]+array[array.length-1-i]);
            }
        }
        System.out.println("Максимальное значение: "+max);
    }
}
