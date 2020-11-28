package by.roger.epamLearn.ModuleTwo;

import java.util.Arrays;
import java.util.Scanner;

/*
Дан целочисленный массив с количеством элементов п. Сжать массив, выбросив из него каждый второй
элемент (освободившиеся элементы заполнить нулями). Примечание. Дополнительный массив не использовать.
 */
public class OneDimArrTaskTen {
    public static void main(String[] args) {
        int choose;
        Scanner in = new Scanner(System.in);
        System.out.println("Программа находит наиболее часто встречающееся число. Если таких чисел несколько," +
                " то определяет наименьшее из них" +
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
        for (int i = 0; i < array.length; i++) {
            for (int j=i+1;j<array.length-1;j++) {
                array[j] = array[j + 1];
            }
            array[array.length-1]=0;
        }
        System.out.println(Arrays.toString(array));
    }
}
