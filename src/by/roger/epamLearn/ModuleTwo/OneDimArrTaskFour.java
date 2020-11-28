package by.roger.epamLearn.ModuleTwo;

import java.util.Arrays;
import java.util.Scanner;

/*
Даны действительные числа а1 ,а2 ,..., аn . Поменять местами наибольший и наименьший элементы.
 */
public class OneDimArrTaskFour {
    public static void main(String[] args) {
        int choose;
        Scanner in = new Scanner(System.in);
        System.out.println("Программа заменяет в массиве чисел наибольшее и наименьшее числа местами." +
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
        System.out.println("Массив чисел до замены:");
        System.out.println(Arrays.toString(array));
        int idxMin = 0;
        int idxMax = 0;
        int min = array[0];
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i]<min){
                idxMin=i;
                min = array[i];
            }
            if (array[i]>max){
                idxMax=i;
                max = array[i];
            }
        }
        array[idxMax] = min;
        array[idxMin] = max;
        System.out.println("Массив чисел после замены:");
        System.out.println(Arrays.toString(array));
    }
}
