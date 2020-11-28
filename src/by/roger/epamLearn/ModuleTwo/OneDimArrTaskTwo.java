package by.roger.epamLearn.ModuleTwo;
/*
Дана последовательность действительных чисел а1 ,а2 ,..., ап. Заменить все ее члены, большие данного Z, этим
числом. Подсчитать количество замен.
 */
import java.util.Arrays;
import java.util.Scanner;

public class OneDimArrTaskTwo {
    public static void main(String[] args) {
        int choose;
        Scanner in = new Scanner(System.in);
        System.out.println("Программа заменяет в массиве чисел те члены которые больше заданного Z." +
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
                in.next(); // this is important!
            }
            size = in.nextInt();
        } while (size <= 0);
        int[] array;
        switch (choose){
            case 1:
                array = CustomArrays.oneDimArrayRandomFilling(size);
                break;
            case 2:
                array = CustomArrays.inputArray(size);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        int z;
        System.out.println("Введите Z: ");
        while (!in.hasNextInt()) {
            System.out.println("Не корректный ввод!");
            in.next(); // this is important!
        }
        z = in.nextInt();
        int countRepls = 0;
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            if (array[i] > z) {
                array[i] = z;
                countRepls++;
            }
        }
        System.out.println("Количество замен: "+countRepls);
        System.out.println(Arrays.toString(array));
    }

}
